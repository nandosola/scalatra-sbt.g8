import org.scalatra.sbt.ScalatraPlugin
import sbt.Keys._
import sbt._

object $name;format="Camel"$Build extends Build {
  val Organization = "$organization$"
  val Name = "$name$"
  val Version = "$version$"
  val javaVersion = "$java_version$"
  val ScalaVersion = "$scala_version$"
  val ScalatraVersion = "$scalatra_version$"
  val akkaVersion = "$akka_version$"

  val compilerSettings = Seq(
    scalacOptions ++= Seq(
      "-target:jvm-"+javaVersion,
      "-feature",
      "-language:postfixOps"
    ))

  lazy val project = Project (
    "$name;format="norm"$",
    file("."),
    settings = ScalatraPlugin.scalatraWithJRebel ++ compilerSettings ++ Seq(
      organization := Organization,
      name := Name,
      version := Version,
      scalaVersion := ScalaVersion,
      resolvers += Classpaths.typesafeReleases,
      libraryDependencies ++= Seq(
        "org.scalatra" %% "scalatra" % ScalatraVersion,
        "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
        "ch.qos.logback" % "logback-classic" % "1.1.2" % "runtime",
        "org.scalatra" %% "scalatra-json" % ScalatraVersion,
        "org.json4s"   %% "json4s-jackson" % "3.2.11",
        "com.typesafe.akka" %% "akka-actor" % akkaVersion,
        "com.typesafe.akka" % "akka-slf4j_2.11" % akkaVersion,
        "com.typesafe.akka" % "akka-testkit_2.11" % akkaVersion % "test",
        "org.eclipse.jetty" % "jetty-webapp" % "9.1.5.v20140505" % "container",
        "org.eclipse.jetty" % "jetty-plus" % "9.1.5.v20140505" % "container",
        "javax.servlet" % "javax.servlet-api" % "3.1.0"
      )
    )
  )
}
