package com.Jobportal.demo.EncryptedService;

import com.Jobportal.demo.Common.AESCipherHelper;
import com.Jobportal.demo.Model.TxnTokenMetadata;
import com.Jobportal.demo.Service.ITokenService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class EncryptionImp implements ITokenService {
    private AESCipherHelper aesHelper;
    private static final String SECRET_KEY="QFghJEVreWNLZXk";
    private static final String VERSION="VI";
    private static final String DELIMITER="#";


    @PostConstruct
    private void init(){
        aesHelper = new AESCipherHelper(SECRET_KEY);
    }

    @Override
    public String encryptTxnToken(String clientId,String username) {
        return aesHelper.encrypt(VERSION + DELIMITER + clientId +DELIMITER+username);
    }

    @Override
    public TxnTokenMetadata decryptTxnToken(String token) throws Exception {
        try {
            String decryptedToken = aesHelper.decrypt(token);
            String[] strArry = decryptedToken.split(DELIMITER);
            if (strArry == null || strArry.length != 3) {
                throw new Exception();
            }
            TxnTokenMetadata tokenDetail = TxnTokenMetadata.builder().clientId(strArry[1]).username(strArry[2]).build();
            return tokenDetail;
        } catch (Exception e) {
            throw new Exception();
        }
    }

}
