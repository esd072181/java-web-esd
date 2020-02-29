package com.sims.bo;

import java.util.List;

import com.sims.model.SalesDetails;
import com.sims.model.SalesHeader;

public interface SalesDetailsBo {

	boolean save(SalesDetails entity);
	boolean update(SalesDetails entity);
	boolean delete(SalesDetails entity);
//	boolean deleteByHeader(SalesHeader salesHeader);
	SalesDetails findById(int criteria);
	List<SalesDetails> getListBySalesHeader(SalesHeader salesHeader);
}

