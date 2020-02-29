package com.lrms.dao;

import java.util.List;
import java.util.Map;

import com.lrms.model.LabExam;

/**
 * 
 * @author dward
 *
 */
public interface LabExamDao {

	boolean save(LabExam entity);
	boolean update(LabExam entity);
	boolean delete(LabExam entity);
	LabExam findById(int criteria);
	Map<Object, Object> findByDescription(Map<Object, Object> mapCriteria);
	List<LabExam> getAllEntity();
}
