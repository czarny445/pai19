package pl.lodz.p.edu.ftims.poi.poi.main;

import com.mongodb.Mongo;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

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
@SpringBootApplication
@EnableMongoRepositories(basePackages = "pl.lodz.p.edu.ftims.poi.poi.repository")
@ComponentScan("pl.lodz.p.edu.ftims.poi.poi")
public class SpringBootMainConfiguration extends AbstractMongoConfiguration {

	@Autowired
	private DepartmentRepository dr;

	@Autowired
	private PackageRepository pr;

	@Autowired
	private HistoryRepository hr;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMainConfiguration.class, args);
	}

	// @RequestMapping("/")
	// @ResponseBody
	// String home() {
	// return "Hello World!";
	// }
	//
	@PostConstruct
	public void run() throws Exception {

		System.out.println("----- Aplikacja uruchomiona -----");
		System.out.println("----- Czyszczenie bazy -----");
		Random random = new Random();
		dr.deleteAll();
		pr.deleteAll();
		hr.deleteAll();
		System.out.println("----- Wypełnianie danymi    -----");
		int k = 5;
		List<Department> dep = new ArrayList<Department>();
		for (int i = 0; i < k; i++) {
			Department d = new Department(String.valueOf(i), "Nazwa "+i,
					"Ulica " + i,
					"" + i,
					"Miasto " + i,
					"" + i + i + "-" + i + i + i);
			dep.add(d);
			dr.save(d);
		}
		
		for (int i = 0; i < k; i++) {
			Package p = new Package(String.valueOf(i), "Paczka " + i,
					"Imie " + i, "Nazwisko " + i, "Ulica " + i, "" + i,
					"Miasto " + i, "" + i + i + "-" + i + i + i,
					new ArrayList<History>());
			ArrayList<History> ha = new ArrayList<History>();
			for(int j = 0; j<k;j++){
				History h = new History();
				h.setID(""+ Math.abs(random.nextInt()));
				//h.setPack(p);
				h.setOddzial(dep.get(j));
				h.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2015-10-0"+j));
				hr.save(h);
				ha.add(h);
			}
			p.setHistory(ha);
			pr.save(p);
		}
		// History historia = new History();
		// History historia2 = new History();
		// Package p = new Package();
		// Package p1 = new Package();
		// Package p2 = new Package();
		// Package p3 = new Package();
		//
		// p.setID(1L);
		// p1.setID(2L);
		// p2.setID(3L);
		// p3.setID(4L);
		//
		// historia.setID(1L);
		// historia.setPack(p);
		// historia.setOddzial(oddzial);
		// historia2.setID(2L);
		// historia2.setPack(p);
		// historia2.setOddzial(oddzial2);
		// ArrayList<History> arrayList = new ArrayList<>();
		// arrayList.add(historia);
		// arrayList.add(historia2);
		// p.setHistory(arrayList);
		//
		// pr.save(p);
		// pr.save(p1);
		// pr.save(p2);
		// pr.save(p3);
		// hr.save(historia);
		// hr.save(historia2);
		//
		// for (Department dprm : dr.findAll()) {
		// System.out.println(dprm.toString());
		// }

		// while(true);
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
