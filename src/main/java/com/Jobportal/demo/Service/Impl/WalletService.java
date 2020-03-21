package com.Jobportal.demo.Service.Impl;

import com.Jobportal.demo.Model.AddMoney;
import com.Jobportal.demo.Model.TransactionId;
import com.Jobportal.demo.Repository.AddMoneyRepository;
import com.Jobportal.demo.Request.AddMoneyRequest;/*
import com.Jobportal.demo.Response.AddMoneyResponse*/;
import com.Jobportal.demo.Service.ITransactionIdGenerator;
import com.Jobportal.demo.Service.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WalletService implements IWalletService {

  //  private final Logger LOGGER = (Logger) LoggerFactory.getLogger(WalletService.class);

    public static final String TXN_SEQUENCE = "TXN_";

    @Autowired
    ITransactionIdGenerator iTransactionIdGenerator;

    @Autowired
    AddMoneyRepository addMoneyRepository;

    @Override
    public String transIdGenerator() {
        List<TransactionId> transId =  iTransactionIdGenerator.findAll();

        if(transId.isEmpty()){
            iTransactionIdGenerator.createTransactionId(1,TXN_SEQUENCE+1);
            return TXN_SEQUENCE+1;
        }
        int n = Integer.parseInt(transId.get(0).getTransId().split("_")[1])+1;
        String newTxnId = TXN_SEQUENCE+(n);
        iTransactionIdGenerator.updateTransactionId(newTxnId,transId.get(0).getId());
        return newTxnId;
    }

    public AddMoney addMoneytInWallet(AddMoneyRequest addMoneyRequest) throws Exception {
        //check session token is present or not
        boolean isRequestedMoneyCorrect = true;
        long requestedMoney = addMoneyRequest.getMoney();
        if(requestedMoney<=4000){
            isRequestedMoneyCorrect=false;
        }
        if(!isRequestedMoneyCorrect){
            throw new Exception("Requested balance is less than 4K");
        }
        String transId=transIdGenerator();
        System.out.println("This is an info message of transId "+transId);
        AddMoney addMoney = new AddMoney();
        addMoney.setTransactionId(transId);
        addMoney.setMoney(requestedMoney);
        addMoney.setUsername(addMoneyRequest.getUsername());
        addMoneyDB(addMoney);
        return addMoney;
    }

    public void addMoneyDB(AddMoney addMoney){

        addMoneyRepository.save(addMoney);
    }
}
