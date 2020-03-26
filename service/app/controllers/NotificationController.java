package controllers;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

import models.*;
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
import javax.*;
import static play.libs.Json.toJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;


public class NotificationController extends Controller {

    private final FormFactory formFactory;
   private final NotificationRepository notificationRepository;
    private final HttpExecutionContext ec;

    @Inject
    public NotificationController(FormFactory formFactory, NotificationRepository notificationRepository, HttpExecutionContext ec) {
        this.formFactory = formFactory;
       this.notificationRepository=notificationRepository;
        this.ec = ec;
    }

    public Result index() {
        return ok(views.html.index.render());
    }

    public CompletionStage<Result> addNotification() {
        JsonNode js = request().body().asJson();
        Notification notification = Json.fromJson(js, Notification.class);
        return notificationRepository.add(notification).thenApplyAsync(p -> {
            //return redirect(routes.PersonController.index());
            String s="{\"id\":"+p.id+"}";
            return ok(s);
        }, ec.current());
    }
    public CompletionStage<Result> getNotification() {
        JsonNode js = request().body().asJson();
        String owner = js.get("owner").asText();
        return notificationRepository.listNote(owner).thenApplyAsync(notificationStream -> {
            return ok(toJson(notificationStream.collect(Collectors.toList())));
        }, ec.current());
    }


    public Result pay(){
        JsonNode js = request().body().asJson();
        String customer = js.get("customer").asText();
        Long id=js.get("id").asLong();
        Person ps = notificationRepository.pay(customer,id);

        if (ps != null) {
            /*return badRequest("not a valid");*/

            return ok(Json.toJson(ps));
        } else {

            return badRequest("Cannot do payment");

        }
    }
    public Result confirm(){
        JsonNode js = request().body().asJson();
        String owner = js.get("owner").asText();
        Long id=js.get("id").asLong();
        Person ps = notificationRepository.confirm(owner,id);

        if (ps != null) {
            /*return badRequest("not a valid");*/

            return ok(Json.toJson(ps));
        } else {

            return badRequest("Cannot Handle penalty");

        }
    }
}
