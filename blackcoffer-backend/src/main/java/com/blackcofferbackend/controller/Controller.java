package com.blackcofferbackend.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blackcofferbackend.dao.Dao;
import com.blackcofferbackend.entities.Data;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/data")
public class Controller {
	
	@Autowired
	private Dao dao;
	
	@GetMapping("/columns")
	public List<List<Object>> getData() {
	    List<String> columnNames = List.of("region", "intensity", "topic", "relevance");
	    return dao.findAll().stream()
	            .map(data -> getColumnValues(data, columnNames))
	            .collect(Collectors.toList());
	}

	private List<Object> getColumnValues(Data data, List<String> columnNames) {
	    return columnNames.stream()
	            .map(columnName -> getColumnValue(data, columnName))
	            .collect(Collectors.toList());
	}

	private Object getColumnValue(Data data, String columnName) {
	    switch (columnName) {
	        case "region":
	            return data.getRegion();
	        case "intensity":
	            return data.getIntensity();
	        case "topic":
	            return data.getTopic();
	        case "relevance":
	            return data.getRelevance();
	        default:
	            throw new IllegalArgumentException("Invalid column name: " + columnName);
	    }
	}
}
