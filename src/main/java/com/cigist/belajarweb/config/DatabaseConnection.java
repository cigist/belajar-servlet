/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cigist.belajarweb.config;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Irwan Cigist <cigist.developer@gmail.com>
 */
public class DatabaseConnection {
    private final static String URL="jdbc:mysql://localhost:3306/perpus";
    private final static String USERNAME="root";
    private final static String PASSWORD="root123!";
    
    public DataSource getDataSource(){
        BasicDataSource bs = new BasicDataSource();
        bs.setUsername(USERNAME);
        bs.setPassword(PASSWORD);
        bs.setUrl(URL);
        return  bs;
    }
}
