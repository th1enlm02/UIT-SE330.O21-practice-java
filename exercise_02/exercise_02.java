package exercise_02;

import java.util.Scanner;

public class exercise_02 {
    public static void main(String[] args) {
        // Nhap so luong hinh
        Scanner scanner = new Scanner(System.in);
        int soLuong;
        System.out.print("Nhap so luong hinh: ");
        soLuong = scanner.nextInt();

        // Nhap danh sach hinh
        Object[] shapes = new Object[soLuong];
        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhap hinh thu " + (i + 1) + ":");
            System.out.println("1. Hinh chu nhat");
            System.out.println("2. Hinh tron");
            System.out.print("-> Chon hinh: ");
            int chon = scanner.nextInt();
            if (chon == 1) {
                Rectangle rectangle = new Rectangle();
                rectangle.nhap();
                shapes[i] = rectangle;
            } else if (chon == 2) {
                Circle circle = new Circle();
                circle.nhap();
                shapes[i] = circle;
            }
        }

        // Xuat danh sach hinh
        int soHinhChuNhat = 0;
        int soHinhTron = 0;
        double maxDienTich = 0;
        System.out.println("-------------------DANH SACH HINH-------------------");
        for (int i = 0; i < soLuong; i++) {
            System.out.println("Hinh thu " + (i + 1) + ":");
            if (shapes[i] instanceof Rectangle) {
                soHinhChuNhat++;
                Rectangle rectangle = (Rectangle) shapes[i];
                System.out.println("<Hinh chu nhat>");
                rectangle.xuat();
                System.out.println("-> Dien tich: " + rectangle.tinhDienTich());
                if (rectangle.tinhDienTich() > maxDienTich) {
                    maxDienTich = rectangle.tinhDienTich();
                }
            } else if (shapes[i] instanceof Circle) {
                soHinhTron++;
                Circle circle = (Circle) shapes[i];
                System.out.println("<Hinh tron>");
                circle.xuat();
                System.out.println("-> Dien tich: " + circle.tinhDienTich());
                if (circle.tinhDienTich() > maxDienTich) {
                    maxDienTich = circle.tinhDienTich();
                }
            }
        }

        // Dem co bao nhieu hinh chu nhat va hinh tron
        System.out.println("----------------------------------------------------");
        System.out.println("=> So hinh chu nhat: " + soHinhChuNhat);
        System.out.println("=> So hinh tron: " + soHinhTron);

        // Hinh co dien tich lon nhat
        System.out.println("----------------------------------------------------");
        System.out.println("=> Hinh co dien tich lon nhat: " + maxDienTich);
    }
}
