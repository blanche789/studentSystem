package com.blanche.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.blanche.dao.StudentInfoDao;
import com.blanche.model.StudentInfo;
import javax.swing.ImageIcon;

public class BrowseStudentInfoFrame extends JInternalFrame {
	private JTextField stuNum;
	private JTextField name;
	private JTextField sex;
	private JTextField age;
	private JTextField academy;
	private JTextField _class;
	private JTextField telephone;
	private StudentInfoDao studentInfoDao = new StudentInfoDao();
	private List<StudentInfo> students = studentInfoDao.querryStudentInfo();
	private StudentInfo studentInfo;
	private int currentRow;		//当前记录条数
	private int id;
	private int tag;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrowseStudentInfoFrame frame = new BrowseStudentInfoFrame();
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
	public BrowseStudentInfoFrame() {
		setTitle("\u6D4F\u89C8\u8BB0\u5F55");
		setIconifiable(true);
		setClosable(true);
		getContentPane().setBackground(Color.WHITE);
		setBounds(550, 300, 703, 398);
		
		JLabel label = new JLabel("\u5B66\u53F7\uFF1A");
		label.setIcon(new ImageIcon(BrowseStudentInfoFrame.class.getResource("/images/icon7 .png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		
		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setIcon(new ImageIcon(BrowseStudentInfoFrame.class.getResource("/images/icon.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		
		JLabel label_2 = new JLabel("\u6027\u522B\uFF1A");
		label_2.setIcon(new ImageIcon(BrowseStudentInfoFrame.class.getResource("/images/icon9.png")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		
		JLabel label_3 = new JLabel("\u5E74\u9F84\uFF1A");
		label_3.setIcon(new ImageIcon(BrowseStudentInfoFrame.class.getResource("/images/icon13.png")));
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		
		JLabel label_4 = new JLabel("\u5B66\u9662\uFF1A");
		label_4.setIcon(new ImageIcon(BrowseStudentInfoFrame.class.getResource("/images/icon10.png")));
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		
		JLabel label_5 = new JLabel("\u73ED\u7EA7\uFF1A");
		label_5.setIcon(new ImageIcon(BrowseStudentInfoFrame.class.getResource("/images/icon11.png")));
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		
		JLabel label_6 = new JLabel("\u7535\u8BDD\uFF1A");
		label_6.setIcon(new ImageIcon(BrowseStudentInfoFrame.class.getResource("/images/icon12.png")));
		label_6.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		
		stuNum = new JTextField();
		stuNum.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		stuNum.setColumns(10);
		
		name = new JTextField();
		name.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		name.setColumns(10);
		
		sex = new JTextField();
		sex.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		sex.setColumns(10);
		
		age = new JTextField();
		age.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		age.setColumns(10);
		
		academy = new JTextField();
		academy.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		academy.setColumns(10);
		
		_class = new JTextField();
		_class.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		_class.setColumns(10);
		
		telephone = new JTextField();
		telephone.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		telephone.setColumns(10);
		
		JButton btnNewButton = new JButton("\u7B2C\u4E00\u6761");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFirstInfoActionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u4E0A\u4E00\u6761");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getLastStudentInfoActionPerformed(e);
			}
		});
		
		JButton btnNewButton_2 = new JButton("\u4E0B\u4E00\u6761");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getNextStudentInfoActionPerformed(e);
			}
		});
		
		JButton btnNewButton_3 = new JButton("\u6700\u540E\u4E00\u6761");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getEndStudentInfoActionPerformed(e);
			}
		});
		
		JButton button = new JButton("\u9000\u51FA");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//返回整数,0代表是,1代表否,2代表取消
				int result = JOptionPane.showConfirmDialog(null, "是否退出");
				if(result==0) {
					dispose();
				}
				System.out.println(result);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_5, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(_class, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_4, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(academy, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_3, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(age, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(sex, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(name, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(stuNum, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNewButton_3)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(button, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
								.addComponent(telephone, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(stuNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(sex, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(age, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(academy, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(_class, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(telephone, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(button)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3))
					.addGap(5))
		);
		getContentPane().setLayout(groupLayout);

	}

	/*
	 * 下一条按钮
	 * 获取下一条记录
	 */
	public void getNextStudentInfoActionPerformed(ActionEvent e) {
		if(currentRow < students.size()) {
			tag=0;
			currentRow++;
			studentInfo = students.get(currentRow-1);
			fillFrameData(currentRow,studentInfo);
		}else {
			JOptionPane.showMessageDialog(null, "已到最后一条记录");
		}
		
	}
	/*
	 * 上一条按钮
	 * 获取上一条记录
	 */
	public void getLastStudentInfoActionPerformed(ActionEvent e) {
		if(currentRow > 1) {
			tag=0;
			currentRow--;
			studentInfo = students.get(currentRow-1);
			fillFrameData(currentRow,studentInfo);
		}else {
			JOptionPane.showMessageDialog(null, "已到第一条记录");
		}
		
	}
	/*
	 * 最后一条按钮
	 * 获取最后一条记录
	 */
	public void getEndStudentInfoActionPerformed(ActionEvent e) {
		tag=0;
		studentInfo = students.get(students.size()-1);
		currentRow = students.size();
		fillFrameData(currentRow,studentInfo);
		
		
	}
	/*
	 * 第一条按钮
	 * 获取第一条记录
	 */
	public void getFirstInfoActionPerformed(ActionEvent e) {
		tag=0;
		studentInfo = students.get(0);
		currentRow = 1;
		fillFrameData(currentRow,studentInfo);
		
		}
	/*
	 * 填充编辑窗口的Data
	 */
	public void fillFrameData(int currentRow,StudentInfo studentInfo) {
		this.currentRow = currentRow;
		this.setTitle("浏览学生表记录" + "&& 当前记录" + currentRow);
		this.stuNum.setText(studentInfo.getStuNum());
		this.name.setText(studentInfo.getName());
		this.sex.setText(studentInfo.getSex());
		this.age.setText(Integer.toString(studentInfo.getAge()));
		this.academy.setText(studentInfo.getAcademy());
		this._class.setText(studentInfo.get_Class());
		this.telephone.setText(studentInfo.getTelephone());
		this.stuNum.setEditable(false);
		this.name.setEditable(false);
		this.sex.setEditable(false);
		this.age.setEditable(false);
		this.academy.setEditable(false);
		this._class.setEditable(false);
		this.telephone.setEditable(false);
		
	}
	
}
