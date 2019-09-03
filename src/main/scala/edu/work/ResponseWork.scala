package edu.work

import akka.http.scaladsl.model.HttpResponse
import edu.models.Response

case class ResponseWork(response : Response,
                        override val completer : HttpResponse => Unit) extends Work

