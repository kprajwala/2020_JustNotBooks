// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/macadmin/2020_JustNotBooks/service/conf/routes
// @DATE:Sat Mar 14 11:56:07 IST 2020

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseItemController ItemController = new controllers.ReverseItemController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReversePersonController PersonController = new controllers.ReversePersonController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseTransactionController TransactionController = new controllers.ReverseTransactionController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseItemController ItemController = new controllers.javascript.ReverseItemController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReversePersonController PersonController = new controllers.javascript.ReversePersonController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseTransactionController TransactionController = new controllers.javascript.ReverseTransactionController(RoutesPrefix.byNamePrefix());
  }

}
