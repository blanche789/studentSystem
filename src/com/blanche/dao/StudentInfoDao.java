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
	 * 增加学生信息
	 * 参数，StudentInfo对象
	 * 返回值result，之心成功的sql语句条数
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
			System.out.println("信息添加失败");
		}finally {
			JDBCUtil.clear(con, ps, rs);
		}
		
		return result;
	}
	/*
	 * 通过班级删除信息
	 * 参数，学生学号
	 * 返回值，result，执行删除的条数
	 */
	public int deleteInfoByStuNum(String stuNum) {
		int result=0;
		try {
			con = JDBCUtil.getConnection();
			String sql = "delete from student_info where stu_num = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1,stuNum);
			result = ps.executeUpdate();  //执行更新操作，删除学生记录
			
		
		} catch (SQLException e) {
			System.out.println("信息删除失败");
		}finally {
			JDBCUtil.clear(con, ps, rs);
		}
		
		return result;
	}
	/*
	 * 通过学号查询学生信息
	 * 返回StudentInfo实例对象
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
			System.out.println("数据查询失败");
		}finally {
			JDBCUtil.clear(con, ps, rs);
		}
		return this.studentInfo;
	}
	
	/*
	 * 通过姓名查询学生信息
	 * 返回StudentInfo实例对象
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
			System.out.println("数据查询失败");
		}finally {
			JDBCUtil.clear(con, ps, rs);
		}
		return students;
	}
	
	/*
	 * 通过班级查询学生信息
	 * 参数,班级String
	 * 返回List<StudentInfo>,将同一个班级的全部信息返回
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
			System.out.println("数据查询失败");
		}finally {
			JDBCUtil.clear(con, ps, rs);
		}
		return students;
	}
	
	/*
	 * 通过学院查询信息
	 * 参数,学院String
	 * 返回List<StudentInfo>,将同一个学院的全部信息返回
	 */
	public List<StudentInfo> queryByAcademy(String academy) {
		List<StudentInfo> students = null;  //为了反映界面中获取的字符串在数据库中查询不到，返回null
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
			System.out.println("数据查询失败");
		}finally {
			JDBCUtil.clear(con, ps, rs);
		}
		return students;
		
	}
	
	/*
	 * 通过班级查询学生信息
	 * 参数,班级String
	 * 返回List<StudentInfo>,将同一个班级的全部信息返回
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
			System.out.println("数据查询失败");
		}finally {
			JDBCUtil.clear(con, ps, rs);
		}
		return students;
	}
	
	/*
	 * 更新学生信息
	 * 参数为传进来的StudentInfo实例对象
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
			System.out.println("信息更新失败");
		}finally {
			JDBCUtil.clear(con, ps, rs);
		}
		
		return result;
	}
	
	/*
	 * 将所有的学生信息存储到List中
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
			System.out.println("数据查询失败");
		}finally {
			JDBCUtil.clear(con, ps, rs);
		}
		
		return students;
	}
	/*
	 * 查询学号是否存在
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
			System.out.println("数据查询失败");
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
			System.out.println("数据查询失败");
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
