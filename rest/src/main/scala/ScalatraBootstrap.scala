import org.scalatra.LifeCycle
import javax.servlet.ServletContext

import akka.actor.ActorSystem
import com.nkdanceservices.common.utils.{ConfigUtil, InitDB, SQLConnection}
import com.nkdanceservices.rest._

class ScalatraBootstrap extends LifeCycle {

  val config = ConfigUtil()

  implicit val system = ActorSystem()
  implicit val db = SQLConnection.db

  override def init(context: ServletContext) {

    //InitDB.init(config)

    context mount (new PingServlet, "/ping")
    context mount (new PostServlet, "/posts")
  }

  override def destroy(context: ServletContext): Unit = {
    system.terminate()
  }
}