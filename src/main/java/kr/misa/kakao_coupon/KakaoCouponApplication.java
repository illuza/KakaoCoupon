package kr.misa.kakao_coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCaching
@SpringBootApplication
public class KakaoCouponApplication {

	public static void main(String[] args) {
		SpringApplication.run(KakaoCouponApplication.class, args);
	}

}
