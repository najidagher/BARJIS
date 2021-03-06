/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smb215team.barjis.util;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * @author dinosaadeh
 */
public class Constants {
    // Visible game world is 5 meters wide
    public static final float VIEWPORT_WIDTH = 16f;
    // Visible game world is 5 meters tall
    public static final float VIEWPORT_HEIGHT = 9f;
    // Location of description file for texture atlas
   public static final String TEXTURE_ATLAS_OBJECTS = "BarjisPackFile.atlas";
 
   
   ///Later on we will be using configuration file (Ali is working on it.)
   public static final float[] borders = new float[]{//startx  ,starty ,dirx ,diry, movex, movey
                                                        -1.2f  ,0.6f   ,-1   ,-1    ,0.4f  ,0.8f,
                                                        -1f    ,-1.4f  ,1    ,-1    ,0.8f  ,0.4f,
                                                        0.9f   ,-1f    ,1    ,1     ,0.4f  ,0.8f,
                                                        0.6f   ,1      ,-1   ,1     ,0.8f  ,0.4f};
   public static final Vector2[] boardMap = new Vector2[]
    
        
    
    
       {
            //Bottom Branch
            //Bottom Branch - middle
         //   new Vector2(-0.1f,0.5f),
               ////1
           new Vector2(-1.2f, -1f),
            new Vector2(-1.6f, -1f),
            new Vector2(-2f, -1f),
            new Vector2(-2.4f, -1f),
            new Vector2(-2.8f, -1f),
            new Vector2(-3.2f, -1f),
            new Vector2(-3.6f, -1f),
            new Vector2(-4f, -1f),
            //Bottom Branch - right
             new Vector2(-1.2f, -0.2f),
            new Vector2(-1.6f, -0.2f),
            new Vector2(-2f, -0.2f),
            new Vector2(-2.4f, -0.2f),
            new Vector2(-2.8f, -0.2f),
            new Vector2(-3.2f, -0.2f),
            new Vector2(-3.6f, -0.2f),
            new Vector2(-4f, -0.2f),
            //Bottom Branch - left
             new Vector2(-1.2f, 0.6f),
            new Vector2(-1.6f, 0.6f),
            new Vector2(-2f, 0.6f),
            new Vector2(-2.4f, 0.6f),
            new Vector2(-2.8f, 0.6f),
            new Vector2(-3.2f, 0.6f),
            new Vector2(-3.6f, 0.6f),
            new Vector2(-4f, 0.6f),
            ////2
            new Vector2(-0.2f, -1.4f),
            new Vector2(-0.2f, -1.8f),
            new Vector2(-0.2f, -2.2f),
            new Vector2(-0.2f, -2.6f),
            new Vector2(-0.2f, -3f),
            new Vector2(-0.2f, -3.4f),
            new Vector2(-0.2f, -3.8f),
            new Vector2(-0.2f, -4.2f),
            //Bottom Branch - right
            new Vector2(0.6f, -4.2f),
            new Vector2(0.6f, -3.8f),
            new Vector2(0.6f, -3.4f),
            new Vector2(0.6f, -3f),
            new Vector2(0.6f, -2.6f),
            new Vector2(0.6f, -2.2f),
            new Vector2(0.6f, -1.8f),
            new Vector2(0.6f, -1.4f),
            //Bottom Branch - left
            new Vector2(-1f, -1.4f),
            new Vector2(-1f, -1.8f),
            new Vector2(-1f, -2.2f),
            new Vector2(-1f, -2.6f),
            new Vector2(-1f, -3f),
            new Vector2(-1f, -3.4f),
            new Vector2(-1f, -3.8f),
            new Vector2(-1f, -4.2f),
             
  
           
             ////3
           new Vector2(0.9f, -1f),
            new Vector2(1.3f, -1f),
            new Vector2(1.7f, -1f),
            new Vector2(2.1f, -1f),
            new Vector2(2.5f, -1f),
            new Vector2(2.9f, -1f),
            new Vector2(3.3f, -1f),
            new Vector2(3.7f, -1f),
            //Bottom Branch - right
            new Vector2(0.9f, -0.2f),
            new Vector2(1.3f, -0.2f),
            new Vector2(1.7f, -0.2f),
            new Vector2(2.1f, -0.2f),
            new Vector2(2.5f, -0.2f),
            new Vector2(2.9f, -0.2f),
            new Vector2(3.3f, -0.2f),
            new Vector2(3.7f, -0.2f),
            //Bottom Branch - left
            new Vector2(0.9f, 0.6f),
            new Vector2(1.3f, 0.6f),
            new Vector2(1.7f, 0.6f),
            new Vector2(2.1f, 0.6f),
            new Vector2(2.5f, 0.6f),
            new Vector2(2.9f, 0.6f),
            new Vector2(3.3f, 0.6f),
            new Vector2(3.7f, 0.6f),
           //,  new Vector2(-0.1f,0.5f)
          /////4
            
            
            new Vector2(-0.2f, 1f),       
            new Vector2(-0.2f, 1.4f),
            new Vector2(-0.2f, 1.8f),
            new Vector2(-0.2f, 2.2f),
            new Vector2(-0.2f, 2.6f),
            new Vector2(-0.2f, 3f),
            new Vector2(-0.2f, 3.4f),
            new Vector2(-0.2f, 3.8f),
         
            //Bottom Branch - right
            
            new Vector2(0.6f, 3.8f),
            new Vector2(0.6f, 3.4f),
            new Vector2(0.6f, 3f),
            new Vector2(0.6f, 2.6f),
            new Vector2(0.6f, 2.2f),
            new Vector2(0.6f, 1.8f),
            new Vector2(0.6f, 1.4f),
            new Vector2(0.6f, 1f),
            //Bottom Branch - left
            new Vector2(-1f, 1f),
            new Vector2(-1f, 1.4f),
            new Vector2(-1f, 1.8f),
            new Vector2(-1f, 2.2f),
            new Vector2(-1f, 2.6f),
            new Vector2(-1f, 3f),
            new Vector2(-1f, 3.4f),
            new Vector2(-1f, 3.8f),
          
             
             //Right Branch
            //Right Branch - middle
            //Right Branch - right
            //Right Branch - left
            //Top Branch
            //Top Branch - middle
            //Top Branch - right
            //Top Branch - left
            //Left Branch
            //Left Branch - middle
            //Left Branch - right
            //Left Branch - left

    };

    // GUI Width
    public static final float VIEWPORT_GUI_WIDTH = 800.0f;
    // GUI Height
    public static final float VIEWPORT_GUI_HEIGHT = 480.0f;

    // <editor-fold desc="These are the boundaries of dice container for each side">
    /**
     * Left bottom side
     */
    public static final Rectangle DICES_CONTAINER_BORDER_TOP_SIDE01 = new Rectangle(-7.65f, 0f, 3.5f, 0.1f);
    public static final Rectangle DICES_CONTAINER_BORDER_BOTTOM_SIDE01 = new Rectangle(-7.65f, -4.5f, 3.5f, 0.1f);
    public static final Rectangle DICES_CONTAINER_BORDER_LEFT_SIDE01 = new Rectangle(-7.65f, -4.5f, 0.1f, 4.5f);
    public static final Rectangle DICES_CONTAINER_BORDER_RIGHT_SIDE01 = new Rectangle(-4.2f, -4.5f, 0.1f, 4.5f);

    /**
     * Right bottom side
     */
    public static final Rectangle DICES_CONTAINER_BORDER_TOP_SIDE02 = new Rectangle(4.1f, 0f, 3.6f, 0.1f);
    public static final Rectangle DICES_CONTAINER_BORDER_BOTTOM_SIDE02 = new Rectangle(4.1f, -4.5f, 3.6f, 0.1f);
    public static final Rectangle DICES_CONTAINER_BORDER_LEFT_SIDE02 = new Rectangle(4.1f, -4.5f, 0.1f, 4.5f);
    public static final Rectangle DICES_CONTAINER_BORDER_RIGHT_SIDE02 = new Rectangle(7.6f, -4.5f, 0.1f, 4.5f);
    // </editor-fold>

    private static class a<T0, T1> {
 
    }
}