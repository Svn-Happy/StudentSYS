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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import sys.ldk.com.entity.Student;
import sys.ldk.com.model.StudentDao;

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
					/*try {
			            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
			                if ("Nimbus".equals(info.getName())) {
			                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
			                    break;
			                }
			            }
			        }catch(Exception e) {
			        	System.out.println(e);
			        }*/
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
		ImageIcon background = new ImageIcon(SignInFram.class.getResource("/sys/ldk/com/image/sky.jpg"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignInFram.class.getResource("/sys/ldk/com/image/学生注册系统.png")));
		setTitle("学生登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, background.getIconWidth(), background.getIconHeight());
		//窗口居中
		//setLocationRelativeTo(true);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setToolTipText("");
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel image = new JLabel(background);
		getLayeredPane().add(image, Integer.valueOf(Integer.MIN_VALUE));
		image.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
		contentPane.setLayout(null);
		
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setOpaque(false);
		desktopPane.setBounds(0, 0, 492, 605);
		contentPane.add(desktopPane);
		desktopPane.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("忘记密码");
		btnNewButton_2.setBounds(294, 284, 103, 32);
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setBorderPainted(false);
		desktopPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetPassword(e);
			}
		});
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_2.setBackground(Color.WHITE);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(183, 248, 178, 32);
		desktopPane.add(passwordTextField);
		passwordTextField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		JButton btnNewButton_1 = new JButton("注册");
		btnNewButton_1.setBounds(202, 453, 85, 37);
		Color c1 = new Color(0,0,255);//背影颜色随便设任意值,只起占位作用。
		btnNewButton_1.setBackground(c1);
		btnNewButton_1.setOpaque(false); //设置背景透明 
		desktopPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setAction(action);
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("学生信息管理系统");
		lblNewLabel_1.setIcon(new ImageIcon(SignInFram.class.getResource("/sys/ldk/com/image/系统 @2x.png")));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(138, 74, 250, 38);
		desktopPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("幼圆", Font.BOLD, 24));
		
		idTextField = new JTextField();
		idTextField.setBounds(183, 187, 178, 31);
		desktopPane.add(idTextField);
		idTextField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		idTextField.setColumns(10);
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.setBounds(202, 368, 85, 37);
		desktopPane.add(btnNewButton);
		Color c = new Color(0,0,255);//背影颜色随便设任意值,只起占位作用。
		btnNewButton.setBackground(c);
		btnNewButton.setOpaque(false); //设置背景透明 
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3 = new JLabel("密码");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(93, 247, 76, 32);
		desktopPane.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(SignInFram.class.getResource("/sys/ldk/com/image/密码.png")));
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("学号");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(96, 185, 84, 32);
		desktopPane.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(SignInFram.class.getResource("/sys/ldk/com/image/账号.png")));
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetRegInfo(e);
			}
		});

		setLocationRelativeTo(null);
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
			student = s.getimage(id,student);
			
			if(student == null) 
				JOptionPane.showMessageDialog(this, "账户或密码错误");
			else {
				student.tString();
				JOptionPane.showMessageDialog(this, "登录成功");
				setVisible(false);
				InterfaceFrame interfaceframe = new InterfaceFrame(student);
				interfaceframe.setVisible(true);
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
