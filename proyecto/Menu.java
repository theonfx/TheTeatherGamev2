import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    public static MenuPrincipal principal = new MenuPrincipal();
    public static MenuRecords records = new MenuRecords();
    public static MenuAyuda ayuda = new MenuAyuda();
    public static MenuCreditos creditos = new MenuCreditos();
    
    /**
     * Constructor for objects of class Menus.
     * 
     */
    public Menu()
    {
        super(800, 600, 1); 
        //Greenfoot.setWorld(principal);
    }
    
}
