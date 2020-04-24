package cn.jc.new_retail;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.jc.new_retail.mapper")
public class NewRetailApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewRetailApplication.class, args);
    }

}
