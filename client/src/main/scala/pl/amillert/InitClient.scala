package pl.amillert
package client

import pl.amillert.common.domain.Message
import pl.amillert.server.api.InitEndpoint

import endpoints4s.xhr.JsonEntitiesFromSchemas
import endpoints4s.xhr.thenable._

object InitClient extends InitEndpoint with Endpoints with JsonEntitiesFromSchemas {

  val eventuallyMsg = initEndpoint(Some("request"))
}
