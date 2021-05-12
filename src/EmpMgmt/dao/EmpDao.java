package EmpMgmt.dao;

import EmpMgmt.dbUtil.DBConnection;
import EmpMgmt.pojo.EmpPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpDao {
    
    public static boolean addEmp (EmpPojo e) throws SQLException {
        Connection c = DBConnection.getConnection();
        PreparedStatement ps=c.prepareStatement("insert into emp values(?,?,?)");
        ps.setInt(1,e.getEmpno());
        ps.setString(2,e.getEname());
        ps.setDouble(3,e.getSal());
        int result=ps.executeUpdate();
        return result==1;
    }
    public static EmpPojo findEmployeeById(int eno)throws SQLException {
        EmpPojo e=null;
        Connection c = DBConnection.getConnection();
        PreparedStatement ps=c.prepareStatement("select * from emp where empno=?");
        ps.setInt(1,eno);
       ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            e=new EmpPojo();
            e.setEmpno(rs.getInt(1));
            e.setEname(rs.getString(2));
            e.setSal(rs.getDouble(3));
        }
        return e;
    }
    public static ArrayList<EmpPojo> getAllEmp() throws SQLException {
        
        Statement st = DBConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from emp");
        ArrayList<EmpPojo> empList=new ArrayList<>();
        while(rs.next())
        {
            EmpPojo e=new EmpPojo();
            e.setEmpno(rs.getInt(1));
            e.setEname(rs.getString(2));
            e.setSal(rs.getDouble(3));
            empList.add(e);
        }
        return empList;
    }
    public static int updateEmp(EmpPojo e) throws SQLException 
    {
        
        Connection c = DBConnection.getConnection();
        PreparedStatement ps=c.prepareStatement(" update emp set empno=?,ename=?,sal=? where empno=?");
        ps.setInt(1,e.getEmpno());
        ps.setString(2,e.getEname());
        ps.setDouble(3,e.getSal());
        ps.setInt(4,e.getEmpno());
       return ( ps.executeUpdate());
       
    }
    public static int deleteEmp(int eno) throws SQLException
    {
        Connection c=DBConnection.getConnection();
        PreparedStatement ps=c.prepareStatement("delete from emp where empno=?");
        ps.setInt(1, eno);
        return (ps.executeUpdate());
    }
}
