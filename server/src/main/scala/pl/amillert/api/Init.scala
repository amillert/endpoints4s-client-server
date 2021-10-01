package pl.amillert
package server
package api

import pl.amillert.common.domain.Message
import pl.amillert.server.api.InitEndpoint

import akka.http.scaladsl.server.Route
import endpoints4s.akkahttp.server._

object Init extends InitEndpoint with Endpoints with JsonEntitiesFromSchemas {

  val route: Route = initEndpoint.implementedBy(_ => Message("Hey there!"))
}
