import java.util.List;
import java.util.Map;
import java.util.jar.Attributes.Name;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import cn.liuchan.Dao.IStudentDao;
import cn.liuchan.Dao.IStudentDaoImpl;
import cn.liuchan.Do.Student;

public class MyTest {
	private IStudentDao studentDao;

	@Before
	public void before() {
		studentDao = new IStudentDaoImpl();
	}

	@After
	public void after() {

	}

	@Test
	public void test01() {
		Student student = new Student("梨花", 12, 99.3);
		System.out.println("插入数据前" + student);
		studentDao.insertStudent(student);
		System.out.println("插入数据后" + student);
	}

	@Test
	public void test02() {
		Student student = new Student("梨花", 12, 99.3);
		System.out.println("插入数据前" + student);
		studentDao.insertStudentCacheId(student);
		System.out.println("插入数据后" + student);
	}

	@Test
	public void test03() {
		studentDao.deleteStudentById(19);
	}

	@Test
	public void test04() {
		Student student = new Student("白芷", 10, 100);
		student.setId(21);
		studentDao.updateStudentById(student);
	}

	/* 查询所有 */
	@Test
	public void test05() {
		List<Student> students = studentDao.selectAllStudents();
		for (Student student : students) {
			System.out.println(student);
		}
	}

	@Test
	public void test06() {
		Map<String, Object> map = studentDao.selectAllStudentsMap();
		System.out.println(map.get("梨花"));
	}

	@Test
	public void test07() {
		Student student = studentDao.selectStudentById(53);
		System.out.println(student);
	}
	@Test
	public void test08() {
		List<Student> students = studentDao.selectStudentsByName("花");
		for(Student student:students)
		System.out.println(student);
	}
}
