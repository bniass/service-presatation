package com.ecole221.prestation.controller;




import com.ecole221.prestation.model.LoginRequest;
import com.ecole221.prestation.model.LoginResponse;
import com.ecole221.prestation.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/users/login")
    public ResponseEntity<LoginResponse> login (@RequestBody LoginRequest loginRequest) throws Exception {
        try{
            log.info("Executing login");

            ResponseEntity<LoginResponse> response = null;
            response = loginService.login(loginRequest);

            return response;
        }
        catch (Exception ex){
            throw new Exception(ex.getMessage());
        }

    }
}
