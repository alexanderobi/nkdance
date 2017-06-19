package com.nkdanceservices.common

import com.nkdanceservices.common.utils.PostgresExtension.api._
import org.joda.time.DateTime

/**
  * Created by alexanderobi on 1/29/17.
  */
case class Author(authorID: Int,
                  name: String,
                  slug: Option[String] = None,
                  image: Option[String] = None,
                  cover: Option[String] = None,
                  bio: Option[String] = None,
                  website: Option[String] = None,
                  location: Option[String] = None,
                  accessibility: Option[String] = None,
                  status: Option[String] = None,
                  language: Option[String] = None,
                  metaTitle: Option[String] = None,
                  metaDescription: Option[String] = None,
                  tour: Option[String] = None,
                  lastLogin: Option[DateTime] = None,
                  createdAt: DateTime = DateTime.now(),
                  createdBy: String,
                  updatedAt: Option[DateTime] = None,
                  updatedBy: Option[String] = None)

class Authors(tag: Tag) extends Table[Author](tag, "AUTHORS") {
  def authorID = column[Int]("AUTHOR_ID", O.PrimaryKey, O.AutoInc, O.Unique)
  def name = column[String]("NAME")
  def slug = column[String]("SLUG")
  def image = column[String]("IMAGE")
  def cover = column[String]("COVER")
  def bio = column[String]("BIO")
  def website = column[String]("WEBSITE")
  def location = column[String]("LOCATION")
  def accessibility = column[String]("ACCESSIBILITY")
  def status = column[String]("STATUS")
  def language = column[String]("LANGUAGE")
  def metaTitle = column[String]("META_TITLE")
  def metaDescription = column[String]("META_DESCRIPTION")
  def tour = column[String]("TOUR")
  def lastLogin = column[DateTime]("LAST_LOGIN")
  def createdAt = column[DateTime]("CREATED_AT")
  def createdBy = column[String]("CREATED_BY")
  def updatedAt = column[DateTime]("UPDATED_AT")
  def updatedBy = column[String]("UPDATED_BY")

  def * = (authorID, name, slug.?, image.?, cover.?, bio.?,  website.?, location.?,
    accessibility.?, status.?, language.?, metaTitle.?, metaDescription.?, tour.?, lastLogin.?,
    createdAt, createdBy, updatedAt.?, updatedBy.?) <> (Author.tupled, Author.unapply)

}

object Authors extends TableQuery(new Authors(_)) {

}