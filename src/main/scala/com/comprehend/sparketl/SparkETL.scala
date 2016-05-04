package com.comprehend.sparketl

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.hive.HiveContext

object SparkETL {

  val sql1 =
    """
      |select
      |		RoleID,
      |		RolePermissions,
      |		Active,
      |		Created,
      |		Updated,
      |		ServerSyncDate,
      |		ViewAllSites,
      |		CreateSubjects,
      |		ModifyPrimaryRecord,
      |		IsInvestigator,
      |		SubjectAdmin,
      |		SeeAudits,
      |		ChangeInvestigator,
      |		ShareSubject,
      |		CanViewStudyGrid,
      |		CanBatchSign,
      |		CanInactivateForm,
      |		CanReactivateForm,
      |		UsePrimarySubjectName,
      |		CanUseTemplates,
      |		CanModifyTemplates,
      |		SetClinicalSignificance,
      |		UseLabMaintenance,
      |		ViewAllSubjects,
      |		Pass1DataEntry,
      |		Pass2DataEntry,
      |		Reconcile,
      |		RoleNameID,
      |		CanUseAdvancedDCFs,
      |		CanUseDCFs
      |from RolesAllModules
    """.stripMargin

  def main(args: Array[String]) {
    val conf = new SparkConf()
    val sc = new SparkContext(conf)
    val hc = new HiveContext(sc)
    hc.setConf("", "")

    println("hello world")

    val foo = hc.read.format("jdbc")
      .option("url", "jdbc:postgresql://dal-metal-edwards-1.dallas.comprehend.com:5476/edwards-dev-clinical")
      .option("driver", "org.postgresql.Driver")
      .option("user", "edwards-dev")
      .option("password", "KYwhdeNCr9u34KZwd2uyUeB")
      .option("dbtable", "dbo.rolesallmodules")
      .load()
    println("load finished")
    foo.registerTempTable("rolesallmodules")
    println("registered temptable")

    hc.sql(sql1)

    val df = hc.sql("select * from dbo.roles")

    df.show()
  }
}
