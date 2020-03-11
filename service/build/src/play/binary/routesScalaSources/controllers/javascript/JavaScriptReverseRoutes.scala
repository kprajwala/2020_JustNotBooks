// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/macadmin/Desktop/sample/RegistrationLogin/conf/routes
// @DATE:Tue Mar 10 13:59:11 IST 2020

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {

  // @LINE:16
  class ReverseItemController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def getBuyItems: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ItemController.getBuyItems",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "itemsbuy"})
        }
      """
    )
  
    // @LINE:25
    def itemDetails: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ItemController.itemDetails",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "itemDetails"})
        }
      """
    )
  
    // @LINE:19
    def getBorrowItems: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ItemController.getBorrowItems",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "itemsborrow"})
        }
      """
    )
  
    // @LINE:22
    def getItemsTaken: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ItemController.getItemsTaken",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "itemtaken"})
        }
      """
    )
  
    // @LINE:23
    def delItem: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ItemController.delItem",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "delete"})
        }
      """
    )
  
    // @LINE:17
    def buy: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ItemController.buy",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "buy"})
        }
      """
    )
  
    // @LINE:20
    def getDonateItems: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ItemController.getDonateItems",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "itemsdonate"})
        }
      """
    )
  
    // @LINE:24
    def editItem: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ItemController.editItem",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editItem"})
        }
      """
    )
  
    // @LINE:21
    def getItemsUpload: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ItemController.getItemsUpload",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "itemupload"})
        }
      """
    )
  
    // @LINE:16
    def addItem: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ItemController.addItem",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "item"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReversePersonController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def profile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PersonController.profile",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "details"})
        }
      """
    )
  
    // @LINE:13
    def editPerson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PersonController.editPerson",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "edit"})
        }
      """
    )
  
    // @LINE:7
    def addPerson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PersonController.addPerson",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "person"})
        }
      """
    )
  
    // @LINE:10
    def valid: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PersonController.valid",
      """
        function(user0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "personVal/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("user", user0))})
        }
      """
    )
  
    // @LINE:12
    def checkName: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PersonController.checkName",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "check"})
        }
      """
    )
  
    // @LINE:8
    def getPersons: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PersonController.getPersons",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "persons"})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PersonController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:11
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PersonController.login",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "personVal"})
        }
      """
    )
  
  }

  // @LINE:27
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
