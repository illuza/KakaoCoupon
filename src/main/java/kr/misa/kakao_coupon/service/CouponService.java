package kr.misa.kakao_coupon.service;

import kr.misa.kakao_coupon.model.Coupon;
import kr.misa.kakao_coupon.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CouponService {
    @Autowired
    private CouponRepository couponRepository;

    public CouponService(final CouponRepository aCouponRepository) { this.couponRepository = aCouponRepository;}

    @Cacheable(value="create")
    @Transactional()
    public Coupon create(final String ID, final String dateExpired, final String ofUser, final boolean bUsed) {
        Coupon coupon = new Coupon(ID, dateExpired, ofUser, bUsed);
        couponRepository.save(coupon);
        return coupon;
    }

    @Cacheable(value="grantedToUser")
    @Transactional()
    public Coupon grantedToUser(final String ofUser) {
        return couponRepository.grantedToUser(ofUser);
    }

    @Cacheable(value="queryAlreadyGranted")
    @Transactional()
    public List<Coupon> queryAlreadyGranted() {
        return couponRepository.queryAlreadyGranted();
    }

    @Cacheable(value="consume")
    @Transactional()
    public Coupon consume(final String ID) {
        return couponRepository.consume(ID);
    }

    @Cacheable(value="cancelGranted")
    @Transactional()
    public Coupon cancelGranted(final String ID) {
        return couponRepository.cancelGranted(ID);
    }

    @Cacheable(value="queryExpiredToday")
    @Transactional()
    public List<Coupon> queryExpiredToday() {
        return couponRepository.queryExpiredToday();
    }
}
