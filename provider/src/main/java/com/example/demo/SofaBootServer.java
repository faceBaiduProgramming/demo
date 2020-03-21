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
public class SofaBootServer {

	public static void main(String[] args) {
		SpringApplication.run(SofaBootServer.class, args);
        System.out.println("Demo启动成功");
	}

}
