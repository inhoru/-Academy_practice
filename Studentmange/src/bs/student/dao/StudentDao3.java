package bs.student.dao;

import java.util.ArrayList;

import bs.student.dto.Student;

public class StudentDao3 {
	private static StudentDao2 dao;
	private ArrayList list = new ArrayList();
	
	public StudentDao3() {
		
	}
	public boolean insertStudent(Student s) {
		boolean duplicateResult = false;
		for(int  i =0;i<list.size();i++) {
			if(list.get(i)!=null&&list.get(i).equals(s)) {
				duplicateResult = true;
				break;
			}
		}if(!duplicateResult) {
			int i =0;
			while(true) {
					if(list.get(i)==null) {
						list.add(s);
						return true;
					
					
				}
					i++;
			}
			
			
		}
		return false;
				
							
			
			
		
		
		
	}
}

