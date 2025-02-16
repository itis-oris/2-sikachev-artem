package handler;

import config.DisplayConfig;
import config.GameConfig;
import entity.Starship;

public class MoveHandler {

    private KeyHandler keyH;

    public MoveHandler(KeyHandler keyH) {
        this.keyH = keyH;
    }

    public void handleMove(Starship starship){
        // Обновление позиции
        if (keyH.isUpPressed() && keyH.isLeftPressed()){
            starship.x -= GameConfig.STARSHIP_D_SPEED;
            starship.y -= GameConfig.STARSHIP_D_SPEED;
        } else if (keyH.isUpPressed() && keyH.isRightPressed()){
            starship.x += GameConfig.STARSHIP_D_SPEED;
            starship.y -= GameConfig.STARSHIP_D_SPEED;
        } else if (keyH.isDownPressed() && keyH.isLeftPressed()){
            starship.x -= GameConfig.STARSHIP_D_SPEED;
            starship.y += GameConfig.STARSHIP_D_SPEED;
        } else if (keyH.isDownPressed() && keyH.isRightPressed()){
            starship.x += GameConfig.STARSHIP_D_SPEED;
            starship.y += GameConfig.STARSHIP_D_SPEED;
        } else if (keyH.isUpPressed()) {
            starship.y -= GameConfig.STARSHIP_SPEED;
        } else if (keyH.isDownPressed()) {
            starship.y += GameConfig.STARSHIP_SPEED;
        } else if (keyH.isLeftPressed()) {
            starship.x -= GameConfig.STARSHIP_SPEED;
        } else if (keyH.isRightPressed()) {
            starship.x += GameConfig.STARSHIP_SPEED;
        }

        // Ограничение движения в пределах экрана
        inTheBox(starship);
        onSide(starship);
    }

    private void inTheBox(Starship starship){
        if (starship.x < 0) starship.x = 0;
        if (starship.x > DisplayConfig.SCREEN_WIDTH - starship.sprite.getWidth()) starship.x = DisplayConfig.SCREEN_WIDTH - starship.sprite.getWidth();
        if (starship.y < 0) starship.y = 0;
        if (starship.y > DisplayConfig.SCREEN_HEIGHT - starship.sprite.getHeight()) starship.y = DisplayConfig.SCREEN_HEIGHT - starship.sprite.getHeight();
    }

    private void onSide(Starship starship){
        if(starship.getIsHost()){
            if (starship.y <= DisplayConfig.SCREEN_HEIGHT/2) starship.y = DisplayConfig.SCREEN_HEIGHT/2;
        } else {
            if (starship.y >= DisplayConfig.SCREEN_HEIGHT/2) starship.y = DisplayConfig.SCREEN_HEIGHT/2;
        }
    }
}
