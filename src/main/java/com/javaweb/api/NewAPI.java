package com.javaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingDTO;
import com.javaweb.service.BuildingService;

import CustomException.FieldRequiredException;

// @controller hoac @restcontroller de thong bao day la java restful api services
@RestController
public class NewAPI { 
	
	@Autowired
	private BuildingService buidingService;
	
//	@RequestMapping(value = "/api/building/", method = RequestMethod.GET)
//	public void getBuilding(@RequestParam(value="name", required = false) String name,
//							@RequestParam(value="number", required = false) Integer number) {
//		System.out.println(name + " " + number);
//	}
	
	@PostMapping(value = "/api/building/")
	// neu su dung @Restcontroller thi khong can @ResponseBody
	@ResponseBody
	public BuildingDTO postBuilding(@RequestBody BuildingDTO building) {
		// example 
		BuildingDTO result = new BuildingDTO();
		
		return result;
	}
	
	@DeleteMapping(value = "/api/building/{id}")
	public void deleteBuilding(@PathVariable Integer id) {
		System.out.println("Da xoa toa nha co id la " + id);
	}
	
	@GetMapping(value = "/api/building/")
	public List<BuildingDTO> getBuilding(@RequestParam(name="name", required = false) String name,
										 @RequestParam(name="districtid", required = false) Long district,
										 @RequestParam(name="typeCode", required = false) List<String> typeCode) {
//		valiDate(building);
		List<BuildingDTO> result = buidingService.findAll(name,district);
		return result;
	}
	
	public void valiDate(BuildingDTO buildingDTO) {
		if(buildingDTO.getName().equals("") || buildingDTO.getName() == null || buildingDTO.getNumberofbasement() == null) {
			throw new FieldRequiredException("name or number is null");
		}
	}
}
