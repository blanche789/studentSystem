package com.blanche.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blanche.model.StudentInfo;
import com.blanche.util.JDBCUtil;

public class StudentInfoDao {
	private Connection con = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	private StudentInfo studentInfo;
	
	/*
	 * ����ѧ����Ϣ
	 * ������StudentInfo����
	 * ����ֵresult��֮�ĳɹ���sql�������
	 */
	public int addInfo(StudentInfo studentInfo) {
		int result=0;
		try {
			con = JDBCUtil.getConnection();
			String sql = "insert into student_info values(null,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, studentInfo.getStuNum());
			ps.setString(2, studentInfo.getName());
			ps.setString(3, studentInfo.getSex());
			ps.setInt(4, studentInfo.getAge());
			ps.setString(5, studentInfo.get_Class());
			ps.setString(6, studentInfo.getAcademy());
			ps.setString(7, studentInfo.getTelephone());
			result = ps.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println("��Ϣ���ʧ��");
		}finally {
			JDBCUtil.clear(con, ps, rs);
		}
		
		return result;
	}
	/*
	 * ͨ���༶ɾ����Ϣ
	 * ������ѧ��ѧ��
	 * ����ֵ��result��ִ��ɾ��������
	 */
	public int deleteInfoByStuNum(String stuNum) {
		int result=0;
		try {
			con = JDBCUtil.getConnection();
			String sql = "delete from student_info where stu_num = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1,stuNum);
			result = ps.executeUpdate();  //ִ�и��²�����ɾ��ѧ����¼
			
		
		} catch (SQLException e) {
			System.out.println("��Ϣɾ��ʧ��");
		}finally {
			JDBCUtil.clear(con, ps, rs);
		}
		
		return result;
	}
	/*
	 * ͨ��ѧ�Ų�ѯѧ����Ϣ
	 * ����StudentInfoʵ������
	 */
	public StudentInfo queryByStuNum(String StuNum) {
		studentInfo = null;
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from student_info where stu_num = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, StuNum);
			rs = ps.executeQuery();
			while(rs.next()) {
				 studentInfo = new StudentInfo();
				studentInfo.setStuNum(rs.getString("stu_num"));
				studentInfo.setName(rs.getString("name"));
				studentInfo.setSex(rs.getString("sex"));
				studentInfo.setAge(rs.getInt("age"));
				studentInfo.setClass(rs.getString("class"));
				studentInfo.setAcademy(rs.getString("academy"));
				studentInfo.setTelephone(rs.getString("telephone"));
				studentInfo.setId(rs.getInt("id"));
				}
		} catch (SQLException e) {
			System.out.println("���ݲ�ѯʧ��");
		}finally {
			JDBCUtil.clear(con, ps, rs);
		}
		return this.studentInfo;
	}
	
	/*
	 * ͨ��������ѯѧ����Ϣ
	 * ����StudentInfoʵ������
	 */
	public List<StudentInfo> queryByName(String name) {
		List<StudentInfo> students = null;
		
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from student_info where name = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if(rs != null) {
				students = new ArrayList<StudentInfo>();
				while(rs.next()) {
					 studentInfo = new StudentInfo();
					 
					studentInfo.setStuNum(rs.getString("stu_num"));
					studentInfo.setName(rs.getString("name"));
					studentInfo.setSex(rs.getString("sex"));
					studentInfo.setAge(rs.getInt("age"));
					studentInfo.setClass(rs.getString("class"));
					studentInfo.setAcademy(rs.getString("academy"));
					studentInfo.setTelephone(rs.getString("telephone"));
					studentInfo.setId(rs.getInt("id"));
					students.add(studentInfo);
					}
			}
			
		} catch (SQLException e) {
			System.out.println("���ݲ�ѯʧ��");
		}finally {
			JDBCUtil.clear(con, ps, rs);
		}
		return students;
	}
	
	/*
	 * ͨ���༶��ѯѧ����Ϣ
	 * ����,�༶String
	 * ����List<StudentInfo>,��ͬһ���༶��ȫ����Ϣ����
	 */
	public List<StudentInfo> queryByClass(String _class) {  
		List<StudentInfo> students = null;
		
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from student_info where class = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, _class);
			rs = ps.executeQuery();
			if(rs != null) {
				students = new ArrayList<StudentInfo>();
				while(rs.next()) {
					 studentInfo = new StudentInfo();
				
					studentInfo.setStuNum(rs.getString("stu_num"));
					studentInfo.setName(rs.getString("name"));
					studentInfo.setSex(rs.getString("sex"));
					studentInfo.setAge(rs.getInt("age"));
					studentInfo.setClass(rs.getString("class"));
					studentInfo.setAcademy(rs.getString("academy"));
					studentInfo.setTelephone(rs.getString("telephone"));
					studentInfo.setId(rs.getInt("id"));
					students.add(studentInfo);
					}
			}
		} catch (SQLException e) {
			System.out.println("���ݲ�ѯʧ��");
		}finally {
			JDBCUtil.clear(con, ps, rs);
		}
		return students;
	}
	
	/*
	 * ͨ��ѧԺ��ѯ��Ϣ
	 * ����,ѧԺString
	 * ����List<StudentInfo>,��ͬһ��ѧԺ��ȫ����Ϣ����
	 */
	public List<StudentInfo> queryByAcademy(String academy) {
		List<StudentInfo> students = null;  //Ϊ�˷�ӳ�����л�ȡ���ַ��������ݿ��в�ѯ����������null
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from student_info where academy = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, academy);
			rs = ps.executeQuery();
			if(rs != null) {
				students = new ArrayList<StudentInfo>();
				while(rs.next()) {
					 studentInfo = new StudentInfo();
					 
					studentInfo.setStuNum(rs.getString("stu_num"));
					studentInfo.setName(rs.getString("name"));
					studentInfo.setSex(rs.getString("sex"));
					studentInfo.setAge(rs.getInt("age"));
					studentInfo.setClass(rs.getString("class"));
					studentInfo.setAcademy(rs.getString("academy"));
					studentInfo.setTelephone(rs.getString("telephone"));
					studentInfo.setId(rs.getInt("id"));
					students.add(studentInfo);
					}
			}
		} catch (SQLException e) {
			System.out.println("���ݲ�ѯʧ��");
		}finally {
			JDBCUtil.clear(con, ps, rs);
		}
		return students;
		
	}
	
	/*
	 * ͨ���༶��ѯѧ����Ϣ
	 * ����,�༶String
	 * ����List<StudentInfo>,��ͬһ���༶��ȫ����Ϣ����
	 */
	public List<StudentInfo> queryBySex(String sex) {  
		List<StudentInfo> students = null;
		
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from student_info where sex = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, sex);
			rs = ps.executeQuery();
			if(rs != null) {
				students = new ArrayList<StudentInfo>();
				while(rs.next()) {
					 studentInfo = new StudentInfo();
				
					studentInfo.setStuNum(rs.getString("stu_num"));
					studentInfo.setName(rs.getString("name"));
					studentInfo.setSex(rs.getString("sex"));
					studentInfo.setAge(rs.getInt("age"));
					studentInfo.setClass(rs.getString("class"));
					studentInfo.setAcademy(rs.getString("academy"));
					studentInfo.setTelephone(rs.getString("telephone"));
					studentInfo.setId(rs.getInt("id"));
					students.add(studentInfo);
					}
			}
		} catch (SQLException e) {
			System.out.println("���ݲ�ѯʧ��");
		}finally {
			JDBCUtil.clear(con, ps, rs);
		}
		return students;
	}
	
	/*
	 * ����ѧ����Ϣ
	 * ����Ϊ��������StudentInfoʵ������
	 */
	public int updateInfo(StudentInfo studentInfo) {
		int result=0;
		try {
			con = JDBCUtil.getConnection();
			String sql = "update student_info set stu_num=?,name=?,sex=?,age=?,class=?,academy=?,telephone=? where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, studentInfo.getStuNum());
			ps.setString(2, studentInfo.getName());
			ps.setString(3, studentInfo.getSex());
			ps.setInt(4, studentInfo.getAge());
			ps.setString(5, studentInfo.get_Class());
			ps.setString(6, studentInfo.getAcademy());
			ps.setString(7, studentInfo.getTelephone());
			ps.setInt(8, studentInfo.getId());
			result = ps.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println("��Ϣ����ʧ��");
		}finally {
			JDBCUtil.clear(con, ps, rs);
		}
		
		return result;
	}
	
	/*
	 * �����е�ѧ����Ϣ�洢��List��
	 */
	public List<StudentInfo> querryStudentInfo(){
		List<StudentInfo> students = new ArrayList<StudentInfo>(); 
		
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from student_info";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				 studentInfo = new StudentInfo();
				studentInfo.setStuNum(rs.getString("stu_num"));
				studentInfo.setName(rs.getString("name"));
				studentInfo.setSex(rs.getString("sex"));
				studentInfo.setAge(rs.getInt("age"));
				studentInfo.setClass(rs.getString("class"));
				studentInfo.setAcademy(rs.getString("academy"));
				studentInfo.setTelephone(rs.getString("telephone"));
				studentInfo.setId(rs.getInt("id"));
				students.add(studentInfo);
				}
		} catch (SQLException e) {
			System.out.println("���ݲ�ѯʧ��");
		}finally {
			JDBCUtil.clear(con, ps, rs);
		}
		
		return students;
	}
	/*
	 * ��ѯѧ���Ƿ����
	 */
	public boolean  judgeExist(String stuNum) {
		boolean result=false;
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from student_info where stu_num=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, stuNum);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = true;
				}
		} catch (SQLException e) {
			System.out.println("���ݲ�ѯʧ��");
		}finally {
			JDBCUtil.clear(con, ps, rs);
		}
		return result;
	}
	public StudentInfo queryById(int id) {
		 studentInfo = new StudentInfo();
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from student_info where id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				studentInfo.setStuNum(rs.getString("stu_num"));
				studentInfo.setName(rs.getString("name"));
				studentInfo.setSex(rs.getString("sex"));
				studentInfo.setAge(rs.getInt("age"));
				studentInfo.setClass(rs.getString("class"));
				studentInfo.setAcademy(rs.getString("academy"));
				studentInfo.setTelephone(rs.getString("telephone"));
				}
			
		} catch (SQLException e) {
			System.out.println("���ݲ�ѯʧ��");
		}finally {
			JDBCUtil.clear(con, ps, rs);
		}
		return studentInfo;
	}
	public static void main(String[] args) {
		List<StudentInfo> students = new ArrayList<StudentInfo>();
		StudentInfo studentInfo = new StudentInfo();
		StudentInfoDao studentInfoDao = new StudentInfoDao();
		students = studentInfoDao.querryStudentInfo();
		System.out.println(students.get(3).getName());
		studentInfo = students.get(0);
		studentInfo.setAge(10);
		studentInfoDao.updateInfo(studentInfo);
		System.out.println(studentInfo.getId());
		studentInfoDao.queryByStuNum("3117004669");
		
	}

}
