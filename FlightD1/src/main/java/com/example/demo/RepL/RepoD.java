package com.example.demo.RepL;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.demo.ModL.Flight;
import jakarta.transaction.Transactional;

public interface RepoD extends JpaRepository<Flight, Integer>{

	
	@Query(value="select * from Flight_ticket", nativeQuery = true)
	public List<Flight> getAllData();
	
	@Query(value="select * from Flight_ticket where id=:id",nativeQuery=true)
	public List<Flight>byid(@Param("id")int id);
	
	@Query(value="select * from Flight_ticket where id between :start and :end",nativeQuery=true)
    public List<Flight> startEnd(@Param("start") int start,@Param("end")int end);
    
    @Modifying
    @Transactional
    @Query(value="delete from Flight_ticket where id=?1 and name=?2",nativeQuery = true)
    Integer deleted(@Param("id") int pid,@Param ("name") String pname);
    
    @Modifying
    @Transactional
    @Query(value="update Flight_ticket set id=:pid where name=:pname",nativeQuery=true)
    public void updateByQuery(@Param ("pid")int pid,@Param ("pname")String pname);
    
    @Query(value="select f from Flight f")
    List<Flight> jpqlQ();
    
    @Query(value="select f from Flight f where f.id=?1")
    public List<Flight> jqBYCon(@Param("id")int Id);
}