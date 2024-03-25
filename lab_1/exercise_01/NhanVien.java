import java.util.Scanner;

public class NhanVien extends Person {
    private double luongCoBan;
    private int heSoLuong;

    // set & get methods
    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }
    public double getLuongCoBan() {
        return luongCoBan;
    }
    public void setHeSoLuong(int heSoLuong) {
        this.heSoLuong = heSoLuong;
    }
    public int getHeSoLuong() {
        return heSoLuong;
    }

    // constructors
    NhanVien () {};
    NhanVien (String hoten, int tuoi, String diaChi, double luongCoBan, int heSoLuong) {
        super(hoten, tuoi, diaChi);
        this.luongCoBan = luongCoBan;
        this.heSoLuong = heSoLuong;
    }
    
    // display method
    public void display() {
        super.display();
        System.out.println("- Luong co ban: " + luongCoBan);
        System.out.println("- He so luong: " + heSoLuong);
    }

    // input method
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.print("- Luong co ban: ");
        luongCoBan = sc.nextDouble();
        System.out.print("- He so luong: ");
        heSoLuong = sc.nextInt();
    }

    // tinhLuong method
    public double tinhLuong() {
        return Math.round(luongCoBan * heSoLuong * 100.0) / 100.0;
    }
}