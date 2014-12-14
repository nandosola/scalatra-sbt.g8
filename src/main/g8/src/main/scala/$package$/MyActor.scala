package $package$

import akka.actor.{Actor, ActorSystem}
import akka.event.Logging

/**
 Perform actor initialization here:

    object $name;format="Camel"$Actor {
      def props(foo: Foo, bar: Bar): Props =
        Props(new $name;format="Camel"$Actor(foo, bar))
    }
*/

class MyActor extends Actor {

  implicit def system: ActorSystem = context.system
  val logger = Logging(system, classOf[MyActor])

  def receive = {
    case "Do stuff and give me an answer" => sender ! "The answer is 42"
    case "Hey, you know what?" => println("Yeah I know... oh boy do I know")
  }
}