package com.Jobportal.demo.Service;

import com.Jobportal.demo.Model.TxnTokenMetadata;

public interface ITokenService {

    public String encryptTxnToken(String clientId, String username);

    public TxnTokenMetadata decryptTxnToken(String token) throws Exception;
}
