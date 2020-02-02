package io.github.jkobejs.zio.google.cloud.oauth2.sttp.webserver.authenticator

import io.github.jkobejs.zio.google.cloud.oauth2.sttp.webserver.http.SttpClient
import io.github.jkobejs.zio.google.cloud.oauth2.webserver.authenticator.Authenticator
import io.github.jkobejs.zio.google.cloud.oauth2.webserver.authenticator.Authenticator.Default
import sttp.client.SttpBackend
import sttp.client.asynchttpclient.WebSocketHandler
import zio.Task
import zio.clock.Clock

trait Live extends Default with SttpClient with Clock.Live

object Live {
  def apply(backend: SttpBackend[Task, Nothing, WebSocketHandler]): Authenticator =
    new Live {
      implicit override val sttpBackend: SttpBackend[Task, Nothing, WebSocketHandler] = backend
    }
}
