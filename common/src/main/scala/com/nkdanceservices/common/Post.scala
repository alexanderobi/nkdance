package com.nkdanceservices.common

import org.joda.time.DateTime

/**
  * Created by alexanderobi on 1/29/17.
  */
case class Post (title: Option[String] = None,
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
                 created_at: Option[DateTime] = None,
                 updated_at: Option[DateTime] = None,
                 published_at: Option[DateTime] = None)

object Post {

}
