name := "gist-slide"

organization := "com.github.xuwei-k"

scalaVersion := "2.9.2"

libraryDependencies ++= Seq(
   "javax.servlet" % "servlet-api" % "2.5"
  ,"net.databinder" % "pamflet-knockoff_2.9.1" % "0.4.1"
  ,"org.eclipse.jetty" % "jetty-webapp" % "7.4.5.v20110725" % "container"
)

addCompilerPlugin("org.scala-tools.sxr" % "sxr_2.9.0" % "0.2.7")

seq(sbtappengine.Plugin.webSettings: _* )

scalacOptions <+= scalaSource in Compile map { "-P:sxr:base-directory:" + _.getAbsolutePath }

scalacOptions ++= Seq("-deprecation","-unchecked")

licenses := Seq("MIT" -> url("https://github.com/xuwei-k/gist-slide/blob/master/LICENSE"))
