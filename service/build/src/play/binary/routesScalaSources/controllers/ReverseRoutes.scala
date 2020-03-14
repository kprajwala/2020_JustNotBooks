// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/macadmin/2020_JustNotBooks/service/conf/routes
// @DATE:Sat Mar 14 11:56:07 IST 2020

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:16
  class ReverseItemController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def getBuyItems(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "itemsbuy")
    }
  
    // @LINE:26
    def itemDetails(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "itemDetails")
    }
  
    // @LINE:20
    def getBorrowItems(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "itemsborrow")
    }
  
    // @LINE:28
    def returnItem(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "itemReturn")
    }
  
    // @LINE:23
    def getItemsTaken(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "itemtaken")
    }
  
    // @LINE:24
    def delItem(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "delete")
    }
  
    // @LINE:18
    def borrow(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "borrow")
    }
  
    // @LINE:27
    def search(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "search")
    }
  
    // @LINE:17
    def buy(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "buy")
    }
  
    // @LINE:21
    def getDonateItems(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "itemsdonate")
    }
  
    // @LINE:25
    def editItem(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "editItem")
    }
  
    // @LINE:22
    def getItemsUpload(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "itemupload")
    }
  
    // @LINE:16
    def addItem(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "item")
    }
  
  }

  // @LINE:6
  class ReversePersonController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def profile(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "details")
    }
  
    // @LINE:13
    def editPerson(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "edit")
    }
  
    // @LINE:7
    def addPerson(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "person")
    }
  
    // @LINE:10
    def valid(user:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "personVal/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("user", user)))
    }
  
    // @LINE:12
    def checkName(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "check")
    }
  
    // @LINE:8
    def getPersons(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "persons")
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:11
    def login(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "personVal")
    }
  
  }

  // @LINE:35
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:35
    def at(file:String): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }

  // @LINE:32
  class ReverseTransactionController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:32
    def addTransaction(trans:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "transaction" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("trans", trans)))))
    }
  
  }


}
