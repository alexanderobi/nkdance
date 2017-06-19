package com.nkdanceservices.common.utils

import slick.jdbc.PostgresProfile.backend.Database

/**
  * Created by alexanderobi on 1/30/17.
  */
object SQLConnection {

  implicit val db = Database.forConfig("postgres")

}
