package issue;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface RoleDao {

	@Select("SELECT ROLE FROM   USER_ROLE A WHERE  LOGIN = #{login} ")
	@Results(value = { 
			@Result(column = "ROLE", property = "ROLE", typeHandler = RoleTypeHandler.class, javaType = Role.class) 
	})
	public Role[] getUserRolesWithResultAnnotation(String login);

	@Select("SELECT ROLE FROM   USER_ROLE A WHERE  LOGIN = #{login} ")
	public List<Role> getUserRoleListWithResultAnnotation(String login);

	
	@Select("SELECT ROLE FROM   USER_ROLE A WHERE  LOGIN = #{login} ")
	@ResultMap("RoleResult")
	public Role[] getUserRolesWithResultMapAnnotationAndXml(String login);

}
