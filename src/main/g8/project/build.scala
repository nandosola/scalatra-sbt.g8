import com.earldouglas.xwp.ContainerPlugin.autoImport._
import com.earldouglas.xwp.JettyPlugin.autoImport._
import com.earldouglas.xwp.{ContainerPlugin, JettyPlugin}
import org.scalatra.sbt._
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
  val jettyVersion = "9.3.19.v20170502"

  val compilerSettings = Seq(
    scalacOptions ++= Seq(
      "-target:jvm-"+javaVersion,
      "-feature",
      "-deprecation",
      "-unchecked",
      "-Xlint",
      "-language:postfixOps",
      "-language:implicitConversions"
    ))

  lazy val project = Project (
    "$name;format="norm"$",
    file("."),
    settings = ScalatraPlugin.scalatraSettings ++ compilerSettings ++ Seq(
      organization := Organization,
      name := Name,
      version := Version,
      scalaVersion := ScalaVersion,
      resolvers += Classpaths.typesafeReleases,
      libraryDependencies ++= Seq(
        "org.scalatra" %% "scalatra" % ScalatraVersion,
        "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
        "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
        "org.scalatra" %% "scalatra-json" % ScalatraVersion,
        "org.json4s"   %% "json4s-jackson" % "3.5.2",
        "com.typesafe.akka" %% "akka-actor" % akkaVersion,
        "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
        "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test",
        "org.eclipse.jetty" % "jetty-webapp" % jettyVersion % "container;compile",
        "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided"
      ),
      //Jetty plugin configuration: only effective under sbt> jetty:*
      containerLibs in Jetty := Seq("org.eclipse.jetty" % "jetty-runner" % jettyVersion intransitive())
    )
  ).enablePlugins(
    JettyPlugin
  )
}
