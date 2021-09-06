package com.mycompany.solution;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution001 {
    
    /**
     * Main program
     * @param args 
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap so luong mang n = ");
        int n = sc.nextInt();  //Nhập số lượng giá trị truyền vào mảng
        soNguyen(n);
    }
    
    /**
     * Solutions program
     * @param ranks
     * @return count
     */
    public static int solutions(int ranks[]) {
        int count = 0;  //Tạo ra một biến đếm bắt đầu từ 0
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();  //Khai báo một mảng chứa các phần tử
        for (int i = 0; i < ranks.length; i++) {  //Vòng lặp duyệt các giá  trị nhập vào từ bàn phím
            System.out.println("gia tri mang thu " + i);
            ranks[i] = sc.nextInt();
            if (0 <= ranks[i] && ranks[i] < 100000000) {
                list.add(ranks[i]);
            } else {
                System.out.println("Gia tri mang tu 0..100.000.000");
                break;
            }
        }
        
        for (int x : ranks) {  //Vòng lặp hiển thị các giá trị đã truyền vào mảng
            if (list.contains(x+1)) {  //so sánh danh sách có số 
                count++;
            }
        }
        return count;
    }

    /**
     * soNguyen program
     * @param n 
     */
    public static void soNguyen(int n) {
        if (2 < n && n < 100000) {
            int arr[] = new int[n];
            System.out.println("so cap bac la: " + solutions(arr));
        } else {
            System.out.println("So luong mang phai tu 2..100.000");
        }
    }
}
