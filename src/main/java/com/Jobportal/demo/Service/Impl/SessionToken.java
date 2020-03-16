/*
package com.Jobportal.demo.Service.Impl;

import com.Jobportal.demo.Service.ISessionToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SessionToken implements ISessionToken {
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public boolean saveSessionToken(String token, String username) {

        String KEY = "user";
    */
/*
    id: 1
    name: Ramu
    age : 25
     *//*


            try {
              //  Map userHash = new ObjectMapper().convertValue(user, Map.class);
                redisTemplate.opsForHash().put(KEY, token, username);

                return true;

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

}
*/
