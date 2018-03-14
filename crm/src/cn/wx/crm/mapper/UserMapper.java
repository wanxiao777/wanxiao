package cn.wx.crm.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.wx.crm.entity.User;

public interface UserMapper {

	@Select("select u.id,u.name,u.password,u.enabled,u.salt,r.name as \"role.name\""
			+ "from users u left outer join roles r on u.role_id = r.id where u.name = #{username}")
	User getUserByName(@Param("username") String username);
}
