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
public class JPAItemRepository implements ItemRepository {

    private final JPAApi jpaApi;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public JPAItemRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
        this.jpaApi = jpaApi;
        this.executionContext = executionContext;
    }

    @Override
    public CompletionStage<Item> add(Item item) {
        return supplyAsync(() -> wrap(em -> insert(em, item)), executionContext);
    }


    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

    private Item insert(EntityManager em, Item item) {
        em.persist(item);
        return item;
    }

    @Override
    public CompletionStage<Stream<Item>> list() {
        return supplyAsync(() -> wrap(em -> list(em)), executionContext);
    }

    private Stream<Item> list(EntityManager em) {
        String s="Available";
        List<Item> items = em.createQuery("select i from Item i where status=:s", Item.class).setParameter("s",s).getResultList();
        return items.stream();
    }

    @Override
    public CompletionStage<Item> buyItem(String customer,Long id) {
        return supplyAsync(() -> wrap(em -> buyItems(em, customer,id)), executionContext);
    }

    private Item buyItems(EntityManager em,String customer,Long id){
            String s="Unavailable";
            int foundItem = em.createQuery("update Item SET customer=:customer,status=:s where id=:id").setParameter("customer", customer).setParameter("id", id).setParameter("s", s).executeUpdate();
        if (foundItem != 0) {
            Item items = em.createQuery("select p from Item p where id=:id",Item.class).setParameter("id", id).getSingleResult();
            return items;
        } else {
            return null;
        }

    }

}
