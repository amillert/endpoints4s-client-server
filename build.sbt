import Dependencies._

ThisBuild / version := "0.0.1"
ThisBuild / organization := "amillert"
ThisBuild / scalaVersion := "2.13.5"

lazy val common = (project in file("common"))
  .settings(name := "common", libraryDependencies ++= endpointsCommon)

lazy val server = (project in file("server"))
  .settings(name := "server", libraryDependencies ++= Seq(endpointsServer))
  .dependsOn(common)

lazy val client = (project in file("client"))
  .settings(name := "client", libraryDependencies ++= Seq(endpointsClient))
  .dependsOn(common)

lazy val root = (project in file(".")).aggregate(common, server, client)
