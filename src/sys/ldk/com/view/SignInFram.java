package sys.ldk.com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import sys.ldk.com.entity.Student;
import sys.ldk.com.model.StudentDao;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class SignInFram extends JFrame {

	private JPanel contentPane;
	private JTextField idTextField;
	private final Action action = new SwingAction();
	private JPasswordField passwordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignInFram signframe = new SignInFram();
					signframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignInFram() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignInFram.class.getResource("/sys/ldk/com/image/学生注册系统.png")));
		setForeground(Color.BLACK);
		setBackground(Color.BLACK);
		setTitle("学生登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 440);
		//窗口居中
		//setLocationRelativeTo(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setToolTipText("");
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(237, 34, 32, 32);
		lblNewLabel.setIcon(new ImageIcon(SignInFram.class.getResource("/sys/ldk/com/image/系统 @2x-1.png")));
		
		JLabel lblNewLabel_1 = new JLabel("学生信息管理系统");
		lblNewLabel_1.setBounds(277, 34, 160, 28);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("学号");
		lblNewLabel_2.setBounds(175, 135, 76, 32);
		lblNewLabel_2.setIcon(new ImageIcon(SignInFram.class.getResource("/sys/ldk/com/image/账号-1.png")));
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3 = new JLabel("密码");
		lblNewLabel_3.setBounds(175, 209, 76, 32);
		lblNewLabel_3.setIcon(new ImageIcon(SignInFram.class.getResource("/sys/ldk/com/image/密码.png")));
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		idTextField = new JTextField();
		idTextField.setBounds(295, 137, 178, 31);
		idTextField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		idTextField.setColumns(10);
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.setBounds(196, 290, 85, 37);
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetRegInfo(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("注册");
		btnNewButton_1.setBounds(368, 290, 85, 37);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setAction(action);
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_3);
		contentPane.add(btnNewButton);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(idTextField);
		contentPane.add(btnNewButton_1);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		passwordTextField.setBounds(295, 209, 178, 32);
		contentPane.add(passwordTextField);
		
		JButton btnNewButton_2 = new JButton("忘记密码");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetPassword(e);
			}
		});
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(487, 209, 103, 32);
		contentPane.add(btnNewButton_2);
	}
	protected void resetPassword(ActionEvent e) {
		newPass frame = new newPass();
		frame.setVisible(true);
	}

	protected void resetRegInfo(ActionEvent e) {
		String id = idTextField.getText().toString();
		String password = passwordTextField.getText().toString();
		
		if("".equals(id) || id == null) {
			JOptionPane.showMessageDialog(this, "登录账号不能为空");
			return;
		}
		if("".equals(password) || password == null) {
			JOptionPane.showMessageDialog(this, "登录密码不能为空");
			return;//结束当前方法不再往下执行
		}
		
		try {
			StudentDao s = new StudentDao();
			s.selectUser(id, password);
			Student student = s.selectUser(id, password);
			if(student == null) 
				JOptionPane.showMessageDialog(this, "账户或密码错误");
			else {
				student.tString();
				JOptionPane.showMessageDialog(this, "登录成功");
				setVisible(false);
				//InterfaceFrame interfaceframe = new InterfaceFrame(s.getimage(id,student));
				//interfaceframe.setVisible(true);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "注册");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			

			setVisible(false);//关闭还是隐藏？
			RogFrame frame = new RogFrame();
			frame.setVisible(true);
			
		}
		
	}
}
