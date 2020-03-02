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
    CompletionStage<Stream<Item>> list();
}
