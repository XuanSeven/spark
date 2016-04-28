name := "SparkETL"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.apache.spark"              %%  "spark-core"              % "1.6.1",
  "org.apache.spark"              %%  "spark-sql"               % "1.6.1",
  "org.postgresql"                %   "postgresql"              % "9.4-1201-jdbc41"
)

assemblyMergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
{
  case PathList("javax", "servlet", xs @ _*) => MergeStrategy.last
  case PathList("javax", "activation", xs @ _*) => MergeStrategy.last
  case PathList("org", "apache", xs @ _*) => MergeStrategy.last
  case PathList("com", "google", xs @ _*) => MergeStrategy.last
  case PathList("com", "esotericsoftware", xs @ _*) => MergeStrategy.last
  case PathList("com", "codahale", xs @ _*) => MergeStrategy.last
  case x => old(x)
}}
