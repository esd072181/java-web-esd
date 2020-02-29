package com.crms.bo.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crms.bo.LabExamBo;
import com.crms.dao.LabExamDao;
import com.crms.model.LabExam;

/**
 * 
 * @author dward
 *
 */
@Service
public class LabExamBoImpl implements LabExamBo {
	
	private final static Logger logger = Logger.getLogger(LabExamBoImpl.class);

	@Autowired
	LabExamDao labExamDao;
	
	public void setLabExamDao(LabExamDao labExamDao){
		this.labExamDao = labExamDao;
	}

	@Override
	@Transactional
	public boolean save(LabExam entity) {
		
		 entity.setCreatedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 entity.setVersion(1);
		 entity.setActive(true);
		 
		 logger.info("Save: " + entity.toString());
		 
		return labExamDao.save(entity);
	}

	@Override
	@Transactional
	public boolean update(LabExam entity) {
		
		 LabExam model = labExamDao.findById(entity.getId());	
		 //update the fields of the model
		 model.setDescription(entity.getDescription());
		 model.setRemarks(entity.getRemarks());
		 model.setFee(entity.getFee());
		 model.setModifiedBy(entity.getModifiedBy());
		 model.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 model.setVersion(model.getVersion() + 1);

		 logger.info("Update: " + model.toString());
		 
		return labExamDao.update(model);
	}
	
	@Override
	@Transactional
	public boolean delete(LabExam entity) {
		
		entity.setActive(false);
		entity.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		entity.setVersion(entity.getVersion() + 1);		
		
		logger.info("Delete: id = " + entity.getId());
		
		return labExamDao.delete(entity);
	}

	@Override
	@Transactional
	public Map<Object, Object> findByDescription(Map<Object,Object> mapCriteria) {
		return labExamDao.findByDescription(mapCriteria);
	}
	
	@Override
	@Transactional
    public List<LabExam> getAllEntity() {
        return labExamDao.getAllEntity();
    }

	@Override
	@Transactional
	public LabExam findById(int criteria) {
		return labExamDao.findById(criteria);
	}

}
