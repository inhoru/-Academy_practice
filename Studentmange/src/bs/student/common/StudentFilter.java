package bs.student.common;

import bs.student.dto.Student;
//
@FunctionalInterface
public interface StudentFilter {
	boolean check(Student s ,Object data);
}
