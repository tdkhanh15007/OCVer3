/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import connectionDb.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Khanh
 */
public class AdminDAO {
    public boolean check(String u, String p) throws SQLException {
        Connection conn = DBConnection.getConnection();
        MainMethod mmt = new MainMethod();
        String pass = mmt.covertoMD5(p);
        PreparedStatement stmt = conn.prepareStatement("Select * From Admin Where admin_us='" + u + "' and password='" + pass + "' and status = 'true'");
        ResultSet rs = stmt.executeQuery();
        int count = 0;
        while (rs.next()) {
            count++;
        }
        if (count == 1) {
            return true;
        }
        return false;
    }
}
