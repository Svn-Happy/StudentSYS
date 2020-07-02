package sys.ldk.com.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

import sys.ldk.com.entity.Student;
import sys.ldk.com.model.StudentDao;

public class InterfaceFrame extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student student = new Student();
					InterfaceFrame frame = new InterfaceFrame(student);
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
	//public InterfaceFrame(Student);
	
	JLabel namelabel2 = new JLabel();
	JLabel sexlabel2 = new JLabel();
	JLabel agelabel2 = new JLabel();
	JLabel telelabel2 = new JLabel();
	JLabel emaillabel2 = new JLabel();
	JPanel personalinfo = new JPanel();
	JPanel updatapersonalinfo = new JPanel();
	JPanel panel = new JPanel();
	private JTextField teletext;
	private JTextField nametext;
	private JTextField sextext;
	private JTextField agetext;
	private JTextField emailtext;

	
	public InterfaceFrame(Student student) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceFrame.class.getResource("/sys/ldk/com/image/学生注册系统.png")));
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		menuBar.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("账号管理");
		mnNewMenu.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mnNewMenu.setForeground(Color.BLACK);
		mnNewMenu.setIcon(new ImageIcon(InterfaceFrame.class.getResource("/sys/ldk/com/image/账号-1.png")));
		mnNewMenu.setBackground(Color.WHITE);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("个人信息          ");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonalinfoShow(e);
			}
		});
		mntmNewMenuItem.setBackground(Color.WHITE);
		mntmNewMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		mntmNewMenuItem.setForeground(Color.BLACK);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("修改密码");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newPass frame = new newPass();
				frame.setVisible(true);
			}
		});
		mntmNewMenuItem_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		mntmNewMenuItem_2.setForeground(Color.BLACK);
		mntmNewMenuItem_2.setBackground(Color.WHITE);
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("切换用户");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 setVisible(false);
				 SignInFram signframe = new SignInFram();
				 signframe.setVisible(true);
			}
		});
		mntmNewMenuItem_4.setForeground(Color.BLACK);
		mntmNewMenuItem_4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		mntmNewMenuItem_4.setBackground(Color.WHITE);
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("退出登录");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_5.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		mntmNewMenuItem_5.setForeground(Color.BLACK);
		mntmNewMenuItem_5.setBackground(Color.WHITE);
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_3 = new JMenu("信息查询");
		mnNewMenu_3.setBackground(Color.BLACK);
		mnNewMenu_3.setForeground(Color.BLACK);
		mnNewMenu_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mnNewMenu_3.setIcon(new ImageIcon(InterfaceFrame.class.getResource("/sys/ldk/com/image/成绩查询-1.png")));
		menuBar.add(mnNewMenu_3);
		
		JMenu mnNewMenu_4 = new JMenu("选课信息");
		mnNewMenu_4.setIcon(new ImageIcon(InterfaceFrame.class.getResource("/sys/ldk/com/image/考试管理-2.png")));
		mnNewMenu_4.setForeground(Color.BLACK);
		mnNewMenu_4.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_4);
		
		JMenu mnNewMenu_5 = new JMenu("系统设置");
		mnNewMenu_5.setIcon(new ImageIcon(InterfaceFrame.class.getResource("/sys/ldk/com/image/设 置.png")));
		mnNewMenu_5.setForeground(Color.BLACK);
		mnNewMenu_5.setBackground(Color.BLACK);
		mnNewMenu_5.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_5);
		getContentPane().setLayout(null);
		personalinfo.setBounds(0, 0, 782, 419);
		getContentPane().add(panel);
		personalinfo.setBackground(Color.WHITE);
		personalinfo.setLayout(null);
		personalinfo.hide();
		
		JLabel idlabel = new JLabel("学号：");
		idlabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		idlabel.setBounds(140, 35, 72, 18);
		personalinfo.add(idlabel);
		
		JLabel idlabel2 = new JLabel(student.getId());
		idlabel2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		idlabel2.setBounds(343, 35, 175, 18);
		personalinfo.add(idlabel2);
		
		JLabel namelabel = new JLabel("姓名：");
		namelabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		namelabel.setBounds(140, 90, 72, 18);
		personalinfo.add(namelabel);
		
		namelabel2 = new JLabel(student.getName());
		namelabel2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		namelabel2.setBounds(343, 90, 175, 18);
		personalinfo.add(namelabel2);
		
		sexlabel2 = new JLabel(student.getSex());
		sexlabel2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		sexlabel2.setBounds(343, 140, 175, 18);
		personalinfo.add(sexlabel2);
		
		JLabel agelabel = new JLabel("年龄：");
		agelabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		agelabel.setBounds(140, 192, 72, 18);
		personalinfo.add(agelabel);
		
		JLabel telelabel = new JLabel("手机号码：");
		telelabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		telelabel.setBounds(140, 296, 98, 18);
		personalinfo.add(telelabel);
		
		JLabel emaillabel = new JLabel("电子邮件：");
		emaillabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		emaillabel.setBounds(140, 245, 98, 18);
		personalinfo.add(emaillabel);
		
		JLabel sexlabel = new JLabel("性别：");
		sexlabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		sexlabel.setBounds(140, 140, 72, 18);
		personalinfo.add(sexlabel);
		
		
		agelabel2 = new JLabel(student.getAge() + " ");
		agelabel2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		agelabel2.setBounds(343, 192, 72, 18);
		personalinfo.add(agelabel2);

		telelabel2 = new JLabel(student.getTele());
		telelabel2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		telelabel2.setBounds(343, 296, 210, 18);
		personalinfo.add(telelabel2);
		
		emaillabel2 = new JLabel(student.getEmail());
		emaillabel2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		emaillabel2.setBounds(343, 245, 210, 18);
		
		personalinfo.add(emaillabel2);
		
		JButton btnNewButton = new JButton("编辑个人信息");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatapersonalinfoShow(e);
			}
		});
		btnNewButton.setBounds(140, 352, 135, 33);
		personalinfo.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("退出");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonalinfoHideout(e);
			}
		});
		btnNewButton_1.setBounds(453, 355, 135, 33);
		personalinfo.add(btnNewButton_1);
		updatapersonalinfo.setBounds(0, 0, 782, 419);
		getContentPane().add(updatapersonalinfo);
		updatapersonalinfo.setBackground(Color.WHITE);
		updatapersonalinfo.setLayout(null);
		updatapersonalinfo.hide();
		
		JLabel idlabelupdata = new JLabel("学号：");
		idlabelupdata.setBackground(Color.WHITE);
		idlabelupdata.setBounds(140, 35, 72, 18);
		idlabelupdata.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		updatapersonalinfo.add(idlabelupdata);
		
		JLabel namelabelupdata = new JLabel("姓名：");
		namelabelupdata.setBounds(140, 90, 72, 18);
		namelabelupdata.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		updatapersonalinfo.add(namelabelupdata);
		
		JLabel agelabelupdata = new JLabel("年龄：");
		agelabelupdata.setBounds(140, 192, 72, 18);
		agelabelupdata.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		updatapersonalinfo.add(agelabelupdata);
		
		JLabel telelabelupdata = new JLabel("手机号码：");
		telelabelupdata.setBounds(140, 296, 98, 18);
		telelabelupdata.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		updatapersonalinfo.add(telelabelupdata);
		
		JLabel emaillabelupdata = new JLabel("电子邮件：");
		emaillabelupdata.setBounds(140, 245, 98, 18);
		emaillabelupdata.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		updatapersonalinfo.add(emaillabelupdata);
		
		JLabel sexlabelupdata = new JLabel("性别：");
		sexlabelupdata.setBounds(140, 140, 72, 18);
		sexlabelupdata.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		updatapersonalinfo.add(sexlabelupdata);
		
		JButton btnNewButton_2 = new JButton("保存");
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Updatepersonalinfo(e,student);
			}
		});
		btnNewButton_2.setBounds(140, 352, 135, 33);
		updatapersonalinfo.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("退出");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatapersonalinfo.hide();
				personalinfo.show();

				getContentPane().add(personalinfo);
			}
		});
		btnNewButton_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnNewButton_1_1.setBounds(453, 355, 135, 33);
		updatapersonalinfo.add(btnNewButton_1_1);
		
		teletext = new JTextField();
		teletext.setText(student.getTele());
		teletext.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		teletext.setBounds(343, 291, 232, 33);
		teletext.setColumns(10);
		updatapersonalinfo.add(teletext);
		
		nametext = new JTextField();
		nametext.setText(student.getName());
		nametext.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		nametext.setColumns(10);
		nametext.setBounds(343, 89, 232, 33);
		updatapersonalinfo.add(nametext);
		
		sextext = new JTextField();
		sextext.setText(student.getSex());
		sextext.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		sextext.setColumns(10);
		sextext.setBounds(343, 139, 232, 33);
		updatapersonalinfo.add(sextext);
		
		agetext = new JTextField();
		agetext.setText(String.valueOf(student.getAge()));
		agetext.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		agetext.setColumns(10);
		agetext.setBounds(343, 191, 232, 33);
		updatapersonalinfo.add(agetext);
		
		emailtext = new JTextField();
		emailtext.setText(student.getEmail());
		emailtext.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		emailtext.setColumns(10);
		emailtext.setBounds(343, 244, 232, 33);
		updatapersonalinfo.add(emailtext);
		
		JLabel idlabelupdata2 = new JLabel(student.getId());
		idlabelupdata2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		idlabelupdata2.setBounds(343, 37, 175, 18);
		updatapersonalinfo.add(idlabelupdata2);
		
		
		panel.setBounds(0, 0, 782, 419);
		getContentPane().add(panel);
		

		setLocationRelativeTo(null);
	}
	

	
	protected void updatapersonalinfoShow(ActionEvent e) {
		personalinfo.hide();
		updatapersonalinfo.show();
		getContentPane().add(updatapersonalinfo);

	}


	protected void Updatepersonalinfo(ActionEvent e,Student student) {
		
		if((	("".equals(nametext.getText().toString()) || nametext.getText().toString() == null) ||
				("".equals(sextext.getText().toString()) || sextext.getText().toString() == null) ||
				(agetext.getText() == null) ||
				("".equals(emailtext.getText().toString()) || emailtext.getText().toString() == null) ||
				("".equals(teletext.getText().toString()) || teletext.getText().toString() == null))) {
			JOptionPane.showMessageDialog(this, "信息不能为空");
			return;
		}
		
		StudentDao s = new StudentDao();
		student.setName(nametext.getText().toString());
		student.setSex(sextext.getText().toString());
		student.setAge(Integer.parseInt(agetext.getText()));
		student.setEmail(emailtext.getText().toString());
		student.setTele(teletext.getText().toString());
		student.tString();


		
		try {
			
			s.updateUser(student);
			
			namelabel2.setText(student.getName());
			sexlabel2.setText(student.getSex());
			agelabel2.setText(agetext.getText());
			telelabel2.setText(student.getTele());
			emaillabel2.setText(student.getEmail());

			student.tString();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		updatapersonalinfo.hide();
		personalinfo.show();

		getContentPane().add(personalinfo);

	}


	protected void PersonalinfoHideout(ActionEvent e) {//退出个人信息
		personalinfo.hide();
		panel.show();
		getContentPane().add(panel);
		
	}


	protected void PersonalinfoShow(ActionEvent e) {//进入个人信息
		panel.hide();
		personalinfo.show();
		getContentPane().add(personalinfo);
		
	}


	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
