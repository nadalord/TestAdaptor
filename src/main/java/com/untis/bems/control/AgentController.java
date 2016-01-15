package com.untis.bems.control;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class AgentController {
	
	@JmsListener(destination = "control.queue")
	public void listen(String text) {
		System.out.println(text);
	}
}
