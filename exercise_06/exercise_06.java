import java.util.Scanner;

public class exercise_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("**********Lua chon chuc nang cua lop MyMath**********");
            System.out.println("1. Tim uoc chung lon nhat cua 2 so thuc");
            System.out.println("2. Tim gia tri lon nhat cua 3 so thuc");
            System.out.println("3. Tim gia tri nho nhat cua 3 so thuc");
            System.out.println("4. Kiem tra 1 so co phai so nguyen to");
            System.out.println("5. Tinh tong day so tu 1 den n");
            System.out.println("0. Thoat");
            System.out.print("Lua chon chuc nang: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Nhap so nguyen a: ");
                    int a = scanner.nextInt();
                    System.out.print("Nhap so nguyen b: ");
                    int b = scanner.nextInt();
                    System.out.println("=> Uoc chung lon nhat cua " + a + " va " + b + " la: " + MyMath.ucln(a, b));
                    break;
                case 2:
                    System.out.print("Nhap so thuc a: ");
                    double a1 = scanner.nextDouble();
                    System.out.print("Nhap so thuc b: ");
                    double b1 = scanner.nextDouble();
                    System.out.print("Nhap so thuc c: ");
                    double c1 = scanner.nextDouble();
                    System.out.println("=> Gia tri lon nhat cua 3 so thuc la: " + MyMath.max(a1, b1, c1));
                    break;
                case 3:
                    System.out.print("Nhap so thuc a: ");
                    double a2 = scanner.nextDouble();
                    System.out.print("Nhap so thuc b: ");
                    double b2 = scanner.nextDouble();
                    System.out.print("Nhap so thuc c: ");
                    double c2 = scanner.nextDouble();
                    System.out.println("=> Gia tri nho nhat cua 3 so thuc la: " + MyMath.min(a2, b2, c2));
                    break;
                case 4:
                    System.out.print("Nhap so nguyen n: ");
                    int n = scanner.nextInt();
                    if (MyMath.isPrime(n)) {
                        System.out.println("=> " + n + " la so nguyen to");
                    } else {
                        System.out.println("=> " + n + " khong phai la so nguyen to");
                    }
                    break;
                case 5:
                    System.out.print("Nhap so nguyen n: ");
                    int n1 = scanner.nextInt();
                    System.out.println("=> Tong day so tu 1 den " + n1 + " la: " + MyMath.sum(n1));
                    break;
                case 0:
                    System.out.println("Ket thuc chuong trinh");
                    break;
                default:
                    System.out.println("<!> Khong tim thay chuc nang tuong ung");
                    break;
                }
            } while (choice != 0);
    }
}
