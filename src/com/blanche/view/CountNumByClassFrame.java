package com.blanche.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.blanche.dao.StudentInfoDao;
import com.blanche.model.StudentInfo;

public class CountNumByClassFrame extends JInternalFrame {
	private JTable numOfPeopleTable;
	private int manNum;
	private int womenNum;
	private StudentInfoDao studentInfoDao = new StudentInfoDao();
//	private StudentInfo studentInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CountNumByClassFrame frame = new CountNumByClassFrame();
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
	public CountNumByClassFrame() {
		setClosable(true);
		setIconifiable(true);
		setResizable(true);
		setTitle("\u6309\u73ED\u7EA7\u7EDF\u8BA1\u5B66\u751F\u4EBA\u6570");
		setBounds(650, 300, 450, 300);
		
		JScrollPane scrollPane = new JScrollPane();
		//���ñ���߽�
		TitledBorder tb = new TitledBorder("��ѯ���");
		//�ڿɹ��������ӱ���߽�
		scrollPane.setBorder(tb);
		
		JButton button = new JButton("\u6253\u5370");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printActionPerformed(e);
			}
		});
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result;
				result = JOptionPane.showConfirmDialog(null, "�Ƿ��˳�");
				if(result==0) {
					dispose();
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_1)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		numOfPeopleTable = new JTable();
		numOfPeopleTable.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		numOfPeopleTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"�༶", "\u4EBA\u6570"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		numOfPeopleTable.getColumnModel().getColumn(0).setResizable(false);
		numOfPeopleTable.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(numOfPeopleTable);
		getContentPane().setLayout(groupLayout);
		
	}
	/*
	 * ��ӡ������
	 */
	public void printActionPerformed(ActionEvent e) {
		try {
			numOfPeopleTable.print();
		} catch (PrinterException e1) {
			e1.printStackTrace();
		}
		
	}

	/*
	 * ��ʾ������
	 */
	public void displayNumOfPeopleTable(){
		List<StudentInfo> students = studentInfoDao.querryStudentInfo();
		fillTable(students);
	}
	
	/*
	 * ����Ա�������
	 * ����,List<StudentInfo>
	 */
	public void fillTable(List<StudentInfo> students) {
		DefaultTableModel dtm = (DefaultTableModel)numOfPeopleTable.getModel();  //��ȡTable��model�����������
		dtm.setRowCount(0);  
		
		//ʵ��������,������swing��API,��Ҫ��RowSorter��JTable���й���,����������������TableModel
		//RowSorter�ǳ�����.��Ҫ������ʵ����������
		RowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(dtm);
		numOfPeopleTable.setRowSorter(sorter);
		
		Set<String> mySet = new HashSet();
		for(StudentInfo studentInfo : students) {
				mySet.add(studentInfo.get_Class());
		}
		
		Iterator<String> it = mySet.iterator();  //������
		
		for(int i=0;i<mySet.size();i++) {
			Vector<String> currentRow = new Vector<String>();
			String str = it.next();
			currentRow.addElement(str);
			currentRow.addElement(studentInfoDao.queryByClass(str).size() + "");
			dtm.addRow(currentRow);
		}
	

	}
}
