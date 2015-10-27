package pl.lodz.p.edu.ftims.poi.poi.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.lodz.p.edu.ftims.poi.poi.entities.History;
import pl.lodz.p.edu.ftims.poi.poi.repository.HistoryRepository;

@Component
public class Scheduler {

    private static final Logger logger = Logger.getLogger(Scheduler.class.getName());
    
    @Autowired
    private HistoryRepository hr;
    
    @Scheduled(cron = "*/5 * * * * ?")
    public void syncronizeDB()
    {
        List<History> findByReportStatus = hr.findByReportStatus(Boolean.FALSE);
        logger.log(Level.INFO, "Scheduler: {0}", findByReportStatus.size());
    }
    
}
