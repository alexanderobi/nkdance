package com.nkdanceservices.common.utils

import com.nkdanceservices.common._
import org.mongodb.scala.MongoClient

/**
  * Created by alexanderobi on 1/30/17.
  */
object MongoUtil {

  implicit class MongoDatabaseClient(c: MongoClient){
    def db = c.getDatabase(DB)
  }

  implicit class MongoDatabaseCollection(c: MongoClient){
    def collection(name: String) = c.db.getCollection(name)
  }

}
