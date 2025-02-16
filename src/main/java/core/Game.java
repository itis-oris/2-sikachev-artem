package core;

import javax.swing.*;
import config.ServerConfig;

public class Game {
    private final GamePanel gamePanel;

    public Game(boolean isHost, String serverIp, String playerName) {
        this.gamePanel = new GamePanel(isHost, serverIp, ServerConfig.SERVER_PORT, playerName);
    }

    public Game(boolean isHost, String serverIp, int serverPort, String playerName) {
        this.gamePanel = new GamePanel(isHost, serverIp, serverPort, playerName);
    }

    public void start() {
        gamePanel.startThread();
    }

    public JPanel getPanel() {
        return gamePanel;
    }
}
