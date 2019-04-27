package com.blanche.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.blanche.dao.UserDao;
import com.blanche.model.User;

public class QueryUserPassword extends JInternalFrame {
	private JTable userInfoTable;
	private JTextField userNameText;
	private UserDao userDao = new UserDao();
	private List<User> users;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryUserPassword frame = new QueryUserPassword();
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
	public QueryUserPassword() {
		Color bg1 = new Color(238, 238, 238);
		getContentPane().setBackground(bg1);
		setClosable(true);

		setIconifiable(true);
		setTitle("\u6309\u7528\u6237\u540D\u67E5\u8BE2\u5B66\u751F\u5BC6\u7801");
		setToolTipText("");
		setBounds(450, 200, 527, 496);
		Color bg2 = new Color(238, 238, 238);
		JScrollPane scrollPane = new JScrollPane();
		TitledBorder tb = new TitledBorder("查询结果");
		scrollPane.setBorder(tb);
		scrollPane.setBackground(bg2);
		JLabel label = new JLabel("\u8F93\u5165\u7528\u6237\u540D:");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		userNameText = new JTextField();
		userNameText.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queryByUserActionPerformed(e);
			}
		});
		
		JButton button_1 = new JButton("\u663E\u793A\u5168\u90E8\u8BB0\u5F55");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayAllActionPerformed(e);
			}
		});
		
		JButton button_3 = new JButton("\u9000\u51FA");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result;
				result = JOptionPane.showConfirmDialog(null, "确定退出吗?");
				if(result==0) {
					dispose();
				}
			}
		});
		
		JButton button_2 = new JButton("\u6253\u5370");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(userNameText, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(button_1)
								.addGap(6))
							.addComponent(scrollPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 489, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(userNameText, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button_2, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		userInfoTable = new JTable();
		userInfoTable.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		userInfoTable.setBackground(Color.WHITE);
		userInfoTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"用户名", "密码"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		userInfoTable.getColumnModel().getColumn(0).setResizable(false);
		userInfoTable.getColumnModel().getColumn(1).setResizable(false);
	
		scrollPane.setViewportView(userInfoTable);
		getContentPane().setLayout(groupLayout);

	}
	/*
	 * 打印功能
	 */
	public void printActionPerformed(ActionEvent e) {
		try {
			userInfoTable.print();
		} catch (PrinterException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	/*
	 * 通过用户名查询记录
	 */
	public void queryByUserActionPerformed(ActionEvent e) {
		String userName = this.userNameText.getText();
		DefaultTableModel dtm = (DefaultTableModel)userInfoTable.getModel();  
		if(userName.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入用户名");
			dtm.setRowCount(0); //使table数据清空
		}else {
			User user = userDao.queryByUserName(userName);  
			if(user==null) {
				JOptionPane.showMessageDialog(null, "不存在该用户");
				dtm.setRowCount(0); //使table数据清空
			}else {
				users = new ArrayList<User>();
				users.add(user);
				this.fillTable(users);
			}
		}
	}

	/*
	 * 显示全部记录
	 */
	public void displayAllActionPerformed(ActionEvent e) {
		 users = userDao.querryUserInfo();
		this.fillTable(users);
		
	}
	
	public void fillTable(List<User> users) {
		DefaultTableModel dtm = (DefaultTableModel)userInfoTable.getModel();
		dtm.setRowCount(0); //设置成0行
		
		for(User user : users) {
			Vector<String> currentRow = new Vector<String>();  //将vector定义到for循环里,这样每次循环都重新实例化集合,防止tableModel只装入了第一条记录
			currentRow.addElement(user.getUserName());
			currentRow.addElement(user.getPassword());
			dtm.addRow(currentRow);
		}
	}
}
