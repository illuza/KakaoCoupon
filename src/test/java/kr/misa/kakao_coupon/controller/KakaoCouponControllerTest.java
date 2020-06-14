package kr.misa.kakao_coupon.controller;

import kr.misa.kakao_coupon.repository.CouponRepository;
import kr.misa.kakao_coupon.service.CouponService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class KakaoCouponControllerTest {

    @Autowired
    private CouponService couponService;

    @Autowired
    private CouponRepository couponRepository;

    @Before
    public void setUp() {
        couponRepository = new CouponRepository()
        couponService = new CouponService(couponRepository);
        couponService.create("0000000000", "2021-07-01", "foo", false);
    }

    @Test
    void generateNofRandom() {
    }

    @Test
    void grantedToUser() {
    }

    @Test
    void consume() {
    }

    @Test
    void cancelGranted() {
    }

    @Test
    void queryExpiredToday() {
    }
}