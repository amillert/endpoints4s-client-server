import Dependencies._

ThisBuild / version := "0.0.1"
ThisBuild / organization := "amillert"
ThisBuild / scalaVersion := "2.13.5"

lazy val common = (project in file("common"))
  .settings(name := "common", libraryDependencies ++= endpointsCommon)

lazy val server = (project in file("server"))
  .settings(name := "server", libraryDependencies += endpointsServer)
  .dependsOn(common)

lazy val client = (project in file("client"))
  .settings(name := "client", libraryDependencies += endpointsClient)
  .dependsOn(server)

lazy val root = (project in file(".")).aggregate(common, server, client)
