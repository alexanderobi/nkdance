package com.nkdanceservices.rest

import com.nkdanceservices.rest.utils.BaseServlet

/**
  * Created by alexanderobi on 1/28/17.
  */
class PingServlet extends BaseServlet {

  get("/"){
    "pong"
  }
}
