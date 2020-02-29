package com.lrms.bo;

import java.util.List;
import java.util.Map;

import com.lrms.model.LabExam;

/**
 * 
 * @author dward
 *
 */
public interface LabExamBo {

	boolean save(LabExam entity);
	boolean update(LabExam entity);
	boolean delete(LabExam entity);
	LabExam findById(int criteria);
	Map<Object, Object> findByDescription(Map<Object,Object> mapCriteria);
	List<LabExam> getAllEntity();
}
