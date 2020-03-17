package com.Jobportal.demo.Repository;

import com.Jobportal.demo.Model.SessionIds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface SessionTokenRepository extends JpaRepository<SessionIds,Integer>{
   // public boolean saveSessionToken(String token, String username);

    /*public boolean saveSessionTokenDb(SessionIds sessionIds);*/

    @Query(value = "SELECT token FROM session_ids s WHERE s.Username = :username", nativeQuery = true)
    public String findSessionTokenDb(String username);


}