enablePlugins(JavaAppPackaging)

name := "akka-request"
organization := "io.dronekit"
version := "0.2.1"
scalaVersion := "2.11.7"

resolvers += "Artifactory" at "https://dronekit.artifactoryonline.com/dronekit/libs-snapshot-local/"

credentials += Credentials("Artifactory Realm", "dronekit.artifactoryonline.com", "publish", "Km4-PSH-aEM-6Fm")
isSnapshot := true
publishTo := {
  val artifactory = "https://dronekit.artifactoryonline.com/"
  if (isSnapshot.value)
    Some("snapshots" at artifactory + s"dronekit/libs-snapshot-local;build.timestamp=${new java.util.Date().getTime}")
  else
    Some("snapshots" at artifactory + "dronekit/libs-release-local")
}

libraryDependencies ++= {
  val akkaV = "2.3.12"
  val akkaStreamV = "1.0"
  val scalaTestV = "2.2.4"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "com.typesafe.akka" %% "akka-stream-experimental" % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-core-experimental" % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-experimental" % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaStreamV,
    "io.spray" %%  "spray-json" % "1.3.2",
    "commons-codec" % "commons-codec" % "1.6",
    "com.typesafe.akka" %% "akka-http-testkit-experimental" % akkaStreamV,
    "io.dronekit" %% "oauth-headers" % "0.2",
    "org.scalatest" %% "scalatest" % "2.2.4" % "test",
    "ch.qos.logback" % "logback-classic" % "1.1.3",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0"
  )
}
