import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.williamhaw"
ThisBuild / organizationName := "williamhaw"

lazy val root = (project in file("."))
  .settings(
    name := "scalaxb-example",
    libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.2.0",
    libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2",
    libraryDependencies += scalaTest % Test
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
