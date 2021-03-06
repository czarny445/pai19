/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.edu.ftims.poi.poi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import pl.lodz.p.edu.ftims.poi.poi.entities.Department;

/**
 * http://docs.spring.io/spring-data/rest/docs/current/reference/html/
 * @author lwieczor
 */
public interface DepartmentRepository extends MongoRepository<Department, String> {

    /**
     *
     * @param Name
     * @return
     */
    public Department findByName(@Param("name") String Name);

}
