package com.nkdanceservices.common

import co.blocke.scalajack.DBKey
import com.nkdanceservices.common.utils.{HasCollection, JFormat, Serialize}
import org.joda.time.DateTime
import org.mongodb.scala.Document

/**
  * Created by alexanderobi on 1/29/17.
  */
case class Author(@DBKey authorID: String,
                  name: Option[String] = None,
                  slug: Option[String] = None,
                  image: Option[String] = None,
                  cover: Option[String] = None,
                  bio: Option[String] = None,
                  website: Option[String] = None,
                  location: Option[String] = None,
                  accessibility: Option[String] = None,
                  status: Option[String] = None,
                  language: Option[String] = None,
                  meta_title: Option[String] = None,
                  meta_description: Option[String] = None,
                  tour: Option[String] = None,
                  last_login: Option[DateTime] = None,
                  created_at: Option[DateTime] = None,
                  created_by: Option[String] = None,
                  updated_at: Option[DateTime] = None,
                  updated_by: Option[String] = None)

object Author extends JFormat with HasCollection with Serialize {
  override val collection_str = "author"

  implicit class SerializePost(a: Author) {
    def toDocument = {
      sj.render(a).asDocument()
    }
  }

  implicit class ExtractPost(d: Document) {
    def toPost = {
      sj.read[Post](d.toBsonDocument)
    }
  }
}