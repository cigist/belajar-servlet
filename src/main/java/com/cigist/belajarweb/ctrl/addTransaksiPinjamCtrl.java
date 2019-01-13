/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cigist.belajarweb.ctrl;

import com.cigist.belajarweb.dao.PengunjungDao;
import com.cigist.belajarweb.dao.BukuDao;
import com.cigist.belajarweb.dao.TransaksiDao;
import com.cigist.belajarweb.model.Buku;
import com.cigist.belajarweb.model.Pengunjung;
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
@WebServlet(urlPatterns = "/transaksi/pinjam", name = "pinjam")
public class addTransaksiPinjamCtrl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Buku> listBuku = new BukuDao().findAll();
            List<Pengunjung> listPengunjung = new PengunjungDao().findAll();
//        render to JSP
            req.setAttribute("listBuku", listBuku);
            req.setAttribute("listPengunjung", listPengunjung);
            req.getRequestDispatcher("/pages/transaksi/addTransaksi.jsp").forward(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(addTransaksiPinjamCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer idBuku = Integer.valueOf(req.getParameter("kodeBuku"));
            Integer idPengunjung = Integer.valueOf(req.getParameter("pengunjung"));
            Transaksi transaksi = new Transaksi();
            
            Buku buku = new BukuDao().findById(idBuku);
            transaksi.setBuku(buku);
            
            Pengunjung pengunjung = new PengunjungDao().finById(idPengunjung);
            transaksi.setPengunjung(pengunjung);
            
            new TransaksiDao().save(transaksi);
            
            resp.sendRedirect(req.getServletContext().getContextPath() +"/transaksi");
        } catch (SQLException ex) {
            Logger.getLogger(addTransaksiPinjamCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }        

    
    

}
