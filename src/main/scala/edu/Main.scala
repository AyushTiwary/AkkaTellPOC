package edu

import akka.actor.Props
import akka.http.scaladsl.Http
import edu.configurations.AkkaConfig
import edu.service.ResponseHandler
import edu.view.ResponseRoute
import scala.concurrent.Future
import scala.util.{Failure, Success}

object Main extends App with AkkaConfig
{
    val responseHandler = system.actorOf(Props[ResponseHandler], "response-handler")
    val responseRoute = new ResponseRoute(responseHandler)

    val serverBinding: Future[Http.ServerBinding] =
        Http().bindAndHandle(responseRoute.route, "localhost", 8000)

    serverBinding.onComplete {

        case Success(_) =>
            println("started")
        case Failure(error) =>
            Http()(system)
                .shutdownAllConnectionPools()
                .andThen {
                    case _ =>
                        println("failed" + error)
                        system.terminate()
                }

    }
}
