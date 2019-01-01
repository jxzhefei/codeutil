package codeutil;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author zhongzf
 * @date 2018年12月29日
 * @description
 */
public class DetailJFrame extends MyJFrame {
	
	private static final long serialVersionUID = 1L;
	private JComboBox<String> template;					//代码模板
	private JTextField path1;							//结构文档路径
	private JTextField path2;							//代码生成路径
	private JTextField project;							//项目名称
	private JTextField packagen;						//包名
	private JTextField author;							//作者
	private JButton btn1;								//生成代码按钮
	private JButton btn2;								//关闭按钮
	private JButton btn3;								
	private JButton btn4;								

	public DetailJFrame(int width, int height, String title) {
		super(width, height, title);
		JPanel jPanel = new JPanel(null);
		addJLabelToJPanel(80, 50, 150, 30, "代码模板：", jPanel);
		template = new JComboBox<>();
		template.setBounds(200, 50, 200, 30);
		jPanel.add(template);
		addJLabelToJPanel(80, 100, 150, 30, "结构文档路径：", jPanel);
		path1 = new JTextField();
		path1.setBounds(200, 100, 165, 30);
		jPanel.add(path1);
		btn3 = new JButton("...");
		btn3.setBounds(365, 100, 35, 29);
		jPanel.add(btn3);
		addJLabelToJPanel(80, 150, 150, 30, "代码生成路径：", jPanel);
		path2 = new JTextField();
		path2.setBounds(200, 150, 165, 30);
		jPanel.add(path2);
		btn4 = new JButton("...");
		btn4.setBounds(365, 150, 35, 29);
		jPanel.add(btn4);
		addJLabelToJPanel(80, 200, 150, 30, "项目名称：", jPanel);
		project = new JTextField();
		project.setBounds(200, 200, 200, 30);
		jPanel.add(project);
		addJLabelToJPanel(80, 250, 150, 30, "包名：", jPanel);
		packagen = new JTextField();
		packagen.setBounds(200, 250, 200, 30);
		jPanel.add(packagen);
		addJLabelToJPanel(80, 300, 150, 30, "作者：", jPanel);
		author = new JTextField();
		author.setBounds(200, 300, 200, 30);
		jPanel.add(author);
		btn1 = new JButton("生成代码");
		btn1.setBounds(90, 400, 100, 30);
		jPanel.add(btn1);
		btn2 = new JButton("关闭");
		btn2.setBounds(270, 400, 100, 30);
		jPanel.add(btn2);
		add(jPanel);
		setVisible(true);
		addListener();
		addItemToJComboBox();
	}
	
	@Override
	public void addListener() {
		ActionListener btn1A = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int result = jfc.showDialog(new JLabel(), "选择");
				if (result == JFileChooser.APPROVE_OPTION) {
					path1.setText(jfc.getSelectedFile().getPath());                           
				}
			}
		};
		btn3.addActionListener(btn1A);
		btn4.addActionListener(btn1A);
	}

	public void addItemToJComboBox() {
		File file = new File("D:\\java\\workspaces\\eclipse\\模板");
		if (file.exists()) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				template.addItem(files[i].getName());
			}
		}
	}
}
