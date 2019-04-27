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
import javax.swing.RowSorter;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.blanche.dao.StudentInfoDao;
import com.blanche.model.StudentInfo;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;

public class QueryStuInfoByStuNumFrame extends JInternalFrame {
	private JTable studentInfoTable;
	private JTextField stuNumText;
	private  StudentInfoDao studentInfoDao = new StudentInfoDao();
	private List<StudentInfo> students;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryStuInfoByStuNumFrame frame = new QueryStuInfoByStuNumFrame();
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
	public QueryStuInfoByStuNumFrame() {
		Color bg1 = new Color(238, 238, 238);
		getContentPane().setBackground(bg1);
		setClosable(true);

		setIconifiable(true);
		setTitle("\u6309\u5B66\u53F7\u67E5\u8BE2\u5B66\u751F\u8BB0\u5F55");
		setToolTipText("");
		setBounds(550, 300, 781, 496);
		Color bg2 = new Color(238, 238, 238);
		JScrollPane scrollPane = new JScrollPane();
		TitledBorder tb = new TitledBorder("查询结果");
		scrollPane.setBorder(tb);
		scrollPane.setBackground(bg2);
		JLabel label = new JLabel("\u8F93\u5165\u5B66\u53F7:");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		stuNumText = new JTextField();
		stuNumText.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queryByStuNumActionPerformed(e);
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
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(stuNumText, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addGap(115))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(stuNumText, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		studentInfoTable = new JTable();
		studentInfoTable.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		studentInfoTable.setBackground(Color.WHITE);
		studentInfoTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5E74\u9F84", "\u73ED\u7EA7", "\u5B66\u9662", "\u8054\u7CFB\u65B9\u5F0F"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		studentInfoTable.getColumnModel().getColumn(0).setResizable(false);
		studentInfoTable.getColumnModel().getColumn(1).setResizable(false);
		studentInfoTable.getColumnModel().getColumn(2).setResizable(false);
		studentInfoTable.getColumnModel().getColumn(3).setResizable(false);
		studentInfoTable.getColumnModel().getColumn(4).setResizable(false);
		studentInfoTable.getColumnModel().getColumn(5).setResizable(false);
		studentInfoTable.getColumnModel().getColumn(6).setResizable(false);
		scrollPane.setViewportView(studentInfoTable);
		getContentPane().setLayout(groupLayout);

	}
	/*
	 * 打印功能
	 */
	public void printActionPerformed(ActionEvent e) {
		try {
			studentInfoTable.print();
		} catch (PrinterException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	/*
	 * 通过学号查询记录
	 */
	public void queryByStuNumActionPerformed(ActionEvent e) {
		String stuNum = this.stuNumText.getText();
		DefaultTableModel dtm = (DefaultTableModel)studentInfoTable.getModel();  
		if(stuNum.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入学号");
			dtm.setRowCount(0); //使table数据清空
		}else {
			StudentInfo studentInfo = studentInfoDao.queryByStuNum(stuNum);  
			if(studentInfo==null) {
				JOptionPane.showMessageDialog(null, "不存在该学号");
				dtm.setRowCount(0); //使table数据清空
			}else {
				students = new ArrayList<StudentInfo>();
				students.add(studentInfo);
				this.fillTable(students);
			}
		}
	}

	/*
	 * 显示全部记录
	 */
	public void displayAllActionPerformed(ActionEvent e) {
		 students = studentInfoDao.querryStudentInfo();
		this.fillTable(students);
		
	}
	
	public void fillTable(List<StudentInfo> students) {
		DefaultTableModel dtm = (DefaultTableModel)studentInfoTable.getModel();
		dtm.setRowCount(0); //设置成0行
		
		//实现排序功能,调用了swing的API,需要将RowSorter与JTable进行关联,而关联的桥梁便是TableModel
				//RowSorter是抽象类.需要其子类实例化啊对象
				RowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(dtm);
				studentInfoTable.setRowSorter(sorter);
				
		for(StudentInfo studentInfo : students) {
			Vector<String> currentRow = new Vector<String>();  //将vector定义到for循环里,这样每次循环都重新实例化集合,防止tableModel只装入了第一条记录
			currentRow.addElement(studentInfo.getStuNum());
			currentRow.addElement(studentInfo.getName());
			currentRow.addElement(studentInfo.getSex());
			currentRow.addElement(studentInfo.getAge() + "");
			currentRow.addElement(studentInfo.get_Class());
			currentRow.addElement(studentInfo.getAcademy()); 
			currentRow.addElement(studentInfo.getTelephone());
			dtm.addRow(currentRow);
		}
	}
}
