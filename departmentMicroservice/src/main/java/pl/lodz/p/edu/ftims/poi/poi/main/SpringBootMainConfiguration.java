package pl.lodz.p.edu.ftims.poi.poi.main;

import com.mongodb.Mongo;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import pl.lodz.p.edu.ftims.poi.poi.entities.History;
import pl.lodz.p.edu.ftims.poi.poi.repository.HistoryRepository;

/**
 *
 * @author lwieczor
 */
@SpringBootApplication
@EnableMongoRepositories(basePackages = "pl.lodz.p.edu.ftims.poi.poi.repository")
@ComponentScan("pl.lodz.p.edu.ftims.poi.poi")
@EnableAsync
@EnableScheduling
public class SpringBootMainConfiguration extends AbstractMongoConfiguration {

    @Autowired
    private HistoryRepository hr;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMainConfiguration.class, args);
    }

//    @RequestMapping("/")
//    @ResponseBody
//    String home() {
//        return "Hello World!";
//    }
//    
    @PostConstruct
    public void run() throws Exception {

        System.out.println("----- Aplikacja uruchomiona -----");
        System.out.println("----- Czyszczenie bazy -----");
        System.out.println("----- Wypełnianie danymi    -----");
//        Department findByName = dr.findByName("Pierwszy");
//        findByName.setAddress("Nowy adres");
//        dr.save(findByName);
//
        History history = new History();
        History history2 = new History();
        History history3 = new History();

        history.setDate(Date.from(LocalDateTime.now().minusDays(3).atZone(ZoneId.systemDefault()).toInstant()));
        history2.setDate(Date.from(LocalDateTime.now().minusDays(4).minusHours(1).atZone(ZoneId.systemDefault()).toInstant()));
        history3.setDate(Date.from(LocalDateTime.now().minusDays(5).minusHours(3).atZone(ZoneId.systemDefault()).toInstant()));

        history.setPack(1L);
        history2.setPack(2L);
        history3.setPack(3L);

        history.setReportStatus(Boolean.TRUE);
        history2.setReportStatus(Boolean.FALSE);
        history3.setReportStatus(Boolean.FALSE);

        hr.save(history);
        hr.save(history2);
        hr.save(history3);

//        while(true);
    }

    @Override
    protected String getDatabaseName() {
        return "poiDepartment";
    }

    @Override
    public Mongo mongo() throws Exception {
        Mongo mongo = new Mongo("localhost");
        return mongo;
    }

}
