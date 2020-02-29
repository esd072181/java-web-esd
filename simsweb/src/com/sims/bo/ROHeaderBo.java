package com.sims.bo;

import com.sims.model.ROHeader;

public interface ROHeaderBo {

	boolean save(ROHeader entity);
	boolean update(ROHeader entity);
	boolean delete(ROHeader entity);
	ROHeader findById(int id);
}

