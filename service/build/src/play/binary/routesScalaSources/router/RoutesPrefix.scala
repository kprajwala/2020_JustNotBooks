// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/macadmin/2020_JustNotBooks/service/conf/routes
// @DATE:Sat Mar 14 11:56:07 IST 2020


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
