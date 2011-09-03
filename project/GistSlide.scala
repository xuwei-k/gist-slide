import sbt._
import Keys._

object GistSlide extends Build{

  lazy val root = Project("root", file("."),
    settings = {
      Defaults.defaultSettings ++ 
      sbtappengine.AppenginePlugin.webSettings ++ Seq(
        libraryDependencies ++= Seq(
          "javax.servlet" % "servlet-api" % "2.5"
         ,"net.databinder" %% "pamflet-knockoff" % "0.2.2"
        )
      )
    }
  )
}
