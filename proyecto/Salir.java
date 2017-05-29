import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Salir here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Salir extends Objeto
{
    /**
     * Act - do whatever the Salir wants to do. This method is called whenever
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
        //Cerrar todo alv
        Greenfoot.stop();
        System.exit(0);
      }
    } 
}
