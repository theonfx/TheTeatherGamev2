import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuCreditos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuCreditos extends Menu
{
    //GreenfootSound credsound = new GreenfootSound("lastgoodbye.mp3");
    private Objeto atras;
    /**
     * Constructor for objects of class MenuAyuda.
     * 
     */
    public MenuCreditos()
    {
        atras = new Atras();
        atras.posX = 70;
        atras.posY = 570;
        
        addObject(atras, atras.posX, atras.posY);
        
    }
    
    public void act()
    {
        //Menu.principal.menusound.stop();
        //if(!credsound.isPlaying()) credsound.play();
    }
}
