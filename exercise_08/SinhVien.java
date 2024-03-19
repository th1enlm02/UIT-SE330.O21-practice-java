import java.util.Scanner;

public class SinhVien implements Comparable<SinhVien>{
    private String hoTen;
    private double diemTrungBinh;

    SinhVien () {
        hoTen = "";
        diemTrungBinh = 0;
    }
    public SinhVien(String hoTen, double diemTrungBinh) {
        this.hoTen = hoTen;
        this.diemTrungBinh = diemTrungBinh;
    }

    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public double getDiemTrungBinh() {
        return diemTrungBinh;
    }
    public void setDiemTrungBinh(double diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    @Override
    public int compareTo(SinhVien o) {
        if (this.diemTrungBinh > o.diemTrungBinh) {
            return 1;
        } else if (this.diemTrungBinh < o.diemTrungBinh) {
            return -1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return "[" + hoTen + "]" + "_" + diemTrungBinh;
    }

    // nhap & xuat
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("- Nhap ho ten: ");
        hoTen = sc.nextLine();
        System.out.print("- Nhap diem trung binh: ");
        diemTrungBinh = sc.nextDouble();
    }
    public void xuat() {
        System.out.println("- Ho ten: " + hoTen);
        System.out.println("- Diem trung binh: " + diemTrungBinh);
    }
}