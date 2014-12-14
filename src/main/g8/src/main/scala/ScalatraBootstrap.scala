import javax.servlet.ServletContext

import $package$._
import akka.actor.{ActorSystem, Props}
import akka.routing.SmallestMailboxPool
import com.typesafe.config.ConfigFactory
import org.scalatra._
import javax.servlet.ServletContext

import org.slf4j.LoggerFactory

class ScalatraBootstrap extends LifeCycle {

  val logger =  LoggerFactory.getLogger(getClass)

  //read application.conf
  val config = ConfigFactory.load()
  val scalatraEnv = sys.env.getOrElse("SCALATRA_ENV", "development")
  val appConf = config.getConfig("properties").getConfig(scalatraEnv)
  logger.info("SCALATRA_ENV is " + scalatraEnv)

  //Initialize Akka
  val system = ActorSystem("MyActorSystem", config)
  val myActor = system.actorOf(Props[MyActor]
    //.props(foo,bar)  //initialize actor here and delete Props[]
    .withRouter(SmallestMailboxPool(nrOfInstances = 2000)), "myActor")

  override def init(context: ServletContext) {
    context.initParameters("org.scalatra.environment") = scalatraEnv
    context.mount(new $servlet_name$(system, myActor), "/*")
  }

  override def destroy(context:ServletContext) {
    system.shutdown()
  }
}
