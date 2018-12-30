/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cigist.belajarweb.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author Irwan Cigist <cigist.developer@gmail.com>
 */
@WebListener
public class ListenerApp implements ServletContextListener, HttpSessionListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Aplikasi start");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Aplikasi stop");
    }

    @Override
    public void sessionCreated(HttpSessionEvent hse) {
        System.out.println("Ada session baru");
        System.out.println(hse.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent hse) {
        System.out.println("Session di-destroy");
    }

}
