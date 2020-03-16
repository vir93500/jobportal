package com.Jobportal.demo.Service;

import com.Jobportal.demo.Model.User;
import com.Jobportal.demo.Response.LoginUserResponse;

import java.util.List;

public interface ILoginJobService {
    LoginUserResponse loginUserStatus(List<User> users, String username, String password, String clientId) throws Exception;
}
