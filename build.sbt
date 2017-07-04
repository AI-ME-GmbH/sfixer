

lazy val commonSettings = Seq(
  name := "dolladolla",
  organization := "org.amaizing",
  scalaVersion := "2.12.2",
  resolvers ++= Seq(
    "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases",
    Resolver.jcenterRepo,
    "Sonatype OSS Releases" at "http://oss.sonatype.org/content/repositories/releases/"
  ),
  version :=  "0.1",
  crossScalaVersions := Seq( "2.11.11"),
  libraryDependencies ++= {
    val catsV = "0.9.0"
    val circeV = "0.8.0"
    val akkaHttpV = "10.0.9"
    val nscalaTimeV = "2.16.0"
    Seq(
      "org.typelevel" %% "cats" % catsV,
      "io.circe" %% "circe-core" % circeV,
      "io.circe" %% "circe-generic" % circeV,
      "io.circe" %% "circe-parser" % circeV,
      "de.heikoseeberger" %% "akka-http-circe" % "1.12.0",
      "com.typesafe.akka" %% "akka-stream" % "2.5.3",
      "com.typesafe.akka" %% "akka-stream-testkit" % "2.5.3" % Test,
      "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpV % Test,
      "com.github.nscala-time" %% "nscala-time" % nscalaTimeV,
      "com.typesafe.akka" %% "akka-http"% akkaHttpV
    )
  }
)

lazy val scalacOpts = scalacOptions ++= Seq(
  "-deprecation", // Emit warning and location for usages of deprecated APIs.
  "-feature", // Emit warning and location for usages of features that should be imported explicitly.
  "-unchecked", // Enable additional warnings where generated code depends on assumptions.
  "-Xlint", // Enable recommended additional warnings.
  "-Ywarn-adapted-args", // Warn if an argument list is modified to match the receiver.
  "-Ywarn-inaccessible", // Warn about inaccessible types in method signatures.
  "-Ywarn-nullary-override", // Warn when non-nullary overrides nullary, e.g. def foo() over def foo.
  "-Ywarn-numeric-widen", // Warn when numerics are widened.
  "-Ypartial-unification" //Infer types
)

lazy val project = Project(id="dolla-core",base = file("core")).settings(commonSettings)
