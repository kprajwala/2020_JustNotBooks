// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/macadmin/2020_JustNotBooks/service/conf/routes
// @DATE:Sat Mar 14 11:56:07 IST 2020

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {

  // @LINE:16
  class ReverseItemController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def getBuyItems: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ItemController.getBuyItems",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "itemsbuy"})
        }
      """
    )
  
    // @LINE:26
    def itemDetails: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ItemController.itemDetails",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "itemDetails"})
        }
      """
    )
  
    // @LINE:20
    def getBorrowItems: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ItemController.getBorrowItems",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "itemsborrow"})
        }
      """
    )
  
    // @LINE:28
    def returnItem: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ItemController.returnItem",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "itemReturn"})
        }
      """
    )
  
    // @LINE:23
    def getItemsTaken: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ItemController.getItemsTaken",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "itemtaken"})
        }
      """
    )
  
    // @LINE:24
    def delItem: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ItemController.delItem",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "delete"})
        }
      """
    )
  
    // @LINE:18
    def borrow: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ItemController.borrow",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "borrow"})
        }
      """
    )
  
    // @LINE:27
    def search: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ItemController.search",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "search"})
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
  
    // @LINE:21
    def getDonateItems: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ItemController.getDonateItems",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "itemsdonate"})
        }
      """
    )
  
    // @LINE:25
    def editItem: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ItemController.editItem",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editItem"})
        }
      """
    )
  
    // @LINE:22
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

  // @LINE:35
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:35
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:32
  class ReverseTransactionController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:32
    def addTransaction: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TransactionController.addTransaction",
      """
        function(trans0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "transaction" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("trans", trans0)])})
        }
      """
    )
  
  }


}
