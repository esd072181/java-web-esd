package com.sims.bo;

import com.sims.model.SalesHeader;

public interface SalesHeaderBo {

	boolean save(SalesHeader entity);
	boolean update(SalesHeader entity);
	boolean delete(SalesHeader entity);
	SalesHeader getEntityByTransNo(String transNo);
	SalesHeader findById(int criteria);
	long getTotalCount();
}

