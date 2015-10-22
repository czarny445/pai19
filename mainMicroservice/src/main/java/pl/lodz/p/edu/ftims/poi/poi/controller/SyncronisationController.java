/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.edu.ftims.poi.poi.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.lodz.p.edu.ftims.poi.poi.dao.HistoryDao;
import pl.lodz.p.edu.ftims.poi.poi.dao.HistoryListDao;
import pl.lodz.p.edu.ftims.poi.poi.entities.History;
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

    @Autowired
    HistoryRepository hr;

    @Autowired
    DepartmentRepository dr;

    @Autowired
    PackageRepository pr;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    String checkpoint(HistoryListDao h) {

        for (HistoryDao history : h.getHistory()) {
            History historia = new History();
            historia.setPack(pr.findOne(history.getPack()));
            historia.setOddzial(dr.findOne(h.getDepartement()));
            historia.setDate(history.getDate());
        }

        return "{\"succes\" :\"true\"}";
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody HistoryListDao checkpointGet() {
        HistoryListDao historyListDao = new HistoryListDao();
        historyListDao.setDepartement(1L);
        HistoryDao dao = new HistoryDao();
        HistoryDao dao2 = new HistoryDao();

        dao.setDate(LocalDateTime.MIN);
        dao2.setDate(LocalDateTime.now());

        dao.setPack(1L);
        dao2.setPack(2L);

        historyListDao.getHistory().add(dao);
        historyListDao.getHistory().add(dao2);
        return historyListDao;
    }
}
