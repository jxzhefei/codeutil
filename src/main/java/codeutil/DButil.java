package codeutil;

import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.swing.JOptionPane;


/**
 * @author INstamina
 * @date 2018年12月30日
 * @description 
 */
public class DButil {
	public static JdbcRowSet getRowSet(String dbType,String user,String pwd,String ip) {
		JdbcRowSet jdbcRowSet = null;
		if ("MYSQL".equals(dbType)) {
			String url = "jdbc:mysql://"+ip;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				RowSetFactory factory = RowSetProvider.newFactory();
				jdbcRowSet = factory.createJdbcRowSet();
				jdbcRowSet.setUrl(url);
				jdbcRowSet.setUsername(user);
				jdbcRowSet.setPassword(pwd);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("数据库连接失败...");
			}
		}
		return jdbcRowSet;
	}
	
	public static List<String> getAllDB(JdbcRowSet jdbcRowSet){
		List<String> list = new ArrayList<>();
		try {
			jdbcRowSet.setCommand("show databases");
			jdbcRowSet.execute();
			LogUtil.log().info("---查询所有数据库---");
			while(jdbcRowSet.next()) {
				list.add(jdbcRowSet.getString("Database"));
			}
			JOptionPane.showMessageDialog(null, "连接成功...", "提示", 1);
		} catch (Exception e) {
			LogUtil.log().info("---查询数据库失败---");
			JOptionPane.showMessageDialog(null, "连接失败...", "错误", 0);
			e.printStackTrace();
		}
		return list;
	}
	
	public static void execute(String cmd,JdbcRowSet jdbcRowSet) {
		try {
			jdbcRowSet.setCommand(cmd);
			jdbcRowSet.execute();
			LogUtil.log().info("---执行"+cmd+"成功---");
		} catch (Exception e) {
			LogUtil.log().info("---执行"+cmd+"失败---");
			e.printStackTrace();
		}
	}
	
	public static List<Object> getResult(String cmd,JdbcRowSet jdbcRowSet){
		
		return null;
	}
}
