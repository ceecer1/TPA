import controllers.Assets
import globals.{TBAApplication, WSClientModule}
import play.api.ApplicationLoader.Context
import play.api._

class TBAApplicationLoader extends ApplicationLoader {
  override def load(context: Context): Application = {
    (new BuiltInComponentsFromContext(context) with TBAComponents).application
  }
}

trait TBAComponents
  extends BuiltInComponentsFromContext
  with TBAApplication
  with WSClientModule {

  import com.softwaremill.macwire.MacwireMacros._

  def routes: Routes = {
    wire[Routes]
  }

  lazy val assets: Assets = new Assets
}
