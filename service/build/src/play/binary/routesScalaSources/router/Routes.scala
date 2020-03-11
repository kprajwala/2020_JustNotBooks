// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/macadmin/Desktop/sample/RegistrationLogin/conf/routes
// @DATE:Tue Mar 10 13:59:11 IST 2020

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  PersonController_2: controllers.PersonController,
  // @LINE:16
  ItemController_1: controllers.ItemController,
  // @LINE:27
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    PersonController_2: controllers.PersonController,
    // @LINE:16
    ItemController_1: controllers.ItemController,
    // @LINE:27
    Assets_0: controllers.Assets
  ) = this(errorHandler, PersonController_2, ItemController_1, Assets_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, PersonController_2, ItemController_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.PersonController.index()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """person""", """controllers.PersonController.addPerson()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """persons""", """controllers.PersonController.getPersons()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """details""", """controllers.PersonController.profile()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """personVal/""" + "$" + """user<[^/]+>""", """controllers.PersonController.valid(user:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """personVal""", """controllers.PersonController.login()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """check""", """controllers.PersonController.checkName()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """edit""", """controllers.PersonController.editPerson()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """item""", """controllers.ItemController.addItem()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """buy""", """controllers.ItemController.buy()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """itemsbuy""", """controllers.ItemController.getBuyItems()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """itemsborrow""", """controllers.ItemController.getBorrowItems()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """itemsdonate""", """controllers.ItemController.getDonateItems()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """itemupload""", """controllers.ItemController.getItemsUpload()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """itemtaken""", """controllers.ItemController.getItemsTaken()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """delete""", """controllers.ItemController.delItem()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """editItem""", """controllers.ItemController.editItem()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """itemDetails""", """controllers.ItemController.itemDetails()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_PersonController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_PersonController_index0_invoker = createInvoker(
    PersonController_2.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ Home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_PersonController_addPerson1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("person")))
  )
  private[this] lazy val controllers_PersonController_addPerson1_invoker = createInvoker(
    PersonController_2.addPerson(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "addPerson",
      Nil,
      "POST",
      this.prefix + """person""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_PersonController_getPersons2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("persons")))
  )
  private[this] lazy val controllers_PersonController_getPersons2_invoker = createInvoker(
    PersonController_2.getPersons(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "getPersons",
      Nil,
      "GET",
      this.prefix + """persons""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_PersonController_profile3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("details")))
  )
  private[this] lazy val controllers_PersonController_profile3_invoker = createInvoker(
    PersonController_2.profile(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "profile",
      Nil,
      "POST",
      this.prefix + """details""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_PersonController_valid4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("personVal/"), DynamicPart("user", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PersonController_valid4_invoker = createInvoker(
    PersonController_2.valid(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "valid",
      Seq(classOf[String]),
      "GET",
      this.prefix + """personVal/""" + "$" + """user<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_PersonController_login5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("personVal")))
  )
  private[this] lazy val controllers_PersonController_login5_invoker = createInvoker(
    PersonController_2.login(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "login",
      Nil,
      "POST",
      this.prefix + """personVal""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_PersonController_checkName6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("check")))
  )
  private[this] lazy val controllers_PersonController_checkName6_invoker = createInvoker(
    PersonController_2.checkName(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "checkName",
      Nil,
      "POST",
      this.prefix + """check""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_PersonController_editPerson7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("edit")))
  )
  private[this] lazy val controllers_PersonController_editPerson7_invoker = createInvoker(
    PersonController_2.editPerson(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "editPerson",
      Nil,
      "POST",
      this.prefix + """edit""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_ItemController_addItem8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("item")))
  )
  private[this] lazy val controllers_ItemController_addItem8_invoker = createInvoker(
    ItemController_1.addItem(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ItemController",
      "addItem",
      Nil,
      "POST",
      this.prefix + """item""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_ItemController_buy9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("buy")))
  )
  private[this] lazy val controllers_ItemController_buy9_invoker = createInvoker(
    ItemController_1.buy(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ItemController",
      "buy",
      Nil,
      "POST",
      this.prefix + """buy""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_ItemController_getBuyItems10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("itemsbuy")))
  )
  private[this] lazy val controllers_ItemController_getBuyItems10_invoker = createInvoker(
    ItemController_1.getBuyItems(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ItemController",
      "getBuyItems",
      Nil,
      "POST",
      this.prefix + """itemsbuy""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_ItemController_getBorrowItems11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("itemsborrow")))
  )
  private[this] lazy val controllers_ItemController_getBorrowItems11_invoker = createInvoker(
    ItemController_1.getBorrowItems(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ItemController",
      "getBorrowItems",
      Nil,
      "POST",
      this.prefix + """itemsborrow""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_ItemController_getDonateItems12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("itemsdonate")))
  )
  private[this] lazy val controllers_ItemController_getDonateItems12_invoker = createInvoker(
    ItemController_1.getDonateItems(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ItemController",
      "getDonateItems",
      Nil,
      "POST",
      this.prefix + """itemsdonate""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_ItemController_getItemsUpload13_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("itemupload")))
  )
  private[this] lazy val controllers_ItemController_getItemsUpload13_invoker = createInvoker(
    ItemController_1.getItemsUpload(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ItemController",
      "getItemsUpload",
      Nil,
      "POST",
      this.prefix + """itemupload""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_ItemController_getItemsTaken14_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("itemtaken")))
  )
  private[this] lazy val controllers_ItemController_getItemsTaken14_invoker = createInvoker(
    ItemController_1.getItemsTaken(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ItemController",
      "getItemsTaken",
      Nil,
      "POST",
      this.prefix + """itemtaken""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_ItemController_delItem15_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("delete")))
  )
  private[this] lazy val controllers_ItemController_delItem15_invoker = createInvoker(
    ItemController_1.delItem(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ItemController",
      "delItem",
      Nil,
      "POST",
      this.prefix + """delete""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_ItemController_editItem16_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("editItem")))
  )
  private[this] lazy val controllers_ItemController_editItem16_invoker = createInvoker(
    ItemController_1.editItem(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ItemController",
      "editItem",
      Nil,
      "POST",
      this.prefix + """editItem""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_ItemController_itemDetails17_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("itemDetails")))
  )
  private[this] lazy val controllers_ItemController_itemDetails17_invoker = createInvoker(
    ItemController_1.itemDetails(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ItemController",
      "itemDetails",
      Nil,
      "POST",
      this.prefix + """itemDetails""",
      """""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_Assets_at18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at18_invoker = createInvoker(
    Assets_0.at(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_PersonController_index0_route(params@_) =>
      call { 
        controllers_PersonController_index0_invoker.call(PersonController_2.index())
      }
  
    // @LINE:7
    case controllers_PersonController_addPerson1_route(params@_) =>
      call { 
        controllers_PersonController_addPerson1_invoker.call(PersonController_2.addPerson())
      }
  
    // @LINE:8
    case controllers_PersonController_getPersons2_route(params@_) =>
      call { 
        controllers_PersonController_getPersons2_invoker.call(PersonController_2.getPersons())
      }
  
    // @LINE:9
    case controllers_PersonController_profile3_route(params@_) =>
      call { 
        controllers_PersonController_profile3_invoker.call(PersonController_2.profile())
      }
  
    // @LINE:10
    case controllers_PersonController_valid4_route(params@_) =>
      call(params.fromPath[String]("user", None)) { (user) =>
        controllers_PersonController_valid4_invoker.call(PersonController_2.valid(user))
      }
  
    // @LINE:11
    case controllers_PersonController_login5_route(params@_) =>
      call { 
        controllers_PersonController_login5_invoker.call(PersonController_2.login())
      }
  
    // @LINE:12
    case controllers_PersonController_checkName6_route(params@_) =>
      call { 
        controllers_PersonController_checkName6_invoker.call(PersonController_2.checkName())
      }
  
    // @LINE:13
    case controllers_PersonController_editPerson7_route(params@_) =>
      call { 
        controllers_PersonController_editPerson7_invoker.call(PersonController_2.editPerson())
      }
  
    // @LINE:16
    case controllers_ItemController_addItem8_route(params@_) =>
      call { 
        controllers_ItemController_addItem8_invoker.call(ItemController_1.addItem())
      }
  
    // @LINE:17
    case controllers_ItemController_buy9_route(params@_) =>
      call { 
        controllers_ItemController_buy9_invoker.call(ItemController_1.buy())
      }
  
    // @LINE:18
    case controllers_ItemController_getBuyItems10_route(params@_) =>
      call { 
        controllers_ItemController_getBuyItems10_invoker.call(ItemController_1.getBuyItems())
      }
  
    // @LINE:19
    case controllers_ItemController_getBorrowItems11_route(params@_) =>
      call { 
        controllers_ItemController_getBorrowItems11_invoker.call(ItemController_1.getBorrowItems())
      }
  
    // @LINE:20
    case controllers_ItemController_getDonateItems12_route(params@_) =>
      call { 
        controllers_ItemController_getDonateItems12_invoker.call(ItemController_1.getDonateItems())
      }
  
    // @LINE:21
    case controllers_ItemController_getItemsUpload13_route(params@_) =>
      call { 
        controllers_ItemController_getItemsUpload13_invoker.call(ItemController_1.getItemsUpload())
      }
  
    // @LINE:22
    case controllers_ItemController_getItemsTaken14_route(params@_) =>
      call { 
        controllers_ItemController_getItemsTaken14_invoker.call(ItemController_1.getItemsTaken())
      }
  
    // @LINE:23
    case controllers_ItemController_delItem15_route(params@_) =>
      call { 
        controllers_ItemController_delItem15_invoker.call(ItemController_1.delItem())
      }
  
    // @LINE:24
    case controllers_ItemController_editItem16_route(params@_) =>
      call { 
        controllers_ItemController_editItem16_invoker.call(ItemController_1.editItem())
      }
  
    // @LINE:25
    case controllers_ItemController_itemDetails17_route(params@_) =>
      call { 
        controllers_ItemController_itemDetails17_invoker.call(ItemController_1.itemDetails())
      }
  
    // @LINE:27
    case controllers_Assets_at18_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at18_invoker.call(Assets_0.at(path, file))
      }
  }
}
