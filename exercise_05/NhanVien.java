import java.util.Scanner;

public class NhanVien implements Measurable {
    private String ten;
    private String maNhanVien;
    private int soGioLam;
    private double giaTheoGio;
    private double luong;

    NhanVien () {};
    public NhanVien(String ten, String maNhanVien, int soGioLam, double giaTheoGio) {
        this.ten = ten;
        this.maNhanVien = maNhanVien;
        this.soGioLam = soGioLam;
        this.giaTheoGio = giaTheoGio;
    }

    // get & set methods
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public String getMaNhanVien() {
        return maNhanVien;
    }
    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
    public int getSoGioLam() {
        return soGioLam;
    }
    public void setSoGioLam(int soGioLam) {
        this.soGioLam = soGioLam;
    }
    public double getGiaTheoGio() {
        return giaTheoGio;
    }
    public void setGiaTheoGio(double giaTheoGio) {
        this.giaTheoGio = giaTheoGio;
    }
    public double getLuong() {
        return luong;
    }
    public void setLuong(double luong) {
        this.luong = luong;
    }

    // nhap & xuat
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("- Nhap ten: ");
        this.ten = sc.nextLine();
        System.out.print("- Nhap ma nhan vien: ");
        this.maNhanVien = sc.nextLine();
        System.out.print("- Nhap so gio lam: ");
        this.soGioLam = sc.nextInt();
        System.out.print("- Nhap gia theo gio: ");
        this.giaTheoGio = sc.nextDouble();
    }
    public void xuat() {
        System.out.println("- Ten: " + ten);
        System.out.println("- Ma nhan vien: " + maNhanVien);
        System.out.println("- So gio lam: " + soGioLam);
        System.out.println("- Gia theo gio: " + giaTheoGio);
        System.out.println("-> Luong: " + this.luong);
    }

    // tinh luong
    public double tinhLuong() {
        return Math.round(soGioLam * giaTheoGio * 100.0) / 100.0;
    }

    @Override
    public double Valuate() {
        return tinhLuong();
    }
}
