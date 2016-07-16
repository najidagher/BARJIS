/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smb215team.barjis.util;

import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author user
 */
public class CellClass {
   
        public   Vector2 VectorMap = new Vector2();
    public   String BoardSide = new String()  ;
    
     
   public CellClass(String BoardSide, Vector2 VectorMap) {
   this.BoardSide=BoardSide;
   this.VectorMap=VectorMap;
   
   }
  
   public float getXposition()
   {return 0f;}
   
}



        /* {
            //Bottom Branch
            //Bottom Branch - middle
            new Vector2(-0.2f, -1.4f),             new Vector2(-0.2f, -1.8f),             new Vector2(-0.2f, -2.2f),
            new Vector2(-0.2f, -2.6f),             new Vector2(-0.2f, -3f),             new Vector2(-0.2f, -3.4f),
            new Vector2(-0.2f, -3.8f),             new Vector2(-0.2f, -4.2f),
//Bottom Branch - right
            new Vector2(0.6f, -4.2f),            new Vector2(0.6f, -3.8f),            new Vector2(0.6f, -3.4f),
            new Vector2(0.6f, -3f),            new Vector2(0.6f, -2.6f),            new Vector2(0.6f, -2.2f),
            new Vector2(0.6f, -1.8f),            new Vector2(0.6f, -1.4f),
//Bottom Branch - left
            new Vector2(-1f, -1.4f),            new Vector2(-1f, -1.8f),            new Vector2(-1f, -2.2f),
            new Vector2(-1f, -2.6f),            new Vector2(-1f, -3f),            new Vector2(-1f, -3.4f),
            new Vector2(-1f, -3.8f),            new Vector2(-1f, -4.2f)
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

    };*/
