/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TimeSlot;

/**
 *
 * @author Admin
 */
public class TimeSlotDBContext extends DBContext{
    
    Connection connection;
    PreparedStatement stm = null;//Thực thi các câu lệnh SQL
    ResultSet rs = null;//Lưu trữ và xử lý dữ liệu
    DBContext db;

    public TimeSlotDBContext() {
        try {
            //lay connection ra 
            db = new DBContext();
            connection = db.getConnection();
            System.out.println("ok");
        } catch (Exception e) {
            System.out.println("Loi : " + e);
        }
    }
    
    public ArrayList<TimeSlot> list() {
        ArrayList<TimeSlot> slots = new ArrayList<>();
        try {
            String sql = "SELECT tid,[description] FROM TimeSlot";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                TimeSlot slot = new TimeSlot();
                slot.setId(rs.getInt("tid"));
                slot.setDescription(rs.getString("description"));
                slots.add(slot);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TimeSlotDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return slots;
    }
}
