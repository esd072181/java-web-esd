package com.sims.bo;

import java.util.List;
import java.util.Map;

import com.sims.model.Brand;

/**
 * 
 * @author dward
 *
 */
public interface BrandBo {

	boolean save(Brand entity);
	boolean update(Brand entity);
	boolean delete(Brand entity);
	Brand findById(int criteria);
	Map<Object, Object> findByDescription(Map<Object,Object> mapCriteria);
	List<Brand> getAllEntity();
}
