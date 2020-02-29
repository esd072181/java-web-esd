package com.pibs.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.pibs.bo.RoomInquiryBo;
import com.pibs.dao.RoomDao;

public class RoomInquiryBoImpl implements RoomInquiryBo {

	private RoomDao dao;
	
	public RoomDao getRoomDao() {
		return dao;
	}

	public void setRoomDao(RoomDao dao) {
		this.dao = dao;
	}

	@Override
	public Map<String, Object> search(HashMap<String, Object> criteriaMap) throws Exception{
		// TODO Auto-generated method stub
		return dao.searchForInquiry(criteriaMap);
	}
	
	@Override
	public Map<String, Object> searchAll(HashMap<String, Object> criteriaMap) throws Exception{
		// TODO Auto-generated method stub
		return dao.search(criteriaMap);
	}

	@Override
	public Map<String, Object> getAvailableRooms(HashMap<String, Object> criteriaMap) throws Exception{
		// TODO Auto-generated method stub
		return dao.getAvailableRoomsForRoomInquiry(criteriaMap);
	}

	@Override
	public Map<String, Object> getOccupiedRooms(HashMap<String, Object> criteriaMap) throws Exception{
		// TODO Auto-generated method stub
		return dao.getOccupiedRoomsForRoomInquiry(criteriaMap);
	}
	
}
