package issue;

import static org.junit.Assert.*;

import java.util.List;

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
	public void getUserRoleListWithResultAnnotation() throws Exception
	{
		List<Role> roles = dao.getUserRoleListWithResultAnnotation("TEST");
		assertEquals(1, roles.size());
		assertEquals(Role.USER, roles.get(0));
	}

	@Test
	public void getUserRolesWithResultMapAnnotation() throws Exception
	{
		Role[] roles = dao.getUserRolesWithResultMapAnnotationAndXml("TEST");
		assertEquals(1, roles.length);
		assertEquals(Role.USER, roles[0]);
	}

}
