package com.Jobportal.demo.Service.Impl;

import com.Jobportal.demo.Model.User;
import com.Jobportal.demo.Response.LoginUserResponse;
import com.Jobportal.demo.Service.ILoginJobService;
import com.Jobportal.demo.Service.ITokenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class LoginUserService implements ILoginJobService {

    @Autowired
    ITokenService iTokenService;

    /*@Autowired
    RedisTemplate redisTemplate;*/

    private final static String SUCCESS = "Success";
    private final static String FAIL = "Fail";

    @Override
    public LoginUserResponse loginUserStatus(List<User> users, String username, String password, String clientId) throws Exception {
        String txnToken = null;
        String status = FAIL;
        for (User user:users){
            if(user.getUsername().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password)){
                 txnToken = iTokenService.encryptTxnToken(clientId,username);
                 status = SUCCESS;

            /*   Map userHash = new ObjectMapper().convertValue(user, Map.class);
                redisTemplate.opsForHash().put(username, txnToken, userHash);*/

              /*  TxnTokenMetadata txnTokenMetadata = iTokenService.decryptTxnToken(txnToken);
                System.out.println("clientId:"+txnTokenMetadata.getClientId());
                System.out.println("username:"+txnTokenMetadata.getUsername());*/
             //save in redis
                System.out.println("saved in redis");
            }
        }
        final LoginUserResponse loginUserResponse = LoginUserResponse.builder().status(status).txnToken(txnToken).build();
        return loginUserResponse;
    }
}
