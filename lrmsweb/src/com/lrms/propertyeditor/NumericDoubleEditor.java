package com.lrms.propertyeditor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;

import com.lrms.util.LRMSUtil;

/**
 * 
 * @author edwarddavid
 * @since 09May2020
 */
public class NumericDoubleEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String numStr) throws IllegalArgumentException {
	    try {
			this.setValue(LRMSUtil.convertNumStrWithCommaToDouble(numStr));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
}
