package com.Jobportal.demo.Service.Impl;

import com.Jobportal.demo.Exception.ExceptionCodes;
import com.Jobportal.demo.Exception.InsufficientMoneyException;
import com.Jobportal.demo.Exception.UserNotFoundException;/*
import com.Jobportal.demo.Exception.WalletRelatedException;*/
import com.Jobportal.demo.Model.AddMoney;
import com.Jobportal.demo.Model.TransactionId;
import com.Jobportal.demo.Repository.AddMoneyRepository;
import com.Jobportal.demo.Repository.SessionTokenRepository;
import com.Jobportal.demo.Request.AddMoneyRequest;/*
import com.Jobportal.demo.Response.AddMoneyResponse*/;
import com.Jobportal.demo.Response.AddMoneyResponse;
import com.Jobportal.demo.Service.ITransactionIdGenerator;
import com.Jobportal.demo.Service.IWalletService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.Jobportal.demo.Exception.ExceptionCodes.USER_NOT_FOUND;

@Component
public class WalletService implements IWalletService {

  //  private final Logger LOGGER = (Logger) LoggerFactory.getLogger(WalletService.class);

    public static final String TXN_SEQUENCE = "TXN_";

    @Autowired
    ITransactionIdGenerator iTransactionIdGenerator;

    @Autowired
    AddMoneyRepository addMoneyRepository;

    @Autowired
    SessionTokenRepository sessionTokenRepository;

    AddMoneyResponse addMoneyResponse = new AddMoneyResponse();

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

    public AddMoneyResponse addMoneytInWallet(AddMoneyRequest addMoneyRequest) throws Exception {
        //check session token is present or not
        if(sessionTokenRepository.findSessionTokenDb(addMoneyRequest.getUsername())!=null){
            System.out.println("User is not logged in");
             throw new UserNotFoundException();
        }

        boolean isRequestedMoneyCorrect = true;
        long requestedMoney = addMoneyRequest.getMoney();
        if(requestedMoney<=4000){
            isRequestedMoneyCorrect=false;
        }
        if(!isRequestedMoneyCorrect){
            throw new InsufficientMoneyException();
        }
        String transId=transIdGenerator();
        addMoneyResponse.setTransId(transId);
        addMoneyDB(addMoneyResponse);
        return addMoneyResponse;
    }

    public void addMoneyDB(AddMoneyResponse addMoneyResponse){
        ModelMapper modelMapper = new ModelMapper();
        AddMoney addMoneyDto = modelMapper.map(addMoneyResponse, AddMoney.class);
        addMoneyRepository.save(addMoneyDto);
    }
}
