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
        MainTest mainTest = new MainTest();
        System.out.println(mainTest.addBinary("1010","1011"));
    }

    public String addBinary(String a, String b) {
        int lenA = a.length()-1;
        int lenB = b.length()-1;
        int temp = 0;
        String result = "";
        int atemp = 0;
        int btemp =0 ;
        while (lenA >= 0 || lenB >= 0) {
            if (lenA >= 0) {
                atemp = Integer.valueOf(a.charAt(lenA) + "");
            }

            if (lenB >= 0) {
                btemp = Integer.valueOf(b.charAt(lenB) + "");
            }
            int plus = btemp + atemp + temp;
            if (plus <= 1) {
                result = plus + result;
                temp = 0;
            } else if (plus == 2) {
                result = 0 + result;
                temp = 1;
            } else {
                result = 1 + result;
                temp = 1;
            }
            lenA--;
            lenB--;
            atemp = 0;
            btemp = 0;
        }
        if (temp == 1) {
            result = 1 + result;
        }

        return result;
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
