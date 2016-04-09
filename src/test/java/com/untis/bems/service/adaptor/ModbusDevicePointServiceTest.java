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
import com.serotonin.modbus4j.msg.ReadInputRegistersRequest;
import com.serotonin.modbus4j.msg.ReadInputRegistersResponse;
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
	
	public void printHEX(byte[] ba) {
		byte c;
		for (int i = 0; i < ba.length; i++) {
			c = ba[i];
			System.out.format("[%d : %02X : %d]\n", i, c, c);
		}
	}
	

	@Test
    public  void get() {
		BemsPoint bemsPoint = new BemsPoint();
		bemsPoint.setPointListIdx(1);
		bemsPoint.setPointId("0");
		bemsPoint.setPrivateIp("192.168.0.201");
		DevicePoint devicePoint = devicePointService.get(bemsPoint);
		logger.debug("Device Point : {}, {}", devicePoint.getPointId(), devicePoint.getPointValue());
		
		
//		Float test = 1.9f;
//		byte[] a = test.
//		System.out.format("%02x%02x\n", );
	}
	
	@Test
    public  void readInputRegistersRequest() throws ModbusInitException, ModbusTransportException {
		IpParameters ipParameters = new IpParameters();
		ipParameters.setHost("192.168.0.201");
		ipParameters.setPort(502);

		ModbusFactory modbusFactory = new ModbusFactory();
		ModbusMaster master = modbusFactory.createTcpMaster(ipParameters, false);

		master.init();

		ReadInputRegistersRequest request = new ReadInputRegistersRequest(1, 32, 2);
		ReadInputRegistersResponse response = (ReadInputRegistersResponse) master.send(request);

		if (response.isException())
			System.out.println("Exception response: message=" + response.getExceptionMessage());
		else {
			System.out.println("readInputRegistersRequest : " + Arrays.toString(response.getShortData()));
			printHEX(response.getData());
			System.out.format("TEST : %f", Float.parseFloat(new String(response.getData())));
		}
    }
	

	@Test
    public  void readHoldingRegisters() throws ModbusInitException, ModbusTransportException {
		IpParameters ipParameters = new IpParameters();
		ipParameters.setHost("192.168.0.130");
		ipParameters.setPort(502);

		ModbusFactory modbusFactory = new ModbusFactory();
		ModbusMaster master = modbusFactory.createTcpMaster(ipParameters, false);

		master.init();

		ReadHoldingRegistersRequest request = new ReadHoldingRegistersRequest(1, 18, 4);
		ReadHoldingRegistersResponse response = (ReadHoldingRegistersResponse) master.send(request);

		if (response.isException())
			System.out.println("readHoldingRegisters Exception response: message=" + response.getExceptionMessage());
		else {
			System.out.println("readHoldingRegisters : " + Arrays.toString(response.getShortData()));
			printHEX(response.getData());
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