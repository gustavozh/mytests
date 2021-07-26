package ie.gustavo.mytests.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ie.gustavo.mytests.service.MyTestService;

@RestController
public class MyTestController {
	
	@Autowired
	MyTestService myTestService;

	@GetMapping("/hello")
	public ResponseEntity<String> helloWorld() {
		return new ResponseEntity<>(myTestService.hello(), HttpStatus.OK);
	}

}
