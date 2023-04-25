package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.pojoclass;

public interface repo extends JpaRepository<pojoclass, Integer> {

}
