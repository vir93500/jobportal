package com.Jobportal.demo.Controller;

import com.Jobportal.demo.Model.AddMoney;
import com.Jobportal.demo.Model.TransactionId;
import com.Jobportal.demo.Repository.AddMoneyRepository;
import com.Jobportal.demo.Request.AddMoneyRequest;/*
import com.Jobportal.demo.Response.AddMoneyResponse;*/
import com.Jobportal.demo.Response.AddMoneyResponse;
import com.Jobportal.demo.Response.LoginUserResponse;
import com.Jobportal.demo.Service.ITransactionIdGenerator;
import com.Jobportal.demo.Service.IWalletService;
import com.Jobportal.demo.Service.Impl.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WalletController {

    @Autowired
    AddMoneyRepository addMoneyRepository;

    @Autowired
    IWalletService iWalletService;

    @Autowired
    ITransactionIdGenerator iTransactionIdGenerator;

    @PostMapping(value = "/addMoneyInWallet")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AddMoneyResponse> addSubscription(@RequestBody AddMoneyRequest addMoneyRequest) throws Exception {
       // AddMoney addMoney = new AddMoney();
      //  try{
          //  AddMoney addMoney = new AddMoney(request.getUsername(),request.getMoney());
            AddMoneyResponse  addMoneyResponse =  iWalletService.addMoneytInWallet(addMoneyRequest);

       /* }
        catch(Exception ex){
            ex.printStackTrace();
            throw new Exception();
        }*/
        return  new ResponseEntity<AddMoneyResponse>(addMoneyResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/addTransid")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> addTransid(@RequestParam("id") String ids) throws Exception {
        try{
            TransactionId transactionId = new TransactionId();
            transactionId.setTransId(ids);
            System.out.println("abc::"+transactionId.getTransId());
            iTransactionIdGenerator.save(transactionId);

        }
        catch(Exception ex){
            ex.printStackTrace();
            throw new Exception();
        }
        return ResponseEntity.ok().build();
    }


}
