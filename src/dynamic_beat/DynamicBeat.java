package dynamic_beat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DynamicBeat extends JFrame {

    private Image screenImage;
    private Graphics screenGraphic;
    private Image introBackground = new ImageIcon(Main.class.getResource("../images/main.jpg")).getImage();   // main 이미지 가져오기;

    private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));   // main 이미지 가져오기;
    private ImageIcon exitButtonEvent = new ImageIcon(Main.class.getResource("../images/exitButton.png"));   // main 이미지 가져오기;
    private JButton exitButton = new JButton(exitButtonEvent);   // main 이미지 가져오기;

    private int mouseX, mouseY;

    public DynamicBeat() {
        setUndecorated(true);
        setTitle("Dynamic Beat");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 1280 * 720 해상도
        setResizable(false);    // 게임창 사용자가 건드릴 수 없음
        setLocationRelativeTo(null); // 게임창 정중앙에 생기도록 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임 종료. 반드시 필요한 설정 안하면 창을 닫아도 프로그램 계속 실행
        setVisible(true);   // 게임창 보이게 true
        setBackground(new Color(0, 0, 0, 0));
        setLayout(null);

        exitButton.setBounds(1245, 0, 30, 30);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitButton.setIcon(exitButtonEvent);
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }
            @Override
            public void mouseExited(MouseEvent e) {
                exitButton.setIcon(exitButtonEvent);
                exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

            }
            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
        });
        add(exitButton);

        menuBar.setBounds(0, 0, 1280, 30);
        menuBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
        menuBar.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - mouseX, y - mouseY);
            }
        });
        add(menuBar);

        Music mainMusic = new Music("apt.mp3", true);
        mainMusic.start();
    }

    // 프로그램 해상도에 맞는 이미지 맞춤
    public void paint(Graphics g) {
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage, 0, 0, null);
    }

    public void screenDraw(Graphics g) {
        g.drawImage(introBackground, 0, 0, null);
        paintComponents(g);
        this.repaint();
    }

}
