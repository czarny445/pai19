package pl.lodz.p.edu.ftims.poi.poi.main;

import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import pl.lodz.p.edu.ftims.poi.poi.entities.Department;
import pl.lodz.p.edu.ftims.poi.poi.repository.DepartmentRepository;

/**
 *
 * @author lwieczor
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableMongoRepositories(basePackages = "pl.lodz.p.edu.ftims.poi.poi.repository")
public class SpringBootMainConfiguration extends AbstractMongoConfiguration implements CommandLineRunner {
    
    @Autowired
    private DepartmentRepository dr;
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMainConfiguration.class, args);
        
    }
    
    @Override
    public void run(String... args) throws Exception {
        
        System.out.println("----- Aplikacja uruchomiona -----");
        System.out.println("----- Czyszczenie bazy -----");
        
        dr.deleteAll();
        System.out.println("----- Wypełnianie danymi    -----");
        
        dr.save(new Department(1L, "Pierwszy", "Testowy adres"));
        dr.save(new Department(2L, "Drugi", "Testowy adres"));
        dr.save(new Department(3L, "Trzeci", "Testowy adres"));
        Department findByName = dr.findByName("Pierwszy");
        findByName.setAddress("Nowy adres");
        dr.save(findByName);
        
        for (Department dprm : dr.findAll()) {
            System.out.println(dprm.toString());
        }
        
    }
    
    @Override
    protected String getDatabaseName() {
        return "poi";
    }
    
    @Override
    public Mongo mongo() throws Exception {
        Mongo mongo = new Mongo("localhost");
        return mongo;
    }
    
}
