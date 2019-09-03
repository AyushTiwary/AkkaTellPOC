package edu.service

import akka.actor.Actor
import akka.http.scaladsl.model.{HttpResponse, StatusCodes}
import edu.models.Response
import edu.work.ResponseWork
import edu.service.ResponseHandler._

object ResponseHandler {
    val BadRequest = "badrequest"
    val OK = "ok"
}

class ResponseHandler extends Actor
{
    override def receive : Receive = {
        case work @ ResponseWork(Response(responseType), _) => checkAndSendResponse(work, responseType.toLowerCase)
    }

    def checkAndSendResponse(responseWork: ResponseWork, responseType : String) = {
        responseType match {
            case OK => responseWork.completer(HttpResponse(StatusCodes.OK))
            case BadRequest => responseWork.completer(HttpResponse(StatusCodes.BadRequest))
            case _ => responseWork.completer(HttpResponse(StatusCodes.NotFound))
        }
    }
}
