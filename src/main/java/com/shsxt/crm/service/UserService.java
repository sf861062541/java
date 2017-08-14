package com.shsxt.crm.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.shsxt.crm.constant.Constant;
import com.shsxt.crm.dao.UserDao;
import com.shsxt.crm.dto.UserDto;
import com.shsxt.crm.util.AssertUtil;
import com.shsxt.crm.util.MD5Util;
import com.shsxt.crm.util.UserIDBase64;
import com.shsxt.crm.vo.CookieUser;
import com.shsxt.crm.vo.User;

@Service
public class UserService {
	@Resource
	private UserDao userDao;
	
	public CookieUser login(User user){
		AssertUtil.isTrue(StringUtils.isBlank(user.getUserName()),Constant.NAME_NULL);
		AssertUtil.isTrue(StringUtils.isBlank(user.getPassword()),Constant.PASSWORD_NULL);
		User tempUser = userDao.queryUserByUserName(user.getUserName());
		AssertUtil.isTrue(null==tempUser,Constant.USER_NULL);
		AssertUtil.isTrue(!MD5Util.md5Method(user.getPassword()).equals(tempUser.getPassword()),Constant.PASSWORD_ERROR);
		CookieUser cookieUser = baseId(tempUser);
		return cookieUser;
	}
	
	private CookieUser baseId(User tempUser){
		CookieUser cookieUser = new CookieUser();
		cookieUser.setId(UserIDBase64.encoderUserID(tempUser.getId()));
		cookieUser.setUserName(tempUser.getUserName());
		cookieUser.setTrueName(tempUser.getTrueName());
		return cookieUser;
	}

	public List<UserDto> queryManagerTrueNames() {
		return userDao.queryManagerTrueNames();
	}
}
