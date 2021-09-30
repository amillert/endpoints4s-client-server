import sbt._

object Dependencies {

  private object Versions {
    val endpoints4s               = "1.3.0"
    val endpoints4sBackCompatible = "1.1.0"
    val endpoints4sAkkaHttpServer = "4.0.0"
    val endpoints4sAkkaHttpClient = "3.0.0"
  }

  val endpointsCommon = Seq(
    "org.endpoints4s" %% "algebra"             % Versions.endpoints4s,
    "org.endpoints4s" %% "json-schema-generic" % Versions.endpoints4sBackCompatible,
    "org.endpoints4s" %% "json-schema-circe"   % Versions.endpoints4sBackCompatible
  )

  val endpointsServer =
    "org.endpoints4s" %% "akka-http-server" % Versions.endpoints4sAkkaHttpServer

  val endpointsClient =
    "org.endpoints4s" %% "akka-http-client" % Versions.endpoints4sAkkaHttpClient

}
