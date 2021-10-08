package fr.pgah;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Intro extends ApplicationAdapter {
  SpriteBatch batch;

  Texture[] imgs;
  int[] coordonneesX;
  int[] coordonneesY;
  int[] hauteursImgs;
  boolean[] montent;
  int hauteurFenetre;

  @Override
  public void create() {
    batch = new SpriteBatch();

    imgs = new Texture[2];
    imgs[0] = new Texture("sio.jpg");
    imgs[1] = new Texture("badlogic.jpg");

    coordonneesX = new int[2];
    coordonneesX[0] = 0;
    coordonneesX[1] = 100;

    coordonneesY = new int[2];
    coordonneesY[0] = 0;
    coordonneesY[1] = 100;

    hauteursImgs = new int[2];
    hauteursImgs[0] = imgs[0].getHeight();
    hauteursImgs[1] = imgs [1].getHeight();

    montent = new boolean[2];
    montent[0] = true;
    montent[1] = false;

    hauteurFenetre= Gdx.graphics.getHeight(); // appel de méthode
  }
  @Override
  public void render() {
    reinitialiserBackground();
    testerBordures();
    majCoordonnees();
    dessiner();
  }
  private void dessiner(){
      batch.begin();

      for (int i = 0; i <= 1; i++) {
        batch.draw(imgs[i], coordonneesX[i], coordonneesY[i]);
      }

      batch.end();
    }
    private void majCoordonnees(){
     for (int i = 0; i <= 1; i++) {
      coordonneesX[i] = coordonneesX[i] + 1;
       if (montent[i]){
         coordonneesY[i] = coordonneesY[i] + 1;
       } else {
         coordonneesY[i] = coordonneesY[i] - 1;
        }
      }
      
    }
    private void testerBordures() {
      for (int i= 0; i<=1; i++){
        if (coordonneesY[i] + hauteursImgs[i] == hauteurFenetre){
          montent[i] = false;
        }
  
        if (coordonneesY[i] == 0) {
          montent[i] = true;
        }
      }
    }
    public void reinitialiserBackground(){
      ScreenUtils.clear(1,0,0,1);
    }
  }

