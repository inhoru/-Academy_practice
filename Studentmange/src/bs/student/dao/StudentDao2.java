package bs.student.dao;

import java.util.Arrays;

import bs.student.common.StudentFilter;
import bs.student.dto.Student;

public class StudentDao2 {
	// 배열을 이용한 dao

	private static StudentDao2 dao;
	private Student[] students = new Student[5];

	private StudentDao2() {
	}

	public static StudentDao2 getStudentDao() {
		if (dao == null)
			dao = new StudentDao2();
		return dao;

	}

	// 학생등록
	public boolean insertStudent(Student s) {
		// boolean result = false;
	
try {
	
	for (int i = 0; i < students.length; i++) {
		if (students[i] == null) {
			students[i] = s;
			return true; // 리턴을 받으면 바로 호출한곳으로 돌아간다 반복문이끝남
			// result =true;
			// break;
		}
	}
	return false;
 }catch (ArrayIndexOutOfBoundsException a) {
	 int[] temp = new int [students.length + 5] {
			 System.arraycopy(students, 0, s, 0, 0);
	 }
	 Arrays.copyOf(null, 0)
 }
		

	}

	// 학생조회
	public Student[] infoStudentAll() {
		// String info = "";
		Student[] searchStudent;// 데이터자체로 보내줄수있다.
		int searchdata = 0;
		for (Student s : students) {
			if (s != null)
				if (s != null)
					searchdata++;
			// info += s.infoStudent() + "\n";
		}
		searchStudent = new Student[searchdata];
		int index = 0;
		for (Student s : students) {
			if (s != null)
				searchStudent[index++] = s;
		}
		return searchStudent;
	}

	// 이름으로찾기
	// 풀네임말고 몇글자로 찾을수있도록만들기
	public String searchByName(String name) {
		String result = "";
		for (Student s : students) {
			if (s != null && s.getName().contains(name)){
				result += s.infoStudent() + "\n";

			}
		}
		return result;
	}

	// 학생수정
	public boolean updateStudent(Student s) {
		for (Student saveStudent : students) {
			if (saveStudent != null && saveStudent.getStudentNo().equals(s.getStudentNo())) {
				saveStudent.setGrade(s.getGrade());
				saveStudent.setAddress(s.getAddress());
				saveStudent.setMajor(s.getMajor());
				return true;

			}
		}
		return false;
	}
	
	//항목별 학생조회
	public Student[] searchStudent(Object data, StudentFilter sf) {
		Student[] resultStudent = new Student[students.length];
		int index= 0;
		for(int i = 0;i<students.length;i++) {
			if(students[i]!=null
					&&sf.check(students[i], data)) {
				resultStudent[index++]=students[i];
			}
		}
		Student[] temp = new Student[index];
		System.arraycopy(resultStudent, 0, temp, 0, index);
		resultStudent = temp;
		return resultStudent;
		
	}
	

}
