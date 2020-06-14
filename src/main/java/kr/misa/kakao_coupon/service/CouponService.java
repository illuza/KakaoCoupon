package kr.misa.kakao_coupon.service;

import kr.misa.kakao_coupon.model.Coupon;
import kr.misa.kakao_coupon.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CouponService {
    @Autowired
    private CouponRepository couponRepository;

    public CouponService(final CouponRepository aCouponRepository) { this.couponRepository = aCouponRepository;}

    @Transactional()
    public Coupon create(final String ID, final String dateExpired, final String ofUser, final boolean bUsed) {
        Coupon coupon = new Coupon(ID, dateExpired, ofUser, bUsed);
        couponRepository.save(coupon);
        return coupon;
    }

    @Transactional()
    public Coupon grantedToUser(final String ofUser) {
        return couponRepository.grantedToUser(ofUser);
    }

    @Transactional()
    public List<Coupon> queryAlreadyGranted() {
        return couponRepository.queryAlreadyGranted();
    }

    @Transactional()
    public Coupon consume(final String ID) {
        return couponRepository.consume(ID);
    }

    @Transactional()
    public Coupon cancelGranted(final String ID) {
        return couponRepository.cancelGranted(ID);
    }

    @Transactional()
    public List<Coupon> queryExpiredToday() {
        return couponRepository.queryExpiredToday();
    }
}
