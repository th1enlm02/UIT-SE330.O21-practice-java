public class MyMath {
    // ucln
    public static int ucln(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 || b == 0) {
            return a + b;
        }
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }
    
    // tim gia tri lon nhat cua 3 so thuc
    public static double max(double a, double b, double c) {
        double max = a;
        if (max < b) {
            max = b;
        }
        if (max < c) {
            max = c;
        }
        return max;
    }

    // tim gia tri nho nhat cua 3 so thuc
    public static double min(double a, double b, double c) {
        double min = a;
        if (min > b) {
            min = b;
        }
        if (min > c) {
            min = c;
        }
        return min;
    }

    // kiem tra 1 so co phai so nguyen to
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // tinh tong day so tu 1 den n
    public static int sum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    // tinh tri tuyet doi cua 1 so nguyen
    public static int abs(int n) {
        if (n < 0) {
            return -n;
        }
        return n;
    }

    // lam tron 1 so thuc
    public static double round(double n) {
        return Math.round(n);
    }
}