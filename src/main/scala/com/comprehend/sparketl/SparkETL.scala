package com.comprehend.sparketl

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext

object SparkETL {
  def main(args: Array[String]) {
    val conf = new SparkConf()
    val sc = new SparkContext(conf)
    val sqc = new SQLContext(sc)

    println("hello world")

    val foo =  sqc.read.format("jdbc")
      .option("url", "jdbc:postgresql://god1-postgres.sf.comprehend.com:5432/xli")
      .option("driver", "org.postgresql.Driver")
      .option("user", "comprehend")
      .option("password", "office2005")
      .option("dbtable", "spark.testtable")
      .load()

    foo.show()
  }
}
