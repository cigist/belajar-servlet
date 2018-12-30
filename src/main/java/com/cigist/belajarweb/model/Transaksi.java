/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cigist.belajarweb.model;

import java.sql.Date;
import lombok.Data;

/**
 *
 * @author Irwan Cigist <cigist.developer@gmail.com>
 */
@Data
public class Transaksi {
    private Integer id;
    private Buku buku;
    private Pengunjung pengunjung;
    private Date tanggalPinjam,tanggalKembali;
}
