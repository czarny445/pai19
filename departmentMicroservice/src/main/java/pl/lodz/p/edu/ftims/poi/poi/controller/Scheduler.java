package pl.lodz.p.edu.ftims.poi.poi.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    @Scheduled(cron = "*/5 * * * * ?")
    public void syncronizeDB()
    {
        
    }
    
}
