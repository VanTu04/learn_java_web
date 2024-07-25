package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	private BuildingRepository buildingRepository;
	
	@Override
	public List<BuildingDTO> findAll(String name, Long district) {
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(name, district);
		List<BuildingDTO> result = new ArrayList<BuildingDTO>();
		for(BuildingEntity item : buildingEntities) {
			BuildingDTO b = new BuildingDTO();
			b.setName(item.getName());
			b.setAdress(item.getStreet() + ", " + item.getWard());
			b.setNumberofbasement(item.getNumberofbasement());
			result.add(b);
		}
		return result;
	}
	
}
