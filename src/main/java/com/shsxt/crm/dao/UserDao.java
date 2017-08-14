package com.shsxt.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.shsxt.crm.dto.UserDto;
import com.shsxt.crm.vo.User;

@Repository
public interface UserDao {
	User queryUserByUserName(String userName);
	
	@Select("select t1.id ,t1.true_name from t_user t1 "
			+ " left join t_user_role t2 on t1.id=t2.user_id "
			+ " where t2.role_id =3")
	List<UserDto> queryManagerTrueNames();
}
