package sys.ldk.com.test;

import java.sql.Connection;

import sys.ldk.com.util.DBUtil;

public class TestJDBConn {
	public static void main(String[] args) {
		
		Connection conn = DBUtil.getConn();
		System.out.println("conn:"+conn);
	}
}
