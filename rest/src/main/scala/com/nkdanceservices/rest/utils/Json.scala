package com.nkdanceservices.rest.utils

import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._

/**
  * Created by alexanderobi on 2/13/17.
  */
trait Json extends JacksonJsonSupport{
  override protected implicit val jsonFormats: Formats = DefaultFormats ++ org.json4s.ext.JodaTimeSerializers.all

  before() {
    contentType = formats("json")
  }
}
