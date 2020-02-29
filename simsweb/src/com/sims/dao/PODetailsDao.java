package com.sims.dao;

import java.util.List;

import com.sims.model.PODetails;
import com.sims.model.POHeader;

/**
 * 
 * @author dward
 *
 */
public interface PODetailsDao {

	boolean save(PODetails entity);
	boolean update(PODetails entity);
	boolean delete(PODetails entity);
	PODetails findById(int id);
	List<PODetails> getListByPOHeader(POHeader poHeader);
}
