import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuAyuda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuAyuda extends Menu
{
    private Objeto atras;
    /**
     * Constructor for objects of class MenuAyuda.
     * 
     */
    public MenuAyuda()
    {
        atras = new Atras();
        atras.posX = 70;
        atras.posY = 570;
        
        addObject(atras, atras.posX, atras.posY);
    }
}
