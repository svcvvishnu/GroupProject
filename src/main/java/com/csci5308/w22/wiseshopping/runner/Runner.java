package com.csci5308.w22.wiseshopping.runner;

import com.csci5308.w22.wiseshopping.service.MerchantService;
import com.csci5308.w22.wiseshopping.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Elizabeth James
 */
@Slf4j
public class Runner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);

    @Autowired
    MerchantService merchantService;
    UserService userService;


    @Override
    public void run(String... args) {
        LOGGER.info("Dummy log");

        try {
            // TODO: Scanner code

            //TODO: Dummy code to validate jar
//            merchantService.registerMerchant("John Doe","johndoe@xyz.com","password123");

            Map<String, String> userDetails = new HashMap<>();
            userDetails.put(UserService.FIRST_NAME, "John");
            userDetails.put(UserService.LAST_NAME, "Doe");
            userDetails.put(UserService.CONTACT, "9096754432");
            userService.updateUserDetails("johndoe@xyz.com",userDetails);

        }
        catch (DataAccessException e){
            log.error(e.getMessage());
        }
    }
}
