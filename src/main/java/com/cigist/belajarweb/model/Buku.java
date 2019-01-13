/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cigist.belajarweb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Irwan Cigist <cigist.developer@gmail.com>
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Buku {

    public Buku(int id,String judulBuku) {
        this.id = id;
        this.judulBuku = judulBuku;
    }
    
    private Integer id;
    private String judulBuku;
    private Integer tahunTerbit;
    private String pengarang;
    private Integer jumlahBuku;
}
