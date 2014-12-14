package $package$

import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import com.typesafe.config.ConfigFactory
import org.scalatest.FunSuiteLike
import org.scalatra.test.scalatest.ScalatraSuite


// For more on Specs2, see http://etorreborre.github.com/specs2/guide/org.specs2.guide.QuickStart.html
class $servlet_name$Test extends ScalatraSuite with FunSuiteLike {

  val config = ConfigFactory.load()
  val scalatraEnv = "test"
  val appConf = config.getConfig("properties").getConfig(scalatraEnv)

  //Initialize Akka
  implicit val system = ActorSystem("testActorSystem")
  val myActor = TestActorRef(MyActor, "myActor")
  /**
   Alternatively, stub actor if integration-test style doesn't please you:

    class ActorStub extends Actor {
      def receive = {
        case _ =>  //no-op
      }
    }
   */

  addServlet(new $servlet_name$(system, myActor), "/*")


  test("GET / on $servlet_name$") {
    get("/") {
      status should equal(200)
    }
  }

}
