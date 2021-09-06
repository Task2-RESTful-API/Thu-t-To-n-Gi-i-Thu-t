package com.mycompany.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution002 {
    /**
     * Main program
     * @param args 
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arr = sc.nextLine();
        kiTu(arr);
    }
    /**
     * Solution program
     * @param arr
     * @return 
     */
    public static int solution(String arr) {
        int count;
        //Tạo một nơi chứa các tập hợp của phần tử
        ArrayList<String> list1 = new ArrayList<>();
        //sử dụng vòng lặp duyệt phẩn tử tăng dần
        for (int i = 0; i < arr.length(); i++) {
            //viết thêm 1 vòng lặp để tăng giá trị i+1
            for (int j = i + 1; j <= arr.length(); j++) {
                //đặt điều kiện nếu i khác với j
                if (i != j) {
                    //thêm tất cả các chuỗi con vào kho chứa
                    //String vd="DiemPhuoc";  
                    list1.add(arr.substring(i, j));//tra ve Di  
                }
            }
        }
        System.out.println("To hop mang:"+list1);
        //Tạo một nơi lưu trữ mới
        TreeMap<String, Integer> list2 = new TreeMap<>();
        for(String c : list1){
            //key: Lấy value của key
            //defaultValue: Nếu key không chứa trong HashMap nó sẽ trả về defaultValue
            //thêm các tập hợp của mảng đã được tách ra và đưa vào nơi lưu trữ mới
            list2.put(c, list2.getOrDefault(c, 0)+1);
        }
        System.out.println("Gia tri mang:"+list2);
        //Tạo một mảng chứa các chuỗi con lặp lại duy nhất 1 lần
        ArrayList<String> freshlist = new ArrayList<>();
        for(String s: list2.keySet()){
            if (list2.get(s)==1) {
                freshlist.add(s);
            }
        }
        //lược bỏ những key được lặp lại
        TreeMap<String, Integer> dictionary = new TreeMap<>();
        for(String s : freshlist){
            dictionary.put(s, s.length());
        }
        System.out.println("Ki tu trong mang:"+dictionary);
        //Thêm vào danh sách mới 
        ArrayList<Integer> newList = new ArrayList<>();
        
        for(String s: dictionary.keySet()){
            newList.add(dictionary.get(s));
        }
        int ans = Integer.MAX_VALUE;
        
        for(int i : newList){
            ans = Math.min(ans, i);
        }
        return ans == Integer.MAX_VALUE ? 0: ans;
    }
    
    /**
     * kiTu program
     * @param arr 
     */
    public static void kiTu(String arr) {
        char s = arr.charAt(0);
        if ('a' <= s && s <= 'z') {
            System.out.println("so luong : "+ solution(arr));
        } else {
            System.out.println("Ki tu nhap phai tu a..z");
        }
    }
}
