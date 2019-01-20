package com.giggs13.aop.dao;

import com.giggs13.aop.entity.Account;
import org.springframework.stereotype.Repository;

@Repository("accountDAOImpl")
public class AccountDAOImpl
        implements AccountDAO {

    private String name;

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    private String serviceCode;

    @Override
    public void addAccount(Account account,
                           boolean vip) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": DOING MY WORK");

        return true;
    }
}
