package com.example.application;

import java.util.concurrent.ThreadLocalRandom;

public class HowToReleaseResource {

	public static void main(String[] args) throws Exception {
		try( // try-with-resources
			PreciousResource res1 = new PreciousResource(1);
			PreciousResource res2 = new PreciousResource(2);
			PreciousResource res3 = new PreciousResource(3);
		) { 
				
		}catch (Exception e) {
			
		}
	}

}

class PreciousResource implements AutoCloseable {
	private int resourceId;

	public PreciousResource(int resourceId) {
		this.resourceId = resourceId;
	}

	public void useResource() {
	}

	@Override
	public void close() throws Exception {
		System.err.println("Closing the resource " + this.resourceId);
		if (ThreadLocalRandom.current().nextBoolean())
			throw new IllegalStateException("something is wrong!");		
	}

}