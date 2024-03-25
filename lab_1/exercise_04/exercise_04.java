import java.util.Scanner;

public class exercise_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // viết chương trình nhập, xuất, cộng, trừ, nhân, chia số phức
        Complex soPhuc1 = new Complex();
        Complex soPhuc2 = new Complex();
        System.out.println("-> Nhap so phuc thu nhat: ");
        soPhuc1.nhap();
        System.out.println("-> Nhap so phuc thu hai: ");
        soPhuc2.nhap();
        System.out.print("-> So phuc thu nhat: ");
        soPhuc1.xuat();
        System.out.print("-> So phuc thu hai: ");
        soPhuc2.xuat();
        System.out.print("-> Tong 2 so phuc: ");
        soPhuc1.cong(soPhuc2).xuat();
        System.out.print("-> Hieu 2 so phuc: ");
        soPhuc1.tru(soPhuc2).xuat();
        System.out.print("-> Tich 2 so phuc: ");
        soPhuc1.nhan(soPhuc2).xuat();
        System.out.print("-> Thuong 2 so phuc: ");
        soPhuc1.chia(soPhuc2).xuat();
    }
}