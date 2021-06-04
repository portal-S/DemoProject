package com.ntiteam.demoProject.repository;

import com.ntiteam.demoProject.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE planets set lord_id = :lordId WHERE id = :planetId", nativeQuery = true)
    public void addLordPlanet(@Param("lordId") int lord_id, @Param("planetId") int planet_id);
}
