// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/macadmin/Desktop/sample/play-java-jpa-example copy/conf/routes
// @DATE:Sat Jan 11 16:04:47 IST 2020


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
