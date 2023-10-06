package com.example.Fioo.Actions;

import com.example.Fioo.Actions.Model.Action;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActionRepository extends JpaRepository<Action, Long> {
    List<Action> findAllByCodStudentOrderByActionDateDesc(Long id);
}
