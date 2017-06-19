package com.nkdanceservices.rest.utils

import org.scalatra.{CorsSupport, ScalatraServlet}

/**
  * Created by alexanderobi on 1/28/17.
  */
trait BaseServlet extends ScalatraServlet with CorsSupport with Json with LoggingSupport {
  options("/*"){
    response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"))
  }
}