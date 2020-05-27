package com.github.bakerybluprint.croissant.week_04.dy.homework.Login;

import com.github.bakerybluprint.croissant.week_04.dy.homework.Customer.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginUtil.class);

    private LoginUtil() {}
    private Customer loginCustomer;

    public static LoginUtil getInstance() {
        return LoginCache.INSTANCE;
    }

    private static class LoginCache {
        private static final LoginUtil INSTANCE = new LoginUtil();
    }

    public void login(Customer customer) {
        this.loginCustomer = customer;
        this.getLoginCustomerInfo();
    }

    public void logout() {
        this.loginCustomer = null;
    }

    public void getLoginCustomerInfo() {
        if (loginCustomer != null) {
            LOGGER.info(this.loginCustomer.toString());
        } else {
            LOGGER.info("로그인 정보가 없습니다");
        }
    }

    public Customer getCustomer() {
        return this.loginCustomer;
    }

    public boolean checkLoginFlg() {
        return this.loginCustomer == null ? false : true;
    }
}
