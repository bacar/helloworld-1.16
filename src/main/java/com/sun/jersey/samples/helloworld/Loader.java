package com.sun.jersey.samples.helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.io.FileUtils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class Loader {

	public static void main(String[] args) throws IOException {
		 Client c = Client.create();
		 WebResource r = c.resource("http://localhost:9998/helloworld");
		 InputStream is = r.get(InputStream.class);
		 
		 InputStreamReader isr = new InputStreamReader(is);
		 BufferedReader br = new BufferedReader(isr);
		 String s;
		 int i = 0;
		 
		 byte[] buffer = new byte[1024 * 100];
		 int numRead = 0;
		 long total = 0;
		 while((numRead = is.read(buffer)) != 0) {
			 total += numRead;
			 System.out.println(String.format("read %s", FileUtils.byteCountToDisplaySize(total)));
		 
		 }
		 
		 
//		 while( (s=br.readLine()) != null ) {
//			 ++i;
//			 System.out.println("Read " + s);
//			try {
//				if(i % 1000 == 0) {
//					TimeUnit.MILLISECONDS.sleep(1);
//				}
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		 }
	}
}
