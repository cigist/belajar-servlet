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
    private final static String URL="jdbc:postgresql://localhost:5432/training";
    private final static String USERNAME="training";
    private final static String PASSWORD="training";
    
    public DataSource getDataSource(){
        BasicDataSource bs = new BasicDataSource();
        bs.setUsername(USERNAME);
        bs.setPassword(PASSWORD);
        bs.setUrl(URL);
        return  bs;
    }
}
