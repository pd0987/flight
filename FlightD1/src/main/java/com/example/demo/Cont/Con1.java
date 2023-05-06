package com.example.demo.Cont;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ModL.Flight;
import com.example.demo.ModL.ModelLogin;
import com.example.demo.RepL.RepoD;
import com.example.demo.Ser.Ser;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
public class Con1 {
	@Autowired
	Ser cusservice;
	
	@PostMapping("/pom")
	public String create(@RequestBody Flight customer)
	{
		return cusservice.addCustomer(customer);
	}
	
	
	@GetMapping("/gm")
	public List<Flight> read()
	{
		return cusservice.getCustomer();
	}
	
	
	@GetMapping("/{id}")
	public Optional <Flight> readById(@PathVariable int id)
	{
		return cusservice.getCustomerById(id);
	
	}
	
	
	@PutMapping("/pum")
	public String update(@RequestBody Flight customer)
	{
		return cusservice.updateCustomer(customer);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id)
	{
		return cusservice.deleteById(id);
	}
	
	
	@GetMapping("/ser")
	public List<Flight> getProSorted(@RequestParam String field)
	{
		return cusservice.getProDetails(field);
	}
		
		
	@GetMapping("/service/{offset}/{pagesize}")
	public List<Flight> getProwithPagination(@PathVariable int offset,@PathVariable int pagesize)
	{
		return cusservice.getProwithPag(offset,pagesize);
	}
	
	
	@PostMapping("/pomL")
	public String login(@RequestBody Map<String,String> loginData)
	{
		String uname=loginData.get("uname");
		String pwd=loginData.get("pwd");
		String result=cusservice.checkLogin(uname,pwd);
		return result;
    }


	@PostMapping("/addL")
	public ModelLogin AddUser(@RequestBody ModelLogin mod)
	{
		return cusservice.addUser(mod);
	}


	@GetMapping("/gmL")
	public List<ModelLogin> listAll()
	{
		return cusservice.getUser();
	}
	
	@Autowired
	public RepoD sr;
	
	//GETTING DETAILS
	
	@Tag(name="Native query",description="Getting details")
	@GetMapping("/saveStudent")
	public List<Flight> getD()
	{
		return sr.getAllData();
	}
	
	@Tag( name="Native query",description="Getting details by id")
	@GetMapping("byName/{id}")
	public List<Flight> getName(@PathVariable ("id") int pid )
	{
		return sr.byid(pid);
	}

	@Tag( name="Native query",description="Getting details by start end method")
	@GetMapping("startend/{start}/{end}")
	public List<Flight> getStart(@PathVariable ("start")int start,@PathVariable ("end")int end)
	{
		return sr.startEnd(start, end);
	}
	
	@Tag( name="JPQL",description="Getting details by methods")
	@GetMapping("jp")
	public List<Flight>jplQuery()
	{
		return sr.jpqlQ();
	}
	
	//DELETING
	
	@Tag( name="Native query",description="Deleting details by id and name")
	@DeleteMapping("/del/{id}/{name}")
	public String delD(@PathVariable ("id") int id,@PathVariable ("name")String name)
	{
		sr.deleted(id, name);
		return "deleted";
	}

	//POSTING

	@Tag( name="Native query",description="Posting details")
	@PutMapping("updatee/{pid}/{pname}")
	public void updateQue(@PathVariable("pid")int pid,@PathVariable("pname") String pname)
	{
		sr.updateByQuery(pid, pname);
	}
}
	
	

