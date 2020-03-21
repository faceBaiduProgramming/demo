package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * @author WGH
 */
@EnableZipkinServer
@SpringBootApplication
@ImportResource({"classpath*:META-INF/spring/*.xml"})
public class DeployApplication {

	public static void main(String[] args) {
		SpringApplication.run(SofaBootClient.class, args);
        System.out.println("Demo启动成功");
	}

}
