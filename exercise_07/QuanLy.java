import java.util.Scanner;

public class QuanLy extends NhanVien {
    private int soNhanVienQuanLy;

    QuanLy() {};
    public QuanLy(String hoTen, NgayThang ngaySinh, int heSoLuong, String phongBan, int soNhanVienQuanLy) {
        super(hoTen, ngaySinh, heSoLuong, phongBan);
        this.soNhanVienQuanLy = soNhanVienQuanLy;
    }

    // set & get methods
    public void setSoNhanVienQuanLy(int soNhanVienQuanLy) {
        this.soNhanVienQuanLy = soNhanVienQuanLy;
    }
    public int getSoNhanVienQuanLy() {
        return soNhanVienQuanLy;
    }

    // nhap
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("- Nhap so nhan vien quan ly: ");
        soNhanVienQuanLy = sc.nextInt();
    }

    // xuat
    public void xuat() {
        super.xuat();
        System.out.println("- So nhan vien quan ly: " + soNhanVienQuanLy);
    }

    // tinh luong
    public double tinhLuong() {
        return Math.round(heSoLuong * 1200000 * 100.0) / 100.0;
    }
}
