plugins {
  kotlin("jvm")
  kotlin("plugin.serialization")
}

dependencies {
  api(project(":common"))

  implementation("io.ktor:ktor-server-core:1.6.4")
  implementation("io.ktor:ktor-server-netty:1.6.4")
  implementation("io.ktor:ktor-serialization:1.6.4")
  implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1")

  implementation("com.stripe:stripe-java:20.89.0")
  implementation("ch.qos.logback:logback-classic:1.2.7")
}

