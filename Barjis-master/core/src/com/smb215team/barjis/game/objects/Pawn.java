/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smb215team.barjis.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.smb215team.barjis.game.Assets;
import static java.lang.Math.abs;
import static jdk.nashorn.internal.objects.NativeMath.round;
/**
 *
 * @author dinosaadeh
 */
public class Pawn extends AbstractGameObject {

    private static final String TAG = Dices.class.getName();
     public static final Pawn instance = new Pawn();
    private TextureRegion pawnImage ;
    
    public Pawn () {
        init();
    }
    
    public void init () {
        dimension.set(0.45f, 0.45f);
        pawnImage = Assets.instance.pawn.pawn;
     
        // Set physics values
     //   velocity.set(3.0f, 4.0f);
      //  terminalVelocity.set(3.0f, 4.0f);
        //friction.set(12.0f, 0.0f);
    //    acceleration.set(0.0f, 25.0f);
        
        // Set bounding box for collision detection
        bounds.set(0, 0, dimension.x, dimension.y);
    }
    public void SetPosition (int v,float x,float y,int p ) { 
      if (p==1) {
          float xpos = getposx();
          float ypos = getposy();
          float xposnew=xpos;
          float yposnew=ypos;
          float horz =0.35f;        //----horizantal -1.3 -0.2 (- 0.35,0 )
          float vert =0.40f;        //----vertical -0.2 1 ( +0, +0.4 )
          float horzsign;
          float vertsign;
          float vertsignup,horzsignleft;
            
           for (int i = 1; i <= v; i++){
          
          if (xposnew<=0 ) {  horzsign =-1;}  else {  horzsign =1;}
          if (yposnew>=-0.2f ) {horzsignleft = 1;}  else {  horzsignleft =+1;}
          if (yposnew<0 ) {  vertsign =1;}  else {  vertsign =-1;}
          if (xposnew<=0 ) {  vertsignup =-1;}  else {  vertsignup =1;}
          
          float coefx = horzsign * horzsignleft;
          float coefy = vertsign * vertsignup;
          
            if (xposnew==0f && yposnew==0f){
                      xposnew=-1.3f+horz;
                      yposnew=-0.25f;
                  }
            
              if ( yposnew >=-1 && yposnew <=1)
              {  
                  
                     if (abs(xposnew + (horz*coefx)) < 3.75f )
                      {   xposnew=xposnew +(horz*coefx); }
                     else 
                         
                       { if(round(xposnew,2) == -3.75f)
                           {yposnew = yposnew -(0.2f*horzsignleft);   horzsignleft =horzsignleft*-1;}
                       }
                      
                       } 
               }
           
             
                  position.set(xposnew, yposnew);
      }
     } 
    
    
    public float getposx(){
        float x = position.x;
        return x;
    }
    
    
    
    public float getposy(){
        float y = position.y;
        return y;
    }
    
    
    @Override
    public void render(SpriteBatch batch) {
        batch.draw(pawnImage.getTexture(), position.x, position.y, origin.x, origin.y, dimension.x, dimension.y, scale.x, scale.y,
         rotation, pawnImage.getRegionX(), pawnImage.getRegionY(), pawnImage.getRegionWidth(), pawnImage.getRegionHeight(), false, false);
        
        
    }
}