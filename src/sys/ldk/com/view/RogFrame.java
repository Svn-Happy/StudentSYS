package sys.ldk.com.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import sys.ldk.com.entity.Student;
import sys.ldk.com.model.StudentDao;
import javax.swing.JPasswordField;

public class RogFrame extends JFrame {

	private JPanel contentPane;
	private JTextField idTextField;
	private final Action action = new SwingAction();
	private JPasswordField passwordTextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RogFrame frame = new RogFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RogFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RogFrame.class.getResource("/sys/ldk/com/image/\u5B66\u751F\u6CE8\u518C\u7CFB\u7EDF.png")));
		setTitle("\u5B66\u751F\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 440);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(237, 31, 32, 32);
		lblNewLabel.setIcon(new ImageIcon(RogFrame.class.getResource("/sys/ldk/com/image/\u7CFB\u7EDF @2x-1.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_1.setBounds(279, 35, 160, 28);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("学号");
		lblNewLabel_2.setBounds(189, 119, 72, 32);
		lblNewLabel_2.setIcon(new ImageIcon(RogFrame.class.getResource("/sys/ldk/com/image/账号-1.png")));
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		idTextField = new JTextField();
		idTextField.setBounds(307, 120, 173, 30);
		idTextField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		idTextField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_2_1.setBounds(189, 171, 72, 32);
		lblNewLabel_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel_2_1.setIcon(new ImageIcon(RogFrame.class.getResource("/sys/ldk/com/image/\u5BC6 \u7801.png")));
		
		JButton btnRegButton = new JButton("\u6CE8\u518C");
		btnRegButton.setBounds(198, 282, 83, 35);
		btnRegButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reg(e);
			}
		});
		btnRegButton.setBackground(Color.WHITE);
		btnRegButton.setFont(new Font("微软雅黑", Font.PLAIN, 19));
		
		JButton btnResetButton = new JButton("\u91CD\u7F6E");
		btnResetButton.setBounds(379, 282, 83, 35);
		btnResetButton.setAction(action);
		btnResetButton.setBackground(Color.WHITE);
		btnResetButton.setForeground(Color.BLACK);
		btnResetButton.setFont(new Font("微软雅黑", Font.PLAIN, 19));
		//给重置按钮添加事件
		btnResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetRegInfo(e);
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_2_1);
		contentPane.add(btnRegButton);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(btnResetButton);
		contentPane.add(idTextField);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		passwordTextField.setBounds(307, 171, 173, 32);
		contentPane.add(passwordTextField);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		passwordField.setBounds(307, 216, 173, 32);
		contentPane.add(passwordField);
		
		JLabel label = new JLabel("(请再次输入密码)");
		label.setBounds(164, 225, 138, 18);
		contentPane.add(label);
	}
	protected void reg(ActionEvent e) {
		//获取注册的用户名 密码 邮箱
		String id = idTextField.getText().toString();
		String password = passwordTextField.getText().toString();
		String rpassword = passwordField.getText().toString();
		//判断非空
		if("".equals(id) || id == null) {
			JOptionPane.showMessageDialog(this, "注册学号不能为空");
			return;
		}
		if("".equals(password) || password == null) {
			JOptionPane.showMessageDialog(this, "注册密码不能为空");
			return;//结束当前方法不再往下执行
		}
		if(!rpassword.equals(password)) {
			JOptionPane.showMessageDialog(this, "两次密码输入不同");
			return;
		}
		if(password.length() < 8) {
			JOptionPane.showMessageDialog(this, "密码长度大于8位");
			return;
		}
		
		/*将数据插入到数据库表中
		 * 将用户数据封装到对象（student）
		 * 减少多个参数传递带来的不便
		 */
		 Student s=new Student();
		 s.setName(id);
		 s.setPassword(password);
		try {
			boolean pd = StudentDao.selectUser(id);
			if(pd == false) {
				JOptionPane.showMessageDialog(this, "该账户已存在，请重新输入");
				return;
			}else {
				 StudentDao dao = new StudentDao();
				int row = dao.insertUser(id, password);
				if(row < 1) JOptionPane.showMessageDialog(this, "注册失败");
				else {
					JOptionPane.showMessageDialog(this, "注册成功");
					 setVisible(false);
					 SignInFram signframe = new SignInFram();
					 signframe.setVisible(true);
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	protected void resetRegInfo(ActionEvent e) {
		//获取注册的用户名 密码 邮箱
		String id = idTextField.getText().toString();
		String password = passwordTextField.getText().toString();
		
		//直接清空操作
		idTextField.setText("");
		passwordTextField.setText("");
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "重置");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
