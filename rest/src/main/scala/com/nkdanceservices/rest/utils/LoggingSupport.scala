package com.nkdanceservices.rest.utils

import org.slf4j.LoggerFactory

/**
  * Created by alexanderobi on 2/13/17.
  */
trait LoggingSupport {
  val logger =  LoggerFactory.getLogger(getClass)
}
