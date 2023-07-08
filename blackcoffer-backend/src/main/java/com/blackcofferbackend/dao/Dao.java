package com.blackcofferbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.blackcofferbackend.entities.Data;

@Repository
public interface Dao extends JpaRepository<Data, Integer>{

}
