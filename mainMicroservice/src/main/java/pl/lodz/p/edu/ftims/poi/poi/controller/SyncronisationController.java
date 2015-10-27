/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.edu.ftims.poi.poi.controller;

import com.google.gson.Gson;
import java.time.Instant;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.lodz.p.edu.ftims.poi.poi.dao.HistoryDao;
import pl.lodz.p.edu.ftims.poi.poi.dao.HistoryListDao;
import pl.lodz.p.edu.ftims.poi.poi.entities.Department;
import pl.lodz.p.edu.ftims.poi.poi.entities.History;
import pl.lodz.p.edu.ftims.poi.poi.entities.Package;
import pl.lodz.p.edu.ftims.poi.poi.repository.DepartmentRepository;
import pl.lodz.p.edu.ftims.poi.poi.repository.HistoryRepository;
import pl.lodz.p.edu.ftims.poi.poi.repository.PackageRepository;

/**
 *
 * @author lwieczor
 */
@Controller
@RequestMapping("/sync")
public class SyncronisationController {

    private static final Logger logger = Logger.getLogger(SyncronisationController.class.getName());
    
    @Autowired
    HistoryRepository hr;

    @Autowired
    DepartmentRepository dr;

    @Autowired
    PackageRepository pr;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    String checkpoint(@RequestBody String input) {
        logger.log(Level.INFO, "Sync:{0}", input);
        Gson gson = new Gson();
        
        HistoryListDao h = gson.fromJson(input, HistoryListDao.class);
        logger.log(Level.INFO, "Sync:{0} h:", h);
        
        for (HistoryDao history : h.getHistory()) {
            Random r = new Random();//Do ukoszernienia
            Department dep = dr.findOne(h.getDepartement());
            Package pack = pr.findOne(history.getPack());
            History historia = new History();
            historia.setID(r.nextLong());//Do ukoszernienia
            historia.setPack(pack);
            historia.setOddzial(dep);
            historia.setDate(history.getDate());
            History save = hr.save(historia);
            pack.getHistory().add(save);
            pr.save(pack);
        }

        return "OK";
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody HistoryListDao checkpointGet() {
        HistoryListDao historyListDao = new HistoryListDao();
        historyListDao.setDepartement(1L);
        HistoryDao dao = new HistoryDao();
        HistoryDao dao2 = new HistoryDao();

        dao.setDate(Date.from(Instant.EPOCH));
        dao2.setDate(Date.from(Instant.now()));

        dao.setPack(1L);
        dao2.setPack(2L);

        historyListDao.getHistory().add(dao);
        historyListDao.getHistory().add(dao2);
        return historyListDao;
    }
}
