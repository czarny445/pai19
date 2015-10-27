/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.lodz.p.edu.ftims.poi.poi.dao.HistoryDao;
import pl.lodz.p.edu.ftims.poi.poi.dao.HistoryListDao;
import pl.lodz.p.edu.ftims.poi.poi.main.SpringBootMainConfiguration;

/**
 *
 * @author lwieczor
 */
public class RESTClient {

    private static final Logger logger = Logger.getLogger(RESTClient.class.getName());

    public RESTClient() {
    }

    @BeforeClass
    public static void setUpClass() {
        SpringBootMainConfiguration.main(new String[0]);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() throws UnsupportedEncodingException, IOException {

        HistoryDao dao = new HistoryDao();
        dao.setDate(Date.from(Instant.EPOCH));
        dao.setPack(1L);
        HistoryListDao dao1 = new HistoryListDao();
        dao1.setDepartement(1L);
        ArrayList<HistoryDao> arrayList = new ArrayList<>();
        arrayList.add(dao);
        dao1.setHistory(arrayList);
        dao1.setDepartement(1L);

        Gson g = new Gson();
        String toJson = g.toJson(dao1);
        logger.log(Level.INFO, "Gson: {0}", toJson);

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://localhost:8080/sync");
        StringEntity input = new StringEntity(toJson);
        post.setEntity(input);
        HttpResponse response = client.execute(post);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        String line = "";
        int statusCode = response.getStatusLine().getStatusCode();
        assertTrue(statusCode==200);

        while ((line = rd.readLine()) != null) {

            System.out.println(line);

        }

    }
}
