package $package$

import org.json4s.{DefaultFormats, Formats, MappingException}
import org.scalatra._
import org.scalatra.json.JacksonJsonSupport
import org.slf4j.LoggerFactory


trait $name;format="Camel"$Stack extends ScalatraServlet with JacksonJsonSupport {

  val logger =  LoggerFactory.getLogger(getClass)
  implicit val jsonFormats: Formats = DefaultFormats.withBigDecimal

  before() {
    contentType = formats("json")
  }

  notFound {
    haltHelper(Response(404, ""))
  }

  error {
    case e: MappingException =>
    logger.error("Mapping exception. The request format couldn't be recognized as  valid JSON", e)
    haltHelper(Response(400, "Couldn't parse request"))

    case e: Throwable =>
    logger.error("Unknown exception received", e)
    haltHelper(Response(500, "Internal server error"))
  }

  def haltHelper(errorResponse: Response) =
    halt(errorResponse.statusCode, errorResponse, Map("Connection" -> "close"))

}
