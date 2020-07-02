package sys.ldk.com.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import sys.ldk.com.model.StudentDao;

public class newPass extends JFrame {
   //以下改动
	private JPanel contentPane;
	private JTextField idTextField;
	private JTextField CaptchaTextField;
	private String Captcha;
  //到这为止
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newPass frame = new newPass();
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
	public newPass() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(newPass.class.getResource("/sys/ldk/com/image/学生注册系统.png")));
		setTitle("修改密码");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 439, 371);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("请输入学号");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel.setBounds(29, 47, 99, 24);
		contentPane.add(lblNewLabel);
		
		idTextField = new JTextField();
		idTextField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		idTextField.setBounds(154, 43, 170, 33);
		contentPane.add(idTextField);
		idTextField.setColumns(10);
		
		JButton btnNewButton = new JButton("邮箱");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentDao st = new StudentDao();
				String message = "debug";
				try {
					message = st.newpassword(idTextField.getText().toString());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(message.equals("该用户不存在")) JOptionPane.showMessageDialog(contentPane, message);
				else if(message.equals("无绑定邮箱")) JOptionPane.showMessageDialog(contentPane, message);
				else Captcha = message;
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnNewButton.setBounds(29, 213, 99, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("请选择验证码发送方式：");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(29, 143, 201, 57);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("手机号");
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnNewButton_1.setBounds(154, 213, 99, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("联系客服");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetRegInfo(e);
			}
		});
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnNewButton_2.setBounds(278, 213, 111, 33);
		contentPane.add(btnNewButton_2);
		
		CaptchaTextField = new JTextField();
		CaptchaTextField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		CaptchaTextField.setColumns(10);
		CaptchaTextField.setBounds(154, 97, 170, 33);
		contentPane.add(CaptchaTextField);
		
		JLabel lblNewLabel_2 = new JLabel("请输入验证码");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(29, 101, 111, 24);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_3 = new JButton("下一步");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentDao st = new StudentDao();
				String message = "debug";
				try {
					message = st.newpassword(idTextField.getText().toString());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(message.equals("该用户不存在")) JOptionPane.showMessageDialog(contentPane, message);
				else if(Captcha.equals(CaptchaTextField.getText().toString())){
					setVisible(false);
					updatapassword frame = new updatapassword(idTextField.getText().toString());
					frame.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(contentPane, "验证码错误！");
			}
		});
		btnNewButton_3.setBounds(294, 284, 113, 27);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("取消");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_3_1.setBounds(14, 284, 113, 27);
		contentPane.add(btnNewButton_3_1);
		

		setLocationRelativeTo(null);
	}

	protected void resetRegInfo(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "客服电话：XXX-XXX XXXX");
	}
}
