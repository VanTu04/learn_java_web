package com.javaweb.service;

import java.util.List;

import com.javaweb.model.BuildingDTO;

public interface BuildingService {
	public abstract List<BuildingDTO> findAll(String name, Long district);
}