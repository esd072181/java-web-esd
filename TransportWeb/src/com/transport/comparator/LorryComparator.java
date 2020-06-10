package com.transport.comparator;

import java.util.Comparator;

import com.transport.model.Lorry;

/**
 * 
 * @author edwarddavid
 * @since 26Apr2020
 * Deprecated on 28Apr2020: Used lambda expression instead (functional interface)
 */
public class LorryComparator implements Comparator<Lorry> {

	@Override
	public int compare(Lorry o1, Lorry o2) {
		return o1.getLorryNo().compareTo(o2.getLorryNo());
	}

}
