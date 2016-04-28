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
      .option("url", "jdbc:postgresql://Xuan@192.168.2.132:5432/biomarin")
      .option("driver", "org.postgresql.Driver")
      .option("dbtable", "study_110_504_csv.stream_page_status")
      .load()

    foo.show()
  }
}
