package edu.models

import spray.json.{DefaultJsonProtocol, RootJsonFormat}
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport

final case class Response(responseType : String)

object Response extends SprayJsonSupport with DefaultJsonProtocol {

 implicit val ResponseFormat : RootJsonFormat[Response] = jsonFormat1(Response.apply)

}
