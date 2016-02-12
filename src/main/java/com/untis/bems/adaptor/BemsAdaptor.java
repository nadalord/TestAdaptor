
package com.untis.bems.adaptor;

import com.untis.bems.domain.DevicePoint;

public interface BemsAdaptor {
	public int addBemsHistory(String date, String time, int pointListIdx, DevicePoint point);
	public void run ();
}
