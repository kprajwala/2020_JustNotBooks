// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/macadmin/Desktop/sample/RegistrationLogin/conf/routes
// @DATE:Tue Mar 10 13:59:11 IST 2020

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:16
  class ReverseItemController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def getBuyItems(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "itemsbuy")
    }
  
    // @LINE:25
    def itemDetails(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "itemDetails")
    }
  
    // @LINE:19
    def getBorrowItems(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "itemsborrow")
    }
  
    // @LINE:22
    def getItemsTaken(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "itemtaken")
    }
  
    // @LINE:23
    def delItem(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "delete")
    }
  
    // @LINE:17
    def buy(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "buy")
    }
  
    // @LINE:20
    def getDonateItems(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "itemsdonate")
    }
  
    // @LINE:24
    def editItem(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "editItem")
    }
  
    // @LINE:21
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

  // @LINE:27
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def at(file:String): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }


}
