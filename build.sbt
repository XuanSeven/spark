name := "SparkETL"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.apache.spark"              %%  "spark-core"              % "1.6.0",
  "org.apache.spark"              %%  "spark-sql"               % "1.6.0",
  "org.apache.spark"              %%  "spark-hive"              % "1.6.0",
  "org.postgresql"                %   "postgresql"              % "9.3-1104-jdbc41"
)

assemblyMergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
{
  case m if m.toLowerCase.endsWith("manifest.mf") => MergeStrategy.discard
  case m if m.startsWith("META-INF") => MergeStrategy.discard
  case PathList("javax", "servlet", xs @ _*) => MergeStrategy.first
  case PathList("org", "apache", xs @ _*) => MergeStrategy.first
  case PathList("org", "jboss", xs @ _*) => MergeStrategy.first
  case "about.html"  => MergeStrategy.rename
  case "reference.conf" => MergeStrategy.concat
  case _ => MergeStrategy.first
}
}