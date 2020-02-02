package io.github.jkobejs.zio.google.cloud.oauth2.sttp.server2server

import io.github.jkobejs.zio.google.cloud.oauth2.sttp.server2server.integration.DefaultAuthenticatorIntegrationSuite
import zio.test._

object Tests
    extends DefaultRunnableSpec(
      suite("All Google Cloud Auth sttp server2server suites")(
//        SttpClientSuite.sttpClientSuite,
        DefaultAuthenticatorIntegrationSuite.defaultAuthenticatorIntegrationSuite
      )
    )
