import java.util.Scanner;

public class exercise_07 {
    public static void main(String[] args) {
        // nhap so luong nhan vien
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong nhan vien: ");
        int soLuongNhanVien = sc.nextInt();
        NhanVien[] nhanVien = new NhanVien[soLuongNhanVien];

        // nhap thong tin nhan vien
        System.out.println("----------Nhap thong tin nhan vien----------");
        nhapDanhSachNhanVien(nhanVien);

        // xuat thong tin nhan vien
        System.out.println("----------Xuat thong tin nhan vien----------");
        xuatDanhSachNhanVien(nhanVien);

        // xuat nhan vien co luong cao nhat
        System.out.println("----------Nhan vien co luong cao nhat----------");
        xuatNhanVienCoLuongCaoNhat(nhanVien);

        // hien thi cac nhan vien sinh vao thang 2
        System.out.println("----------Nhan vien sinh vao thang 2----------");
        xuatNhanVienSinhVaoThangHai(nhanVien);

        // xuat nhan vien thuoc phong "Ke toan"
        System.out.println("----------Nhan vien thuoc phong Ke toan----------");
        xuatNhanVienThuocPhongKeToan(nhanVien);

        // dem so luong nhan vien co ten la "An"
        System.out.println("----------So luong nhan vien co ten la 'An'----------");
        System.out.println("=> So luong nhan vien co ten la 'An': " + demSoLuongNhanVienCoTenLaAn(nhanVien));

    }
    public static void nhapDanhSachNhanVien(NhanVien[] nhanVien) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < nhanVien.length; i++) {
            System.out.println("Nhap thong tin nhan vien thu " + (i + 1) + ":");
            System.out.println("Chon loai nhan vien:");
            System.out.println("1. Nhan vien");
            System.out.println("2. Giam doc");
            System.out.println("3. Quan ly");
            System.out.print("-> Chon loai nhan vien: ");
            int loaiNhanVien = sc.nextInt();
            sc.nextLine();
            switch (loaiNhanVien) {
                case 1:
                    nhanVien[i] = new NhanVien();
                    nhanVien[i].nhap();
                    nhanVien[i].setLuong(nhanVien[i].tinhLuong());
                    break;
                case 2:
                    nhanVien[i] = new GiamDoc();
                    nhanVien[i].nhap();
                    nhanVien[i].setLuong(nhanVien[i].tinhLuong());
                    break;
                case 3:
                    nhanVien[i] = new QuanLy();
                    nhanVien[i].nhap();
                    nhanVien[i].setLuong(nhanVien[i].tinhLuong());
                    break;
                default:
                    System.out.println("<!> Loai nhan vien khong hop le!");
                    i--;
                    break;
            }
        }
    }
    public static void xuatDanhSachNhanVien(NhanVien[] nhanVien) {
        for (int i = 0; i < nhanVien.length; i++) {
            System.out.println("Thong tin nhan vien thu " + (i + 1) + ":");
            nhanVien[i].xuat();
            System.out.println("-> Luong: " + nhanVien[i].getLuong());
        }
    }
    public static void xuatNhanVienCoLuongCaoNhat(NhanVien[] nhanVien) {
        double luongCaoNhat = nhanVien[0].getLuong();
        int index = 0;
        for (int i = 1; i < nhanVien.length; i++) {
            if (nhanVien[i].getLuong() > luongCaoNhat) {
                luongCaoNhat = nhanVien[i].getLuong();
                index = i;
            }
        }
        System.out.println("=> Nhan vien co luong cao nhat:");
        nhanVien[index].xuat();
        System.out.println("-> Luong: " + nhanVien[index].getLuong());
    }
    public static void xuatNhanVienSinhVaoThangHai(NhanVien[] nhanVien) {
        for (int i = 0; i < nhanVien.length; i++) {
            if (nhanVien[i].getNgaySinh().getThang() == 2) {
                System.out.println("Thong tin nhan vien sinh vao thang 2:");
                nhanVien[i].xuat();
                System.out.println("-> Luong: " + nhanVien[i].getLuong());
            }
        }
    }
    public static void xuatNhanVienThuocPhongKeToan(NhanVien[] nhanVien) {
        for (int i = 0; i < nhanVien.length; i++) {
            if (nhanVien[i].getPhongBan().equals("Ke toan")) {
                System.out.println("Thong tin nhan vien thuoc phong ke toan:");
                nhanVien[i].xuat();
                System.out.println("-> Luong: " + nhanVien[i].getLuong());
            }
        }
    }
    public static int demSoLuongNhanVienCoTenLaAn(NhanVien[] nhanVien) {
        int count = 0;
        for (int i = 0; i < nhanVien.length; i++) {
            if (nhanVien[i].getHoTen().equals("An")) {
                count++;
            }
        }
        return count;
    }
}
