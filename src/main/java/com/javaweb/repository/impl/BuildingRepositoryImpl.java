package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	static final String url = "jdbc:mysql://localhost:3306/estatebasic";
	static final String username = "root";
	static final String password = "0978477143";
	
	@Override
	public List<BuildingEntity> findAll(String name, Long district) {
		List<BuildingEntity> result = new ArrayList<BuildingEntity>();
		StringBuilder str = new StringBuilder("SELECT * FROM building b WHERE 1=1 ");
		if(name != null && !name.equals("")) {
			str.append(" AND b.name like '%" + name + "%' ");
		}
		if(district != null) {
			str.append(" AND b.districtid = " + district + " ");
		}
		try (Connection conn = DriverManager.getConnection(url, username, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(str.toString());)
		{	
			while(rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setName(rs.getString(2));
				building.setStreet(rs.getString(3));
				building.setWard(rs.getString(4));
				building.setNumberofbasement(rs.getInt(7));
				result.add(building);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
