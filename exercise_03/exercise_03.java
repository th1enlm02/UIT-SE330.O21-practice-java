import java.util.Scanner;

public class exercise_03 {
    public static void main(String[] args) {
        int soLuongSinhVien;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong sinh vien: ");
        soLuongSinhVien = sc.nextInt();
        SinhVien[] danhSachSinhVien = new SinhVien[soLuongSinhVien];
        nhapDanhSachSinhVien(danhSachSinhVien);
        
        // viết vòng lặp chọn chức năng quản lý sinh viên
        int luaChon;
        do {
            System.out.println("**********Quan ly sinh vien**********");
            System.out.println("1. Nhap danh sach sinh vien");
            System.out.println("2. Xuat danh sach sinh vien");
            System.out.println("3. Sap xep va hien thi danh sach theo diem trung binh");
            System.out.println("4. Tim kiem sinh vien theo ten");
            System.out.println("5. Xuat thong tin cac sinh vien co ho la Le");
            System.out.println("0. Thoat");
            System.out.print("-> Nhap lua chon: ");
            luaChon = sc.nextInt();
            switch (luaChon) {
                case 1:
                    boolean flag = false;
                    while (!flag) {
                        System.out.println("Xoa danh sach sinh vien hien tai? (1) Co (2) Khong");
                        int luaChonXoa = sc.nextInt();
                        if (luaChonXoa == 1) {
                            System.out.print("Nhap so luong sinh vien: ");
                            danhSachSinhVien = new SinhVien[sc.nextInt()];
                            nhapDanhSachSinhVien(danhSachSinhVien);
                            flag = true;
                        } else if (luaChonXoa == 2) {
                            flag = true;
                        } else {
                            System.out.println("<!> Nhap khong hop le, vui long nhap lai");
                        }
                    }
                    break;
                case 2:
                    xuatDanhSachSinhVien(danhSachSinhVien);
                    break;
                case 3:
                    sapXepVaHienThiDanhSachTheoDiemTB(danhSachSinhVien);
                    break;
                case 4:
                    timKiemSinhVienTheoTen(danhSachSinhVien);
                    break;
                case 5:
                    xuatThongTinCacSinhVienCoHoLe(danhSachSinhVien);
                    break;
                case 0:
                    System.out.println("Ket thuc chuong trinh");
                    break;
                default:
                    System.out.println("<!> Lua chon khong hop le");
                    break;
            }
        } while (luaChon != 0);
    }
    public static void nhapDanhSachSinhVien(SinhVien[] danhSachSinhVien) {
        Scanner sc = new Scanner(System.in);
        // nhap
        System.out.println("----------Nhap danh sach sinh vien----------");
        for (int i = 0; i < danhSachSinhVien.length; i++) {
            System.out.println("Nhap thong tin sinh vien thu " + (i + 1));
            danhSachSinhVien[i] = new SinhVien();
            danhSachSinhVien[i].input();
        }
    }

    public static void xuatDanhSachSinhVien(SinhVien[] danhSachSinhVien) {
        // xuat
        System.out.println("----------Xuat danh sach sinh vien----------");
        for (int i = 0; i < danhSachSinhVien.length; i++) {
            System.out.println("Thong tin sinh vien thu " + (i + 1));
            danhSachSinhVien[i].output();
        }
    }

    public static void sapXepVaHienThiDanhSachTheoDiemTB(SinhVien[] danhSachSinhVien) {
        // sap xep
        System.out.println("----------Sap xep danh sach sinh vien theo diem trung binh----------");
        for (int i = 0; i < danhSachSinhVien.length - 1; i++) {
            for (int j = i + 1; j < danhSachSinhVien.length; j++) {
                if (danhSachSinhVien[i].getDiemTrungBinh() > danhSachSinhVien[j].getDiemTrungBinh()) {
                    SinhVien temp = danhSachSinhVien[i];
                    danhSachSinhVien[i] = danhSachSinhVien[j];
                    danhSachSinhVien[j] = temp;
                }
            }
        }
        xuatDanhSachSinhVien(danhSachSinhVien);
    }

    public static void timKiemSinhVienTheoTen(SinhVien[] danhSachSinhVien) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------Tim kiem sinh vien theo ten----------");
        System.out.print("Nhap ten sinh vien can tim: ");
        String tenSinhVienCanTim = sc.nextLine();
        boolean timThay = false;
        for (int i = 0; i < danhSachSinhVien.length; i++) {
            if (danhSachSinhVien[i].getFullname().equals(tenSinhVienCanTim)) {
                System.out.println("=> Thong tin sinh vien thu " + (i + 1));
                danhSachSinhVien[i].output();
                timThay = true;
            }
        }
        if (!timThay) {
            System.out.println("<!> Khong tim thay sinh vien co ten " + tenSinhVienCanTim);
        }
    }

    // xuất ra thông tin các sinh viên có họ là Lê
    public static void xuatThongTinCacSinhVienCoHoLe(SinhVien[] danhSachSinhVien) {
        System.out.println("----------Xuat thong tin cac sinh vien co ho la Le----------");
        for (int i = 0; i < danhSachSinhVien.length; i++) {
            if (danhSachSinhVien[i].getFullname().startsWith("Le") || danhSachSinhVien[i].getFullname().startsWith("Lê")) {
                System.out.println("=> Thong tin sinh vien thu " + (i + 1));
                danhSachSinhVien[i].output();
            }
        }
    }
}
