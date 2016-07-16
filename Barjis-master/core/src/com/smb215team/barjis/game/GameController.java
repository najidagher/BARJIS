/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smb215team.barjis.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;//for testing
import com.badlogic.gdx.audio.Sound;
import com.smb215team.barjis.game.objects.Dice;
import com.smb215team.barjis.game.objects.DiceContainer;
import com.smb215team.barjis.game.objects.Dices;
import com.smb215team.barjis.game.objects.Pawn;
import com.smb215team.barjis.util.Constants;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Vector2;
import com.smb215team.barjis.game.objects.Player;
import com.smb215team.barjis.screens.MenuScreen;
import java.lang.String;
import com.smb215team.barjis.util.CellClass;
/**
 *
 * @author dinosaadeh
 */
public class GameController {
    private static final String TAG = GameController.class.getName();
    private Game game;

    
    // <editor-fold desc="Dino: TO DELETE Dummy stuff">
    public float dummyTimerForThrowingDices = 0.0f;
    Pawn[] dummyPawnToFillMap;
    // </editor-fold>
    
    Player[] players;
    DiceContainer diceContainer;
    
    Sound diceSound = Gdx.audio.newSound(Gdx.files.internal("diceSound.mp3"));
    
    public GameController (Game game) {
        this.game = game;
        init();
    }
    
    private void init () {
        Dices.instance.init();
        initTestObjects();
    }
    
    private void initTestObjects() {
        // <editor-fold desc="Dino: TO DELETE Dummy pawn/dice">
        //dummyPawnToFillMap = new Pawn[2];
     dummyPawnToFillMap = new Pawn[24];
       
      //CellClass[][][] cellarray = new CellClass[4][3][8];
      CellClass[] cellarray = new CellClass[96];
      String cat[] = new String[]{"A","B","C","D"};
      int cnt=0;
      for (int i= 1;i<=1;i++){
          
     
    for (int j=1;j<=3;j++)
    {
    for (int z=1;z<=8;z++){
        
   // arr[0] = new Employee("Peter", 100);
   Vector2 V =new Vector2(i/1f,j/1f); 
         
      
   cellarray[0] =new CellClass(cat[i],V);
 
      dummyPawnToFillMap[cnt] = new Pawn(); 
           
           dummyPawnToFillMap[cnt].position.set(Constants.boardMap[cnt].x, Constants.boardMap[cnt].y);
  cnt =cnt+1;
   ////////we should know assign the  coordinates in the cellClass not in the constants
      }
   } 
   } 
      
     /*
         
      dummyPawnToFillMap[0] = new Pawn();
 dummyPawnToFillMap[0].position.set(-0.2f,-1.4f);
 
  dummyPawnToFillMap[1] = new Pawn();
   dummyPawnToFillMap[1].position.set(-0.2f,-1.8f);
    */
         
      /*
    for(int i = 0; i < dummyPawnToFillMap.length; i++) {
           dummyPawnToFillMap[i] = new Pawn(); 
           
           dummyPawnToFillMap[i].position.set(Constants.boardMap[i].x, Constants.boardMap[i].y);

        }  
      */
        // </editor-fold>

        diceContainer = new DiceContainer();  
    }
    
    public void update (float deltaTime) {
        handleDebugInput(deltaTime);
        Dices.instance.update(deltaTime); //commentToDelete: later on this will be called only when needed
        
        testCollisions ();

        // <editor-fold desc="Dino: Dummy timer to throw dices">
        dummyTimerForThrowingDices += deltaTime;
        if(dummyTimerForThrowingDices >= 5 && Dices.instance.canPlayerThrowDices) {
            Dices.instance.throwDices(diceContainer.diceMarginFromX, diceContainer.diceMarginToX, diceContainer.diceMarginFromY, diceContainer.diceMarginToY);
            diceSound.play();
            dummyTimerForThrowingDices -= 5.0f; // If you reset it to 0 you will loose a few milliseconds every 2 seconds.
            Gdx.app.log(TAG, Dices.instance.getValue());
        }
        // </editor-fold>
    }

    public void dispose() {
        diceSound.dispose();
    }
    
    private void handleDebugInput(float deltaTime) {
        if (Gdx.app.getType() != com.badlogic.gdx.Application.ApplicationType.Desktop) {
            return;
        }
// Selected Sprite Controls
        float sprMoveSpeed = 5 * deltaTime;
        if (Gdx.input.isKeyPressed(Keys.A)) {
            moveSelectedSprite(
                    -sprMoveSpeed, 0);
        }
        if (Gdx.input.isKeyPressed(Keys.D)) {
            moveSelectedSprite(sprMoveSpeed, 0);
        }
        if (Gdx.input.isKeyPressed(Keys.W)) {
            moveSelectedSprite(0,
                    sprMoveSpeed);
        }
        if (Gdx.input.isKeyPressed(Keys.S)) {
            moveSelectedSprite(0,
                    -sprMoveSpeed);
        }
    }

    private void backToMenu () {
        // switch to menu screen
        game.setScreen(new MenuScreen(game));
    }
    private void moveSelectedSprite(float x, float y) {
        //testSprites[selectedSprite].translate(x, y);
    }
    
    private void testCollisions () {
        // <editor-fold desc="TO DELETE: Test collision dummy dice with borders">
//        if (!diceContainer.borderTop.overlaps(dummyDice.bounds) && !diceContainer.borderBottom.overlaps(dummyDice.bounds) && !diceContainer.borderLeft.overlaps(dummyDice.bounds) && !diceContainer.borderRight.overlaps(dummyDice.bounds)) {
//            dummyDice.canCollideBorderTop = true;
//            dummyDice.canCollideBorderBottom = true;
//            dummyDice.canCollideBorderLeft = true;
//            dummyDice.canCollideBorderRight = true;
//            return;
//        }
//            if (diceContainer.borderTop.overlaps(dummyDice.bounds) && dummyDice.canCollideBorderTop){
//                dummyDice.collideWithWall(false, 't');
//            }
//            if (diceContainer.borderBottom.overlaps(dummyDice.bounds) && dummyDice.canCollideBorderBottom){
//                dummyDice.collideWithWall(false, 'b');
//            }
//            if (diceContainer.borderLeft.overlaps(dummyDice.bounds) && dummyDice.canCollideBorderLeft){
//                dummyDice.collideWithWall(true, 'l');
//            }
//            if (diceContainer.borderRight.overlaps(dummyDice.bounds) && dummyDice.canCollideBorderRight){
//                dummyDice.collideWithWall(true, 'r');
//            }
        // </editor-fold>
        // <editor-fold desc="Test collision: Dice <-> Dice borders">
        for (Dice dice : Dices.instance.dices) {
            if(null == dice)
                return;
            if (!diceContainer.borderTop.overlaps(dice.bounds) && !diceContainer.borderBottom.overlaps(dice.bounds) && !diceContainer.borderLeft.overlaps(dice.bounds) && !diceContainer.borderRight.overlaps(dice.bounds)) {
                dice.canCollideBorderTop = true;
                dice.canCollideBorderBottom = true;
                dice.canCollideBorderLeft = true;
                dice.canCollideBorderRight = true;
                continue;
            }
            if (diceContainer.borderTop.overlaps(dice.bounds) && dice.canCollideBorderTop){
                dice.collideWithWall(false, 't');
            }
            if (diceContainer.borderBottom.overlaps(dice.bounds) && dice.canCollideBorderBottom){
                dice.collideWithWall(false, 'b');
            }
            if (diceContainer.borderLeft.overlaps(dice.bounds) && dice.canCollideBorderLeft){
                dice.collideWithWall(true, 'l');
            }
            if (diceContainer.borderRight.overlaps(dice.bounds) && dice.canCollideBorderRight){
                dice.collideWithWall(true, 'r');
            }
        }
        // </editor-fold>
    }
}