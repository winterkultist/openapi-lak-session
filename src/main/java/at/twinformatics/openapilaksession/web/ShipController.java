package at.twinformatics.openapilaksession.web;

import at.twinformatics.openapilaksession.web.model.Ship;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShipController implements ShipApi {

    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Hello, World";
    }

    @Override
    public ResponseEntity<Ship> shipIdGet(Integer id) {
        final var ship = new Ship().id(id);
        return new ResponseEntity<>(ship, HttpStatus.OK);
    }
}
