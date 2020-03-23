package com.Jobportal.demo.Repository;

import com.Jobportal.demo.Model.AddMoney;
import com.Jobportal.demo.Response.AddMoneyResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddMoneyRepository extends JpaRepository<AddMoney, Long> {
}
