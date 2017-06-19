package com.nkdanceservices.common.utils

import com.nkdanceservices.common._
import com.typesafe.config.Config
import slick.jdbc.PostgresProfile.backend.Database

/**
  * Created by alexanderobi on 2/14/17.
  */
object InitDB {

  def init(config:Config)(implicit db:Database) = {

    if(config.getString(ENV) != "production") {
      SetupDB.createSchema
    }
  }

}
