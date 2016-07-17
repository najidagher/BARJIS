/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smb215team.barjis.util;

import com.badlogic.gdx.math.Vector2;
import java.util.HashMap;

/**
 *
 * @author user
 */
public class CellClass {
   
        public   Vector2 VectorMap = new Vector2();
        public   String BoardSide = new String()  ; 
     
   public CellClass(String BoardSide, Vector2 VectorMap) {
   this.BoardSide=BoardSide;////la categorie (Left, Bottom, Right, Top )
   this.VectorMap=VectorMap;////le vecteur contenant la ligne et la colone
   
   }
  
   public float getposition(CellClass s,String coord)
   { 
       //Vector2 Vreturn =new Vector2();
       String catcell = s.BoardSide; ///La categorie
       Vector2 vcell = s.VectorMap;///le vecteur ligne colone
       float startX,startY,PosX,PosY,ligne,colone,dirX,dirY;
       float boarderX;
       float boarderY;
       String coordxy=coord;//pour savoir si on cherche x our y
       float Vreturn;
       int catnum=0; /// A est la categorie par Default
       if (catcell =="A")
           {catnum=0;} /// pour chercher les parametres de la Class Constants.
       if (catcell =="B")
           {catnum=6;} /// pour chercher les parametres de la Class Constants.
       if (catcell =="C")
           {catnum=12;}/// pour chercher les parametres de la Class Constants.
       if (catcell =="D")
           {catnum=18;}/// pour chercher les parametres de la Class Constants.
    if (catnum ==0 || catnum ==12) ///pour A et C les lignes < Colones
    {
      ligne=vcell.x;
      colone=vcell.y;
    }
    else ///Pour B et D les colones <  lignes
    { colone=vcell.x;
      ligne=vcell.y;}
      ////0.9f,-1f,1,1,0.4f,0.8f,
      boarderX =Constants.borders[catnum]; //X de la premiere Cell de la categorie A00 par exemple
      boarderY =Constants.borders[catnum+1];//Y de la premiere Cell de la categorie A00 par exemple
      dirX     =Constants.borders[catnum+2];///si x varie positivement vers la droite ou negativement vers la gauche
      dirY     =Constants.borders[catnum+3];///si y varie positivement vers le haut ou negativement vers le bas
     PosX =boarderX + ( colone * dirX * Constants.borders[catnum+4]);
     PosY =boarderY + ( ligne  * dirY * Constants.borders[catnum+5]);
     Vreturn =0f;
  
     if (coordxy=="x") 
     {Vreturn =PosX;}
     else
     {Vreturn =PosY;}
   
       return (Vreturn);
   
   } 
}



      