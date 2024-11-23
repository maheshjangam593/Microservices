package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.Model.Alien;

@RepositoryRestResource(collectionResourceRel = "älien", path = "alien")
public interface AlienRepo extends JpaRepository<Alien, Integer> {

}
