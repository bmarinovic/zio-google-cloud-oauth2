package io.github.jkobejs.zio.google.cloud.oauth2.sttp.webserver.http

import zio.test.suite

object SttpClientSuite {
  val sttpClientSuite = suite("Sttp Client tests")(
//    testM("sttp client fails for invalid uri") {
    //        implicit val be: SttpBackendStub[Task, Nothing] = SttpBackendStub(TaskMonadAsyncError)
    //        val sttpClient  = SttpClient()
    //        val req         = Fixtures.httpAccessRequest.copy(uri = "https:/ /uri")
    //
    //        sttpClient.httpClient.authenticate(req)
    //
    //      assertM(authenticateRequest.either, equalTo(Left(HttpError.UriParseError("Invalid URI"))))
    //    }
//    testM("sttp client fails when response is not success") {
//      val client4s = Client[Task](_ => Resource.liftF[Task, Response[Task]](Task.succeed(Response.notFound[Task])))
//
//      val sttpClient = new SttpClient {
//        override val client = client4s
//      }
//
//      assertM(
//        sttpClient.httpClient.authenticate(Fixtures.httpAccessRequest).either,
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
//      assertM(
//        sttpClient.httpClient.authenticate(Fixtures.httpAccessRequest).either,
//        equalTo(Left(HttpError.ResponseParseError("Malformed message body: Invalid JSON")))
//      )
//    },
//    testM("sttp client authentication succeeds for valid data") {
//
//      val client4s = Client[Task](
//        _ =>
//          Resource.liftF[Task, Response[Task]](
//            Task.succeed(
//              Response[Task](
//                body = fs2.Stream.fromIterator[Task](
//                  s"""
//                     |{
//                     |  "access_token": "${Fixtures.httpAccessResponse.access_token}",
//                     |  "token_type": "${Fixtures.httpAccessResponse.token_type}",
//                     |  "expires_in": ${Fixtures.httpAccessResponse.expires_in},
//                     |  "refresh_token" : "${Fixtures.httpAccessResponse.refresh_token}"
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
//      assertM(sttpClient.httpClient.authenticate(Fixtures.httpAccessRequest), equalTo(Fixtures.httpAccessResponse))
//    },
//    testM("sttp client refresh token succeeds for valid data") {
//
//      val client4s = Client[Task](
//        _ =>
//          Resource.liftF[Task, Response[Task]](
//            Task.succeed(
//              Response[Task](
//                body = fs2.Stream.fromIterator[Task](
//                  s"""
//                     |{
//                     |  "access_token": "${Fixtures.httpRefreshResponse.access_token}",
//                     |  "token_type": "${Fixtures.httpRefreshResponse.token_type}",
//                     |  "expires_in": ${Fixtures.httpRefreshResponse.expires_in}
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
//      assertM(sttpClient.httpClient.refreshToken(Fixtures.httpRefreshRequest), equalTo(Fixtures.httpRefreshResponse))
//    }
  )
}
