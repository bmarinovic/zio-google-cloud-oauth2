package io.github.jkobejs.zio.google.cloud.oauth2.sttp.server2server.http

//import cats.effect.Resource
//import zio.Task
//import zio.interop.catz._
//import zio.test.Assertion.equalTo
//import zio.test.{assertM, suite, testM}
//import io.github.jkobejs.zio.google.cloud.oauth2.server2server.http._

object SttpClientSuite {
//  val sttpClientSuite = suite("Sttp Client tests")(
//    testM("sttp client fails for invalid uri") {
//      val client4s = Client[Task](_ => null)
//
//      val sttpClient = new SttpClient {
//        override val client = client4s
//      }
//
//      val req = HttpAuthRequest(
//        jwtToken = "",
//        uri = "https:/ /uri",
//        grantType = "grant"
//      )
//
//      assertM(sttpClient.httpClient.auth(req).either, equalTo(Left(HttpError.UriParseError("Invalid URI"))))
//    },
//    testM("sttp client fails when response is not success") {
//      val client4s = Client[Task](_ => Resource.liftF[Task, Response[Task]](Task.succeed(Response.notFound[Task])))
//
//      val sttpClient = new SttpClient {
//        override val client = client4s
//      }
//
//      val req = HttpAuthRequest(
//        jwtToken = "",
//        uri = "https://uri",
//        grantType = "grant"
//      )
//
//      assertM(
//        sttpClient.httpClient.auth(req).either,
//        equalTo(Left(HttpError.HttpRequestError(status = "404 Not Found", body = "Not found")))
//      )
//    },
//    testM("sttp client fails when response body is invalid") {
//      val client4s = Client[Task](
//        _ =>
//          Resource.liftF[Task, Response[Task]](
//            Task.succeed(Response[Task](body = fs2.Stream.fromIterator[Task]("test".getBytes().iterator)))
//          )
//      )
//
//      val sttpClient = new SttpClient {
//        override val client = client4s
//      }
//
//      val req = HttpAuthRequest(
//        jwtToken = "",
//        uri = "https://uri",
//        grantType = "grant"
//      )
//
//      assertM(
//        sttpClient.httpClient.auth(req).either,
//        equalTo(Left(HttpError.ResponseParseError("Malformed message body: Invalid JSON")))
//      )
//    },
//    testM("sttp client succeeds for valid data") {
//      val resp = HttpAuthResponse(
//        access_token = "accessToken",
//        token_type = "JWT",
//        expires_in = 1000
//      )
//      val client4s = Client[Task](
//        _ =>
//          Resource.liftF[Task, Response[Task]](
//            Task.succeed(
//              Response[Task](
//                body = fs2.Stream.fromIterator[Task](
//                  s"""
//                     |{
//                     |  "access_token": "${resp.access_token}",
//                     |  "token_type": "${resp.token_type}",
//                     |  "expires_in": ${resp.expires_in}
//                     |}
//                     |""".stripMargin
//                    .getBytes()
//                    .iterator
//                )
//              )
//            )
//          )
//      )
//
//      val sttpClient = new SttpClient {
//        override val client = client4s
//      }
//
//      val req = HttpAuthRequest(
//        jwtToken = "token",
//        uri = "https://uri",
//        grantType = "grant"
//      )
//
//      assertM(sttpClient.httpClient.auth(req), equalTo(resp))
//    }
//  )
}
