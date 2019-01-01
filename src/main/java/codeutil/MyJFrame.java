package codeutil;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author zhongzf
 * @date 2018Äê12ÔÂ29ÈÕ
 * @description
 */
public class MyJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public MyJFrame(int width,int height,String title) {
		setTitle(title);
		setSize(width, height);
		setDefaultLookAndFeelDecorated(isDefaultLookAndFeelDecorated());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public void addJLabelToJPanel(int x,int y,int width,int height,String text,JPanel jPanel) {
		JLabel jLabel = new JLabel(text);
		jLabel.setBounds(x, y, width, height);
		jPanel.add(jLabel);
	}
	
	public void addListener() {
		
	}
}
