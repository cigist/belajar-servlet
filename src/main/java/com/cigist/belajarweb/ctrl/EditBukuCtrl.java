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
@WebServlet(urlPatterns = "/buku/update", name = "Update Buku")
public class EditBukuCtrl extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer idBuku = Integer.valueOf(req.getParameter("idBuku"));
            Buku dataBuku = new BukuDao().findById(idBuku);
            
           System.out.println("DATA BUKU = "+dataBuku);
           req.setAttribute("buku", dataBuku);
           req.getRequestDispatcher("/pages/buku/EditBuku.jsp").forward(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(EditBukuCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Buku buku = new Buku();
            buku.setId(Integer.valueOf(req.getParameter("kodeBuku")));
            buku.setJudulBuku(req.getParameter("judulBuku"));
            buku.setTahunTerbit(Integer.valueOf(req.getParameter("tahunTerbit")));
            buku.setPengarang(req.getParameter("pengarang"));
            buku.setJumlahBuku(Integer.valueOf(req.getParameter("jumlahBuku")));
            BukuDao bukuDao;
            bukuDao = new BukuDao();
            bukuDao.update(buku);
            
        } catch (SQLException ex) {
            Logger.getLogger(BukuAddCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        resp.sendRedirect(req.getServletContext().getContextPath() +"/buku");
    }
    
}
