package com.shsxt.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.shsxt.crm.dto.SaleChanceParams;
import com.shsxt.crm.vo.SaleChance;

@Repository
public interface SaleChanceDao {

	List<SaleChance> querySaleChanceForPage(SaleChanceParams scp, PageBounds pageBounds);
	
	int insertSaleChance(SaleChance saleChance);

	SaleChance querySaleChanceById(Integer id);

	int updateSaleChance(SaleChance saleChance);
	
	@Update("update t_sale_chance "+ 
  		"set is_valid=0 "+
  		"where id in (${ids})")
	int deleteSaleChance(@Param(value="ids") String ids);
	
}
