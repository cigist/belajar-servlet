/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cigist.belajarweb.ctrl;

import com.cigist.belajarweb.dao.BukuDao;
import com.cigist.belajarweb.dao.PengunjungDao;
import com.cigist.belajarweb.dao.TransaksiDao;
import com.cigist.belajarweb.model.Buku;
import com.cigist.belajarweb.model.Pengunjung;
import com.cigist.belajarweb.model.Transaksi;
import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet(urlPatterns = "/transaksi/kembali",name = "transaksi kembali")
public class TrnsaksiKembali  extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer idTransaksi = Integer.valueOf(req.getParameter("idTransaksi"));
            Integer idBuku = Integer.valueOf(req.getParameter("kodeBuku"));
            Transaksi transaksi = new Transaksi();
            transaksi.setId(idTransaksi);
            
            Buku buku = new BukuDao().findById(idBuku);
            transaksi.setBuku(buku);
             
            new TransaksiDao().update(transaksi);
            resp.sendRedirect(req.getServletContext().getContextPath() +"/transaksi");
        } catch (SQLException ex) {
            Logger.getLogger(TrnsaksiKembali.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
