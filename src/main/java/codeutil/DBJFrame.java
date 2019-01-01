package codeutil;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author zhongzf
 * @date 2018年12月29日
 * @description
 */
public class DBJFrame extends MyJFrame {
	
	private static final long serialVersionUID = 1L;

	private JComboBox<String> dbType;				//数据库类型
	private JTextField server;						//服务器地址
	private JTextField userName;					//用户名
	private JPasswordField password;				//密码
	private JComboBox<String> database;				//数据库
	private JButton connect;						//连接按钮
	private JButton skip;							//跳过按钮
	private JdbcRowSet jdbcRowSet;
	
	public DBJFrame(int width, int height, String title) {
		super(width, height, title);
		JPanel jPanel = new JPanel(null);
		addJLabelToJPanel(80, 50, 150, 30, "数据库类型：", jPanel);
		dbType = new JComboBox<>(new String[]{"MYSQL","ORICLE","DB2"});
		dbType.setBounds(200, 50, 200, 30);
		jPanel.add(dbType);
		addJLabelToJPanel(80, 100, 150, 30, "服务器地址：", jPanel);
		server = new JTextField();
		server.setBounds(200, 100, 200, 30);
		jPanel.add(server);
		addJLabelToJPanel(80, 150, 150, 30, "用户名：", jPanel);
		userName = new JTextField();
		userName.setBounds(200, 150, 200, 30);
		jPanel.add(userName);
		addJLabelToJPanel(80, 200, 150, 30, "密码：", jPanel);
		password = new JPasswordField();
		password.setBounds(200, 200, 200, 30);
		jPanel.add(password);
		addJLabelToJPanel(80, 250, 150, 30, "数据库：", jPanel);
		database = new JComboBox<>(new String[]{"--请选择数据库--"});
		database.setBounds(200, 250, 200, 30);
		jPanel.add(database);
		connect = new JButton("测试连接");
		connect.setBounds(90, 310, 100, 30);
		jPanel.add(connect);
		skip = new JButton("跳过");
		skip.setBounds(270, 310, 100, 30);
		jPanel.add(skip);
		add(jPanel);
		setVisible(true);
	}

	@Override
	public void addListener() {
		ActionListener bt1A = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String dbType1 = dbType.getSelectedItem()+"" ;
				String ip = server.getText();
				String user = userName.getText();
				char[] pchar = password.getPassword();
				String pwd = String.valueOf(pchar);
				jdbcRowSet = DButil.getRowSet(dbType1, user, pwd, ip);
				List<String> dbList = DButil.getAllDB(jdbcRowSet);
				for (String db : dbList) {
					database.addItem(db);
				}
				System.out.println(dbType1);
				System.out.println(ip);
				System.out.println(user);
				System.out.println(pwd);
			}
		};
		connect.addActionListener(bt1A);
		
		ItemListener jcb = new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				String db = "";
				if (database.getSelectedIndex()!=0) {
					db = database.getSelectedItem()+"";
				}else {
					JOptionPane.showMessageDialog(database, "请选择数据库...", "提示", 1);
				}
				DButil.execute("use "+db, jdbcRowSet);
				DBJFrame.this.dispose();
				new DetailJFrame(500, 550, "");
			}
		};
		database.addItemListener(jcb);
		
		ActionListener bt2A = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DBJFrame.this.dispose();
				new DetailJFrame(500, 550, ""); 
			}
		};
		skip.addActionListener(bt2A);
	}


	
	
}
