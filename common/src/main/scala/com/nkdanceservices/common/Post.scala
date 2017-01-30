package com.nkdanceservices.common

import co.blocke.scalajack.DBKey
import com.nkdanceservices.common.utils.{HasCollection, JFormat, Serialize}
import org.joda.time.DateTime
import org.mongodb.scala.Document


/**
  * Created by alexanderobi on 1/29/17.
  */
case class Post (@DBKey postID: String,
                 title: Option[String] = None,
                 slug: Option[String] = None,
                 markdown: Option[String] = None,
                 html: Option[String] = None,
                 image: Option[String] = None,
                 featured: Option[Boolean] = None,
                 page: Option[Boolean] = None,
                 status: Option[String] = None,
                 language: Option[String] = None,
                 meta_title: Option[String] = None,
                 meta_description: Option[String] = None,
                 author: Option[Author] = None,
                 created_at: Option[DateTime] = None,
                 updated_at: Option[DateTime] = None,
                 published_at: Option[DateTime] = None
                )

object Post extends JFormat with HasCollection with Serialize {
  override val collection_str = "posts"

  implicit class SerializePost(p:Post) {
    def toDocument = {
      sj.render(p).asDocument()
    }
  }

  implicit class ExtractPost(d:Document) {
    def toPost = {
      sj.read[Post](d.toBsonDocument)
    }
  }
}
