import java.awt.Color;

public class Game {
    Player player;
    GameFrame frame;

    Game(GameFrame frame) {
        this.frame = frame;
        initEntities();
    }

    void run() {
        while(true) {
            if(frame.active) {
                makeMoves();
                detectCollisions();
                render();
            }
            delay();
        }
    }

    void initEntities() {
        player = new Player(30, 550, 3);
    }

    void makeMoves() {
        player.move();
    }

    void detectCollisions() {}

    void render() {
        frame.render();
        player.render(frame.graphics);


        frame.repaint();
    }

    void delay() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {}
    }
}

