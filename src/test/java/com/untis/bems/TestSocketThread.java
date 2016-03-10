package com.untis.bems;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import com.serotonin.modbus4j.sero.io.StreamUtils;

public class TestSocketThread extends Thread {
	Socket s;
	InputStream in;

	TestSocketThread(Socket s) {
            System.out.println("Socket opened");
            try {
                this.s = s;
                this.in = s.getInputStream();
                start();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

	@Override
	public void run() {
		byte[] b = new byte[1024];
		int readcount;
		try {
			while (true) {
				readcount = in.read(b);
				if (readcount == -1)
					break;
				System.out.println("Test");
				System.out.println(StreamUtils.dumpMessage(b, 0, readcount));
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		try {
			if (s != null)
				s.close();
		} catch (IOException e) {
		}

		System.out.println("Socket closed");
	}
}
