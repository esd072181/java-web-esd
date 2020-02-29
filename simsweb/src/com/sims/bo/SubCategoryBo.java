package com.sims.bo;

import java.util.List;
import java.util.Map;

import com.sims.model.SubCategory;

/**
 * 
 * @author dward
 *
 */
public interface SubCategoryBo {

	boolean save(SubCategory entity);
	boolean update(SubCategory entity);
	boolean delete(SubCategory entity);
	SubCategory findById(int criteria);
	Map<Object, Object> findByDescription(Map<Object,Object> mapCriteria);
	List<SubCategory> getAllEntity();
}
