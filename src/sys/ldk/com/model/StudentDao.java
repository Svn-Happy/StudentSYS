package sys.ldk.com.model;

import sys.ldk.com.model.JavaEmail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

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
		String sql2 = "insert into tb_stu_image(id)"
				+ "values(?)";
		//准备preparedStatement对象
		PreparedStatement ps = conn.prepareStatement(sql);
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		
		ps.setString(1,id);
		ps.setString(2, password);
		ps2.setString(1, id);
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
	
	//修改个人信息
	public static int updateUser(Student student) throws SQLException{
		//获取链接多想
		Connection conn = DBUtil.getConn();
		//修改sql语句
		String sql = "update tb_stu_image "
				+ "set name = ?,sex = ? , age = ?,email=?,"
				+ "tele = ? where id = ?" ;
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, student.getName());
		ps.setString(2, student.getSex());
		ps.setInt(3, student.getAge());
		ps.setString(4, student.getEmail());
		ps.setString(5, student.getTele());
		ps.setString(6, student.getId());
		System.out.println("over");
		student.tString();
		
		return ps.executeUpdate();
	}
	
	//修改密码或忘记密码（短信验证方面）
	public static String newpassword(String id) throws SQLException {
		Connection conn = DBUtil.getConn();
		String sql = "select * from tb_stu_image where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,id);
		
		ResultSet rls = ps.executeQuery();
		//根据结果集是否为空判断用户是否存在 
		//若存在 判断email字段是否为空
        //email字段为空 报错并结束 否则 直接发送验证码
		if(rls.next())
			if(!(rls.getString("email").contains("@")))
				return "无绑定邮箱";
			else
			{
				JavaEmail sendEmail=new JavaEmail();
				//将发送的邮件设置为想要发送的邮箱 并发送四位验证码
				sendEmail.setReceiveMailAccount(rls.getString("email"));
				Random random=new Random();
				String str="";
				for(int i=0;i<4;i++) {
					int n=random.nextInt(10);
					str+=n;
				}
				sendEmail.setInfo(str);
				try {
					sendEmail.Send();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return str;
			}
		else
			return "该用户不存在";
		
	}
	
	public static int updatePassword(Student student) throws SQLException{
		//获取链接多想
		Connection conn = DBUtil.getConn();
		//修改sql语句
		System.out.println(student.getId() + student.getPassword());
		String sql = "update tb_stu_info set password = ? where id = ?" ;
		//密码修改失败，是否存在语法错误
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, student.getPassword());
		ps.setString(2, student.getId());
		
		return ps.executeUpdate();
	}
	
	
}







