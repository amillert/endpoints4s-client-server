package pl.amillert
package common
package converters

import pl.amillert.common.domain.Message

import endpoints4s.generic.JsonSchemas

trait MessageJsonSchemas extends JsonSchemas {

  implicit lazy val messageJsonSchema: JsonSchema[Message] =
    genericJsonSchema[Message]
}
