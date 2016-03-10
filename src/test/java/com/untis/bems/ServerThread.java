package com.untis.bems;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerThread extends Thread {

	@Override
	public void run() {
		
		try {
			ServerSocket ss = new ServerSocket(10502);
			while (true)
				new TestSocketThread(ss.accept());
		}
        catch (IOException e) {
            e.printStackTrace();
        }
	}
}
