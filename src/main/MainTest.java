package main;



import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    List<List<Integer>> listList = new ArrayList<>();
    public static final String REGX="(\\d+(\\.\\d+)?)";

    public static final Pattern PATTERN= Pattern.compile(REGX);
    public static void main(String[] args) {
//        int[] words = {0,1,0,2,1,0,1,3,2,1,2,1};
//        ListNode l = new ListNode(1);
//        l.next = new ListNode(2);
////        l.next.next = new ListNode(3);
////        l.next.next.next = new ListNode(4);
////        l.next.next.next.next = new ListNode(5);
//        MainTest m = new MainTest();
//        System.out.println(m.isMatch("aaaa","***a"));
//        try{
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date startDate = simpleDateFormat.parse("2019-10-22 00:00:00");
//            Date endDate = simpleDateFormat.parse("2020-12-20 24:00:00");
//            System.out.println(startDate.getTime()  + "  " + endDate.getTime());
//        }catch (Exception e) {
//
//        }

        Optional<Member> optionalMember = Optional.ofNullable(new Member());
        Optional<String> optional = Optional.of("af");
        System.out.println(optional.get());
        optionalMember.ifPresent(mem -> {
            System.out.println("adsfa" + mem.getName());
        });
    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        if (s.equals(p)) return true;
        int m = s.length();
        int n = p.length();
        int posS = 0;
        int posP = 0;
        int posStar = -1;
        int posOfS = -1;
        //if posS == posP || posP == '?', ++posS and ++posP.
        //posOfS, posStar, record the positon of '*' in s and p, ++posP and go on.
        //if not match, go back to star, ++posOfS
        while (posS < m) {
            if (posP < n && (s.charAt(posS) == p.charAt(posP) || p.charAt(posP) == '?')) {
                ++posS;
                ++posP;
            }
            else if (posP < n && p.charAt(posP) == '*') {
                posStar = posP;
                posOfS = posS;
                ++posP;
                continue;
            }
            else if (posStar != -1) {
                posS = posOfS;
                posP = posStar + 1;
                ++posOfS;
            }
            else {
                return false;
            }
        }
        while (posP < n && p.charAt(posP) == '*') {
            ++posP;
        }

        return posS == m && posP == n;
    }


}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
}
class Member {
    String name;
    String age;
    public Member() {
        System.out.println("构造函数初始化!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
