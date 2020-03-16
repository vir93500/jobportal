package com.Jobportal.demo.Repository;

import com.Jobportal.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value="Select * from mytable",nativeQuery = true)
    public List<User> ListUser();
}

