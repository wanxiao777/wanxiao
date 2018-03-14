package cn.wx.crm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import cn.wx.crm.entity.SalesChance;

public interface SalesChanceMapper {

	@Select("select * from (select rownum rn,id,cust_name,title,contact,contact_tel,create_date "
			+ "from sales_chances) t where t.rn>=#{startIndex} and t.rn<=#{endIndex}")
	List<SalesChance> getContent(Map<String, Object> map);
	
	@Select("select count(id) from sales_chances")
	long getTotalElement();
}
