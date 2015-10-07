package pl.lodz.p.edu.ftims.poi.poi.main;

import com.mongodb.Mongo;
import java.net.UnknownHostException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author lwieczor
 */
@SpringBootApplication
@EnableWebMvc
@EnableSpringDataWebSupport
public class SpringBootMainConfiguration {

    @Bean
    public Mongo mongo() throws UnknownHostException {
        Mongo mongo = new Mongo("localhost");
        return mongo;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMainConfiguration.class, args);
    }

}
