/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.edu.ftims.poi.poi.repository;

import java.math.BigInteger;
import org.springframework.data.mongodb.repository.MongoRepository;
import pl.lodz.p.edu.ftims.poi.poi.entities.Historia;

/**
 * http://docs.spring.io/spring-data/rest/docs/current/reference/html/
 * @author lwieczor
 */
public interface HistoryRepository extends MongoRepository<Historia, BigInteger> {
    
}
