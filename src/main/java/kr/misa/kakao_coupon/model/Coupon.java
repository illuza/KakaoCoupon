package kr.misa.kakao_coupon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Coupon extends RootEntity {
    @Column(nullable = true, length=4)
    private String ID;

    @Column(nullable = true)
    private String dateExpired;

    @Column(nullable = true)
    private String ofUser;

    @Column(nullable = false)
    private boolean bUsed;

    public Coupon() {
        // this.dateExpired = today() + 30;
    }

    public Coupon(final String a_ID, final String a_dateExpired, final String a_ofUser, final boolean a_bUsed) {
        this.ID = a_ID;
        this.dateExpired = a_dateExpired;
        this.ofUser = a_ofUser;
        this.bUsed = a_bUsed;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDateExpired() {
        return dateExpired;
    }

    public void setDateExpired(String dateExpired) {
        this.dateExpired = dateExpired;
    }

    public String getOfUser() {
        return ofUser;
    }

    public void setOfUser(String ofUser) {
        this.ofUser = ofUser;
    }

    public boolean isbUsed() {
        return bUsed;
    }

    public void setbUsed(boolean bUsed) {
        this.bUsed = bUsed;
    }
}
