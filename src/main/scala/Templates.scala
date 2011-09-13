package com.xuwei_k 

object Templates {

  def default(
        title: String,
        slides: xml.NodeBuffer,
        heads: xml.NodeBuffer = new xml.NodeBuffer,
        bodyScripts: xml.NodeBuffer = new xml.NodeBuffer
    ) = {

    val base = "/assets/"

    <html>
      <head>
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
        <meta http-equiv="Expires" content="0" />
        <title>{ title }</title>
        <link rel="stylesheet" type="text/css" href={ base + "css/show.css"} />
        <link rel="stylesheet" type="text/css" href={ base + "css/prettify.css"} />
        <script type="text/javascript" src={ base + "js/jquery.min.js" } ></script>
        <script type="text/javascript" src={ base + "js/show.js" } ></script>
        <script type="text/javascript" src={ base + "js/prettify/prettify.js"} ></script>
        {
          ("apollo" :: "css" :: "hs" :: "lisp" :: "lua" :: "ml" :: "proto" ::
          "scala" :: "sql" :: "sql" :: "vb" :: "vhdl" :: "wiki" :: 
          "yaml" :: Nil).map { lang =>
            <script type="text/javascript" src={
              base + "js/prettify/lang-%s.js".format(lang)
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
