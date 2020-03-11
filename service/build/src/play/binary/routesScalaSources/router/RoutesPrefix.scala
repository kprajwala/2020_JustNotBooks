// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/macadmin/Desktop/sample/RegistrationLogin/conf/routes
// @DATE:Tue Mar 10 13:59:11 IST 2020


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
