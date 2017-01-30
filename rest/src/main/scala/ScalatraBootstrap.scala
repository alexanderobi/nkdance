import org.scalatra.LifeCycle
import javax.servlet.ServletContext

import akka.actor.ActorSystem
import com.nkdanceservices.rest._

class ScalatraBootstrap extends LifeCycle {

  implicit val system = ActorSystem()

  override def init(context: ServletContext) {
    context mount (new PingServlet, "/ping")
  }

  override def destroy(context: ServletContext): Unit = {
    system.terminate()
  }
}