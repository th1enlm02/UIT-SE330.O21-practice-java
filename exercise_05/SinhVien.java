import java.util.Scanner;

public class SinhVien implements Measurable {
    private String hoTen;
    private String mssv;
    private double diemToan;
    private double diemLy;
    private double diemHoa;
    private double diemTrungBinh;

    SinhVien() {}
    public SinhVien(String hoTen, String mssv, double diemToan, double diemLy, double diemHoa, double diemTrungBinh) {
        this.hoTen = hoTen;
        this.mssv = mssv;
        this.diemToan = diemToan;
        this.diemLy = diemLy;
        this.diemHoa = diemHoa;
        this.diemTrungBinh = diemTrungBinh;
    }

    // get & set methods
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public void setMssv(String mssv) {
        this.mssv = mssv;
    }
    public void setDiemToan(double diemToan) {
        this.diemToan = diemToan;
    }
    public void setDiemLy(double diemLy) {
        this.diemLy = diemLy;
    }
    public void setDiemHoa(double diemHoa) {
        this.diemHoa = diemHoa;
    }
    public void setDiemTrungBinh(double diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }
    public String getHoTen() {
        return this.hoTen;
    }
    public String getMssv() {
        return this.mssv;
    }
    public double getDiemToan() {
        return this.diemToan;
    }
    public double getDiemLy() {
        return this.diemLy;
    }
    public double getDiemHoa() {
        return this.diemHoa;
    }
    public double getDiemTrungBinh() {
        return this.diemTrungBinh;
    }

    // nhap & xuat
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("- Nhap ho ten: ");
        this.hoTen = sc.nextLine();
        System.out.print("- Nhap mssv: ");
        this.mssv = sc.nextLine();
        System.out.print("- Nhap diem toan: ");
        this.diemToan = sc.nextDouble();
        System.out.print("- Nhap diem ly: ");
        this.diemLy = sc.nextDouble();
        System.out.print("- Nhap diem hoa: ");
        this.diemHoa = sc.nextDouble();
    }

    public void xuat() {
        System.out.println("- Ho ten: " + this.hoTen);
        System.out.println("- Mssv: " + this.mssv);
        System.out.println("- Diem toan: " + this.diemToan);
        System.out.println("- Diem ly: " + this.diemLy);
        System.out.println("- Diem hoa: " + this.diemHoa);
        System.out.println("-> Diem trung binh: " + this.diemTrungBinh);
    }

    // tinh diem trung binh
    public double tinhDiemTrungBinh() {
        return Math.round((this.diemToan + this.diemLy + this.diemHoa) / 3 * 100.0) / 100.0;
    }

    @Override
    public double Valuate() {
        return  tinhDiemTrungBinh();
    }
}
