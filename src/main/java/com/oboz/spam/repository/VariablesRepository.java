package com.oboz.spam.repository;

import com.oboz.spam.model.SpamVariables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VariablesRepository extends JpaRepository<SpamVariables, String> {
    @Query("select s from SpamVariables s where Num =?1")
    public List<SpamVariables> findByNum(String Num);
}
