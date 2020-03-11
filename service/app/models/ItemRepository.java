package models;

import com.google.inject.ImplementedBy;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

/**
 * This interface provides a non-blocking API for possibly blocking operations.
 */
@ImplementedBy(JPAItemRepository.class)
public interface ItemRepository {

    CompletionStage<Item> add(Item item);
    CompletionStage<Item> buyItem(String customer,Long id);
    CompletionStage<Stream<Item>> listBuy(String owner);
    CompletionStage<Stream<Item>> listBorrow(String owner);
    CompletionStage<Stream<Item>> listDonate(String owner);
    CompletionStage<Stream<Item>> listUploaded(String owner);
    CompletionStage<Stream<Item>> listTaken(String customer);
    public CompletionStage<Item> edit(Long id,Integer price,String description,String address,String category);
    CompletionStage<Item> del(String owner,Long id);
    abstract Item details(Long id);
}
