package com.pibs.module;

import java.util.HashMap;
import java.util.Map;

import com.pibs.bo.LoginBo;
import com.pibs.constant.ActionConstant;
import com.pibs.constant.MapConstant;
import com.pibs.model.User;

public class LoginModule implements PIBSModule{

	@Override
	public Map<String, Object> executeRequest(HashMap<String, Object> dataMap) throws Exception{
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		try {
			String action = (String)dataMap.get(MapConstant.ACTION);
			LoginBo bo = (LoginBo) dataMap.get(MapConstant.BEAN);
					
			switch(action) {
				case ActionConstant.VALIDATEUSER: {
					HashMap<String, Object> resultMap =  (HashMap<String, Object>) bo.validateUserAccount((User)dataMap.get(MapConstant.CLASS_DATA));	
					if (resultMap!=null && !resultMap.isEmpty()) {
						returnMap.put(MapConstant.BOOLEAN_DATA, MapConstant.TRUE);
						returnMap.put(MapConstant.CLASS_DATA, resultMap.get(MapConstant.CLASS_DATA));
					} else {
						returnMap.put(MapConstant.BOOLEAN_DATA, MapConstant.FALSE);
						returnMap.put(MapConstant.CLASS_DATA, null);
					}
				}; break;
				default: break;
			};			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			
		}

		return returnMap;
	}

	
	
}
