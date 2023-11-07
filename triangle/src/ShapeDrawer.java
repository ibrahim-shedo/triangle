import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.function.Consumer;

public class ShapeDrawer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Shape Drawer!");
        System.out.println("Choose a shape to display:");
        System.out.println("1. Triangle");
        System.out.println("2. Rectangle");
        System.out.println("3. Circle");
        System.out.print("Enter your choice (1/2/3): ");
        
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                drawTriangle();
                break;
            case 2:
                drawRectangle();
                break;
            case 3:
                drawCircle();
                break;
            default:
                System.out.println("Invalid choice. Please choose 1, 2, or 3.");
        }
    }
    
    private static void drawTriangle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You've chosen to draw a triangle.");
        System.out.print("Enter the base length: ");
        int base = scanner.nextInt();
        System.out.print("Enter the height: ");
        int height = scanner.nextInt();
        
        if (base <= 0 || height <= 0) {
            System.out.println("Invalid dimensions. Both base and height must be positive.");
        } else {
            drawShape(g -> {
                int[] xPoints = {200, 200 + base, 200 + (base / 2)};
                int[] yPoints = {300, 300, 300 - height};
                g.setColor(Color.blue);
                g.fillPolygon(xPoints, yPoints, 3);
            });
        }
    }
    
    private static void drawRectangle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You've chosen to draw a rectangle.");
        System.out.print("Enter the width: ");
        int width = scanner.nextInt();
        System.out.print("Enter the height: ");
        int height = scanner.nextInt();
        
        if (width <= 0 || height <= 0) {
            System.out.println("Invalid dimensions. Both width and height must be positive.");
        } else {
            drawShape(g -> {
                g.setColor(Color.green);
                g.fillRect(200, 300 - height, width, height);
            });
        }
    }
    
    private static void drawCircle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You've chosen to draw a circle.");
        System.out.print("Enter the radius: ");
        int radius = scanner.nextInt();
        
        if (radius <= 0) {
            System.out.println("Invalid radius. Radius must be positive.");
        } else {
            drawShape(g -> {
                g.setColor(Color.red);
                g.fillOval(200 - radius, 300 - radius, 2 * radius, 2 * radius);
            });
        }
    }

    private static void drawShape(Consumer<Graphics> drawFunction) {
        JFrame frame = new JFrame("Shape Drawer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawFunction.accept(g);
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }
}
