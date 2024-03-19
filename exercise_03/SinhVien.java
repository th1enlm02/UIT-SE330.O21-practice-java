import java.util.Scanner;

public class SinhVien {
    private String fullname;
    private String mssv;
    private String lop;
    private double diemTrungBinh;

    SinhVien () {};
    SinhVien (String fullname, String mssv, String lop, double diemTrungBinh) {
        this.fullname = fullname;
        this.mssv = mssv;
        this.lop = lop;
        this.diemTrungBinh = diemTrungBinh;
    }

    public String getFullname() {
        return fullname;
    }
    public String getMssv() {
        return mssv;
    }
    public String getLop() {
        return lop;
    }
    public double getDiemTrungBinh() {
        return diemTrungBinh;
    }
    public void setFullName (String fullname) {
        this.fullname = fullname;
    }
    public void setMssv(String mssv) {
        this.mssv = mssv;
    }
    public void setLop(String lop) {
        this.lop = lop;
    }
    public void setDiemTrungBinh(double diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    // nhap
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("- Nhap ho ten: ");
        fullname = sc.nextLine();
        System.out.print("- Nhap mssv: ");
        mssv = sc.nextLine();
        System.out.print("- Nhap lop: ");
        lop = sc.nextLine();
        System.out.print("- Nhap diem trung binh: ");
        diemTrungBinh = sc.nextDouble();
    }

    // xuat
    public void output() {
        System.out.println("- Ho ten: " + fullname);
        System.out.println("- Mssv: " + mssv);
        System.out.println("- Lop: " + lop);
        System.out.println("- Diem trung binh: " + diemTrungBinh);
    }
}