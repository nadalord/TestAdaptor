package com.untis.bems.service.adaptor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

@Service("modbusDevicePoint")
public class ModbusDevicePointServiceImpl implements DevicePointService {
	
	public Map<Integer, DevicePoint> getAll(List<BemsPoint> bemsPoints) {		
        IpParameters params = new IpParameters();
        params.setHost("localhost");
        params.setPort(502);

        ModbusMaster master = new ModbusFactory().createTcpMaster(params, false);
        master.setTimeout(2000);
        master.setRetries(5);
        try {
        	master.init();
        	master.getValue(new NumericLocator(1, RegisterRange.HOLDING_REGISTER, 11,DataType.TWO_BYTE_INT_SIGNED));
        } catch (ModbusInitException e) {
        	e.printStackTrace();
        } catch (ModbusTransportException e) {
			e.printStackTrace();
		} catch (ErrorResponseException e) {
			e.printStackTrace();
		} finally {
        	master.destroy();
        }
        
		Map<Integer, DevicePoint> maps = new HashMap<Integer, DevicePoint>();		
		return maps;
	}
}
