/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cigist.belajarweb.test;

import com.cigist.belajarweb.dao.BukuDao;
import com.cigist.belajarweb.model.Buku;
import java.sql.SQLException;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author Irwan Cigist <cigist.developer@gmail.com>
 */
public class BukuDaoTest extends TestCase{
    private final BukuDao bukuDao;

    public BukuDaoTest() {
        this.bukuDao = new BukuDao();
    }
    
    @Test
    public void testSaveBuku() throws SQLException{
        Buku buku = new Buku();
        buku.setJudulBuku("Java Core");
        buku.setJumlahBuku(10);
        buku.setPengarang("Udin");
        buku.setTahunTerbit(2018);
        
        bukuDao.save(buku);
    }
    
}
