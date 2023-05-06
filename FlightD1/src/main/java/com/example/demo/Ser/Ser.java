package com.example.demo.Ser;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.ModL.Flight;
import com.example.demo.ModL.ModelLogin;
import com.example.demo.RepL.RepoD;
import com.example.demo.RepL.RepoL;

@Service
public class Ser {
	@Autowired
	RepoD repository;
	
	@Autowired
	RepoL repositoryL;
	
	public String addCustomer(Flight customer)
	{
		repository.save(customer);
		return "Added successfully";
	}
	public List<Flight> getCustomer()
	{
		return repository.findAll();
		
	}
	public Optional<Flight> getCustomerById(int id)
	{
		return repository.findById(id);
	}
	public String updateCustomer(Flight customer)
	{
		repository.save(customer);
		return "Updated successfully";
	}
	public String deleteById(int id)
	{
		repository.deleteById(id);
		return "Deleted successfully";
	}
	
	public List<Flight> getProDetails(@RequestParam String field)
	{
		return repository.findAll(Sort.by(Direction.ASC,field));
	}

	public List<Flight> getProwithPag(int offset, int pagesize)
	{
		Page<Flight> page=repository.findAll(PageRequest.of(offset, pagesize));
		return page.getContent();
	}
	
	public String checkLogin(String uname,String pwd)
	{
		ModelLogin user=repositoryL.findByuname(uname);
		if(user==null)
		{
			return "Invalid Details";
		}
		else
		{
			if(user.getPwd().equals(pwd))
			{
				return "Login successful";
			}
			else
			{
				return "Login failed";
			}
		}
	}
	
	public ModelLogin addUser(ModelLogin mod)
	{
		return repositoryL.save(mod);
	}
	
	
	public List<ModelLogin> getUser() 
	{
		return repositoryL.findAll();
	}

}
