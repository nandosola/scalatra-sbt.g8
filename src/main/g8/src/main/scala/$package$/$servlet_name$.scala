package $package$

import akka.actor.{Actor, ActorRef, ActorSystem}
import akka.pattern.ask
import akka.util.Timeout
import org.scalatra.{Accepted, FutureSupport}
import org.slf4j.LoggerFactory

import scala.concurrent.duration._
import scala.concurrent.ExecutionContext


class $servlet_name$(system: ActorSystem, myActor: ActorRef) extends $name;format="Camel"$Stack with FutureSupport {

  override val logger =  LoggerFactory.getLogger(getClass)

  implicit val timeout = new Timeout(2 seconds)
  protected implicit def executor: ExecutionContext = system.dispatcher

  get("/") {

  }

  // You'll see the output from this in the browser.
  get("/ask") {
    myActor ? "Do stuff and give me an answer"
  }

  // You'll see the output from this in your terminal.
  get("/tell") {
    myActor ! "Hey, you know what?"
    Accepted()
  }

}

/**  Sample decorator to time the execution of a request
trait ExecTimer {
  val logger: Logger

  def time(f: => ???)= {
    val s = System.currentTimeMillis
    val response = f
    logger.info("SuccessResponse - Elapsed time: " + (System.currentTimeMillis - s) + "ms" )
    response
  }
}
*/