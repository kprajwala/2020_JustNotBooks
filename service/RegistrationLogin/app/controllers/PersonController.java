package controllers;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

import models.Person;
import models.PersonRepository;
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

/**
 * The controller keeps all database operations behind the repository, and uses
 * {@link play.libs.concurrent.HttpExecutionContext} to provide access to the
 * {@link play.mvc.Http.Context} methods like {@code request()} and {@code flash()}.
 */
public class PersonController extends Controller {

    private final FormFactory formFactory;
    private final PersonRepository personRepository;
    private final HttpExecutionContext ec;

    @Inject
    public PersonController(FormFactory formFactory, PersonRepository personRepository, HttpExecutionContext ec) {
        this.formFactory = formFactory;
        this.personRepository = personRepository;
        this.ec = ec;
    }

    public Result index() {
        return ok(views.html.index.render());
    }

    public CompletionStage<Result> addPerson() {
        JsonNode js = request().body().asJson();
        Person person = Json.fromJson(js, Person.class);
        return personRepository.add(person).thenApplyAsync(p -> {
            //return redirect(routes.PersonController.index());
            return ok("Insert Successful");
        }, ec.current());
    }



    public CompletionStage<Result> delPerson(String name) {
        return personRepository.del(name).thenApplyAsync(p -> {
            return ok("Delete successful");
        }, ec.current());
    }

    public CompletionStage<Result> getPersons() {
        return personRepository.list().thenApplyAsync(personStream -> {
            return ok(toJson(personStream.collect(Collectors.toList())));
        }, ec.current());
    }
    public Result valid(String user) {
        return ok("Hi "+user);
    }
   //Map<String, String> hm = new HashMap<String, String>();
    public Result login() {
        JsonNode j=request().body().asJson();
        String username=j.get("name").asText();
        String password=j.get("pswd").asText();
        Person ps=personRepository.login(username,password);
       if(ps==null){
            return ok("Invalid credentials!!");
        }
        else{
            return redirect("personVal/"+ps.name);
        }

    }
    public Result profile(){
        JsonNode j=request().body().asJson();
        String username=j.get("name").asText();

        /*return personRepository.listuser(username,password).thenApplyAsync(personStream -> {
            return ok(toJson(personStream.collect(Collectors.toList())));*/
            Person ps=personRepository.profile(username);
            if(ps==null){
                return ok("Invalid credentials!!");
            }
            else{
                String s="{\"email\":\""+ps.email+"\",\"name\":\""+ps.phoneNumber+"\"}";

                return ok(Json.parse(s));
            }

        }
    }

