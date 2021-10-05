import org.scalajs.sbtplugin.ScalaJSPlugin
import sbtcrossproject.CrossProject
import sbtcrossproject.CrossPlugin.autoImport.{ crossProject, CrossType }

Global / onChangedBuildSource := ReloadOnSourceChanges

ThisBuild / version := "0.0.1"
ThisBuild / organization := "amillert"
ThisBuild / scalaVersion := "2.13.5"

lazy val common = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .settings(
    libraryDependencies ++= Seq(
      "org.endpoints4s" %%% "algebra"             % "1.5.0",
      "org.endpoints4s" %%% "json-schema-generic" % "1.5.0",
      "org.endpoints4s" %%% "json-schema-circe"   % "1.5.0"
    )
  )

lazy val server = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .settings(libraryDependencies += "org.endpoints4s" %% "akka-http-server" % "5.1.0")
  .dependsOn(common)

val client = project
  .enablePlugins(ScalaJSPlugin)
  .settings(
    libraryDependencies += "org.endpoints4s" %%% "xhr-client" % "3.1.0"
  )
  .dependsOn(common.js, server.jvm)
