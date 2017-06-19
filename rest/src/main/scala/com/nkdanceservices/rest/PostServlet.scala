package com.nkdanceservices.rest

import com.nkdanceservices.common.{Post, Posts}
import akka.actor.ActorSystem
import com.nkdanceservices.rest.utils.{APIUtils, BaseServlet, meta}
import com.nkdanceservices.common.utils.PostgresExtension.api._
import org.scalatra.{AsyncResult, FutureSupport}

import scala.concurrent.ExecutionContext

case class PagedPost(meta:meta, objects:List[Post])

/**
  * Created by alexanderobi on 2/13/17.
  */
class PostServlet(implicit var system:ActorSystem,
                  implicit var db: Database) extends BaseServlet with FutureSupport {

  protected implicit def executor: ExecutionContext = system.dispatcher

  get("/?") {
    val (offset, limit) = APIUtils.getPaging(params)
    new AsyncResult() {
     val is = {
       for {
         posts <- Posts.findAll(limit, offset)
       } yield {
         PagedPost(meta(limit, None, offset, None, posts.length), posts)
       }
     }
    }
  }

  get("/:id/?") {
    val id = params("id").toInt
    new AsyncResult() {
      val is = {
        for {
          post <- Posts.findPostById(id)
        } yield post
      }
    }
  }

  post("/?") {
    val body = (parsedBody).extract[Post]
    new AsyncResult() {
      val is = {
        for {
          posts <- Posts.createPost(body)
        } yield {
          posts.postID
        }
      }
    }
  }

}
