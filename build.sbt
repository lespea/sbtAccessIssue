import sbt.ClassLoaderLayeringStrategy._

val scalaVer = {
  "3.4.2"
//   "3.3.3"
//  "2.13.14"
}

lazy val root = project
  .in(file("."))
  .settings(
    name         := "sbtAccessIssue",
    version      := "0.1.0-SNAPSHOT",
    scalaVersion := scalaVer,
    libraryDependencies ++= Seq(
      "commons-io" % "commons-io" % "2.16.1",
    ),
    classLoaderLayeringStrategy := ScalaLibrary,
  )
