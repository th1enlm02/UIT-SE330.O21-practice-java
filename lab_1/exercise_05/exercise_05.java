import java.util.Scanner;

public class exercise_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao so luong nhan vien: ");
        int soLuongNhanVien = sc.nextInt();
        System.out.print("Nhap vao so luong sinh vien: ");
        int soLuongSinhVien = sc.nextInt();
        Object[] objs = new Object[soLuongNhanVien + soLuongSinhVien];

        // nhap
        System.out.println("----------Nhap thong tin----------");
        for (int i = 0; i < soLuongNhanVien; i++) {
            System.out.println("Nhap thong tin nhan vien thu " + (i + 1));
            NhanVien nv = new NhanVien();
            nv.nhap();
            nv.setLuong(nv.Valuate());
            objs[i] = nv;
        }
        for (int i = soLuongNhanVien; i < soLuongNhanVien + soLuongSinhVien; i++) {
            System.out.println("Nhap thong tin sinh vien thu " + (i - soLuongNhanVien + 1));
            SinhVien sv = new SinhVien();
            sv.nhap();
            sv.setDiemTrungBinh(sv.Valuate());
            objs[i] = sv;
        }

        // xuat
        System.out.println("----------Xuat thong tin----------");
        for (int i = 0; i < soLuongNhanVien + soLuongSinhVien; i++) {
            if (objs[i] instanceof NhanVien) {
                System.out.println("Thong tin nhan vien thu " + (i + 1));
                ((NhanVien) objs[i]).xuat();
            } else {
                System.out.println("Thong tin sinh vien thu " + (i - soLuongNhanVien + 1));
                ((SinhVien) objs[i]).xuat();
            }
        }

        // tinh luong trung binh va diem trung binh
        System.out.println("----------Luong trung binh va diem trung binh----------");
        double luongTrungBinh = 0;
        double diemTrungBinh = 0;
        for (int i = 0; i < soLuongNhanVien + soLuongSinhVien; i++) {
            if (objs[i] instanceof NhanVien) {
                luongTrungBinh += ((NhanVien) objs[i]).getLuong();
            } else {
                diemTrungBinh += ((SinhVien) objs[i]).getDiemTrungBinh();
            }
        }
        luongTrungBinh /= soLuongNhanVien;
        diemTrungBinh /= soLuongSinhVien;
        System.out.println("=> Luong trung binh cua nhan vien: " + luongTrungBinh);
        System.out.println("=> Diem trung binh cua sinh vien: " + diemTrungBinh);
    }
}
