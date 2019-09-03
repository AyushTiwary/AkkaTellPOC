package edu.configurations

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import scala.concurrent.ExecutionContext

trait AkkaConfig {
    implicit val system : ActorSystem = ActorSystem("Service")
    implicit val dispatcher : ExecutionContext = system.dispatcher
    implicit val materializer : ActorMaterializer = ActorMaterializer()
}
