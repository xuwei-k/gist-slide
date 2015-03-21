name := "gist-slide"

organization := "com.github.xuwei-k"

scalaVersion := "2.9.2"

libraryDependencies ++= Seq(
   "javax.servlet" % "servlet-api" % "2.5"
  ,"net.databinder" % "pamflet-knockoff_2.9.1" % "0.4.1"
)

scalacOptions ++= Seq("-deprecation","-unchecked")

licenses := Seq("MIT" -> url("https://github.com/xuwei-k/gist-slide/blob/master/LICENSE"))
