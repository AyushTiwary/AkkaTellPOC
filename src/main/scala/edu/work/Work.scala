package edu.work

import akka.http.scaladsl.model.HttpResponse

trait Work {
    def completer : HttpResponse => Unit
}

