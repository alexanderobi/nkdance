package com.nkdanceservices.common.utils

import java.sql.Date

import com.nkdanceservices.common.{Author, Authors, Post, Posts}
import org.joda.time.DateTime
import slick.jdbc.PostgresProfile
import slick.jdbc.PostgresProfile.api._
import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by alexanderobi on 2/9/17.
  */
object SetupDB {

  val schema = Authors.schema ++ Posts.schema
  val current = DateTime.now()

  def createSchema(implicit db: Database) = {
    try {
      val setup = DBIO.seq(
        /*schema.create,
        Authors ++= Seq(
          Author(1, "Dave", Some("Dave"), Some("/dave"), Some("cover"), Some("bio"),
            Some("www.dave.org"), Some("maryland"), Some("accessibility"), Some("status"),
            Some("english"), Some("meta tile"), Some("meta description"), Some("tour"),
            Some(current), current, "dave", Some(current), Some("dave")),
          Author(2, "John", Some("John"), Some("/John"), Some("cover"), Some("bio"),
            Some("www.John.org"), Some("maryland"), Some("accessibility"), Some("status"),
            Some("english"), Some("meta tile"), Some("meta description"), Some("tour"),
            Some(current), current, "John", Some(current), Some("John"))
        ),*/
        Posts ++= Seq(
          Post(1, "First Post", Some("first-post"), Some("markdown1"), Some("html1"),
            Some("/post1"), Some(true), false, Some("status"), Some("english"),
            Some("meta tile"), Some("meta description"), 1, current, Some(current),
            Some(current), Some("www.dave.org"), List("first", "second")),
          Post(2, "Second Post", Some("second-post"), Some("markdown2"), Some("html2"),
            Some("/post1"), Some(true), false, Some("status"), Some("english"),
            Some("meta tile"), Some("meta description"), 2, current, Some(current),
            Some(current), Some("www.dave.org"), List("first", "second"))
        )
      )
      Await.result(db.run(setup), 60 seconds)
    } catch {
      case e: Throwable => println(s"error occurred $e")
    } finally db.close
  }
}
