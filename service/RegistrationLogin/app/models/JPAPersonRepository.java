package models;

import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.stream.Stream;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.lang.Exception;
import javax.persistence.NoResultException;


import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * Provide JPA operations running inside of a thread pool sized to the connection pool
 */
public class JPAPersonRepository implements PersonRepository {

    private final JPAApi jpaApi;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public JPAPersonRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
        this.jpaApi = jpaApi;
        this.executionContext = executionContext;
    }

    @Override
    public CompletionStage<Person> add(Person person) {
        return supplyAsync(() -> wrap(em -> insert(em, person)), executionContext);
    }

    @Override
    public CompletionStage<Stream<Person>> list() {
        return supplyAsync(() -> wrap(em -> list(em)), executionContext);
    }

    @Override
    public CompletionStage<Person> del(String name) {
        return supplyAsync( () -> wrap(em -> delete(em, name)), executionContext);
    }

    @Override
    public CompletionStage<Stream<Person>> listuser(String username,String password) {
        return supplyAsync( () -> wrap(em -> listuser(em, username,password)), executionContext);
    }

    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

    private Person insert(EntityManager em, Person person) {
        em.persist(person);
        return person;
    }

    private Person delete(EntityManager em, String name) {
        Person person = em.createQuery("select p from Person p where p.name=:name", Person.class).setParameter("name", name).getSingleResult();
        em.remove(person);
        return person;
    }

    private Stream<Person> list(EntityManager em) {
        List<Person> persons = em.createQuery("select p from Person p", Person.class).getResultList();
        return persons.stream();
    }


    private Stream<Person> listuser(EntityManager em,String username,String password){
        try {
            List<Person> persons = em.createQuery("select p from Person p where name=:username and pswd=:password", Person.class).setParameter("username", username).setParameter("password", password).getResultList();
            return persons.stream();

        }
        catch(NoResultException e){
            return null;
        }

    }

    @Override
    public Person login(String username,String password) throws NoResultException {
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
            EntityManager em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();

            Person foundPerson = em.createQuery("select p from Person p where name=:username and pswd=:password", Person.class).setParameter("username", username).setParameter("password", password).getSingleResult();
            //em.remove(foundPerson);
            return foundPerson;
        } catch (NoResultException e) {
            return null;
        }
    }
        @Override
        public Person profile(String username) throws NoResultException {
            try{
                EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
                EntityManager em= entityManagerFactory.createEntityManager();
                em.getTransaction().begin();

                Person foundPerson = em.createQuery("select p from Person p where name=:username ",Person.class).setParameter("username", username).getSingleResult();
                //em.remove(foundPerson);
                return foundPerson;
            }
            catch(NoResultException e){
                return null;
            }




        }
}
