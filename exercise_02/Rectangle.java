package exercise_02;

import java.util.Scanner;

public class Rectangle extends Shape{
    private double chieuDai;
    private double chieuRong;

    public Rectangle() {}
    public Rectangle(double chieuDai, double chieuRong) {
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    public double getChieuDai() {
        return chieuDai;
    }
    public void setChieuDai(double chieuDai) {
        this.chieuDai = chieuDai;
    }
    public double getChieuRong() {
        return chieuRong;
    }
    public void setChieuRong(double chieuRong) {
        this.chieuRong = chieuRong;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("- Nhap chieu dai: ");
        chieuDai = sc.nextDouble();
        System.out.print("- Nhap chieu rong: ");
        chieuRong = sc.nextDouble();
    }

    public void xuat() {
        System.out.println("- Chieu dai: " + chieuDai);
        System.out.println("- Chieu rong: " + chieuRong);
    }

    @Override
    public String toString() {
        return "Rectangle";
    }

    @Override
    public double tinhDienTich() {
        return Math.round(chieuDai * chieuRong * 100.0) / 100.0;
    }
    
}
