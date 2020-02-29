package com.pibs.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.pibs.bo.RptRoomBo;
import com.pibs.dao.RoomDao;

public class RptRoomBoImpl implements RptRoomBo {
	
	private RoomDao roomDao;
	
	public RoomDao getRoomDao() {
		return roomDao;
	}

	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	@Override
	public Map<String, Object> getRecords(HashMap<String, Object> criteriaMap) throws Exception{
		// TODO Auto-generated method stub
		return roomDao.searchForListReport(criteriaMap);
	}
	
}
