package main;


import com.sun.xml.internal.ws.util.StringUtils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

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
        String[] words = {"word","good","best","good"};
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
//        l.next.next = new ListNode(3);
//        l.next.next.next = new ListNode(4);
//        l.next.next.next.next = new ListNode(5);
        MainTest m = new MainTest();
        System.out.println(m.findSubstring("wordgoodgoodgoodbestword",words));
    }
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        if (words == null || words.length < 1) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        int len = words[0].length();
        int totalLen = words.length*len;
        for (int i = 0; i + totalLen <= s.length();i++) {
            for (int k = 0; k < words.length; k++) {
                if (map.containsKey(words[k])) {
                    map.put(words[k], map.get(words[k])+1);
                } else {
                    map.put(words[k], 1);
                }
            }
            boolean flag = true;
            for (int j = i; j < i+totalLen;j = j+len) {
                if (map.containsKey(s.substring(j,j+len)) && map.get(s.substring(j,j+len)) >=1) {
                    map.put(s.substring(j,j+len), map.get(s.substring(j,j+len))-1);
                } else {
                    break;
                }
            }
            for (Integer value:map.values()) {
                if (value != 0) {
                    flag = false;
                }
            }
            if (flag) {
                list.add(i);
            }
            map.clear();
        }

        return list;
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
}
