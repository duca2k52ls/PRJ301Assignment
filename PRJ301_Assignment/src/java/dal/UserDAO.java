/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import model.Account;
import model.Lecture;
import model.Role;
import model.Student;

/**
 *
 * @author Admin
 */
public class UserDAO {

    Connection connection;
    PreparedStatement stm = null;//Thực thi các câu lệnh SQL
    ResultSet rs = null;//Lưu trữ và xử lý dữ liệu
    DBContext db;

    public UserDAO() {
        try {
            //lay connection ra 
            db = new DBContext();
            connection = db.getConnection();
            System.out.println("ok");
        } catch (Exception e) {
            System.out.println("Loi : " + e);
        }
    }

    public boolean checkAccount(String username, String password) {
        String sql = "select * from dbo.[Account] where username = ? and password = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, password);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            String mess = e.toString();
            System.out.println("Check Account:" + mess);
        }
        return false;
    }

    public Account getAccount(String username) {
        try {
            String sql = "select a.accountid, username, password, role from Account a \n"
                    + "                    inner join [Role] ro on a.roleid = ro.roleid\n"
                    + "					where username= ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, username);
            ResultSet rs = pre.executeQuery();
            Account acc = null;
            while (rs.next()) {
                if (acc == null) {
                    acc = new Account();
                    Role role = new Role();

                    role.setRole(rs.getBoolean("role"));
                    acc.setRole(role);

                    acc.setId(rs.getInt("accountid"));
                    acc.setUsername(rs.getString("username"));
                    acc.setPassword(rs.getString("password"));
                }
            }
            return acc;
        } catch (Exception e) {
            String mess = e.toString();
            System.out.println("Get account:" + mess);
        }
        return null;
    }

    public Account getAccountStu(String username) {
        try {
            String sql = "select a.accountid, username, password, role, s.stdid from Account a \n"
                    + "                    inner join Role ro on a.roleid = ro.roleid\n"
                    + "					inner join Student s on s.accountid = a.accountid\n"
                    + "                    where username=?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, username);
            ResultSet rs = pre.executeQuery();
            Account acc = null;
            while (rs.next()) {
                if (acc == null) {
                    acc = new Account();
                    Role role = new Role();

                    role.setRole(rs.getBoolean("role"));
                    acc.setRole(role);

                    acc.setId(rs.getInt("accountid"));
                    acc.setUsername(rs.getString("username"));
                    acc.setPassword(rs.getString("password"));
                }
                Student student = new Student();
                student.setAccount(acc);
                student.setId(rs.getInt("stdid"));
                acc.getStudents().add(student);
            }
            return acc;
        } catch (Exception e) {
            String mess = e.toString();
            System.out.println("Get account:" + mess);
        }
        return null;
    }

    public Account getAccountLec(String username) {
        try {
            String sql = "select a.accountid, username, password, role, l.lid, sj.subid, sj.subname from Account a \n"
                    + "                    inner join [Role] ro on a.roleid = ro.roleid\n"
                    + "					inner join Lecturer l on l.accountid=a.accountid\n"
                    + "					inner join [Group] g on g.lid=l.lid\n"
                    + "					inner join [Subject] sj on sj.subid=g.subid\n"
                    + "                    where username= ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, username);
            ResultSet rs = pre.executeQuery();
            Account acc = null;
            while (rs.next()) {
                if (acc == null) {
                    acc = new Account();
                    Role role = new Role();

                    role.setRole(rs.getBoolean("role"));
                    acc.setRole(role);

                    acc.setId(rs.getInt("accountid"));
                    acc.setUsername(rs.getString("username"));
                    acc.setPassword(rs.getString("password"));
                }
              
                Lecture lecture = new Lecture();
                lecture.setAccount(acc);
                lecture.setId(rs.getInt("lid"));
                acc.getLectures().add(lecture);
            }
            return acc;
        } catch (Exception e) {
            String mess = e.toString();
            System.out.println("Get account:" + mess);
        }
        return null;
    }
}
