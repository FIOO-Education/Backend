package com.example.Fioo.Actions;

import com.example.Fioo.Actions.Model.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {
    List<Action> findAllByCodStudentOrderByActionDateDesc(Long id);
    

    List<Action> findAllByCodStudentAndCodClassIsNullOrderByActionDateDesc(Long codStudent);
}
