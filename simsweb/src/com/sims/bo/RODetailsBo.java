package com.sims.bo;

import java.util.List;

import com.sims.model.RODetails;
import com.sims.model.ROHeader;

public interface RODetailsBo {

	boolean save(RODetails entity);
	boolean update(RODetails entity);
	boolean delete(RODetails entity);
	RODetails findById(int id);
	List<RODetails> getListByROHeader(ROHeader roHeader);
}

