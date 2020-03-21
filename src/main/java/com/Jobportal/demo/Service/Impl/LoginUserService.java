package com.Jobportal.demo.Service.Impl;

import com.Jobportal.demo.Model.SessionIds;
import com.Jobportal.demo.Model.User;
import com.Jobportal.demo.Response.LoginUserResponse;
import com.Jobportal.demo.Service.ILoginJobService;
import com.Jobportal.demo.Repository.SessionTokenRepository;
import com.Jobportal.demo.Service.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoginUserService implements ILoginJobService {

    @Autowired
    ITokenService iTokenService;

    @Autowired
    SessionTokenRepository iSessionToken;

    /*@Autowired
    RedisTemplate redisTemplate;*/

    private final static String SUCCESS = "Success";
    private final static String FAIL = "Fail";

    @Override
    @Caching(
            put= { @CachePut(value= "sessionTokenCache", key= "#username") },
            evict= { @CacheEvict(value= "allSessionTokenCache", allEntries= true) }
    )
    public LoginUserResponse loginUserStatus(List<User> users, String username, String password, String clientId) throws Exception {
        String txnToken = null;
        String status = FAIL;
        for (User user:users){
            if(user.getUsername().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password)){
                 txnToken = iTokenService.encryptTxnToken(clientId,username);
                 status = SUCCESS;

                if(!iSessionToken.findSessionTokenDb(username).equalsIgnoreCase(txnToken)) {
                     SessionIds sessionIds = new SessionIds(txnToken, user.getUsername());
                     iSessionToken.save(sessionIds);
                 }

            /*   Map userHash = new ObjectMapper().convertValue(user, Map.class);
                redisTemplate.opsForHash().put(username, txnToken, userHash);*/

              /*  TxnTokenMetadata txnTokenMetadata = iTokenService.decryptTxnToken(txnToken);
                System.out.println("clientId:"+txnTokenMetadata.getClientId());
                System.out.println("username:"+txnTokenMetadata.getUsername());*/
             //save in redis
                System.out.println("saved in DB");
            }
        }
        final LoginUserResponse loginUserResponse = LoginUserResponse.builder().status(status).txnToken(txnToken).build();
        return loginUserResponse;
    }
}
