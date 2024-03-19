import java.util.Arrays;
import java.util.Scanner;

public class exercise_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong sinh vien: ");
        int soLuongSinhVien = sc.nextInt();
        SinhVien[] danhSachSinhVien = new SinhVien[soLuongSinhVien];

        // Nhap danh sach sinh vien
        System.out.println("----------Nhap thong tin sinh vien----------");
        for (int i = 0; i < soLuongSinhVien; i++) {
            danhSachSinhVien[i] = new SinhVien();
            System.out.println("Nhap thong tin sinh vien thu " + (i + 1) + ":");
            danhSachSinhVien[i].nhap();
        }

        // Xuat danh sach sinh vien
        System.out.println("----------Xuat thong tin sinh vien vua nhap----------");
        for (int i = 0; i < soLuongSinhVien; i++) {
            System.out.println("Thong tin sinh vien thu " + (i + 1) + ":");
            danhSachSinhVien[i].xuat();
        }

        // Sap xep danh sach sinh vien theo diem trung binh tang dan
        Arrays.sort(danhSachSinhVien);
        System.out.println("----------Danh sach sinh vien sap xep theo diem trung binh tang dan----------");
        for (int i = 0; i < soLuongSinhVien; i++) {
            System.out.println("Thong tin sinh vien thu " + (i + 1) + ":");
            danhSachSinhVien[i].xuat();
        }
    }
}
