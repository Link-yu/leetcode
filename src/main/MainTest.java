package main;



import java.util.*;


/**
 * Created on 2017/7/17.
 * Title: Simple
 * Description: Example
 * Copyright: Copyright(c) 2016
 * Company: 杭州公共交通云科技有限公司
 *
 * @author 维斯
 */
public class MainTest {
    public static void main(String[] args) {
        String [] cityCodes = "361100".split(",");
        System.out.println(cityCodes[0]);
    }

    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length<= 1) {
            return false;
        }
        Arrays.sort(deck);
        boolean flag = false;
        for (int x = 2; x <= deck.length;x++) {
            if (deck.length%x != 0) {
                continue;
            }
            flag = false;
            for (int i= 0; i<= deck.length-x;i=i+x) {
                if (deck[i] != deck[i+x-1]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return true;
            }
        }
        return false;
    }
}
