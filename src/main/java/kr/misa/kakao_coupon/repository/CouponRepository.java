package kr.misa.kakao_coupon.repository;

import kr.misa.kakao_coupon.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    public Coupon save(Coupon coupon);
    public Coupon findOne(Long ID);
    public Coupon grantedToUser(final String ofUser);
    public List<Coupon> queryAlreadyGranted();
    public Coupon consume(final String ID);
    public Coupon cancelGranted(final String ID);
    public List<Coupon> queryExpiredToday();
}
