package com.nkdanceservices.rest.utils

import org.scalatra.Params

/**
  * Created by alexanderobi on 2/13/17.
  */
object APIUtils {

  def getPaging(params: Params) = {
    val offset = params.getOrElse("offset", "0").toInt
    val limit = params.getOrElse("limit", "20").toInt
    (offset, limit)
  }

}
