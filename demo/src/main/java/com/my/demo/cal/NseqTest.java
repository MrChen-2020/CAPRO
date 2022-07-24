package com.my.demo.cal;

import java.util.HashSet;
import java.util.Scanner;

public class NseqTest {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int onum=in.nextInt();
            HashSet<Integer> set=new HashSet<>();
            int result=0;
            while(onum!=0){
                int nnum=onum%10;
                if(set.add(nnum)){
                    result=result*10+nnum;
                }
                onum=onum/10;
            }
            System.out.println(result);
        }
    }
}
