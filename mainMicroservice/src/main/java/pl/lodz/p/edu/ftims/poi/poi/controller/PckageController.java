package pl.lodz.p.edu.ftims.poi.poi.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.lodz.p.edu.ftims.poi.poi.entities.Package;
import pl.lodz.p.edu.ftims.poi.poi.repository.PackageRepository;

@Controller
@RequestMapping("/package")
public class PckageController {
	
	@Autowired
	private PackageRepository pr;
	
	 @RequestMapping("/getAllPackages")
	    public @ResponseBody
	    List getAllPackages()
	    {
		 	return pr.findAll();
	    }
	 
	 @RequestMapping("/create")
		public @ResponseBody Package create(@RequestBody Package pack) {
			Random r = new Random();
			pack.setID(r.nextLong());
			pr.save(pack);
			return pack;			
		}
}
