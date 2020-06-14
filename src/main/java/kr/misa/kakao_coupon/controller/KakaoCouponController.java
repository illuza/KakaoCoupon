package kr.misa.kakao_coupon.controller;

import kr.misa.kakao_coupon.model.Coupon;
import kr.misa.kakao_coupon.service.CouponService;
import kr.misa.kakao_coupon.util.Allocated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/coupon_v0.8")
public class KakaoCouponController {

    @Autowired
    private CouponService couponService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/random/{N}", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8")
    public List<Coupon> generateNofRandom(@PathVariable Long N) {
        List<Coupon> lstRandomCoupons = new ArrayList<Coupon>(N.intValue());
        List<Integer> lstIDs = null;
        lstIDs = Allocated.newBlock(N.intValue());
        int i = 0;
        for (Coupon coupon :
                lstRandomCoupons) {
            String a_ID = String.format("%04d", lstIDs.get(i));
            coupon.setID(a_ID);
            i++;
        }

        return lstRandomCoupons;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/gift/{ofUser}", method = RequestMethod.GET)
    public Coupon grantedToUser(@PathVariable String ofUser) {
        return couponService.grantedToUser(ofUser);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/consume/{ID}", method = RequestMethod.PUT)
    public Coupon consume(@PathVariable String ID) {
        return couponService.consume(ID);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/cancel/{ID}", method = RequestMethod.PUT)
    public Coupon cancelGranted(@PathVariable String ID) {
        return couponService.cancelGranted(ID);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/expired_today.do", method = RequestMethod.GET)
    public List<Coupon> queryExpiredToday() {
        return couponService.queryExpiredToday();
    }
}
