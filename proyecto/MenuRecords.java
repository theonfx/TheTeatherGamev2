import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuRecords here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuRecords extends Menu
{
    private Objeto atras;
    private ScoreBoard scores;
    /**
     * Constructor for objects of class MenuRecords.
     * 
     */
    public MenuRecords()
    {
        atras = new Atras();
        atras.posX = 70;
        atras.posY = 570;
        
        addObject(atras, atras.posX, atras.posY);
        
        scores = new ScoreBoard(800,400);
        addObject(scores, 400, 300);
    }
}
