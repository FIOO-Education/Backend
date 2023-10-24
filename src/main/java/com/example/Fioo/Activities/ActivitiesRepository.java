package com.example.Fioo.Activities;

import com.example.Fioo.Activities.Model.Activities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActivitiesRepository extends JpaRepository<Activities, Long> {
    List<Activities> findAllByCodClass(Long codClass);
}
