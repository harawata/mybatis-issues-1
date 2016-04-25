package issue;

import static org.junit.Assert.*;

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
	public void getUserRolesWithResultAnnotation() throws Exception
	{
		Role[] roles = dao.getUserRolesWithResultAnnotation("TEST");
		assertEquals(1, roles.length);
		assertEquals(Role.USER, roles[0]);
	}

	@Test
	public void getUserRolesWithResultMapAnnotation() throws Exception
	{
		Role[] roles = dao.getUserRolesWithResultMapAnnotationAndXml("TEST");
		assertEquals(1, roles.length);
		assertEquals(Role.USER, roles[0]);
	}

}
