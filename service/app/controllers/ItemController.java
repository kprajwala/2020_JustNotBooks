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

    public CompletionStage<Result> getBuyItems() {
        JsonNode js = request().body().asJson();
        String owner = js.get("owner").asText();
        return itemRepository.listBuy(owner).thenApplyAsync(itemStream -> {
            return ok(toJson(itemStream.collect(Collectors.toList())));
        }, ec.current());
    }
    public CompletionStage<Result> getBorrowItems() {
        JsonNode js = request().body().asJson();
        String owner = js.get("owner").asText();
        return itemRepository.listBorrow(owner).thenApplyAsync(itemStream -> {
            return ok(toJson(itemStream.collect(Collectors.toList())));
        }, ec.current());
    }
    public CompletionStage<Result> getDonateItems() {
        JsonNode js = request().body().asJson();
        String owner = js.get("owner").asText();
        return itemRepository.listDonate(owner).thenApplyAsync(itemStream -> {
            return ok(toJson(itemStream.collect(Collectors.toList())));
        }, ec.current());
    }
    public CompletionStage<Result> getItemsUpload() {
        JsonNode js = request().body().asJson();
        String owner = js.get("owner").asText();
        return itemRepository.listUploaded(owner).thenApplyAsync(itemStream -> {
            return ok(toJson(itemStream.collect(Collectors.toList())));
        }, ec.current());
    }
    public CompletionStage<Result> getItemsTaken() {
        JsonNode js = request().body().asJson();
        String customer = js.get("customer").asText();
        return itemRepository.listTaken(customer).thenApplyAsync(itemStream -> {
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
                return ok(" "+ps.owner);
            }
            else {

                return badRequest("cannot Buy");

            }
        });

    }

    public CompletionStage<Result> delItem() {
        JsonNode js = request().body().asJson();
        String owner = js.get("owner").asText();
        Long id = js.get("id").asLong();
        return itemRepository.del(owner,id).thenApplyAsync(p -> {
            if (p != null) {
                /*return badRequest("not a valid");*/
                return ok("Delete Successful");
            }
            else {

                return badRequest("cannot Delete");

            }
        }, ec.current());
    }


    public CompletionStage<Result> editItem() {
        JsonNode j = request().body().asJson();
        Long id=j.get("id").asLong();
        Integer price=j.get("price").asInt();
        String description = j.get("description").asText();
        String address = j.get("address").asText();
        String category = j.get("category").asText();
        return itemRepository.edit(id,price,description,address,category).thenApplyAsync(p -> {
            if(p!=null)
                return ok("Update successful");
            else
                return badRequest("Cannot update");
        }, ec.current());
    }

    public Result itemDetails() {

        JsonNode j = request().body().asJson();
        Long id = j.get("id").asLong();

        /*return personRepository.listuser(username,password).thenApplyAsync(personStream -> {
            return ok(toJson(personStream.collect(Collectors.toList())));*/
        Item ps = itemRepository.details(id);

        if (ps == null) {
            return ok("Invalid credentials!!");
        } else {
            String s = "{\"itemName\":\"" + ps.itemName + "\", \"price\":\"" + ps.price + "\",\"category\":\"" + ps.category + "\",\"address\":\"" + ps.address + "\",\"description\":\"" + ps.description + "\",\"from2\":\"" + ps.from2 + "\",\"to2\":\"" + ps.to2 + "\"}";

            return ok(Json.parse(s));
        }

    }
}
