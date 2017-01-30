package com.nkdanceservices.common.utils

import com.nkdanceservices.common.utils.MongoUtil._
import org.mongodb.scala.MongoClient

/**
  * Created by alexanderobi on 1/30/17.
  */
trait HasCollection {
  def collection_str:String
  def collection(implicit mc:MongoClient) = mc.collection(collection_str)
}