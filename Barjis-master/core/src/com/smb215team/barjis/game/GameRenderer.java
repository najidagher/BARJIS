/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smb215team.barjis.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.smb215team.barjis.util.Constants;
import com.smb215team.barjis.game.objects.*;
/**
 *
 * @author dinosaadeh
 */
public class GameRenderer implements Disposable {
    private OrthographicCamera camera;
    private OrthographicCamera cameraGUI;
    private SpriteBatch batch;
    private GameController gameController;
    public float Xsize =9;
    public float Ysize= 9;
    
    ShapeRenderer dummyShapeRenderer = new ShapeRenderer();
    
    public GameRenderer (GameController gameController) {
        this.gameController = gameController;
        init();
    }
    
    private void init () {
        batch = new SpriteBatch();
        
        camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        camera.position.set(0, 0, 0);
        camera.update();
        
        cameraGUI = new OrthographicCamera(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT);
        cameraGUI.position.set(0, 0, 0);
        cameraGUI.setToOrtho(true); // flip y-axis
        cameraGUI.update();
    }
    
    public void render () {
        renderTestObjects();
        renderGui(batch);
    }
    
    public void resize (int width, int height) {
        camera.viewportWidth = (Constants.VIEWPORT_HEIGHT / height) * width;
        camera.update();
        
        cameraGUI.viewportHeight = Constants.VIEWPORT_GUI_HEIGHT;
        cameraGUI.viewportWidth = (Constants.VIEWPORT_GUI_HEIGHT / (float)height) * (float)width;
        cameraGUI.position.set(cameraGUI.viewportWidth / 2, cameraGUI.viewportHeight / 2, 0);
        cameraGUI.update();
    }
    
    @Override public void dispose () {
        batch.dispose();
    }
   
    private void renderTestObjects() {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        
        // <editor-fold desc="Dino: might lose this. I want to put the board on the screen to see how it looks in terms of dimensions and to throw my dices in a transparently delimited region">
        Sprite boardSprite = new Sprite(Assets.instance.board.board);
        boardSprite.setSize(Xsize,Ysize);
        boardSprite.setCenter(0, 0);
        boardSprite.draw(batch);
        // </editor-fold>

        gameController.dummyPawn.render(batch);
        gameController.dummyDice.render(batch);
        Dices.instance.render(batch);
    //    Pawn.instance.render(batch);
        batch.end();
       
        // <editor-fold desc="FOR DEBUGGING: drawing borders of dices to test collision">
//        dummyShapeRenderer.setProjectionMatrix(camera.combined);
//        dummyShapeRenderer.begin(ShapeType.Line);
//        dummyShapeRenderer.setColor(1, 1, 0, 1);
//        dummyShapeRenderer.rect(-7.65f, 0f, 3.5f, 0.1f);//top border
//        dummyShapeRenderer.rect(-7.65f, -4.5f, 3.5f, 0.1f);//bottom border
//        dummyShapeRenderer.rect(-7.65f, -4.5f, 0.1f, 4.5f);//left border
//        dummyShapeRenderer.rect(-4.2f, -4.5f, 0.1f, 4.5f);//right border
        
//        dummyShapeRenderer.rect(4.1f, 0f, 3.6f, 0.1f);//top border
//        dummyShapeRenderer.rect(4.1f, -4.5f, 3.6f, 0.1f);//bottom border
//        dummyShapeRenderer.rect(4.1f, -4.5f, 0.1f, 4.5f);//left border
//        dummyShapeRenderer.rect(7.6f, -4.5f, 0.1f, 4.5f);//right border
//        dummyShapeRenderer.end();

//        for(Dice dice : Dices.instance.dices){
//            if(null == dice)
//                continue;
//            dummyShapeRenderer.begin(com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Line);
//            dummyShapeRenderer.setColor(1, 1, 0, 1);
//            dummyShapeRenderer.rect(dice.bounds.x, dice.bounds.y, dice.bounds.width, dice.bounds.height);
//            dummyShapeRenderer.end();
//        }
        // </editor-fold>
    }
    
    private void renderGui (SpriteBatch batch) {
        batch.setProjectionMatrix(cameraGUI.combined);
        batch.begin();
        renderGuiMovesToBePlayed(batch);
        // draw FPS text (anchored to bottom right edge)
        renderGuiFpsCounter(batch);
        batch.end();
    }

    private void renderGuiMovesToBePlayed (SpriteBatch batch) {
        float x = -15;
        float y = -15;
        Assets.instance.fonts.defaultNormal.draw(batch, "" + Dices.instance.getValue(), x + 75, y + 37);
       
        Assets.instance.fonts.defaultNormal.draw(batch, " "+Dices.instance.getMsg(), 50, 60);
         
         
        
         Assets.instance.fonts.defaultNormal.draw(batch, "x= " + gameController.dummyPawn.getposx()  + " y= "+ gameController.dummyPawn.getposy() ,  75,  37);
//Assets.instance.fonts.defaultNormal.draw(batch, "x= " +  Dices.instance.getValuef() ,  75,  37);
    }
    
    private void renderGuiFpsCounter (SpriteBatch batch) {
        float x = cameraGUI.viewportWidth - 55;
        float y = cameraGUI.viewportHeight - 15;
        int fps = Gdx.graphics.getFramesPerSecond();
        BitmapFont fpsFont = Assets.instance.fonts.defaultNormal;
        if (fps >= 45) {
            // 45 or more FPS show up in green
            fpsFont.setColor(0, 1, 0, 1);
        } else if (fps >= 30) {
            // 30 or more FPS show up in yellow
            fpsFont.setColor(1, 1, 0, 1);
        } else {
            // less than 30 FPS show up in red
            fpsFont.setColor(1, 0, 0, 1);
        }
        fpsFont.draw(batch, "FPS: " + fps, x, y);
        fpsFont.setColor(1, 1, 1, 1); // white
    }
}