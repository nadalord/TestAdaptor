package com.untis.bems.service.adaptor;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.ip.IpParameters;
import com.serotonin.modbus4j.msg.ReadHoldingRegistersRequest;
import com.serotonin.modbus4j.msg.ReadHoldingRegistersResponse;
import com.untis.bems.AbstractTestableContext;
import com.untis.bems.ServerThread;
import com.untis.bems.domain.BemsPoint;
import com.untis.bems.domain.DevicePoint;
import com.untis.bems.mapper.adaptor.BemsPointMapperTest;

public class ModbusDevicePointServiceTest extends AbstractTestableContext {

	private static final Logger logger = LoggerFactory.getLogger(ModbusDevicePointServiceTest.class);
	
	@Autowired
	BemsPointService bemsPointService;
	
	@Autowired
	@Qualifier("modbusDevicePoint")
	DevicePointService devicePointService;

	@Test
    public  void readHoldingRegisters() {
		
        IpParameters ipParameters = new IpParameters();
        ipParameters.setHost("localhost");
        ipParameters.setPort(502);

        ModbusFactory modbusFactory = new ModbusFactory();
        ModbusMaster master = modbusFactory.createTcpMaster(ipParameters, false);
        
        try {
			master.init();
		} catch (ModbusInitException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        try {
        	
            ReadHoldingRegistersRequest request = new ReadHoldingRegistersRequest(1, 10, 2);
            ReadHoldingRegistersResponse response = (ReadHoldingRegistersResponse) master.send(request);

            if (response.isException())
                System.out.println("Exception response: message=" + response.getExceptionMessage());
            else
                System.out.println(Arrays.toString(response.getShortData()));
        }
        catch (ModbusTransportException e) {
            e.printStackTrace();
        }
    }
		
	@Test
	public void getAll() {
		
//        IpParameters ipParameters = new IpParameters();
//        ipParameters.setHost("localhost");
//        ipParameters.setPort(502);
//
//        ModbusFactory modbusFactory = new ModbusFactory();
//        ModbusMaster master = modbusFactory.createTcpMaster(ipParameters, false);
//		
//		List<BemsPoint> bemsPoints = bemsPointService.getList(1, 1);
//		assertTrue(bemsPoints.size() > 1);
//		
//		Map<Integer, DevicePoint> maps = devicePointService.getAll(bemsPoints);
//		assertTrue(maps.size() >= 1);
//		
//		for (Map.Entry<Integer, DevicePoint> entry : maps.entrySet()){
//			logger.debug("DDC Bems Point [{} : {} : {}]", 
//					entry.getValue().getPointId(), 
//					entry.getValue().getPointName(),
//					entry.getValue().getPointValue());
//		}
	}
}