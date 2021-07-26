package ie.gustavo.mytests.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class MyOtherTestServiceImpl implements MyOtherTestService {

	@Override
	@Retryable(value = RuntimeException.class, maxAttempts = 5, backoff = @Backoff(delay = 10000))
	public void helloAsync() {
		System.out.println("I'm repeting!");
		throw new RuntimeException("Again?!");
	}

}
