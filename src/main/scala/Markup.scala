package gist_slide

object Markup {
  import pamflet.PamfletDiscounter._
  import java.net.URL

  def parse(content: String, index: Int = 0) = {
    val Meta = """(?i)(HTML)""".r

    val slides = content.split("(?m)^!SLIDE")
    if(slides.isEmpty) log("no slides within file %s at index %s" format(content, index))
    ((new xml.NodeBuffer, index) /: slides.drop(1))( (a, s) => {
      (a._1 &+ (<div class="content" id={"slide-%s" format a._2}>
       <div class="container">{
         s.split("\n")(0).trim match {
            case Meta(meta) => {
              <div>{ xml.PCData( s.split("\n").toList.drop(1).mkString("") ) }</div>
            }
            case _ => parseMarkdown(s)
          }
        }</div>
      </div>), a._2 + 1)
    })
  }

  private def parseMarkdown(content: String) = toXHTML(knockoff(content))
}
