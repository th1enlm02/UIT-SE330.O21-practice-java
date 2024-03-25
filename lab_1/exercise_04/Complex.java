import java.util.Scanner;

public class Complex {
    private double phanThuc;
    private double phanAo;

    Complex() {};
    Complex (double phanThuc, double phanAo) {
        this.phanThuc = phanThuc;
        this.phanAo = phanAo;
    }

    // get & set methods
    public double getPhanThuc() {
        return phanThuc;
    }
    public void setPhanThuc(double phanThuc) {
        this.phanThuc = phanThuc;
    }
    public double getPhanAo() {
        return phanAo;
    }
    public void setPhanAo(double phanAo) {
        this.phanAo = phanAo;
    }

    // nhap & xuat
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("- Nhap phan thuc: ");
        phanThuc = sc.nextDouble();
        System.out.print("- Nhap phan ao: ");
        phanAo = sc.nextDouble();
    }
    public void xuat() {
        // xét phần ảo dương hay âm
        if (phanAo < 0) {
            System.out.println(phanThuc + " + " + "(" + phanAo + ")" + "i");
        } else {
            System.out.println(phanThuc + " + " + phanAo + "i");
        }
    }

    // cong, tru, nhan, chia 2 so phuc
    public Complex cong(Complex soPhuc) {
        Complex tong = new Complex();
        tong.phanThuc = phanThuc + soPhuc.phanThuc;
        tong.phanAo = phanAo + soPhuc.phanAo;
        return tong;
    }
    public Complex tru(Complex soPhuc) {
        Complex hieu = new Complex();
        hieu.phanThuc = phanThuc - soPhuc.phanThuc;
        hieu.phanAo = phanAo - soPhuc.phanAo;
        return hieu;
    }
    public Complex nhan(Complex soPhuc) {
        Complex tich = new Complex();
        tich.phanThuc = phanThuc * soPhuc.phanThuc - phanAo * soPhuc.phanAo;
        tich.phanAo = phanThuc * soPhuc.phanAo + phanAo * soPhuc.phanThuc;
        return tich;
    }
    public Complex chia(Complex soPhuc) {
        Complex thuong = new Complex();
        thuong.phanThuc = (phanThuc * soPhuc.phanThuc + phanAo * soPhuc.phanAo) / (Math.pow(soPhuc.phanThuc, 2) + Math.pow(soPhuc.phanAo, 2));
        thuong.phanAo = (phanAo * soPhuc.phanThuc - phanThuc * soPhuc.phanAo) / (Math.pow(soPhuc.phanThuc, 2) + Math.pow(soPhuc.phanAo, 2));
        return thuong;
    }
}