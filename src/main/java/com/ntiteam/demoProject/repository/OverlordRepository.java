package com.ntiteam.demoProject.repository;

import com.ntiteam.demoProject.model.Overlord;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
public interface OverlordRepository extends JpaRepository<Overlord, Integer> {

    @Query("FROM Overlord WHERE id NOT IN (select overlord from Planet)")
    public List<Overlord> getLazyLords();

    @Query("FROM Overlord ORDER BY age DESC")
    public List<Overlord> getYoungLords(Pageable pageable);

}
