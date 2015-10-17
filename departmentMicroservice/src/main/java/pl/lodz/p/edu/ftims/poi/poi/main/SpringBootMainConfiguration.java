package pl.lodz.p.edu.ftims.poi.poi.main;

import com.mongodb.Mongo;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
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
