/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cigist.belajarweb.dao;

import com.cigist.belajarweb.config.DatabaseConnection;
import com.cigist.belajarweb.model.Buku;
import com.cigist.belajarweb.model.Pengunjung;
import com.cigist.belajarweb.model.Transaksi;
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
public class TransaksiDao {

    public List<Transaksi> findAll() throws SQLException {
        List<Transaksi> listTransaksi = new ArrayList<>();
        DatabaseConnection db = new DatabaseConnection();
        DataSource dataSource = db.getDataSource();
        try (Connection connection = dataSource.getConnection()) {
            String SQL = "SELECT transaksi.id,\n"
                    + "    buku.id,\n"
                    + "    buku.judul_buku,\n"
                    + "    pengunjung.nama,\n"
                    + "	pengunjung.alamat,\n"
                    + "    transaksi.tanggal_pinjam,\n"
                    + "    transaksi.tanggal_kembali\n"
                    + "FROM perpus.transaksi join perpus.buku buku on transaksi.id_buku = buku.id\n"
                    + "join perpus.pengunjung pengunjung on transaksi.id_pengunjung = pengunjung.id;";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(SQL);
                while (resultSet.next()) {
                    Transaksi transaksi = new Transaksi();
                    transaksi.setId(resultSet.getInt(1));
                    transaksi.setBuku(new Buku(resultSet.getInt(2),resultSet.getString(3)));
                    transaksi.setPengunjung(new Pengunjung(resultSet.getString(4), resultSet.getString(5)));
                    transaksi.setTanggalPinjam(resultSet.getDate(6));
                    transaksi.setTanggalKembali(resultSet.getDate(7));

                    listTransaksi.add(transaksi);
                }

                resultSet.close();
                connection.close();

            }
        }
        return listTransaksi;
    }

    public void save(Transaksi transaksi) throws SQLException {
        DatabaseConnection db = new DatabaseConnection();
        DataSource dataSource = db.getDataSource();
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            String SQL = "INSERT INTO perpus.transaksi(id_buku,id_pengunjung,tanggal_pinjam)\n"
                    + "    VALUES (?, ?, now());";
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setInt(1, transaksi.getBuku().getId());
            statement.setInt(2, transaksi.getPengunjung().getId());
            statement.executeUpdate();
            statement.close();

            SQL = "UPDATE perpus.buku set jumlah_buku = ? where id = ?";
            statement = connection.prepareStatement(SQL);
            statement.setInt(1, transaksi.getBuku().getJumlahBuku() - 1);
            statement.setInt(2, transaksi.getBuku().getId());
            statement.executeUpdate();
            statement.close();

            connection.setAutoCommit(true);
            connection.close();
        }

    }

    public void update(Transaksi transaksi) throws SQLException {
        DatabaseConnection db = new DatabaseConnection();
        DataSource dataSource = db.getDataSource();
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            String SQL = "UPDATE `perpus`.`transaksi` SET `tanggal_kembali`=now() WHERE `id`=?";
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setInt(1, transaksi.getId());
            statement.executeUpdate();
            statement.close();

            SQL = "UPDATE perpus.buku set jumlah_buku = ? where id = ?";
            statement = connection.prepareStatement(SQL);
            statement.setInt(1, transaksi.getBuku().getJumlahBuku() + 1);
            statement.setInt(2, transaksi.getBuku().getId());
            statement.executeUpdate();
            statement.close();

            connection.setAutoCommit(true);
            statement.close();
            connection.close();

        }
    }
;
}
