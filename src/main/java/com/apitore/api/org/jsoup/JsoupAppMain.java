package com.apitore.api.org.jsoup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author Keigo Hattori
 */
@ComponentScan
@EnableDiscoveryClient
@SpringBootApplication
public class JsoupAppMain {

  public static void main(String[] args) {
    SpringApplication.run(JsoupAppMain.class, args);
  }

}
