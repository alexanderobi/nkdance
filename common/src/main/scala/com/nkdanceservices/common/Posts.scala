package com.nkdanceservices.common

import com.nkdanceservices.common.utils.PostgresExtension.api._
import org.joda.time.DateTime
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by alexanderobi on 1/29/17.
  */
case class Post (postID: Int,
                 title: String,
                 slug: Option[String] = None,
                 markdown: Option[String] = None,
                 html: Option[String] = None,
                 image: Option[String] = None,
                 featured: Option[Boolean] = None,
                 page: Boolean,
                 status: Option[String] = None,
                 language: Option[String] = None,
                 metaTitle: Option[String] = None,
                 metaDescription: Option[String] = None,
                 authorID: Int,
                 createdAt: DateTime = DateTime.now(),
                 updatedAt: Option[DateTime] = None,
                 publishedAt: Option[DateTime] = None,
                 url: Option[String] = None,
                 tags: List[String])

class Posts(tag: Tag) extends Table[Post](tag, "POSTS") {
  def postID = column[Int]("POST_ID", O.PrimaryKey, O.AutoInc, O.Unique)
  def title = column[String]("TITLE")
  def slug = column[String]("SLUG")
  def markdown = column[String]("MARKDOWN")
  def html = column[String]("HTML")
  def image = column[String]("IMAGE")
  def featured = column[Boolean]("FEATURED")
  def page = column[Boolean]("PAGE")
  def status = column[String]("STATUS")
  def language = column[String]("LANGUAGE")
  def metaTitle = column[String]("META_TITLE")
  def metaDescription = column[String]("META_DESCRIPTION")
  def authorID = column[Int]("AUTHOR_ID")
  def createdAt = column[DateTime]("CREATED_AT")
  def updatedAt = column[DateTime]("UPDATED_AT")
  def publishedAt = column[DateTime]("PUBLISHED_AT")
  def url = column[String]("URL")
  def tags = column[List[String]]("TAGS")

  def * = (postID, title, slug.?, markdown.?, html.?, image.?, featured.?, page,
  status.?, language.?, metaTitle.?, metaDescription.?, authorID, createdAt, updatedAt.?,
  publishedAt.?, url.?, tags) <> (Post.tupled, Post.unapply)

  // Relationship
  def author = foreignKey("AUTHOR_FK", authorID, Authors)(_.authorID)

}

object Posts extends TableQuery(new Posts(_)){

  def findPostById(id: Int)(implicit db: Database) = {
    db.run(this.filter(_.postID === id).result).map(_.headOption)
  }

  def createPost(post: Post)(implicit db: Database) = {
    db.run(this returning this.map(_.postID) into ((pst, postID) => pst.copy(postID = postID)) += post)
  }

  def findAll(limit: Int, offset: Int)(implicit db: Database) = {
    db.run(this.drop(offset).take(limit).result).map(_.toList)
  }
}
