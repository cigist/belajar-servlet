/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cigist.belajarweb.dao;

import com.cigist.belajarweb.config.DatabaseConnection;
import com.cigist.belajarweb.model.Buku;
import com.cigist.belajarweb.model.Pengunjung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Irwan Cigist <cigist.developer@gmail.com>
 */
public class PengunjungDao {

    public PengunjungDao() {
    }
    public List<Pengunjung> findAll() throws SQLException {
        List<Pengunjung> listPengunjung = new ArrayList<>();
        DatabaseConnection db = new DatabaseConnection();
        DataSource dataSource = db.getDataSource();
        try (Connection connection = dataSource.getConnection()) {
            String SQL = "SELECT id, nama, alamat\n"
                    + "  FROM perpus.pengunjung ORDER BY id asc";
            try (Statement statement = connection.createStatement(); 
               ResultSet resultSet = statement.executeQuery(SQL)) {
                while (resultSet.next()) {
                    Pengunjung pengunjungs = new Pengunjung();
                    pengunjungs.setId(resultSet.getInt(1));
                    pengunjungs.setNama(resultSet.getString(2));
                    pengunjungs.setAlamat(resultSet.getString(3));
                    listPengunjung.add(pengunjungs);
                }
                resultSet.close();
                statement.close(); 
                connection.close();
            }
            
        }
        return listPengunjung;
    }

    public Pengunjung finById(Integer idPengunjung) throws SQLException {
        DatabaseConnection db = new DatabaseConnection();
        DataSource dataSource = db.getDataSource();
        try (Connection connection = dataSource.getConnection()) {
            String SQL = "SELECT id,nama,alamat\n"
                    + "  FROM perpus.pengunjung WHERE id=?";
            Pengunjung pengunjung;
            try (PreparedStatement statement = connection.prepareCall(SQL)) {
                statement.setInt(1, idPengunjung);
                ResultSet resultSet = statement.executeQuery();
                pengunjung= new Pengunjung();
                if (resultSet.next()) {
                    pengunjung.setId(resultSet.getInt(1));
                    pengunjung.setNama(resultSet.getString(2));
                    pengunjung.setAlamat(resultSet.getString(3));
                }
                resultSet.close();
                statement.close(); 
                connection.close();
            }
            return pengunjung;
        }
    }
    
}
