package controllers;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

import models.Item;
import models.ItemRepository;
import play.data.FormFactory;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;

import java.io.*;
import java.sql.*;
import javax.inject.Inject;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.concurrent.CompletionStage;
import javax.persistence.NoResultException;
import java.util.stream.Collectors;
import javax.persistence.Query;

import static play.libs.Json.toJson;

public class ItemController extends Controller {

    private final FormFactory formFactory;
    private final ItemRepository itemRepository;
    private final HttpExecutionContext ec;

    @Inject
    public ItemController(FormFactory formFactory, ItemRepository itemRepository, HttpExecutionContext ec) {
        this.formFactory = formFactory;
        this.itemRepository = itemRepository;
        this.ec = ec;
    }

    public Result index() {
        return ok(views.html.index.render());
    }

    public CompletionStage<Result> getItems() {
        return itemRepository.list().thenApplyAsync(itemStream -> {
            return ok(toJson(itemStream.collect(Collectors.toList())));
        }, ec.current());
    }

    public CompletionStage<Result> addItem() {
        JsonNode js = request().body().asJson();
        Item item = Json.fromJson(js, Item.class);
        return itemRepository.add(item).thenApplyAsync(p -> {
            //return redirect(routes.PersonController.index());
            String s="{\"id\":"+p.id+"}";
            return ok(s);
        }, ec.current());
    }

    public CompletionStage<Result> buy(){
        JsonNode js = request().body().asJson();
        String customer = js.get("customer").asText();
        Long id = js.get("id").asLong();
        return itemRepository.buyItem(customer,id).thenApplyAsync(ps ->{
            if (ps != null) {
                /*return badRequest("not a valid");*/
                return ok(ps.status);
            }
            else {

                return badRequest("cannot Buy");

            }
        });

    }
}
