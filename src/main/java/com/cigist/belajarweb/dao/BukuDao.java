/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cigist.belajarweb.dao;

import com.cigist.belajarweb.config.DatabaseConnection;
import com.cigist.belajarweb.model.Buku;
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
public class BukuDao {

    public void save(Buku buku) throws SQLException {
        DatabaseConnection db = new DatabaseConnection();
        DataSource dataSource = db.getDataSource();
        try (Connection connection = dataSource.getConnection()) {
            String SQL = "INSERT INTO perpus.buku(judul_buku, tahub_terbit, pengarang, jumlah_buku)\n"
                    + "    VALUES (?, ?, ?, ?);";
            try (PreparedStatement statement = connection.prepareCall(SQL)) {
                statement.setString(1, buku.getJudulBuku());
                statement.setInt(2, buku.getTahunTerbit());
                statement.setString(3, buku.getPengarang());
                statement.setInt(4, buku.getJumlahBuku());

                statement.executeUpdate();
                statement.close();
                connection.close();
            }
        }
    }

    public void update(Buku buku) throws SQLException { 
        DatabaseConnection db = new DatabaseConnection();
        DataSource dataSource = db.getDataSource();
        try (Connection connection = dataSource.getConnection()) {
             String SQL = "UPDATE perpus.buku\n"
                + "   SET judul_buku=?, tahub_terbit=?, pengarang=?, jumlah_buku=?\n"
                + " WHERE id=?";
            try (PreparedStatement statement = connection.prepareCall(SQL)) {
                statement.setString(1, buku.getJudulBuku());
                statement.setInt(2, buku.getTahunTerbit());
                statement.setString(3, buku.getPengarang());
                statement.setInt(4, buku.getJumlahBuku());
                statement.setInt(5,buku.getId());

                statement.executeUpdate();
                statement.close();
                connection.close();
            }
        }
    };
     public void delete(Integer idBuku) throws SQLException {
        DatabaseConnection db = new DatabaseConnection();
        DataSource dataSource = db.getDataSource();
        Connection connection = dataSource.getConnection();
        String SQL = "DELETE FROM perpus.buku\n"
                + " WHERE id=?;";
        try (PreparedStatement statement = connection.prepareCall(SQL)) {
            statement.setInt(1, idBuku);
            statement.executeUpdate();
            statement.close();
            connection.close();
        }
    }

    ;
     public List<Buku> findAll() throws SQLException {
        List<Buku> listBuku = new ArrayList<>();
        DatabaseConnection db = new DatabaseConnection();
        DataSource dataSource = db.getDataSource();
        try (Connection connection = dataSource.getConnection()) {
            String SQL = "SELECT id, judul_buku, tahub_terbit, pengarang, jumlah_buku\n"
                    + "  FROM perpus.buku ORDER BY id asc";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Buku buku = new Buku();
                buku.setId(resultSet.getInt(1));
                buku.setJudulBuku(resultSet.getString(2));
                buku.setTahunTerbit(resultSet.getInt(3));
                buku.setPengarang(resultSet.getString(4));
                buku.setJumlahBuku(resultSet.getInt(5));

                listBuku.add(buku);
            }

           resultSet.close();
           statement.close(); 
                connection.close();
        }
        return listBuku;
    }

    public Buku findById(Integer idBuku) throws SQLException {
        DatabaseConnection db = new DatabaseConnection();
        DataSource dataSource = db.getDataSource();
        try (Connection connection = dataSource.getConnection()) {
            String SQL = "SELECT id, judul_buku, tahub_terbit, pengarang, jumlah_buku\n"
                    + "  FROM perpus.buku WHERE id=?";
            Buku buku;
            try (PreparedStatement statement = connection.prepareCall(SQL)) {
                statement.setInt(1, idBuku);
                ResultSet resultSet = statement.executeQuery();
                buku = new Buku();
                if (resultSet.next()) {
                    buku.setId(resultSet.getInt(1));
                    buku.setJudulBuku(resultSet.getString(2));
                    buku.setTahunTerbit(resultSet.getInt(3));
                    buku.setPengarang(resultSet.getString(4));
                    buku.setJumlahBuku(resultSet.getInt(5));
                }
                resultSet.close();
                statement.close(); 
                connection.close();
            }
            return buku;
        }
    }
}
