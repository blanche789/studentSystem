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

public class EditStudentInfoFrame extends JInternalFrame {
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
	private int currentRow;		//��ǰ��¼����
	private int id;
	private int tag;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditStudentInfoFrame frame = new EditStudentInfoFrame();
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
	public EditStudentInfoFrame() {
		setTitle("\u6D4F\u89C8\u8BB0\u5F55");
		setIconifiable(true);
		setClosable(true);
		getContentPane().setBackground(Color.WHITE);
		setBounds(550, 300, 703, 398);
		
		JLabel label = new JLabel("\u5B66\u53F7\uFF1A");
		label.setIcon(new ImageIcon(EditStudentInfoFrame.class.getResource("/images/icon7 .png")));
		label.setFont(new Font("΢���ź�", Font.PLAIN, 21));
		
		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setIcon(new ImageIcon(EditStudentInfoFrame.class.getResource("/images/icon.png")));
		label_1.setFont(new Font("΢���ź�", Font.PLAIN, 21));
		
		JLabel label_2 = new JLabel("\u6027\u522B\uFF1A");
		label_2.setIcon(new ImageIcon(EditStudentInfoFrame.class.getResource("/images/icon9.png")));
		label_2.setFont(new Font("΢���ź�", Font.PLAIN, 21));
		
		JLabel label_3 = new JLabel("\u5E74\u9F84\uFF1A");
		label_3.setIcon(new ImageIcon(EditStudentInfoFrame.class.getResource("/images/icon13.png")));
		label_3.setFont(new Font("΢���ź�", Font.PLAIN, 21));
		
		JLabel label_4 = new JLabel("\u5B66\u9662\uFF1A");
		label_4.setIcon(new ImageIcon(EditStudentInfoFrame.class.getResource("/images/icon10.png")));
		label_4.setFont(new Font("΢���ź�", Font.PLAIN, 21));
		
		JLabel label_5 = new JLabel("\u73ED\u7EA7\uFF1A");
		label_5.setIcon(new ImageIcon(EditStudentInfoFrame.class.getResource("/images/icon11.png")));
		label_5.setFont(new Font("΢���ź�", Font.PLAIN, 21));
		
		JLabel label_6 = new JLabel("\u7535\u8BDD\uFF1A");
		label_6.setIcon(new ImageIcon(EditStudentInfoFrame.class.getResource("/images/icon12.png")));
		label_6.setFont(new Font("΢���ź�", Font.PLAIN, 21));
		
		stuNum = new JTextField();
		stuNum.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		stuNum.setColumns(10);
		
		name = new JTextField();
		name.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		name.setColumns(10);
		
		sex = new JTextField();
		sex.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		sex.setColumns(10);
		
		age = new JTextField();
		age.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		age.setColumns(10);
		
		academy = new JTextField();
		academy.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		academy.setColumns(10);
		
		_class = new JTextField();
		_class.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		_class.setColumns(10);
		
		telephone = new JTextField();
		telephone.setFont(new Font("΢���ź�", Font.PLAIN, 16));
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
		
		JButton btnNewButton_4 = new JButton("\u7F16\u8F91");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editAcitonPerformed(e);
			}
		});
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmEditActionPerformed(e);
			}
		});
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(18)
							.addComponent(btnNewButton_1)
							.addGap(18)
							.addComponent(btnNewButton_2)
							.addGap(18)
							.addComponent(btnNewButton_3)
							.addGap(102))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton_4)
							.addGap(33)
							.addComponent(button)
							.addGap(26)
							.addComponent(button_1)
							.addGap(176))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(telephone, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(_class, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(academy, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(age, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(sex, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(name, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(stuNum, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE)))
							.addGap(23)))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(stuNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(btnNewButton_4)
						.addComponent(button_1))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
	/*
	 * ȡ����ť��ͨ��id����ԭ�������ݣ�ʹ����������û�ԭ��������
	 */
	public void cancelActionPerformed(ActionEvent e) {
		this.stuNum.setText(studentInfoDao.queryById(id).getStuNum());
		this.name.setText(studentInfoDao.queryById(id).getName());
		this.sex.setText(studentInfoDao.queryById(id).getSex());
		
		if(studentInfoDao.queryById(id).getAge()!=0) {  //�����û���û������ݵ�ʱ��,���ȡ����ť,��������û�������ݿ���ҵ�������0,�Ӷ�������Ϊ0��bug
		this.age.setText(Integer.toString(studentInfoDao.queryById(id).getAge()));
		}
		this.academy.setText(studentInfoDao.queryById(id).getAcademy());
		this._class.setText(studentInfoDao.queryById(id).get_Class());
		this.telephone.setText(studentInfoDao.queryById(id).getTelephone());
		
	}
	
	/*
	 * ȷ����ť
	 */
	public void confirmEditActionPerformed(ActionEvent e) {
		if(tag!=1) {
			JOptionPane.showMessageDialog(null, "�����༭״̬");
			return ;  //��ʾ֮�󣬽��������������������ִ�н������Ĵ��룬��studentInfo��ָ����쳣
		}else if(studentInfo==null) {
			JOptionPane.showMessageDialog(null, "�����������");  //�����û���δ�����¼ֱ�ӵ��ȷ����ť�����ֿ�ָ��bug����Ϊ���ʱ��ȫ�ֱ���studentInfo��δ�������
			return ;
		}
		int result=0;
		studentInfo.setStuNum(this.stuNum.getText()); 
		studentInfo.setName(this.name.getText());
		studentInfo.setSex(this.sex.getText());
		studentInfo.setAcademy(this.academy.getText());
		studentInfo.setAge(Integer.parseInt(this.age.getText()));
		studentInfo.setClass(this._class.getText());
		studentInfo.setTelephone(this.telephone.getText());
		studentInfo.setId(id);
		
		if(!studentInfoDao.queryById(id).getStuNum().equals(this.stuNum.getText())) {	
			if(studentInfoDao.judgeExist(this.stuNum.getText())) {
				tag++;
				String origStuNum = studentInfoDao.queryById(id).getStuNum();  //����һ���ַ����ݴ�ԭ����ѧ��
				JOptionPane.showMessageDialog(null, "ѧ���Ѵ���");
				this.stuNum.setText(origStuNum);
				return ;
				}
		}
		else if(studentInfo.getStuNum().equals("")) {
			
			JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ��");
			String origStuNum = studentInfoDao.queryById(id).getStuNum();
			this.stuNum.setText(origStuNum);
			return ;
		}else if(studentInfo.getStuNum().length()!=10) {
			String origStuNum = studentInfoDao.queryById(id).getStuNum(); 
			JOptionPane.showMessageDialog(null, "ѧ�ų���Ϊ10λ");
			this.stuNum.setText(origStuNum);
			
			return ;
		}else if(!studentInfo.getStuNum().matches("311[0-9]+")) {
			String origStuNum = studentInfoDao.queryById(id).getStuNum();
			JOptionPane.showMessageDialog(null, "ѧ�����ʹ���"); 
			this.stuNum.setText(origStuNum);
			return;
		}else if(studentInfo.getName().equals("")) {
				String origName = studentInfoDao.queryById(id).getName(); 
				JOptionPane.showMessageDialog(null, "��������Ϊ��");
				this.name.setText(origName);
				return ;
			}else if(studentInfo.getSex().equals("")) {
				String origSex = studentInfoDao.queryById(id).getSex(); 
				JOptionPane.showMessageDialog(null, "�Ա���Ϊ��");
				this.sex.setText(origSex);
				return ;
			}else if(!studentInfo.getSex().matches("��||Ů")) {
				String origSex = studentInfoDao.queryById(id).getSex(); 
				JOptionPane.showMessageDialog(null, "�Ա����ʹ���");
				this.sex.setText(origSex);
				return;
			}else if(studentInfo.getAcademy().equals("")) {
				String origAcademy = studentInfoDao.queryById(id).getAcademy(); 
				JOptionPane.showMessageDialog(null, "ѧԺ����Ϊ��");
				this.academy.setText(origAcademy);
				return ;
			}else if(studentInfo.get_Class().equals("")) {
				String origClass = studentInfoDao.queryById(id).get_Class(); 
				JOptionPane.showMessageDialog(null, "�༶����Ϊ��");
				this._class.setText(origClass);
				return ;
			}else if(studentInfo.getTelephone().equals("")) {
				String origPhone= studentInfoDao.queryById(id).getTelephone(); 
				JOptionPane.showMessageDialog(null, "�ֻ��Ų���Ϊ��");
				this.telephone.setText(origPhone);
				return ;
			}else if(studentInfo.getTelephone().length() != 11) {
				String origPhone= studentInfoDao.queryById(id).getTelephone(); 
			JOptionPane.showMessageDialog(null, "�ֻ��ű���Ϊ11λ");
			this.telephone.setText(origPhone);
			return;
		}
		else if(!studentInfo.getTelephone().matches("^(1[38]\\d{9}|15[012356789]\\d{8}|14[57]\\d{8}|17[678]\\d{8})$")) {
			String origPhone= studentInfoDao.queryById(id).getTelephone(); 
			JOptionPane.showMessageDialog(null, "�ֻ������ʹ���");
			this.telephone.setText(origPhone);
			return;
		}
		result = studentInfoDao.updateInfo(studentInfo);
		 if(result != 0) {
			JOptionPane.showMessageDialog(null, "��Ϣ���³ɹ�");
		}else {
			JOptionPane.showMessageDialog(null, "��Ϣ����ʧ��");
		}
		
	}
	
	/*
	 * �༭��ť
	 */
	public void editAcitonPerformed(ActionEvent e) {
		tag=1;
		this.stuNum.setEditable(true);
		this.name.setEditable(true);
		this.sex.setEditable(true);
		this.age.setEditable(true);
		this.academy.setEditable(true);
		this._class.setEditable(true);
		this.telephone.setEditable(true);
		
	}

	/*
	 * ��һ����ť
	 * ��ȡ��һ����¼
	 */
	public void getNextStudentInfoActionPerformed(ActionEvent e) {
		if(currentRow < students.size()) {
			tag=0;
			currentRow++;
			studentInfo = students.get(currentRow-1);
			id = studentInfo.getId();
			fillFrameData(currentRow,studentInfo);
		}else {
			JOptionPane.showMessageDialog(null, "�ѵ����һ����¼");
		}
		
	}
	/*
	 * ��һ����ť
	 * ��ȡ��һ����¼
	 */
	public void getLastStudentInfoActionPerformed(ActionEvent e) {
		if(currentRow > 1) {
			tag=0;
			currentRow--;
			studentInfo = students.get(currentRow-1);
			id = studentInfo.getId();  //��ȡ�����ǰ��¼������id���Ա��ڱ༭��ʱ������������id��ѯ��ԭ������Ϣ����༭����Ϣ���Ƚ�
			fillFrameData(currentRow,studentInfo);
		}else {
			JOptionPane.showMessageDialog(null, "�ѵ���һ����¼");
		}
		
	}
	/*
	 * ���һ����ť
	 * ��ȡ���һ����¼
	 */
	public void getEndStudentInfoActionPerformed(ActionEvent e) {
		tag=0;
		studentInfo = students.get(students.size()-1);
		id = studentInfo.getId(); //��ȡ�����ǰ��¼������id���Ա��ڱ༭��ʱ������������id��ѯ��ԭ������Ϣ����༭����Ϣ���Ƚ�
		currentRow = students.size();
		fillFrameData(currentRow,studentInfo);
		
		
	}
	/*
	 * ��һ����ť
	 * ��ȡ��һ����¼
	 */
	public void getFirstInfoActionPerformed(ActionEvent e) {
		tag=0;
		studentInfo = students.get(0);
		id = studentInfo.getId(); //��ȡ�����ǰ��¼������id���Ա��ڱ༭��ʱ������������id��ѯ��ԭ������Ϣ����༭����Ϣ���Ƚ�
		currentRow = 1;
		fillFrameData(currentRow,studentInfo);
		
		}
	/*
	 * ���༭���ڵ�Data
	 */
	public void fillFrameData(int currentRow,StudentInfo studentInfo) {
		this.currentRow = currentRow;
		this.setTitle("���ѧ�����¼" + "&& ��ǰ��¼" + currentRow);
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
