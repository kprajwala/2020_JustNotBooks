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
import javax.persistence.Query;


import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * Provide JPA operations running inside of a thread pool sized to the connection pool
 */
public class JPANotificationRepository implements NotificationRepository {

    private final JPAApi jpaApi;
    private final DatabaseExecutionContext executionContext;
    //public enum status{Available,Unavailable};

    @Inject
    public JPANotificationRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
        this.jpaApi = jpaApi;
        this.executionContext = executionContext;
    }

    @Override
    public CompletionStage<Notification> add(Notification notification) {
        return supplyAsync(() -> wrap(em -> insert(em, notification)), executionContext);
    }


    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

    private Notification insert(EntityManager em, Notification notification) {
        em.persist(notification);
        return notification;
    }
    @Override
    public CompletionStage<Stream<Notification>> listNote(String owner) {
        return supplyAsync(() -> wrap(em -> listnote(em,owner)), executionContext);
    }
    private Stream<Notification> listnote(EntityManager em,String owner) {
        List<Notification> notes = em.createQuery("select i from Notification i where owner=:owner or customer=:owner", Notification.class).setParameter("owner",owner).getResultList();
        return notes.stream();
    }

    @Override
    public Person pay(String customer,Long id) {
        return wrap(em -> pay(em,customer,id));
    }

    private Person  pay(EntityManager em, String customer, Long id) {
        String cs="Processed";
        int i = em.createQuery("update Notification SET customerStatus=:cs where id=:id").setParameter("cs",cs).setParameter("id", id).executeUpdate();
        //int i=q.executeUpdate();
        if (i != 0) {
            Query query=em.createQuery("select owner from Notification where id=:id").setParameter("id",id);
            String name=query.getSingleResult().toString();
            Person notes = em.createQuery("select p from Person p where name=:name", Person.class).setParameter("name", name).getSingleResult();
            return notes;
        } else {
            return null;
        }
    }
    @Override
    public Person confirm(String owner,Long id) {
        return wrap(em -> confirm(em,owner,id));
    }

    private Person  confirm(EntityManager em, String owner, Long id) {
        String cs="Processed";
        int i = em.createQuery("update Notification SET ownerStatus=:cs where id=:id").setParameter("cs",cs).setParameter("id", id).executeUpdate();
        //int i=q.executeUpdate();
        if (i != 0) {
            Query query=em.createQuery("select customer from Notification where id=:id").setParameter("id",id);
            String name=query.getSingleResult().toString();
           Person details = em.createQuery("select i from Person i where i.name=:name", Person.class).setParameter("name", name).getSingleResult();
           Notification notification = em.createQuery("select i from Notification i where i.id=:id",Notification.class).setParameter("id",id).getSingleResult();
           em.remove(notification);
            return details;
        } else {
            return null;
        }
    }

}
