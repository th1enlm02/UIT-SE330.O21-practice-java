package exercise_02;

import java.util.Scanner;

public class Circle extends Shape {
    private double banKinh;

    public Circle() {}
    public Circle(double banKinh) {
        this.banKinh = banKinh;
    }

    public double getBanKinh() {
        return banKinh;
    }
    public void setBanKinh(double banKinh) {
        this.banKinh = banKinh;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("- Nhap ban kinh: ");
        banKinh = sc.nextDouble();
    }

    public void xuat() {
        System.out.println("- Ban kinh: " + banKinh);
    }

    @Override
    public String toString() {
        return "Circle";
    }
    @Override
    public double tinhDienTich() {
        return Math.round(Math.PI * Math.pow(banKinh, 2) * 100.0) / 100.0;
    }
}
