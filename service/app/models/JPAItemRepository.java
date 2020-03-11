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
    //public enum status{Available,Unavailable};

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
    public CompletionStage<Stream<Item>> listBuy(String owner) {
        return supplyAsync(() -> wrap(em -> listbuy(em,owner)), executionContext);
    }
    private Stream<Item> listbuy(EntityManager em,String owner) {
        String s="Available";
        String cat="Buy";
        List<Item> items = em.createQuery("select i from Item i where status=:s and not owner=:owner and category=:cat", Item.class).setParameter("s",s).setParameter("owner",owner).setParameter("cat",cat).getResultList();
        return items.stream();
    }
    @Override
    public CompletionStage<Stream<Item>> listBorrow(String owner) {
        return supplyAsync(() -> wrap(em -> listborrow(em,owner)), executionContext);
    }
    private Stream<Item> listborrow(EntityManager em,String owner) {
        String s="Available";
        String cat="Borrow";
        List<Item> items = em.createQuery("select i from Item i where status=:s and not owner=:owner and category=:cat", Item.class).setParameter("s",s).setParameter("owner",owner).setParameter("cat",cat).getResultList();
        return items.stream();
    }
    @Override
    public CompletionStage<Stream<Item>> listDonate(String owner) {
        return supplyAsync(() -> wrap(em -> listdonate(em,owner)), executionContext);
    }
    private Stream<Item> listdonate(EntityManager em,String owner) {
        String s="Available";
        String cat="Donate";
        List<Item> items = em.createQuery("select i from Item i where status=:s and not owner=:owner and category=:cat", Item.class).setParameter("s",s).setParameter("owner",owner).setParameter("cat",cat).getResultList();
        return items.stream();
    }
    @Override
    public CompletionStage<Stream<Item>> listUploaded(String owner) {
        return supplyAsync(() -> wrap(em -> listUpload(em,owner)), executionContext);
    }
    private Stream<Item> listUpload(EntityManager em,String owner) {
        //String s="Available";
        List<Item> items = em.createQuery("select i from Item i where owner=:owner", Item.class).setParameter("owner",owner).getResultList();
        return items.stream();
    }

    @Override
    public CompletionStage<Stream<Item>> listTaken(String customer) {
        return supplyAsync(() -> wrap(em -> listTake(em,customer)), executionContext);
    }
    private Stream<Item> listTake(EntityManager em,String customer) {
        //String s="Available";
        List<Item> items = em.createQuery("select i from Item i where customer=:customer", Item.class).setParameter("customer",customer).getResultList();
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

    @Override
    public CompletionStage<Item> del(String owner,Long id) {
        return supplyAsync(() -> wrap(em -> delete(em, owner,id)), executionContext);
    }
    private Item delete(EntityManager em, String owner,Long id) {
        Item item = em.createQuery("select i from Item i where i.owner=:owner and i.id=:id", Item.class).setParameter("owner", owner).setParameter("id", id).getSingleResult();
        em.remove(item);
        return item;
    }

    @Override
    public CompletionStage<Item> edit(Long id,Integer price,String description,String address,String category) {
        return supplyAsync(() -> wrap(em -> editvalue(em, id, price,description,address,category)), executionContext);
    }

    private Item editvalue(EntityManager em, Long id, Integer price,String description,String address,String category) {
        String status="Available";
        int i = em.createQuery("update Item SET price=:price,description=:description,address=:address,category=:category where id=:id and status=:status").setParameter("id", id).setParameter("price", price).setParameter("address", address).setParameter("description", description).setParameter("category", category).setParameter("status", status).executeUpdate();
        //int i=q.executeUpdate();
        if (i != 0) {
            Item items = em.createQuery("select i from Item i where id=:id", Item.class).setParameter("id", id).getSingleResult();
            return items;
        } else {
            return null;
        }
    }

    @Override
    public Item details(Long id) throws NoResultException {
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
            EntityManager em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();

            Item foundItem = em.createQuery("select p from Item p where id=:id ", Item.class).setParameter("id", id).getSingleResult();
            //em.remove(foundPerson);
            return foundItem;
        } catch (NoResultException e) {
            return null;
        }


    }


}
