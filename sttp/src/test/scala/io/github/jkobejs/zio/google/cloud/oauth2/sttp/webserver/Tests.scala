package io.github.jkobejs.zio.google.cloud.oauth2.sttp.webserver

import io.github.jkobejs.zio.google.cloud.oauth2.sttp.webserver.integration.DefaultAuthenticatorIntegrationSuite
import zio.test.{suite, DefaultRunnableSpec}

object Tests
    extends DefaultRunnableSpec(
      suite("All Google Cloud OAuth sttp Web Server suites")(
//        SttpClientSuite.sttpClientSuite,
        DefaultAuthenticatorIntegrationSuite.defaultAuthenticatorIntegrationSuite
      )
    )
