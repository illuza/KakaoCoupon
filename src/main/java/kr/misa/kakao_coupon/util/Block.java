package kr.misa.kakao_coupon.util;

public class Block {
    private boolean bUsed;
    private Integer iSize;

    public Block(boolean a_bUsed, Integer a_iSize) {
        this.bUsed = a_bUsed;
        this.iSize = a_iSize;
    }

    public boolean isbUsed() {
        return bUsed;
    }

    public void setbUsed(boolean bUsed) {
        this.bUsed = bUsed;
    }

    public Integer getiSize() {
        return iSize;
    }

    public void setiSize(Integer iSize) {
        this.iSize = iSize;
    }
}
