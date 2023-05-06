package com.example.demo.RepL;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.ModL.ModelLogin;

public interface RepoL extends JpaRepository<ModelLogin, String> {
	ModelLogin findByuname(String uname);

}
