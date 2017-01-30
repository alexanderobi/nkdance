package com.nkdanceservices.common.utils

import co.blocke.scalajack._
import mongo._

/**
  * Created by alexanderobi on 1/30/17.
  */
trait Serialize {
  val sj = ScalaJack(MongoFlavor())
}
