import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MainWindow extends JFrame {

    private DrawPanel drawingPanel = new DrawPanel();

    public MainWindow(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int WIDTH = 1100;
        int HEIGHT = 900;
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setLayout(null);

        drawingPanel.setBounds(0, 0, WIDTH, 560);
        add(drawingPanel);

        JButton stepByStepButton = new JButton("Нарисовать линии");
        stepByStepButton.setBounds(260, 570, 200, 40);
        stepByStepButton.addActionListener(e -> {
            drawingPanel.drawLines(lines);
        });
        add(stepByStepButton);

        JButton drawPolygon = new JButton("Нарисовать полигон");
        drawPolygon.setBounds(20, 570, 200, 40);
        drawPolygon.addActionListener(e -> {
            drawingPanel.drawPolygon(polygon);
        });
        add(drawPolygon);

        JButton CDAButton = new JButton("Нарисовать прямоугольник");
        CDAButton.setBounds(260, 620, 200, 40);
        CDAButton.addActionListener(e -> {
            drawingPanel.drawRectangle(rectangle);
        });
        add(CDAButton);


        JButton clearButton = new JButton("Очистить");
        clearButton.setBounds(260, 770, 200, 40);
        clearButton.addActionListener(e -> {
            drawingPanel.drawLines(new ArrayList<>());
                    drawingPanel.drawRectangle(new ArrayList<>());
                            drawingPanel.drawPolygon(new ArrayList<>());
        });
        add(clearButton);

        setResizable(false);
    }

    static int n, m;
    static ArrayList<ArrayList<Integer>> lines = new ArrayList<>();
    static ArrayList<Integer> rectangle = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> polygon = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        lines.add(new ArrayList<>());
        lines.get(0).addAll(Arrays.asList(0, 0, 4, 8));
        lines.add(new ArrayList<>());
        lines.get(1).addAll(Arrays.asList(-10, -4, 0, 4));
        lines.add(new ArrayList<>());
        lines.get(2).addAll(Arrays.asList(-3, -7, -3, 7));
        lines.add(new ArrayList<>());
        lines.get(3).addAll(Arrays.asList(-7, -1, 7, -1));
        lines.add(new ArrayList<>());
        lines.get(4).addAll(Arrays.asList(3, -7, 3, 7));


        rectangle = new ArrayList<>();
        rectangle.addAll(Arrays.asList(-5, -4, 4, 4));

        polygon.add(new ArrayList<>());
        polygon.get(0).addAll(Arrays.asList(-5, 8, 6, -3));
        polygon.add(new ArrayList<>());
        polygon.get(1).addAll(Arrays.asList(6, -3, -12, -3));
        polygon.add(new ArrayList<>());
        polygon.get(2).addAll(Arrays.asList(-12, -3, -5, 8));

        MainWindow mainWindow = new MainWindow();
        mainWindow.repaint();
    }
}
