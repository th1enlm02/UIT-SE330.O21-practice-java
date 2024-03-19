import java.util.Scanner;

public class NhanVien {
    protected String hoTen;
    protected NgayThang ngaySinh = new NgayThang();
    protected int heSoLuong;
    protected String phongBan;
    protected double luong;

    NhanVien() {};
    public NhanVien(String hoTen, NgayThang ngaySinh, int heSoLuong, String phongBan) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.heSoLuong = heSoLuong;
        this.phongBan = phongBan;
    }

    // set & get methods
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public String getHoTen() {
        return hoTen;
    }
    public void setNgaySinh(NgayThang ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public NgayThang getNgaySinh() {
        return ngaySinh;
    }
    public void setHeSoLuong(int heSoLuong) {
        this.heSoLuong = heSoLuong;
    }
    public int getHeSoLuong() {
        return heSoLuong;
    }
    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }
    public String getPhongBan() {
        return phongBan;
    }
    public void setLuong(double luong) {
        this.luong = luong;
    }
    public double getLuong() {
        return luong;
    }

    // nhap
    protected void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("- Nhap ho ten: ");
        hoTen = sc.nextLine();
        System.out.println("- Nhap ngay sinh: ");
        ngaySinh.nhap();
        System.out.print("- Nhap he so luong: ");
        heSoLuong = sc.nextInt();
        sc.nextLine();
        System.out.print("- Nhap phong ban: ");
        phongBan = sc.nextLine();
    }

    // xuat
    protected void xuat() {
        System.out.println("- Ho ten: " + hoTen);
        System.out.println("- Ngay sinh: " + ngaySinh.toString());
        System.out.println("- He so luong: " + heSoLuong);
        System.out.println("- Phong ban: " + phongBan);
    }

    // tinh luong
    protected double tinhLuong() {
        return Math.round(heSoLuong * 1200000 * 100.0) / 100.0;
    }
}