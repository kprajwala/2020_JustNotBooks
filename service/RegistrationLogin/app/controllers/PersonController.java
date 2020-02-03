package controllers;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import java.util.Map;
import java.util.HashMap;

import models.Person;
import models.PersonRepository;
import play.data.FormFactory;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;

import java.io.*;
import java.sql.*;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

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
   //Map<String, String> hm = new HashMap<String, String>();
    public Result loginValidate() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Admin@123");
            Statement myStatement = con.createStatement();
            JsonNode requestJson = request().body().asJson();
            String username = null;
            String password = null;
            if(requestJson.has("name")){
                username=requestJson.get("name").asText();
            }
            if(requestJson.has("pswd")){
                password=requestJson.get("pswd").asText();
            }
            String sql = "select * from project.Person where name='"+username+"' and pswd='"+password+"'";
            ResultSet rs = myStatement.executeQuery(sql);
            while (rs.next()) {
               //if(password=="sri123")
                    return ok("Login Successful!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ok("Invalid Credentials");
    }
}
