package com.yaxingguo.mysitespring;

import com.yaxingguo.mysitespring.dao.MenuDao;
import com.yaxingguo.mysitespring.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
public class userTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MenuDao menuDao;

    @Test
    public void TestCryptPasswordEncoder(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encode = passwordEncoder.encode("1234");
//        String encode2 = passwordEncoder.encode("1234");
//        System.out.println(encode2);
//        System.out.println(encode);
        boolean matches = passwordEncoder.matches("1234", "$2a$10$ZlCqiEQRgF5RSyna81uFm.WlATb.nqeNctdHAgEshxpILNVwkViZC");
        System.out.println(matches);
    }

    @Test
    public void testGetPermByUserId(){
        List<String> list = menuDao.getPermsByUserId(1L);
        System.out.println(list);
    }
}
