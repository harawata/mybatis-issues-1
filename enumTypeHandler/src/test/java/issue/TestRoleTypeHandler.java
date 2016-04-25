package issue;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = { "classpath:applicationContext.xml" })
public class TestRoleTypeHandler {

	@Autowired
	RoleDao dao;

	@Test
	public void getUserRolesWithResultAnnotation() {
		try {
			Role[] roles = dao.getUserRolesWithResultAnnotation("TEST");
			assert (roles.length == 3);
			System.out.println("Roles found with ResultMapAnnotation: " + Arrays.toString(roles));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getUserRolesWithResultMapAnnotation() {
		try {
			Role[] roles = dao.getUserRolesWithResultMapAnnotationAndXml("TEST");
			assert (roles.length == 3);
			System.out.println("Roles found with ResultAnnotation: " + Arrays.toString(roles));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
