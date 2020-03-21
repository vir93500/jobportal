package com.Jobportal.demo.Service;

import com.Jobportal.demo.Model.TransactionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface ITransactionIdGenerator extends JpaRepository<TransactionId,String> {

    @Modifying
    @Transactional
    @Query(value = "insert into transactionid (id,trans_id) VALUES (?1,?2)",nativeQuery = true)
    public void createTransactionId(int id,String transid);

    /*@Query(name="SELECT * FROM transactionid u limit 1",nativeQuery = true)
    public TransactionId getTransactionId();*/

    @Modifying
    @Transactional
    @Query(value = "UPDATE transactionid u set u.trans_id =:transid where u.id=:id",nativeQuery = true)
    public void updateTransactionId(String transid,int id);

    //public String deleteTransactionId();

}
