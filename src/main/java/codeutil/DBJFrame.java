package codeutil;



import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author zhongzf
 * @date 2018��12��29��
 * @description
 */
public class DBJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public DBJFrame() {
		JPanel jPanel = new JPanel(null);
		addJLabelToJPanel(80, 50, 150, 30, "���ݿ����ͣ�", jPanel);
		JComboBox<String> jComboBox = new JComboBox<>(new String[]{"MYSQL","ORICLE","DB2"});
		jComboBox.setBounds(200, 50, 200, 30);
		jPanel.add(jComboBox);
		addJLabelToJPanel(80, 100, 150, 30, "��������ַ��", jPanel);
		JTextField jTextField = new JTextField();
		jTextField.setBounds(200, 100, 200, 30);
		jPanel.add(jTextField);
		addJLabelToJPanel(80, 150, 150, 30, "�û�����", jPanel);
		JTextField jTextField2 = new JTextField();
		jTextField2.setBounds(200, 150, 200, 30);
		jPanel.add(jTextField2);
		addJLabelToJPanel(80, 200, 150, 30, "���룺", jPanel);
		JPasswordField jPasswordField = new JPasswordField();
		jPasswordField.setBounds(200, 200, 200, 30);
		jPanel.add(jPasswordField);
		add(jPanel);
		setTitle("����������");
		setSize(500, 400);
		setDefaultLookAndFeelDecorated(isDefaultLookAndFeelDecorated());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void addJLabelToJPanel(int x,int y,int width,int height,String text,JPanel jPanel) {
		JLabel jLabel = new JLabel(text);
		jLabel.setBounds(x, y, width, height);
		jPanel.add(jLabel);
	}
}
