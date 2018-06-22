name := "spark-scala"

version := "0.1"

scalaVersion := "2.11.8"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.3.0"

//libraryDependencies ++= Seq(
//  "org.apache.spark" %% "spark-sql" % "2.3.0",
//  "org.apache.spark" %% "spark-mllib" % "2.3.0"
//)

// configures sbt assembly
lazy val root = (project in file(".")).
  settings(
    name := "spark-demo",
    version := "0.1",
    scalaVersion := "2.11.8",
    mainClass in Compile := Some("com.spark.Application")
  )
