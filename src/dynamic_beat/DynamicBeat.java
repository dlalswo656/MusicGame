package dynamic_beat;

import javax.swing.*;
import java.awt.*;

public class DynamicBeat extends JFrame {

    private Image screenImage;
    private Graphics screenGraphic;
    private Image introBackground;

    public DynamicBeat() {
        setTitle("Dynamic Beat");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 1280 * 720 해상도
        setResizable(false);    // 게임창 사용자가 건드릴 수 없음
        setLocationRelativeTo(null); // 게임창 정중앙에 생기도록 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임 종료. 반드시 필요한 설정 안하면 창을 닫아도 프로그램 계속 실행
        setVisible(true);   // 게임창 보이게 true

        introBackground = new ImageIcon(Main.class.getResource("../images/main.jpg")).getImage();   // main 이미지 가져오기

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
        this.repaint();
    }

}
