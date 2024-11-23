package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

//public interface SqlDao extends CrudRepository<ZAlien1,Integer>{
//
//	List<ZAlien1> findByName(String name);
//
//	List<ZAlien1> findByaIdGreaterThan(int aId);
//
////	@Query("select * from ZAlien1 where name='mahi' order by aId")
////	List<ZAlien1> findByNameSorted(String name);
//
//}
public interface SqlDao extends JpaRepository<ZAlien1, Integer> {

//	List<ZAlien1> findByName(String name);
//
//	List<ZAlien1> findByaIdGreaterThan(int aId);

//	@Query("select * from ZAlien1 where name='mahi' order by aId")
//	List<ZAlien1> findByNameSorted(String name);

}
