package edu.view

import akka.actor.ActorRef
import akka.http.scaladsl.model.HttpResponse
import akka.http.scaladsl.server.{Directives, Route}
import edu.models.Response
import edu.work.ResponseWork

class ResponseRoute(responseHandler : ActorRef) extends Directives
{
    def route : Route = response

    private def response = {
        path("response"){

            post {

                entity(as[Response]) {

                    responseRequest => {

                        completeWith(instanceOf[HttpResponse]) {
                            completer => {
                                responseHandler ! ResponseWork(responseRequest, completer)
                            }
                        }
                    }
                }
            }
        }
    }
}
