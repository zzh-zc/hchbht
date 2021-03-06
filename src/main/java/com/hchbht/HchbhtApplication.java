package com.hchbht;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.hchbht.mapper")
@SpringBootApplication
public class HchbhtApplication {

    public static void main(String[] args) {
        SpringApplication.run(HchbhtApplication.class, args);
    }

}
