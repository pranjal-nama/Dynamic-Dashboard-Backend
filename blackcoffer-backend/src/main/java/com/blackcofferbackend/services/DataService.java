package com.blackcofferbackend.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blackcofferbackend.dao.Dao;
import com.blackcofferbackend.entities.Data;

@Component
public class DataService {
	@Autowired
	public Dao dao;
	
	public List<Data> getData(){
		List<Data> list = (List<Data>)this.dao.findAll();
		return list;
	}
}
