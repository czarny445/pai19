package pl.lodz.p.edu.ftims.poi.poi.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.lodz.p.edu.ftims.poi.poi.entities.Department;
import pl.lodz.p.edu.ftims.poi.poi.entities.Package;
import pl.lodz.p.edu.ftims.poi.poi.repository.DepartmentRepository;

@Controller
@RequestMapping("/department")
public class DetpartmentController {
	
	@Autowired
	private DepartmentRepository dr;
	
	@RequestMapping("/getAllDepartments")
	 public @ResponseBody
	    List getAllDepartments()
	    {
		 	return dr.findAll();
	    }
	
	@RequestMapping("/create")
	public @ResponseBody Department create(@RequestBody Department department) {
		Random r = new Random();
		department.setID(Math.abs(r.nextLong()));
		dr.save(department);
		return department;			
	}
}
