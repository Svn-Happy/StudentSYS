package sys.ldk.com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sys.ldk.com.entity.Student;
import sys.ldk.com.model.StudentDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class updatapassword extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String id = null;
					updatapassword frame = new updatapassword(id);
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
	public updatapassword(String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("请输入新密码：");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel.setBounds(41, 49, 142, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("请再次输入密码：");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(41, 108, 166, 37);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(197, 49, 166, 37);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(197, 110, 166, 37);
		contentPane.add(passwordField_1);
		
		JButton btnNewButton = new JButton("完成");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetRegInfo(e,id);
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnNewButton.setBounds(141, 188, 113, 27);
		contentPane.add(btnNewButton);
	}

	protected void resetRegInfo(ActionEvent e,String id)  {
		//获取注册的用户名 密码 邮箱
		String Id = id;
		String password = passwordField_1.getText().toString();
		String rpassword = passwordField.getText().toString();
		//判断非空
		if("".equals(id) || id == null) {
			JOptionPane.showMessageDialog(this, "注册学号不能为空");
			return;
		}
		if("".equals(password) || password == null) {
			JOptionPane.showMessageDialog(this, "修改密码不能为空");
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
		Student s = new Student();
		s.setId(Id);
		s.setPassword(passwordField_1.getText().toString());
		StudentDao sd = new StudentDao();
		try {
			if(sd.updatePassword(s) > 0)
				JOptionPane.showMessageDialog(this, "修改密码成功");
			else
				JOptionPane.showMessageDialog(this, "修改密码失败");
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		setVisible(false);
	}
}
