package com.untis.bems.service.adaptor.ddc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.code.DataType;
import com.serotonin.modbus4j.code.RegisterRange;
import com.serotonin.modbus4j.exception.ErrorResponseException;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.ip.IpParameters;
import com.serotonin.modbus4j.locator.BaseLocator;
import com.serotonin.modbus4j.locator.NumericLocator;
import com.untis.bems.domain.BemsPoint;
import com.untis.bems.domain.DevicePoint;
import com.untis.bems.service.adaptor.DevicePointService;

@Service("modbusDevicePoint")
public class ModbusDevicePointServiceImpl implements DevicePointService {
	
	private static final Logger logger = LoggerFactory.getLogger(ModbusDevicePointServiceImpl.class);
	
	private ModbusMaster initModbus(String ipAddress) {
		IpParameters params = new IpParameters();
		params.setHost(ipAddress);
		params.setPort(502);
		
        ModbusFactory modbusFactory = new ModbusFactory();
        ModbusMaster master = modbusFactory.createTcpMaster(params, false);
        
		master.setTimeout(2000);
		master.setRetries(5);
		
		try {
			master.init();
		} catch (ModbusInitException e) {
			logger.error("[IP : {}] Modbus Init Error.", ipAddress);
			e.printStackTrace();
			master.destroy();
		}
		
		return master;
	}
	
	private DevicePoint getValue(ModbusMaster master, BemsPoint bemsPoint) {
		int offset = Integer.parseInt(bemsPoint.getPointId());
		Number resultValue = null;
		
		try {
			// resultValue = master.getValue(new NumericLocator(1, RegisterRange.INPUT_REGISTER, offset, DataType.EIGHT_BYTE_INT_UNSIGNED_SWAPPED));
			resultValue = master.getValue(new NumericLocator(1, RegisterRange.INPUT_REGISTER, offset, DataType.FOUR_BYTE_INT_UNSIGNED));
		} catch (ModbusTransportException e) {
			logger.error("Modbus Transport Error. [IP : {}]", bemsPoint.getPrivateIp());
			e.printStackTrace();
		} catch (ErrorResponseException e) {
			logger.error("Modbus Response Error. [IP : {}]", bemsPoint.getPrivateIp());
			e.printStackTrace();
		}
		
		DevicePoint devicePoint = new DevicePoint();
		devicePoint.setPointId(bemsPoint.getPointId());
		devicePoint.setPointValue(resultValue.toString());
		return devicePoint;
	}
	
	public DevicePoint get(BemsPoint bemsPoint) {
		ModbusMaster master = initModbus(bemsPoint.getPrivateIp());
		DevicePoint devicePoint = getValue(master, bemsPoint);
		return devicePoint;
	}
	
	public Map<Integer, DevicePoint> getAll(List<BemsPoint> bemsPoints) {		
		Map<Integer, DevicePoint> maps = new HashMap<Integer, DevicePoint>();		
		for (BemsPoint point : bemsPoints) {
			ModbusMaster master = initModbus(point.getPrivateIp());
			DevicePoint devicePoint = getValue(master, point);
			maps.put(point.getPointListIdx(), devicePoint);
			master.destroy();
		}
		return maps;
	}
}
