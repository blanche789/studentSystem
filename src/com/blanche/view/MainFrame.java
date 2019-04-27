package com.blanche.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.blanche.dao.UserDao;
import com.blanche.model.User;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JToolBar;
import java.awt.Font;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private  JDesktopPane table;
	public static JMenuBar menuBar;
	public static JMenu menu;
	public static JMenuItem menuItem_3;
    private ImageIcon imgBackground; 
    private UserDao userDao = new UserDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		
		setTitle("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 600);
		//创建背景图片
		imgBackground = new ImageIcon("icon6.jpg");
		 menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menu = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		menuBar.add(menu);
		
		 menuItem_3 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//返回整数,0代表是,1代表否,2代表取消
				int result = JOptionPane.showConfirmDialog(null, "是否退出");
				if(result==0) {
					dispose();
				}
				System.out.println(result);
			}
		});
		
		JMenuItem menuItem_1 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyPasswordFrame modifyPassword = new ModifyPasswordFrame();
				modifyPassword.setVisible(true);
				table.add(modifyPassword);
				if(judgeAdmin(LoginFram.userName)) {  //判断是不是管理员,是的话就可以更改用户名
					modifyPassword.userName.setEditable(true);
				}else {
					modifyPassword.oldPassword.requestFocus();
				}
				
			}
		});
		menu.add(menuItem_1);
		
		JMenuItem queryPasswordItem = new JMenuItem("\u67E5\u8BE2\u7528\u6237\u5BC6\u7801");
		queryPasswordItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryUserPassword queryUserPassword = new QueryUserPassword();
				queryUserPassword.setVisible(true);
				table.add(queryUserPassword);
				
			}
		});
		menu.add(queryPasswordItem);
		menu.add(menuItem_3);
		
		JMenu menu_1 = new JMenu("\u5B66\u751F\u4FE1\u606F\u64CD\u4F5C");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u589E\u52A0\u5B66\u751F\u8868\u8BB0\u5F55");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addStuInfoActionPerformed(e);
			}
		});
		menu_1.add(menuItem_2);
		
		JMenuItem editInfoItem = new JMenuItem("\u7F16\u8F91\u5B66\u751F\u8868\u8BB0\u5F55");
		editInfoItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editActionPerformed(e);
			}
		});
		
		JMenuItem menuItem_15 = new JMenuItem("\u6D4F\u89C8\u5B66\u751F\u8868\u8BB0\u5F55");
		menuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				browseActionPerformed(e);
			}
		});
		menu_1.add(menuItem_15);
		menu_1.add(editInfoItem);
		
		JMenu deleteInfoItem = new JMenu("\u5220\u9664\u5B66\u751F\u8868\u8BB0\u5F55");
		menu_1.add(deleteInfoItem);
		
		JMenuItem menuItem_6 = new JMenuItem("\u6309\u5B66\u53F7\u5220\u9664\u8BB0\u5F55");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteByStuNumActionPerformed(e);
			}
		});
		deleteInfoItem.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("\u6309\u73ED\u7EA7\u5220\u9664\u8BB0\u5F55");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteByClassActionPerformed(e);
			}
		});
		deleteInfoItem.add(menuItem_7);
		
		JMenuItem menuItem_8 = new JMenuItem("\u6309\u9662\u5220\u9664\u8BB0\u5F55");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteByAcademyActionPerformed(e);
			}
		});
		deleteInfoItem.add(menuItem_8);
		
		JMenu menu_4 = new JMenu("\u67E5\u8BE2\u5B66\u751F");
		menuBar.add(menu_4);
		
		JMenuItem menuItem_5 = new JMenuItem("\u6309\u5B66\u53F7\u67E5\u8BE2");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryStuInfoByStuNumFrame queryByStuNum = new QueryStuInfoByStuNumFrame();
				queryByStuNum.setVisible(true);
				table.add(queryByStuNum);
			}
		});
		menu_4.add(menuItem_5);
		
		JMenuItem menuItem_9 = new JMenuItem("\u6309\u59D3\u540D\u67E5\u8BE2");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryStuInfoByName queryByName = new QueryStuInfoByName();
				queryByName.setVisible(true);
				table.add(queryByName);
			}
		});
		menu_4.add(menuItem_9);
		
		JMenuItem menuItem_10 = new JMenuItem("\u6309\u73ED\u7EA7\u67E5\u8BE2");
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryStuInfoByClassFrame queryInfoByClass = new QueryStuInfoByClassFrame();
				queryInfoByClass.setVisible(true);
				table.add(queryInfoByClass);
			}
		});
		menu_4.add(menuItem_10);
		
		JMenuItem menuItem_11 = new JMenuItem("\u6309\u9662\u7EA7\u67E5\u8BE2");
		menuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryStuInfoByAcademyFrame queryInfoByAcademy = new QueryStuInfoByAcademyFrame();
				queryInfoByAcademy.setVisible(true);
				table.add(queryInfoByAcademy);
			}
		});
		menu_4.add(menuItem_11);
		
		JMenu menu_5 = new JMenu("\u4EBA\u6570\u7EDF\u8BA1");
		menuBar.add(menu_5);
		
		JMenuItem menuItem_12 = new JMenuItem("\u6309\u6027\u522B\u7EDF\u8BA1");
		menuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				countBySexActionPerformed(e);
			}
		});
		menu_5.add(menuItem_12);
		
		JMenuItem menuItem_13 = new JMenuItem("\u6309\u73ED\u7EA7\u7EDF\u8BA1");
		menuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				countByClassActionPerformed(e);
			}
		});
		menu_5.add(menuItem_13);
		
		JMenuItem menuItem_14 = new JMenuItem("\u6309\u5B66\u9662\u7EDF\u8BA1");
		menuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				countByAcademyAcationPerformed(e);
			}
		});
		menu_5.add(menuItem_14);
		
		JMenu menu_3 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		menuBar.add(menu_3);
		
		JMenuItem menuItem = new JMenuItem("\u4F5C\u8005\u4FE1\u606F");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DesignerFrame designerFrame = new DesignerFrame();
				designerFrame.setVisible(true);
				table.add(designerFrame);
				
			}
		});
	
		menu_3.add(menuItem);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JDesktopPane();
		
		table.setBackground(UIManager.getColor("Button.light"));
		contentPane.add(table, BorderLayout.CENTER);
		table.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 1924, 83);
		table.add(toolBar);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539\u5BC6\u7801");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyPasswordFrame modifyPassword = new ModifyPasswordFrame();
				modifyPassword.setVisible(true);
				table.add(modifyPassword);
				if(judgeAdmin(LoginFram.userName)) {
					modifyPassword.userName.setEditable(true);
				}else {
					modifyPassword.oldPassword.requestFocus();
				}
				
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		toolBar.add(btnNewButton);
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.setIcon(new ImageIcon(MainFrame.class.getResource("/images/icon16.png")));
		btnNewButton.setVerticalTextPosition(AbstractButton.BOTTOM);
		btnNewButton.setHorizontalTextPosition(AbstractButton.CENTER);
		
		JButton button = new JButton("\u6D4F\u89C8\u5B66\u751F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BrowseStudentInfoFrame browseFrame = new BrowseStudentInfoFrame();
				browseFrame.setVisible(true);
				table.add(browseFrame);
			}
		});
		button.setIcon(new ImageIcon(MainFrame.class.getResource("/images/icon17.png")));
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		button.setBackground(SystemColor.menu);
		toolBar.add(button);
		
		JButton button_1 = new JButton("\u67E5\u8BE2\u5B66\u751F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryStuInfoByStuNumFrame queryByStuNum = new QueryStuInfoByStuNumFrame();
				queryByStuNum.setVisible(true);
				table.add(queryByStuNum);
			}
		});
		button_1.setIcon(new ImageIcon(MainFrame.class.getResource("/images/icon18.png")));
		button_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		button_1.setBackground(SystemColor.menu);
		toolBar.add(button_1);
		
		JButton button_2 = new JButton("\u7EDF\u8BA1\u4EBA\u6570");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				countByAcademyAcationPerformed(e);
			}
		});
		button_2.setIcon(new ImageIcon(MainFrame.class.getResource("/images/icon19.png")));
		button_2.setVerticalTextPosition(SwingConstants.BOTTOM);
		button_2.setHorizontalTextPosition(SwingConstants.CENTER);
		button_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		button_2.setBackground(SystemColor.menu);
		toolBar.add(button_2);
		
		JButton button_3 = new JButton("\u9000\u51FA\u7CFB\u7EDF");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//返回整数,0代表是,1代表否,2代表取消
				int result = JOptionPane.showConfirmDialog(null, "是否退出");
				if(result==0) {
					dispose();
				}
				System.out.println(result);
			}
		});
		button_3.setIcon(new ImageIcon(MainFrame.class.getResource("/images/icon20.png")));
		button_3.setVerticalTextPosition(SwingConstants.BOTTOM);
		button_3.setHorizontalTextPosition(SwingConstants.CENTER);
		button_3.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		button_3.setBackground(SystemColor.menu);
		toolBar.add(button_3);
//		contentPane.add(lblBackground);

//		//使窗体居中
//		this.setLocationRelativeTo(null);
		//使窗体最大化,继承自awt.Frame
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		/*
		 * 判断登录进来的用户是否是管理员,如果不是的话就使查询用户密码框消失
		 */
		if(!judgeAdmin(LoginFram.userName)) {
			queryPasswordItem.setVisible(false);
			editInfoItem.setVisible(false);
			deleteInfoItem.setVisible(false);
			
		}
		
	}
	
	/*
	 * 显示增加学生窗体
	 */
	public void addStuInfoActionPerformed(ActionEvent e) {
		AddStudentInfoFrame addStudentInfoFrame = new AddStudentInfoFrame();
		addStudentInfoFrame.setVisible(true);
		table.add(addStudentInfoFrame);
		
	}
	/*
	 * 显示浏览学生窗体
	 */
	public void browseActionPerformed(ActionEvent e) {
		BrowseStudentInfoFrame browseFrame = new BrowseStudentInfoFrame();
		browseFrame.setVisible(true);
		table.add(browseFrame);
		
	}

	/*
	 *显示编辑学生窗体
	 */
	public void editActionPerformed(ActionEvent e) {
		EditStudentInfoFrame editStudentInfo = new EditStudentInfoFrame();
		editStudentInfo.setVisible(true);
		table.add(editStudentInfo);
		
	}

	/*
	 * 判断用户是不是管理员
	 */
	public boolean judgeAdmin(String userName) {
		boolean tag=false;
		User user = userDao.queryByUserName(userName);
		if(user!=null) {
			if(user.getRight().equals("admin")) {
				tag=true;
			}
		}
		return tag;
	}
	/*
	 * 显示通过学院计数窗体
	 */
	public void countByAcademyAcationPerformed(ActionEvent e) {
		CountNumByAcademyFrame countByAcademy = new CountNumByAcademyFrame();
		countByAcademy.setVisible(true);
		table.add(countByAcademy);
		countByAcademy.displayNumOfPeopleTable();
		
	}
	/*
	 * 显示通过班级计数窗体
	 */
	public void countByClassActionPerformed(ActionEvent e) {
		CountNumByClassFrame countByClass = new CountNumByClassFrame();
		countByClass.setVisible(true);
		table.add(countByClass);
		countByClass.displayNumOfPeopleTable();
		
	}
	/*
	 * 显示通过性别计数窗体
	 */
	public void countBySexActionPerformed(ActionEvent e) {
		CountNumBySexFrame countBySex = new CountNumBySexFrame();
		countBySex.setVisible(true);
		table.add(countBySex);
		countBySex.displayNumOfPeopleTable();
		
	}
	/*
	 *显示通过学院删除学生窗体
	 */
	public void deleteByAcademyActionPerformed(ActionEvent e) {
		DeleteStudentInfoByAcademyFrame deleteByAcademy = new DeleteStudentInfoByAcademyFrame();
		deleteByAcademy.setVisible(true);
		table.add(deleteByAcademy);
		
	}
	
	/*
	 * 显示通学号院删除学生窗体
	 */
	public void deleteByStuNumActionPerformed(ActionEvent e) {
		DeleteStudentInfoByStuNumFrame deleteFrame = new DeleteStudentInfoByStuNumFrame();
		deleteFrame.setVisible(true);
		table.add(deleteFrame);
		
	}
	/*
	 * 显示通过班级删除学生窗体
	 */
	public void deleteByClassActionPerformed(ActionEvent e) {
		DeleteStudentInfoByClassFrame deleteByClass = new DeleteStudentInfoByClassFrame();
		deleteByClass.setVisible(true);
		table.add(deleteByClass);
		
	}
}
