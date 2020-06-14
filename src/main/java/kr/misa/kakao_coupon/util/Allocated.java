package kr.misa.kakao_coupon.util;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;

public class Allocated {
    static Block[] Blocks;
    static Integer idxCurrent;

    Allocated() {
        Blocks = new Block[(int) pow(10, 10)];
        Blocks[0].setbUsed(false);
        Blocks[0].setiSize((int) pow(10,10));
        idxCurrent = 0;
    }

    public static List<Integer> newBlock(Integer iSize) {
        List<Integer> blkNew = new ArrayList<Integer>();
        Integer i = idxCurrent;
        while (i < pow(10, 10)) {
            if (!Blocks[i].isbUsed()) {
                if (Blocks[i].getiSize() >= iSize) {
                    Blocks[i].setbUsed(true);
                    Blocks[i].setiSize(iSize);
                    break;
                }
            }
            i += iSize;
        }

        int j = 0;
        for (j = i; j < iSize+1; j++) {
            blkNew.add(j);
        }
        idxCurrent = j+1;

        return blkNew;
    }

    public static void freeBlock(Integer iBlkIndex) {
        if (!Blocks[iBlkIndex].isbUsed()) {
            return;
        }
        Blocks[iBlkIndex].setbUsed(false);
    }
}
