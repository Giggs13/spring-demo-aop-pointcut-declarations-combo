package com.giggs13.aop;

import com.giggs13.aop.dao.AccountDAOImpl;
import com.giggs13.aop.dao.MembershipDAO;
import com.giggs13.aop.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAOImpl accountDAO = context.getBean(AccountDAOImpl.class);
        accountDAO.addAccount(new Account(), true);
        accountDAO.doWork();
        accountDAO.setName("foobar");
        accountDAO.getName();
        accountDAO.setServiceCode("silver");
        accountDAO.getServiceCode();

        MembershipDAO membershipDAO = context.getBean(MembershipDAO.class);
        membershipDAO.addSillyMember();
        membershipDAO.goToSleep();

        context.close();
    }
}
