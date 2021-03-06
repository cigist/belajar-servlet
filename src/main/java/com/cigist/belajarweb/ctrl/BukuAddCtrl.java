/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cigist.belajarweb.ctrl;

import com.cigist.belajarweb.dao.BukuDao;
import com.cigist.belajarweb.model.Buku;
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
@WebServlet(urlPatterns = "/buku/new", name = "tambahBuku")
public class BukuAddCtrl extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/buku/AddBuku.jsp").forward(req, resp);
    }

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Buku buku = new Buku();
            buku.setJudulBuku(req.getParameter("judulBuku"));
            buku.setTahunTerbit(Integer.valueOf(req.getParameter("tahunTerbit")));
            buku.setPengarang(req.getParameter("pengarang"));
            buku.setJumlahBuku(Integer.valueOf(req.getParameter("jumlahBuku")));
            BukuDao bukuDao;
            bukuDao = new BukuDao();
            bukuDao.save(buku);
            
        } catch (SQLException ex) {
            Logger.getLogger(BukuAddCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        resp.sendRedirect(req.getServletContext().getContextPath() +"/buku");
    }
    
}
