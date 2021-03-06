package pl.lodz.p.edu.ftims.poi.poi.controller;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.lodz.p.edu.ftims.poi.poi.dao.ErrorDao;
import pl.lodz.p.edu.ftims.poi.poi.dao.HistoryDao;
import pl.lodz.p.edu.ftims.poi.poi.dao.HistoryListDao;
import pl.lodz.p.edu.ftims.poi.poi.entities.History;
import pl.lodz.p.edu.ftims.poi.poi.repository.HistoryRepository;

@Component
public class Scheduler {

    private static final Logger logger = Logger.getLogger(Scheduler.class.getName());

    private static final ResourceBundle bundle = ResourceBundle.getBundle("application");

    @Autowired
    private HistoryRepository hr;

    @Scheduled(cron = "*/5 * * * * ?")
    public void syncronizeDB() throws UnsupportedEncodingException, IOException {
        List<History> historyNotReported = hr.findByReportStatus(Boolean.FALSE);
        logger.log(Level.INFO, "Scheduler: {0}", historyNotReported.size());
        if (0 == historyNotReported.size()) {
            logger.log(Level.INFO, "Scheduler: {0}", "there is no work to do");
            return;
        }
        List<HistoryDao> historyDao = new ArrayList<>();

        historyNotReported.stream().forEach((history) -> {
            historyDao.add(new HistoryDao(history));
        });

        HistoryListDao historyListDao = new HistoryListDao();
        historyListDao.setHistory(historyDao);
        historyListDao.setDepartement(bundle.getString("departement"));

        logger.log(Level.INFO, "Scheduler: {0}", historyListDao);

        Gson g = new Gson();
        String toJson = g.toJson(historyListDao);

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(bundle.getString("sync.endpoint"));
        StringEntity input = new StringEntity(toJson);
        post.setEntity(input);
        HttpResponse response = client.execute(post);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        int statusCode = response.getStatusLine().getStatusCode();
        ErrorDao fromJson = g.fromJson(rd, ErrorDao.class);
        if (statusCode == 200 && !fromJson.getError()) {
            historyNotReported.stream().forEach((history) -> {
                history.setReportStatus(Boolean.TRUE);
                logger.log(Level.INFO, "Setting status: {0}", history);
                hr.save(history);
            });
        } else {
            for (int i = 0; i < fromJson.getInsertedRecords(); i++) {
                History history = historyNotReported.get(i);
                history.setReportStatus(Boolean.TRUE);
                logger.log(Level.INFO, "Setting status: {0}", history);
                hr.save(history);
            }
        }
    }

}
