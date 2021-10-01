package pl.amillert
package server
package api

import pl.amillert.common.converters.MessageJsonSchemas
import pl.amillert.common.domain.Message

import endpoints4s.algebra._
import scala.concurrent.Future

trait InitEndpoint extends Endpoints with JsonEntitiesFromSchemas with MessageJsonSchemas {

  def initEndpoint: Endpoint[Option[String], Message] = endpoint(
    request = get(url = path / "init", headers = optRequestHeader("api-secret-key")),
    response = ok(jsonResponse[Message], docs = Some("Initial endpoint"))
  )

}
