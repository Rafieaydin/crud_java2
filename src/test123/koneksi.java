/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test123;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LOQ
 */
public class koneksi {
    static final String DB_URL = "jdbc:mysql://localhost/test"; // ini penting
    static final String DB_USER = "root";
    static final String DB_PASS = "";
    private Connection Conn;
    private ResultSet rs;
    private Statement stmn;
    private PreparedStatement pr;
    
    public koneksi (){
        this.getConnection();
    }
    
    public void  getConnection(){
        try {
            Conn = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (SQLException ex) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    
    public  ResultSet getData(){
        try {
            pr = Conn.prepareStatement("SELECT * FROM mahasiswa");
            rs = pr.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        return null;
    }   
    
     public  ResultSet select(int id){
        try {
            pr = Conn.prepareStatement("SELECT * FROM mahasiswa where id ="+id);
            rs = pr.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        return null;
    }   
    
    
    public int insert(mahassiwa mhs){
        try {
            pr = Conn.prepareStatement("insert into mahasiswa (nama,nim,jurusan,angkatan) VALUES(?,?,?,?)");
            pr.setString(1, mhs.getNama());
            pr.setString(2, mhs.getNim());
            pr.setString(3, mhs.getJurusan());
            pr.setString(4, Integer.toString(mhs.getAngkatan()));
            int output = pr.executeUpdate();
            pr.close();
            return output;
        } catch (SQLException ex) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        return -1;
    }
    
     public int update(mahassiwa mhs, int id){
        try {
            pr = Conn.prepareStatement("UPDATE mahasiswa SET nama = ? , nim = ?, jurusan = ?, angkatan = ? WHERE id = ?");
            pr.setString(1, mhs.getNama());
            pr.setString(2, mhs.getNim());
            pr.setString(3, mhs.getJurusan());
            pr.setString(4, Integer.toString(mhs.getAngkatan()));
            pr.setString(5, Integer.toString(id));
            int output = pr.executeUpdate();
            pr.close();
            return output;
        } catch (SQLException ex) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        return -1;
    }
     
     public int delete(int id){
        try {
            pr = Conn.prepareStatement("DELETE FROM mahasiswa where id ="+id);
            int output = pr.executeUpdate();
            pr.close();
            return output;
        } catch (SQLException ex) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
