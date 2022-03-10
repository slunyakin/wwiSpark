version := "0.1"

scalaVersion := "2.11.12"

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.4"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.4"
libraryDependencies += "org.apache.spark" %% "spark-hive" % "2.4.4"
libraryDependencies += "com.microsoft.azure" % "spark-mssql-connector" % "1.0.2"
libraryDependencies += "org.rogach" %% "scallop" % "4.1.0"
libraryDependencies += "net.liftweb" %% "lift-json" % "3.5.0"
libraryDependencies += "junit" % "junit" % "4.13" % Test
libraryDependencies += "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % Test
libraryDependencies += "org.scalatestplus" %% "junit-4-13" % "3.2.11.0" % "test"