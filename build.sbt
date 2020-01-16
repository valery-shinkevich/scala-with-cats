name := "scala-with-cats"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies ++= Seq("org.typelevel" %% "cats-kernel" % "2.1.0", "org.typelevel" %% "cats-core" % "2.1.0")

scalacOptions ++= Seq(
  "-Xfatal-warnings",
  "-Ypartial-unification"
)