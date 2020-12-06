package UpcCards;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.*;
import org.springframework.validation.BindException;


@RestController
public class UpcCardsController{

    @Autowired
    UpcCardsService service;

    @RequestMapping(value = "/upc-cards", method = RequestMethod.GET)
    public ResponseEntity<UpcCard> getUpcCard(@Valid UpcCard model, 
                                        BindingResult result) throws BindException {
        if (result.hasErrors()) {
            throw new BindException(result);
        } 
        UpcCard itemFound = service.findByUpc(model.getUpc());

        return new ResponseEntity<UpcCard>(itemFound, HttpStatus.OK);
    }

    @RequestMapping(value = "/upc-cards", method = RequestMethod.POST)
    public ResponseEntity<UpcCard> postUpcCard(@Valid UpcCard model, 
                                        BindingResult result) throws BindException {
        if (result.hasErrors()) {
            throw new BindException(result);
        } 
        service.save(model);
        return new ResponseEntity<UpcCard>(model, HttpStatus.OK);
    }
}
