import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Jugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugador extends Actor
{
    private String nombre;
    private int puntaje;
    private int nivel;
    
    protected int posX;
    protected int posY;
    
    
    public Jugador()
    {
        puntaje = 0;
        nivel = 0;
    }
    public void actualizaPuntaje(int puntos)
    {
        puntaje = puntos;
    }
    
    public int getNivel()
    {
        return nivel;
    }
    
    public int getPuntaje()
    {
        return puntaje;
    }
    
    public void actualizaNivel(int nivel)
    {
        this.nivel = nivel;
    }
    
    public void actualizaNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
  
        public boolean isTouchingPelota(Jugador personaje)
    {
        return personaje.isTouching(Pelota.class);
    }
    
    public boolean isTouchingHelado(Jugador personaje)
    {
        return personaje.isTouching(Helado.class);
    }
    
    public List getObjectsAtOffsetHelados(int dx, int dy, Jugador personaje)
    {
        return personaje.getObjectsAtOffset(dx,dy, Helado.class);
        
    }
    
    
    /**
     * Act - do whatever the Jugador wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
