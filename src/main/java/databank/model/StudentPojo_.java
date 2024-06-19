package databank.model;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2024-06-12T18:12:42.210-0400")
@StaticMetamodel(StudentPojo.class)
public class StudentPojo_ {
	public static volatile SingularAttribute<StudentPojo, Integer> id;
	public static volatile SingularAttribute<StudentPojo, String> lastName;
	public static volatile SingularAttribute<StudentPojo, String> firstName;
	public static volatile SingularAttribute<StudentPojo, String> email;
	public static volatile SingularAttribute<StudentPojo, String> phoneNumber;
	public static volatile SingularAttribute<StudentPojo, String> program;
	public static volatile SingularAttribute<StudentPojo, LocalDateTime> created;
	public static volatile SingularAttribute<StudentPojo, LocalDateTime> updated;
	public static volatile SingularAttribute<StudentPojo, Integer> version;
}
