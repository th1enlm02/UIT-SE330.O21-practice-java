import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class exercise_11 extends JPanel {
    private final int NUM_STARS = 25;
    private final int STAR_SIZE = 50;
    private final int ROTATION_STEP = 360 / NUM_STARS;

    public exercise_11() {
        setPreferredSize(new Dimension(1000, 600));
        setBackground(Color.BLACK);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Lấy kích thước của JPanel
        int width = getWidth();
        int height = getHeight();

        // Thiết lập gốc tọa độ ở chính giữa JPanel
        g2d.translate(width / 2, height / 2);

        // Vẽ 20 ngôi sao
        for (int i = 0; i < NUM_STARS; i++) {
            drawStar(g2d, i * ROTATION_STEP, STAR_SIZE);
        }
    }

    private void drawStar(Graphics2D g2d, int angle, int size) {
        // Lấy màu ngẫu nhiên
        Color color = getRandomColor();
        g2d.setColor(color);

        // Xác định tọa độ và góc quay của ngôi sao
        int x = (int) (size * Math.cos(Math.toRadians(angle)));
        int y = (int) (size * Math.sin(Math.toRadians(angle)));
        int rotationAngle = angle + 90;

        // Vẽ ngôi sao
        g2d.rotate(Math.toRadians(rotationAngle));
        drawRegularStar(g2d, x, y, size);
        g2d.rotate(-Math.toRadians(rotationAngle));
    }

    private void drawRegularStar(Graphics2D g2d, int x, int y, int size) {
        int[] xPoints = new int[10];
        int[] yPoints = new int[10];
        double angle = Math.PI / 5;
        double goldenRatio = 2 / (3 + Math.sqrt(5));

        for (int i = 0; i < 10; i++) {
            double radius = size * (i % 2 == 0 ? 1 : goldenRatio);
            xPoints[i] = (int) (x + radius * Math.cos(i * angle));
            yPoints[i] = (int) (y + radius * Math.sin(i * angle));
        }

        g2d.fillPolygon(xPoints, yPoints, 10);
    }

    private Color getRandomColor() {
        Random random = new Random();
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Stars");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new exercise_11());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
