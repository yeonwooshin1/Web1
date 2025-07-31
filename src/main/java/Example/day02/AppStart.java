package Example.day02;  // package

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//  @SpringBootConfiguration  스프링 세팅
//  @EnableAutoConfiguration  스프링 세팅한걸 연결
//  @ComponentScan(excludeFilters = { @Filter(type = FilterType.CUSTOM,   --> 컴포넌트를 세팅

public class AppStart { // class start
    public static void main(String[] args) {    // main start
        SpringApplication.run(AppStart.class);
    }   // main end
}   // class end
