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
            
           req.setAttribute("buku", dataBuku);
           req.getRequestDispatcher("/pages/buku/EditBuku.jsp").forward(req, resp);
        } catch (SQLException ex) {
            Logger.getLogger(EditBukuCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
