package io.github.jkobejs.zio.google.cloud.oauth2.sttp.server2server.authenticator

import io.github.jkobejs.zio.google.cloud.oauth2.server2server.authenticator.Authenticator
import io.github.jkobejs.zio.google.cloud.oauth2.server2server.authenticator.Authenticator.Default
import io.github.jkobejs.zio.google.cloud.oauth2.server2server.sign.TSecJwtSign
import io.github.jkobejs.zio.google.cloud.oauth2.sttp.server2server.http.SttpClient
import sttp.client.SttpBackend
import sttp.client.asynchttpclient.WebSocketHandler
import zio.Task
import zio.clock.Clock

trait Live extends Default with TSecJwtSign with SttpClient with Clock.Live

object Live {
  def apply(backend: SttpBackend[Task, Nothing, WebSocketHandler]): Authenticator =
    new Live {
      implicit override val sttpBackend: SttpBackend[Task, Nothing, WebSocketHandler] = backend
    }
}
