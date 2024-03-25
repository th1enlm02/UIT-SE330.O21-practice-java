import java.util.Scanner;

public class GiamDoc extends NhanVien {
    private int heSoChucVu;

    GiamDoc() {};
    public GiamDoc(String hoTen, NgayThang ngaySinh, int heSoLuong, String phongBan, int heSoChucVu) {
        super(hoTen, ngaySinh, heSoLuong, phongBan);
        this.heSoChucVu = heSoChucVu;
    }

    // set & get methods
    public void setHeSoChucVu(int heSoChucVu) {
        this.heSoChucVu = heSoChucVu;
    }
    public int getHeSoChucVu() {
        return heSoChucVu;
    }

    // nhap
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("- Nhap he so chuc vu: ");
        heSoChucVu = sc.nextInt();
    }

    // xuat
    public void xuat() {
        super.xuat();
        System.out.println("- He so chuc vu: " + heSoChucVu);
    }

    // tinh luong
    public double tinhLuong() {
        return Math.round((heSoLuong + heSoChucVu) * 1200000 * 100.0) / 100.0;
    }
}
