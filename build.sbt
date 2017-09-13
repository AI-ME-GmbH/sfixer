/**
 * The default scala compiler optiuons
 *
 */
lazy val scalacOpts = scalacOptions ++= Seq(
  "-deprecation", // Emit warning and location for usages of deprecated APIs.
  "-feature", // Emit warning and location for usages of features that should be imported explicitly.
  "-unchecked", // Enable additional warnings where generated code depends on assumptions.
  "-language:postfixOps",//enable postfix op notation
  "-language:implicitConversions",
  "-Xlint", // Enable recommended additional warnings.
  "-Ywarn-adapted-args", // Warn if an argument list is modified to match the receiver.
  "-Ywarn-inaccessible", // Warn about inaccessible types in method signatures.
  "-Ywarn-nullary-override", // Warn when non-nullary overrides nullary, e.g. def foo() over def foo.
  "-Ywarn-numeric-widen", // Warn when numerics are widened.
  "-Ypartial-unification" //Infer types
)

/**
 * Project settings for core
 *
 */
lazy val commonSettings = Seq(
  organization := "org.amaizing",
  scalaVersion := "2.12.3",
  resolvers ++= Seq(
    "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases",
    Resolver.jcenterRepo,
    "Sonatype OSS Releases" at "http://oss.sonatype.org/content/repositories/releases/"
  ),
  version :=  "0.1",
  scalacOpts,
  crossScalaVersions := Seq( "2.11.11"),
  libraryDependencies ++= {
    val catsV = "1.0.0-MF"
    val circeV = "0.9.0-M1"
    val nscalaTimeV = "2.16.0"
    Seq(
      "org.typelevel" %% "cats-core" % catsV,
      "io.circe" %% "circe-core" % circeV,
      "io.circe" %% "circe-generic" % circeV,
      "io.circe" %% "circe-parser" % circeV,
      "com.github.nscala-time" %% "nscala-time" % nscalaTimeV,
      "com.ironcorelabs" %% "cats-scalatest" % "2.3.0" % "test",
      "org.scalacheck" %% "scalacheck" % "1.13.5" % "test"
    )
  }
)

lazy val akkaDependencies = Seq(
  name := "sfixr-akka",
  libraryDependencies ++= {
    val akkaHttpV = "10.0.10"
    val akkaV = "2.5.4"
    val nscalaTimeV = "2.16.0"
    Seq(
      "de.heikoseeberger" %% "akka-http-circe" % "1.19.0-M1",
      "com.typesafe.akka" %% "akka-stream" % akkaV,
      "com.typesafe.akka" %% "akka-stream-testkit" % akkaV % Test,
      "com.typesafe.akka" %% "akka-http" % akkaHttpV,
      "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpV % Test,
      "com.github.nscala-time" %% "nscala-time" % nscalaTimeV
    )
  }
)


lazy val core = Project(id="sfixer-core", base = file("core"))
  .settings(name := "dolla-core")
  .settings(commonSettings)

lazy val akka = Project(id="sfixer-akka", base=file("sfixr-akka"))
  .settings(commonSettings)
  .settings(akkaDependencies)
  .dependsOn(core)

lazy val root = Project(id="root", base = file("."))
  .settings(commonSettings)
  .aggregate(core, akka)
