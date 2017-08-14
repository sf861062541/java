package com.shsxt.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.shsxt.crm.dto.CustomerDto;

@Repository
public interface CustomerDao {
	
	@Select("select id,name from t_customer")
	List<CustomerDto> queryCustomerNames();

}
