import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin
import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnPlugin
import org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootExtension

plugins {
  kotlin("multiplatform")
  id("org.jetbrains.compose") version "1.0.0"
  kotlin("plugin.serialization")
}

//val environment = "prod"
val environment = "test"

kotlin {
  js(IR) {
    browser {
      webpackTask {
        if(environment == "prod") {
          args.plusAssign(listOf("--env.backendHost=https://semudando.com.br"))
        } else {
          args.plusAssign(listOf("--env.backendHost=localhost:9090"))
        }
        webpackConfigApplier {
          export = false
        }
      }
    }
    binaries.executable()
  }

  sourceSets {
    val jsMain by getting {
      dependencies {
        api(project(":common"))

        implementation(compose.web.core)
        implementation(compose.runtime)
        implementation(npm("@stripe/stripe-js", "1.18.0"))
        api(npm("imask", "6.2.2"))
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
        implementation("io.ktor:ktor-client-js:1.6.5")
        implementation("io.ktor:ktor-client-serialization:1.6.5")
      }
    }
  }
}

rootProject.plugins.withType(NodeJsRootPlugin::class.java) {
  rootProject.the<NodeJsRootExtension>().versions.webpackCli.version = "4.9.0"
  rootProject.the<NodeJsRootExtension>().versions.webpackDevServer.version = "4.3.1"
}

rootProject.plugins.withType<YarnPlugin> {
  rootProject.the<YarnRootExtension>().apply { resolution("@webpack-cli/serve", "1.6.0") }
}