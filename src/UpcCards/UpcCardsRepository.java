package UpcCards;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UpcCardsRepository extends CrudRepository<UpcCard, Long>{
    List<UpcCard> findByUpc(String upc);
}