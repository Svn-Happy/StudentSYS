package sys.ldk.com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sys.ldk.com.entity.Student;
import sys.ldk.com.util.DBUtil;

/*
 * dao 数据访问层对象
 * dao 类中，一般都是些操作数据库的CRUD的方法
 */
public class StudentDao {
	
	//注册学生信息 在操作数据库表的数据的时候
	//如果是增加数据 删除数据 修改数据 返回值都是数据的受影响行数
	//如果是查询的情况下，才会返回对象或者佘集合
	//public ? addStudent() {
		
		
	//注册账户时插入数据
	public static int insertUser
	(String id,String password) 
			throws SQLException {
		
		//获取数据库对象
		Connection conn = DBUtil.getConn();
		//准备sql语句
		//编写sql
		String sql = "insert into tb_stu_info(id,password)"
				+ "values(?,?)";
		//准备preparedStatement对象
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1,id);
		ps.setString(2, password);
		int row = ps.executeUpdate();
		
		DBUtil.closeConn(conn);
		ps.close();
		return row;
	}
	
	//判断账户是否存在
	public static boolean selectUser(String id) throws SQLException{
			Connection conn = DBUtil.getConn();
			
			String sql = "select * from tb_stu_info where id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,id);
			
			ResultSet rls = ps.executeQuery();
			
			/*
			 * ResultSet 是结果集，将从数据库查询到的数据存放到ResuLtSet
			 */			
			if(rls.next()) {
				DBUtil.closeConn(conn);
				return false;
			}else {
				DBUtil.closeConn(conn);
				return true;
			}
		}
	
	//账户存在，判断密码
	public static Student selectUser(String id,String password) throws SQLException{
		
		Student s = new Student();
		Connection conn = DBUtil.getConn();
		
		String sql = "select * from tb_stu_info where id=? and password=?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1,id);
		ps.setString(2, password);
		
		ResultSet rls = ps.executeQuery();//洒家也不知道哪里有问题了。
		
		/*
		 * ResultSet 是结果集，将从数据库查询到的数据存放到ResuLtSet
		 */ 
		if(rls.next()) {
			s.setId(rls.getString("id"));
			s.setPassword(rls.getString("password"));
			return s;
		}
		else return null;
		
	}
	
	//取出数据库中账号内的密码
	public static Student getimage(String id,Student s) throws SQLException{
		
		Connection conn = DBUtil.getConn();
		
		String sql = "select * from tb_stu_image where id=?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1,id);
		
		ResultSet rls = ps.executeQuery();//洒家也不知道哪里有问题了。
		
		/*
		 * ResultSet 是结果集，将从数据库查询到的数据存放到ResuLtSet
		 */ 
		if(rls.next()) {

			s.setId(rls.getString("id"));
			s.setName(rls.getString("name"));
			s.setSex(rls.getString("sex"));
			s.setAge(rls.getInt("age"));
			s.setTele(rls.getString("tele"));
			s.setEmail(rls.getString("email"));
			
			return s;
		}//别扯了，整不出来的。
		return null;
		
	}
	
	//修改密码或忘记密码（流程相同）
	public static void newpassword(String id) {
		
	}
}







