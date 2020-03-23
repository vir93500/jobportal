package com.Jobportal.demo.Service;

import com.Jobportal.demo.Model.AddMoney;
import com.Jobportal.demo.Request.AddMoneyRequest;
import com.Jobportal.demo.Response.AddMoneyResponse;

public interface IWalletService {
    public String transIdGenerator();

    public AddMoneyResponse addMoneytInWallet(AddMoneyRequest addMoneyRequest) throws Exception;
}
