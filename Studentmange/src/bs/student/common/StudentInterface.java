package bs.student.common;

import bs.student.dto.Student;

@FunctionalInterface
public interface StudentInterface {
	boolean check(Student s ,Object data);
}
