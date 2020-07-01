package sys.ldk.com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTextField;

public class newPass extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
		
		textField = new JTextField();
		textField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField.setBounds(154, 43, 170, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("邮箱");
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
		btnNewButton_2.setBounds(278, 213, 105, 33);
		contentPane.add(btnNewButton_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(154, 97, 170, 33);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("请输入验证码");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(29, 101, 111, 24);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_3 = new JButton("下一步");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				updatapassword frame = new updatapassword();
				frame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(294, 284, 113, 27);
		contentPane.add(btnNewButton_3);
	}

	protected void resetRegInfo(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "客服电话：XXX-XXX XXXX");
	}
}
