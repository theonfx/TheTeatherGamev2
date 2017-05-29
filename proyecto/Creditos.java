import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Creditos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creditos extends Objeto
{
    /**
     * Act - do whatever the Creditos wants to do. This method is called whenever
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
        Greenfoot.setWorld( Menu.creditos );// Add your action code here.
      }
    }  
}
