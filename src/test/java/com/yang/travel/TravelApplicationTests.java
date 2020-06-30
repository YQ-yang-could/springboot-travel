package com.yang.travel;

import com.yang.travel.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TravelApplicationTests {
    @Autowired
    private UserInfoService userInfoService;
    @Test
    void contextLoads() throws Exception {
        //System.out.println(userInfoService.findByUsername("yyq").getEmail());
        System.out.println(userInfoService.findAll());
        userInfoService.findById(1);
        userInfoService.findOtherRoles(1);
        //userInfoService.addRoleToUser(3,);
    }
    @Test
    public void memberTest(){

    }

}
