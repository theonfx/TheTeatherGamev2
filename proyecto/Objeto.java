import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Objeto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Objeto extends Actor
{
    protected int posX;
    protected int posY;
    
    /**
     * Act - do whatever the Objeto wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void Mueve(int posX, int posY)
    {
        
    }
    
    public void Gira(int Dir, int Dis)
    {
    }
    
    public boolean isTouchingPelota(Objeto personaje)
    {
        return personaje.isTouching(Pelota.class);
    }
    
    public boolean isTouchingHelado(Objeto personaje)
    {
        return personaje.isTouching(Helado.class);
    }
    
    public List getObjectsAtOffsetHelados(int dx, int dy, Objeto personaje)
    {
        return personaje.getObjectsAtOffset(dx,dy, Helado.class);
        
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
