import java.util.Scanner;

public class NgayThang {
    private int ngay;
    private int thang;
    private int nam;
    
    NgayThang() {};
    public NgayThang(int ngay, int thang, int nam) {
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
    }
    
    public String toString() {
        return ngay + "/" + thang + "/" + nam;
    }

    // set & get methods
    public void setNgay(int ngay) {
        this.ngay = ngay;
    }
    public int getNgay() {
        return ngay;
    }
    public void setThang(int thang) {
        this.thang = thang;
    }
    public int getThang() {
        return thang;
    }
    public void setNam(int nam) {
        this.nam = nam;
    }
    public int getNam() {
        return nam;
    }

    // nhap
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("+ Nhap ngay: ");
        ngay = sc.nextInt();
        System.out.print("+ Nhap thang: ");
        thang = sc.nextInt();
        System.out.print("+ Nhap nam: ");
        nam = sc.nextInt();
    }
}
