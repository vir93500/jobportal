package com.Jobportal.demo.Service;

import com.Jobportal.demo.Model.AddMoney;
import com.Jobportal.demo.Request.AddMoneyRequest;

public interface IWalletService {
    public String transIdGenerator();

    public AddMoney addMoneytInWallet(AddMoneyRequest addMoneyRequest) throws Exception;
}
