package com.untis.bems.service.adaptor;

import static org.junit.Assert.*;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

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
import com.untis.bems.domain.BemsPoint;
import com.untis.bems.domain.DevicePoint;

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
		bemsPoint.setDeviceId("1");
		bemsPoint.setFunctionCode(0x04);
		bemsPoint.setDataType(0x08);
		bemsPoint.setPointId("32");
		bemsPoint.setPrivateIp("192.168.0.201");
		
		DevicePoint devicePoint = devicePointService.get(bemsPoint);
		logger.debug("Device Point (TR1) : {}, {}", devicePoint.getPointId(), devicePoint.getPointValue());
		
		bemsPoint.setDeviceId("2");
		devicePoint = devicePointService.get(bemsPoint);
		logger.debug("Device Point (TR2) : {}, {}", devicePoint.getPointId(), devicePoint.getPointValue());
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
			float f = ByteBuffer.wrap(response.getData()).order(ByteOrder.BIG_ENDIAN).getFloat();
			System.out.println("TEST : " + f);
		}
    }
}