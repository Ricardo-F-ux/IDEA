package com.fjq.java1;

import org.junit.Test;

import java.util.List;

/**
 * @author EnvyFL
 * @create 2021-04-20-10:48 下午
 * @class
 */
public class DAOTest {

    @Test
     public void test(){
        CustomersDAO customersDAO = new CustomersDAO();

        customersDAO.add(new Customers());
        List<Customers> list = customersDAO.getForList(10);

        StudnetDAO studnetDAO = new StudnetDAO();
        Student student = (Student) studnetDAO.getIndex(1);

    }


}
