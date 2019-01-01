package codeutil;

import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.swing.JOptionPane;


/**
 * @author INstamina
 * @date 2018��12��30��
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
				throw new RuntimeException("���ݿ�����ʧ��...");
			}
		}
		return jdbcRowSet;
	}
	
	public static List<String> getAllDB(JdbcRowSet jdbcRowSet){
		List<String> list = new ArrayList<>();
		try {
			jdbcRowSet.setCommand("show databases");
			jdbcRowSet.execute();
			LogUtil.log().info("---��ѯ�������ݿ�---");
			while(jdbcRowSet.next()) {
				list.add(jdbcRowSet.getString("Database"));
			}
			JOptionPane.showMessageDialog(null, "���ӳɹ�...", "��ʾ", 1);
		} catch (Exception e) {
			LogUtil.log().info("---��ѯ���ݿ�ʧ��---");
			JOptionPane.showMessageDialog(null, "����ʧ��...", "����", 0);
			e.printStackTrace();
		}
		return list;
	}
	
	public static void execute(String cmd,JdbcRowSet jdbcRowSet) {
		try {
			jdbcRowSet.setCommand(cmd);
			jdbcRowSet.execute();
			LogUtil.log().info("---ִ��"+cmd+"�ɹ�---");
		} catch (Exception e) {
			LogUtil.log().info("---ִ��"+cmd+"ʧ��---");
			e.printStackTrace();
		}
	}
	
	public static List<Object> getResult(String cmd,JdbcRowSet jdbcRowSet){
		
		return null;
	}
}
