package at.twinformatics.openapilaksession.web;

import at.twinformatics.openapilaksession.Stuff;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShipController implements Stuff, ShipApi {

    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Hello, World";
    }
}
