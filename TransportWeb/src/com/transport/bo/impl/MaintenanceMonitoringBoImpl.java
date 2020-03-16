package com.transport.bo.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import com.transport.bo.MaintenanceMonitoringBo;
import com.transport.constant.ActionConstant;
import com.transport.constant.MapConstant;
import com.transport.constant.MiscConstant;
import com.transport.constant.ModuleConstant;
import com.transport.dao.MaintenanceMonitoringDao;
import com.transport.model.ListValue;
import com.transport.model.Lorry;
import com.transport.model.MaintenanceMonitoring;
import com.transport.service.ServiceManager;
import com.transport.service.ServiceManagerImpl;
import com.transport.util.ReportUtils;
import com.transport.util.TransportUtils;

import net.sf.jasperreports.renderers.JCommonDrawableRenderer;

/**
 * 
 * @author dward
 * @since 25Mar2019
 * Date Updated: 16Mar2020
 */
public class MaintenanceMonitoringBoImpl implements MaintenanceMonitoringBo {

	private MaintenanceMonitoringDao dao;
	
	public MaintenanceMonitoringDao getMaintenanceMonitoringDao() {
		return dao;
	}

	public void setMaintenanceMonitoringDao(MaintenanceMonitoringDao dao) {
		this.dao = dao;
	}

	@Override
	public Map<String, Object> add(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		
		MaintenanceMonitoring model = (MaintenanceMonitoring) dataMap.get(MapConstant.CLASS_DATA);
		
		//Get the lorry details here
        HashMap<String,Object> criteriaMap = new HashMap<String, Object>();
        criteriaMap.put("plateNo", model.getPlateNo());
        criteriaMap.put("lorryNo", model.getLorryNo());
        criteriaMap.put(MapConstant.MODULE, ModuleConstant.LORRY);
        criteriaMap.put(MapConstant.ACTION, ActionConstant.GET_DATA_BY_CRITERIA);
		ServiceManager service = new ServiceManagerImpl();
		Map<String, Object> resultMap = service.executeRequest(criteriaMap);
        
		Lorry lorry = null;
        if (resultMap!=null && !resultMap.isEmpty()) {
        	lorry = (Lorry) resultMap.get(MapConstant.CLASS_DATA);		        		
        }
        criteriaMap = null;
        service = null;
        resultMap = null;
		
        model.setTrailerNo(lorry.getTrailerNo());
        model.setCapacity(lorry.getCapacity());
        model.setCategory(lorry.getCategory());
        model.setTransportId(lorry.getTransportId());
        
		return dao.save(dataMap);
	}

	@Override
	public Map<String, Object> update(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		return dao.update(dataMap);
	}

	@Override
	public Map<String, Object> delete(HashMap<String, Object> dataMap) throws Exception {
		// TODO Auto-generated method stub
		return dao.delete(dataMap);
	}

	@Override
	public Map<String, Object> getActiveData(HashMap<String, Object> criteriaMap) throws Exception{
		// TODO Auto-generated method stub
		return dao.getActiveData(criteriaMap);
	}

	@Override
	public Map<String, Object> getDataById(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.getDataById(criteriaMap);
	}

	@Override
	public Map<String, Object> generateExcelFile(HashMap<String, Object> criteriaMap) throws Exception {
		
		@SuppressWarnings("unchecked")
		HashMap<String, Object> dataMap = (HashMap<String, Object>)criteriaMap.get(MapConstant.REPORT_DATA_MAP);
		String localPath = (String)criteriaMap.get(MapConstant.REPORT_LOCALPATH);
		
		boolean isReportGenerated = ReportUtils.generateMaintenanceMonitoringExcelFile(dataMap, localPath);
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put(MapConstant.BOOLEAN_DATA, isReportGenerated);
		
		return returnMap;
		
	}

	@Override
	public Map<String, Object> generateMaintenanceCategoryPDF(HashMap<String, Object> criteriaMap) throws Exception {
	
		String localPath = (String)criteriaMap.get(MapConstant.REPORT_LOCALPATH);
		String year = (String) criteriaMap.get(MapConstant.YEAR_CRITERIA);
		String month = (String) criteriaMap.get(MapConstant.MONTH_CRITERIA);
		month = TransportUtils.getStrMonth(Integer.parseInt(month));
		
		//Get the data
		List<Integer> lovIdList = dao.getMaintenanceCategoryData(criteriaMap);
		
		//Categorize lovIdList
		int counter = 0;
		int lvId = 0;
		Map<String, Integer> categoryLOVMap = new HashMap<>();
		for (ListValue lv: TransportUtils.getMaintenanceCategoryLOV()) {
			lvId = lv.getId();
			counter = 0;
			for (Integer id: lovIdList) {
				if (id == lvId) {
					counter += 1;
				}
			}
			if (counter>0) {
				categoryLOVMap.put(TransportUtils.getMaintenanceCategoryById(lvId), counter);
			}
		}
		
		//Prepare the data
		DefaultPieDataset dataset = new DefaultPieDataset();
		if (categoryLOVMap.size()>0) {
			categoryLOVMap.forEach((key, val) -> dataset.setValue(key, val));
		}
		
		//Prepare the chart
		JFreeChart chart = ChartFactory.createPieChart3D("Maintenance Category", dataset, true, true, false);
		  
	    // Create the custom label generator to show the percentage
	    final PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} = {2}");
		PiePlot plot = (PiePlot) chart.getPlot();
//		plot.setStartAngle(290); //these are used for PiePlot3D
//		plot.setDirection(Rotation.CLOCKWISE);
//		plot.setForegroundAlpha(0.5f);
		plot.setNoDataMessage("No data to display");
		plot.setLabelGenerator(labelGenerator);

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("Chart", new JCommonDrawableRenderer(chart));
		parameters.put("Year", year);
		parameters.put("Month", month);
		
		criteriaMap.put(MapConstant.RPT_TITLE, MiscConstant.RPT_MAINTENANCE_CATEGORY_TITLE);
		criteriaMap.put(MapConstant.RPT_PDF, MiscConstant.PDF_MAINTENANCE_CATEGORY_REPORT);
		criteriaMap.put(MapConstant.RPT_JASPER, MiscConstant.RPT_MAINTENANCE_CATEGORY_REPORT);
		  
		//dummy dataList ---> report will not be generated if this is null or empty
		List<Object> dataList = new ArrayList<>();
		Lorry dto = new Lorry();
		dto.setId(1);
		dataList.add(dto);
		
		boolean isReportGenerated = ReportUtils.generateReport(dataList, criteriaMap, parameters, localPath);
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put(MapConstant.BOOLEAN_DATA, isReportGenerated);
		
		return returnMap;
	}

	

}
