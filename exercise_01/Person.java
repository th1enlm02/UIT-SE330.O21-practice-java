import java.util.Scanner;

public class Person {
    private String hoten;
    private int tuoi;
    private String diaChi;

    Person() {};
    Person(String hoten, int tuoi, String diaChi) {
        this.hoten = hoten;
        this.tuoi = tuoi;
        this.diaChi = diaChi;
    }
    protected void display() {
        System.out.println("- Ho ten: " + hoten);
        System.out.println("- Tuoi: " + tuoi);
        System.out.println("- Dia chi: " + diaChi);
    }
    protected void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("- Nhap ho ten: ");
        hoten = sc.nextLine();
        System.out.print("- Nhap tuoi: ");
        tuoi = sc.nextInt();
        sc.nextLine();
        System.out.print("- Nhap dia chi: ");
        diaChi = sc.nextLine();
    }
}