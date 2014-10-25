package com.xuwei_k
import javax.servlet.http._
import scala.util.control.Exception.allCatch

object Main {
  private def intParam(req: HttpServletRequest, key: String): Option[Int] =
    Option(req.getParameter(key)).flatMap{ v =>
      try{
        Some(v.toInt)
      }catch{
        case _: NumberFormatException => None
      }
    }
}

class Main extends HttpServlet{

  override def doGet(req: HttpServletRequest, resp: HttpServletResponse){

    resp.setContentType("text/html; charset=UTF-8")

    def write(s: Any) = resp.getWriter().println(s)

    allCatch.either{

      val markdown = "https://gist.github.com/raw" + req.getRequestURI

      val htmlBody = Markup.parse(io.Source.fromURL(markdown,"UTF-8").mkString)

      val prettifyVersion = Main.intParam(req, "prettify_version")

      write(
        Templates.default("", prettifyVersion, htmlBody._1)
      )

    }.left.foreach{ e =>
      resp.setContentType("text/plain; charset=UTF-8")
      write(e.toString + "\n\n" + e.getStackTrace.mkString("\n") )
    }
  }

}

