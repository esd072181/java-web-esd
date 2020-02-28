package com.drms.bo.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.drms.bo.MedicineBo;
import com.drms.dao.MedicineDao;
import com.drms.model.Medicine;

/**
 * 
 * @author dward
 *
 */
@Service
public class MedicineBoImpl implements MedicineBo {

	@Autowired
	MedicineDao medicineDao;
	
	public void setMedicineDao(MedicineDao medicineDao){
		this.medicineDao = medicineDao;
	}

	@Override
	@Transactional
	public boolean save(Medicine entity) {
		
		 entity.setCreatedBy(1);//test code
		 entity.setCreatedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 entity.setVersion(1);
		 entity.setActive(true);
		 
		return medicineDao.save(entity);
	}

	@Override
	@Transactional
	public boolean update(Medicine entity) {
		
		 Medicine model = medicineDao.findById(entity.getId());	
		 //update the fields of the model
		 model.setItemCode(entity.getItemCode());
		 model.setDescription(entity.getDescription());
		 model.setGenericName(entity.getGenericName());
		 model.setRemarks(entity.getRemarks());
		 model.setLotNo(entity.getLotNo());
		 model.setDateManufactured(entity.getDateManufactured());
		 model.setExpirationDate(entity.getExpirationDate());
		 model.setRetailSellingPrice(entity.getRetailSellingPrice());
		 model.setModifiedBy(1);//test code
		 model.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 model.setVersion(model.getVersion() + 1);

		return medicineDao.update(model);
	}
	
	@Override
	@Transactional
	public boolean delete(int criteria) {
		
		Medicine model = medicineDao.findById(criteria);
		 model.setActive(false);
		 model.setModifiedBy(1);//test code
		 model.setModifiedOn(new java.sql.Timestamp(System.currentTimeMillis()));
		 model.setVersion(model.getVersion() + 1);		
		
		return medicineDao.delete(model);
	}

	@Override
	@Transactional
	public Map<Object, Object> findByDescription(Map<Object,Object> mapCriteria) {
		return medicineDao.findByDescription(mapCriteria);
	}
	
	@Override
	@Transactional
    public List<Medicine> getAllEntity() {
        return medicineDao.getAllEntity();
    }

	@Override
	@Transactional
	public Medicine findById(int criteria) {
		return medicineDao.findById(criteria);
	}

}
