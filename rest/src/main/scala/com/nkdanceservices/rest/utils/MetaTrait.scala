package com.nkdanceservices.rest.utils

/**
  * Created by alexanderobi on 2/14/17.
  */
trait MetaTrait {
  val limit:Long
  val next:Option[String]
  val offset:Long
  val previous:Option[String]
  val total_count:Long
}

case class meta (
                  override val limit:Long,
                  override val next:Option[String],
                  override val offset:Long,
                  override val previous:Option[String],
                  override val total_count:Long
                ) extends MetaTrait
