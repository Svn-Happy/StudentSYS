package sys.ldk.com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import sys.ldk.com.entity.Student;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceFrame extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceFrame frame = new InterfaceFrame();
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
	public InterfaceFrame() {
		
	}
	public InterfaceFrame(Student student) {
		setBackground(Color.BLACK);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
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
		mntmNewMenuItem.setBackground(Color.WHITE);
		mntmNewMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		mntmNewMenuItem.setForeground(Color.BLACK);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("修改密码");
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
		mntmNewMenuItem_5.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		mntmNewMenuItem_5.setForeground(Color.BLACK);
		mntmNewMenuItem_5.setBackground(Color.WHITE);
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_1 = new JMenu("班级信息");
		mnNewMenu_1.setForeground(Color.BLACK);
		mnNewMenu_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mnNewMenu_1.setIcon(new ImageIcon(InterfaceFrame.class.getResource("/sys/ldk/com/image/班级信息.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_3 = new JMenu("成绩查询");
		mnNewMenu_3.setBackground(Color.BLACK);
		mnNewMenu_3.setForeground(Color.BLACK);
		mnNewMenu_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		mnNewMenu_3.setIcon(new ImageIcon(InterfaceFrame.class.getResource("/sys/ldk/com/image/成绩查询-1.png")));
		menuBar.add(mnNewMenu_3);
		
		JMenu mnNewMenu_4 = new JMenu("考试管理");
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
