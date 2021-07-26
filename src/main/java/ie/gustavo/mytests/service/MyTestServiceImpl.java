package ie.gustavo.mytests.service;

import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyTestServiceImpl implements MyTestService {

	@Autowired
	MyOtherTestService myOtherTestService;
	
	@Override
	public String hello() {
		String hello = "Hello!";
		
		try {
			helloSync();
		} catch(Exception e) {
			Executors.newSingleThreadExecutor().execute(() -> myOtherTestService.helloAsync());
		}
		
		return hello;
	}
	
	private void helloSync() throws Exception {
		throw new Exception("Oh my god!");
	}

}
