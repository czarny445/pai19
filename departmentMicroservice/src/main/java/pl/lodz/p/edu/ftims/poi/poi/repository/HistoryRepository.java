/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.edu.ftims.poi.poi.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import pl.lodz.p.edu.ftims.poi.poi.entities.History;

/**
 *
 * @author lwieczor
 */
public interface HistoryRepository extends MongoRepository<History, Long> {

    @Override
    @RestResource(exported = false)
    void delete(Long id);

    @Override
    @RestResource(exported = false)
    void delete(History entity);
    
    public List<History> findByReportStatus(Boolean reportStatus);

}
