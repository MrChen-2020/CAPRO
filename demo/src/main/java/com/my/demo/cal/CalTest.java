package com.my.demo.cal;

import java.util.HashMap;
import java.util.Scanner;
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class CalTest {
    public static void main(String[] args) {
//        Scanner in =new Scanner(System.in);
//        String s=in.next();
//        new CalTest().repeatLong(s);
        ListNode listNode1=new ListNode(9);
        ListNode listNode1next=new ListNode(9);
        ListNode listNode1next1=new ListNode(9);
        listNode1.next=listNode1next;
        listNode1next.next=listNode1next1;
        ListNode listNode2=new ListNode(9);
        ListNode listNode2next=new ListNode(9);
        listNode2.next=listNode2next;
        ListNode listNode=new CalTest().addTwoNumbers(listNode1,listNode2);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }

    //重复字符的最长子串
    private void repeatLong(String s){
        if (s.length()==0){
            return;
        }
        char[] cs= s.toCharArray();
        int left=0;
        int right=0;
        int max=0;
        HashMap<Character,Integer> map=new HashMap<>();
        while(right<s.length()){
            char a=cs[right];
            right++;

        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre=null;
        ListNode next=null;
        int carrier=0;
        while(l1!=null || l2!=null){
            int v1=l1!=null?l1.val:0;
            int v2=l2!=null?l2.val:0;
            ListNode curNode=new ListNode();
            int sum=v1+v2+carrier;
            carrier=sum/10;
            int rv=sum%10;
            curNode.val=rv;
            if(pre==null){
                pre=curNode;
            }else{
                if(next==null){
                    pre.next=curNode;
                    next=curNode;
                }else{
                    next.next=curNode;
                    next=curNode;
                }
            }
            l1=l1!=null?l1.next:null;
            l2=l2!=null?l2.next:null;
        }
        if(carrier>0){
            ListNode curNode=new ListNode();
            curNode.val=carrier;
            if(next==null){
                next=pre;
            }
            next.next=curNode;
        }
        return pre;
    }
}
