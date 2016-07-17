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
      ////player function
      
      CellClass[] path =new CellClass[190];
      dummyPawnToFillMap = new Pawn[75]; 
        String cat[] = new String[]{"A","B","C","D"};
        int pcat=0; 
        int pcategorie=0;
        int cnt1=0; 
        
    for(int i = 0; i<=3; i++){
        for(int j=0;j<=2;j++)  {
            for(int z=0;z<=7;z++){       
                /////this condition is only valid for player=1 untill now
         if ((i==pcategorie && (j==1 ||j==2) ) || ((i!=pcategorie ) &&(j!=1 || z==7)) )
                /////this condition is only valid for player=1 untill now
              {      
                 Vector2 Vect =new Vector2(j/1f,z/1f);
                 path[cnt1] = new CellClass(cat[pcat],Vect);
                 
                 dummyPawnToFillMap[cnt1] = new Pawn();            
                 dummyPawnToFillMap[cnt1].position.set(path[cnt1].getposition(path[cnt1], "x")
                                               ,path[cnt1].getposition(path[cnt1], "y"));
                 
                  System.out.println("pcat "+pcat+" cnt= "+cnt1+ " x= "+path[cnt1].getposition(path[cnt1], "x")+""
                                                  + " y="+path[cnt1].getposition(path[cnt1], "y"));
                 cnt1=cnt1+1;
                }     
                                }
                               }
        pcat=pcat+1; if (pcat >3) {pcat=pcat-3;}        }    
       
                for(int w=0;w<=7;w++) { 
                Vector2 Vect =new Vector2(0/1f,w/1f);
                path[cnt1] = new CellClass(cat[0],Vect);
               int s=cnt1;
               
               dummyPawnToFillMap[cnt1] = new Pawn();            
                 dummyPawnToFillMap[cnt1].position.set(path[cnt1].getposition(path[cnt1], "x")
                                               ,path[cnt1].getposition(path[cnt1], "y"));
                 System.out.println("cnt= "+s+" x2nd= "
                                   +path[cnt1].getposition(path[cnt1], "x")+" y="
                                   +path[cnt1].getposition(path[cnt1], "y"));
                    cnt1=cnt1+1;}
                for(int h=cnt1;h<cnt1+8;h++)
                {
                 Vector2 Vect =new Vector2(0/1f,h/1f);
                path[h] = new CellClass(cat[0],Vect);
                
                 System.out.println("cnt= "+h+" x3rd= "
                                   +path[h].getposition(path[h], "x")+" y="
                                   +path[h].getposition(path[h], "y"));
                } 
     ////player function      
     /*
      dummyPawnToFillMap = new Pawn[96]; 
      CellClass[] cellarray = new CellClass[96];//creating 96 cell
    //  String cat[] = new String[]{"A","B","C","D"};//A-->Left ; B-->Bottom  ; C--> Right ;   D-->Top
      int cnt=0;
      for (int i= 0;i<=3;i++){  ///// pour les 4 categories
              for (int j=0;j<=2;j++){  ///pour les lignes/colones
                    for (int z=0;z<=7;z++){  ///pour les lignes/colones
        
            Vector2 V =new Vector2(j/1f,z/1f);////on cree le vecteur ligne colone. 
            cellarray[cnt] =new CellClass(cat[i],V);///on cree la classe cell contenant la categorie +le vecteur ligne/colone 
           dummyPawnToFillMap[cnt] = new Pawn();            
           dummyPawnToFillMap[cnt].position.set(cellarray[cnt].getposition(cellarray[cnt], "x")
                                               ,cellarray[cnt].getposition(cellarray[cnt], "y"));
  
          cnt =cnt+1;///represents the cell number from 0 till 95
   
                                           }
                                     } 
                               } 
       
      */
      
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
        //Player.playerpath(0);
        
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