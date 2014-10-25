package com.xuwei_k 

object Templates {

  private[this] val languages = List(
    "apollo", "basic", "clj", "css", "dart", "erlang", "go", "hs", "lisp", "llvm", "lua", "matlab", "ml", "mumps", "n", "pascal", "proto", "r", "rd", "scala", "sql", "tcl", "tex", "vb", "vhdl", "wiki", "xq", "yaml"
  )

  private[this] final val assets = "/assets/"
  private[this] def base(v: Int) = "http://cdnjs.cloudflare.com/ajax/libs/prettify/r" + v + "/"
  private[this] final val jquery = "http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"

  def default(
        title: String,
        prettifyVersion: Option[Int],
        slides: xml.NodeBuffer,
        heads: xml.NodeBuffer = new xml.NodeBuffer,
        bodyScripts: xml.NodeBuffer = new xml.NodeBuffer
    ) = {
    val baseURL = base(prettifyVersion.getOrElse(298))

    <html>
      <head>
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
        <meta http-equiv="Expires" content="0" />
        <title>{ title }</title>
        <link rel="stylesheet" type="text/css" href={ assets + "css/show.css"} />
        <link rel="stylesheet" type="text/css" href={ baseURL + "prettify.css"} />
        <script type="text/javascript" src={ jquery } ></script>
        <script type="text/javascript" src={ assets + "js/show.js" } ></script>
        <script type="text/javascript" src={ baseURL + "prettify.js"} ></script>
        {
          languages.map { lang =>
            <script type="text/javascript" src={
              baseURL + "lang-" + lang + ".min.js"
            }></script>
          } ++ heads
        }
      <script type="text/javascript"><!--
        window.onload=function() { prettyPrint(); };
      --></script>
      </head>
      <body>
        <div id="slides">
          <div id="reel">
            { slides }
          </div>
        </div>
        {bodyScripts}
      </body>
    </html>
   }
}
