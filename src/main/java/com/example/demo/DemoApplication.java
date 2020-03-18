package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WGH
 */
@RestController
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
        System.out.println("Demo启动成功");
	}

    @RequestMapping(value = "/sayHello",method = RequestMethod.GET)
    public String sayHello(String name){
	    String sayHello = "你好，"+name;
//        System.out.println(sayHello);
        return sayHello;
    }

}
