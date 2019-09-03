name := "AkkaTell"

version := "0.1"

scalaVersion := "2.12.8"

val akkaVersion = "2.5.25"
val akkaHttpVersion = "10.1.9"

libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-stream" % akkaVersion
)
