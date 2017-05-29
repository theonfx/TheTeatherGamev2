import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Atras here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Atras extends Objeto
{
    /**
     * Act - do whatever the Atras wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        click();// Add your action code here.
    }    
    public void click()
    {
      if(Greenfoot.mouseClicked(this))  // Add your action code here.
      {
        //Menu.principal.menusound.stop();
        Greenfoot.setWorld( Menu.principal );// Add your action code here.
      }
    } 
}
