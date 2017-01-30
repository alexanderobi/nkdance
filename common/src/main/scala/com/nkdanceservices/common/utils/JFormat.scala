package com.nkdanceservices.common.utils

import org.json4s.{DefaultFormats, Formats}

/**
  * Created by alexanderobi on 1/30/17.
  */
trait JFormat {
  implicit val jsonFormats: Formats = DefaultFormats ++ org.json4s.ext.JodaTimeSerializers.all
}
