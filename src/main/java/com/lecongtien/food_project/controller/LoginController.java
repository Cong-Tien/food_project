package com.lecongtien.food_project.controller;

import com.lecongtien.food_project.payload.request.SignInRequest;
import com.lecongtien.food_project.payload.response.DataResponse;
import com.lecongtien.food_project.repository.UserRepository;
import com.lecongtien.food_project.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/signin")
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    UserRepository userRepository;

    @PostMapping("")
    public ResponseEntity<?> signin(@RequestBody SignInRequest request){
        DataResponse dataResponse = new DataResponse();

        boolean isSuccess = loginService.checkLogin(request.getUsername(),request.getPassword());

        dataResponse.setStatus(HttpStatus.OK.value());
        dataResponse.setDesc("Thanh cong");
        dataResponse.setSuccess(isSuccess);
        dataResponse.setData(userRepository.findByEmailAndPassword(request.getUsername(),request.getPassword()));
        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }
}
