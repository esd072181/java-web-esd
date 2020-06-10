package com.transport.comparator;

import java.util.Comparator;

import com.transport.model.ListValue;


/**
 * 
 * @author edwarddavid
 * @since 26Apr2020
 */
public class ListValueComparator implements Comparator<ListValue> {

	@Override
	public int compare(ListValue l1, ListValue l2) {
		return l1.getListValue().compareTo(l2.getListValue());
	}

}
