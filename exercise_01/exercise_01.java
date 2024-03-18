import java.util.Scanner;

public class exercise_01 {
    public static void main(String[] args) {
        // Nhập số lượng nhân viên
        int soLuongNhanVien;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong nhan vien: ");
        soLuongNhanVien = sc.nextInt();

        // Nhập thông tin nhân viên
        NhanVien[] list = new NhanVien[soLuongNhanVien];
        for (int i = 0; i < soLuongNhanVien; i++) {
            list[i] = new NhanVien();
            System.out.println("Nhap thong tin nhan vien thu " + (i + 1) + ":");
            list[i].input();
        }
        System.out.println("------------------------------------------");
        // Hiển thị thông tin nhân viên và lương
        for (int i = 0; i < soLuongNhanVien; i++) {
            System.out.println("Thong tin nhan vien thu " + (i + 1) + ":");
            list[i].display();
            System.out.println("-> Luong: " + list[i].tinhLuong());
        }
        System.out.println("------------------------------------------");
        // Tính tổng lương và tìm nhân viên có lương cao nhất
        double max = list[0].tinhLuong();
        int index = 0;
        double sum = 0;
        for (int i = 0; i < soLuongNhanVien; i++) {
            sum += list[i].tinhLuong();
            if (list[i].tinhLuong() > max) {
                max = list[i].tinhLuong();
                index = i;
            }
        }
        System.out.println("=> Tong luong cua nhan vien: " + sum);
        System.out.println("=> Nhan vien co luong cao nhat: ");
        list[index].display();
    }
}
