/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cigist.belajarweb.ctrl;

import com.cigist.belajarweb.dao.BukuDao;
import com.cigist.belajarweb.dao.TransaksiDao;
import com.cigist.belajarweb.model.Buku;
import com.cigist.belajarweb.model.Transaksi;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Irwan Cigist <cigist.developer@gmail.com>
 */
@WebServlet(urlPatterns = {"/transaksi","/transaksi/list"})
public class TransaksiListCtrl extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Transaksi> listTransaksi = new TransaksiDao().findAll();
            //render to JSP
            req.setAttribute("listTransaksi", listTransaksi);
            req.getRequestDispatcher("/pages/transaksi/listTransaksi.jsp").forward(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(BukuListCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
}
