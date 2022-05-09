package com.example.masksale;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.masksale.mapper")
public class MaskSaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaskSaleApplication.class, args);
    }

}
