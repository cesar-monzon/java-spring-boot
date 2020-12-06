package UpcCards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UpcCardsService{

    @Autowired
    private UpcCardsRepository repo;
    
    public UpcCard findByUpc(String upc) {

        List<UpcCard> results = repo.findByUpc(upc);

        if(results.size() > 0){
            return results.get(0);
        }
        return null;
    }

    public UpcCard save(UpcCard card) {
        return repo.save(card);
    }
}