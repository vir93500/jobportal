package com.Jobportal.demo.Repository;

import com.Jobportal.demo.Model.Registeration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegisterationRepository extends JpaRepository<Registeration, Integer> {
    @Query(value = "SELECT * FROM mytable b WHERE b.Username = :username", nativeQuery = true)
    List<Registeration> findByUsername(String username);
}
