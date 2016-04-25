package issue;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.Alias;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;



@Alias("RoleTypeHandler")
@MappedTypes(Role.class)
public class RoleTypeHandler<E extends Enum<E>> extends BaseTypeHandler<Role> {

	 @Override
	  public void setNonNullParameter(PreparedStatement ps, int i, Role parameter, JdbcType jdbcType) throws SQLException {
		ps.setInt(i, parameter.getValue());
	  }

	  @Override
	  public Role getNullableResult(ResultSet rs, String columnName) throws SQLException {
	    return  Role.getRoleFromValue(rs.getInt(columnName));
	  }

	  @Override
	  public Role getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
	    return Role.getRoleFromValue(rs.getInt(columnIndex));
	  }

	  @Override
	  public Role getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
	    return Role.getRoleFromValue(cs.getInt(columnIndex));
	  }
}
