package pl.lodz.p.edu.ftims.poi.poi.controller;

import java.time.Instant;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.lodz.p.edu.ftims.poi.poi.entities.History;
import pl.lodz.p.edu.ftims.poi.poi.repository.HistoryRepository;

@Controller
public class CheckpointController {

    @Autowired
    HistoryRepository hr;

    @RequestMapping("/checkpoint")
    public @ResponseBody String checkpoint(@RequestBody History h) {
        h.setDate(Date.from(Instant.now()));
        hr.save(h);
        return "{\"succes\" :\"true\"}";
    }
    
    @RequestMapping("/checkpointload")
    public @ResponseBody History checkpointload() {
        History history = new History();
        history.setDate(Date.from(Instant.now()));
        history.setPack("1234567890");
        return history;
    }

}
