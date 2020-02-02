/*
 * Copyright 2019 Josip Grgurica and Contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.jkobejs.zio.google.cloud.oauth2.sttp.server2server.http

import io.circe._
import io.circe.generic.auto._
import io.circe.parser._
import io.github.jkobejs.zio.google.cloud.oauth2.server2server
import io.github.jkobejs.zio.google.cloud.oauth2.server2server.http.HttpError.{
  HttpRequestError,
  ResponseParseError,
  UriParseError
}
import io.github.jkobejs.zio.google.cloud.oauth2.server2server.http._
import sttp.client._
import sttp.client.asynchttpclient.WebSocketHandler
import sttp.model.Uri
import zio.{Task, ZIO}

trait SttpClient extends HttpClient {

  implicit val sttpBackend: SttpBackend[Task, Nothing, WebSocketHandler]

  override val httpClient: HttpClient.Service[Any] =
    (request: HttpAuthRequest) =>
      ZIO
        .fromEither(Uri.parse(request.uri))
        .mapError(UriParseError)
        .flatMap(
          uri =>
            ZIO.absolve(
              basicRequest
                .post(uri)
                .body("grant_type" -> request.grantType, "assertion" -> request.jwtToken)
                .send()
                .either
                .map(r => decodeAndRefineErrors[HttpAuthResponse](r))
            )
        )
        .refineOrDie {
          case e: server2server.http.HttpError => e
        }

  def decodeAndRefineErrors[T](
    response: Either[Throwable, Response[Either[String, String]]]
  )(implicit decoder: Decoder[T]): Either[server2server.http.HttpError, T] =
    response.left
      .map(e => HttpRequestError("Failed effect", e.getMessage))
      .flatMap(
        response =>
          response.body match {
            case Left(error) =>
              Left(HttpRequestError(response.statusText, error))
            case Right(value) =>
              decode(value) match {
                case Left(parseError) => Left(ResponseParseError(parseError.getMessage))
                case Right(t)         => Right(t)
              }
          }
      )
}

object SttpClient {
  def apply(backend: SttpBackend[Task, Nothing, WebSocketHandler]): SttpClient = new SttpClient {
    implicit override val sttpBackend: SttpBackend[Task, Nothing, WebSocketHandler] = backend
  }
}
