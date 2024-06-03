/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test123;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LOQ
 */
public class Test123 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        koneksi p = new koneksi();
        ResultSet output =  p.getData();
        try {
            while(output.next()){
                System.out.println(output.getString("nama"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Test123.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        mahassiwa m = new mahassiwa();
//        m.setNama("eko");
//        m.setNim("ABS001");
//        m.setJurusan("IF");
//        m.setAngkatan(2020);
//        p.insert(m);
//        
//        m.setNama("ekos");
//        m.setNim("ABCEEJ");
//        m.setJurusan("IFJ");
//        m.setAngkatan(2021);
//        p.update(m,11);
//        
//        p.delete(13);

        crud c = new crud();
        c.setVisible(true);
    }
    
}
