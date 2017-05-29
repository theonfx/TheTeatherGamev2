import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Niveles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Niveles extends World
{
    //public GreenfootSound win = new GreenfootSound("win.mp3");
    //public GreenfootSound fail = new GreenfootSound("fail.mp3");
    public int puntaje = 0;
    
    /**
     * Constructor for objects of class Niveles.
     * 
     */
    public Niveles()
    {
        super(800, 600, 1);
        //escenario = new Escenario();
        //Greenfoot.setWorld(escenario);
    }
    
    abstract void muestraInterfaz();
    abstract void resetTimer();
    abstract  void validaTecla();
    abstract  void MuestraIndicaciones();
    
    public void guardaRecord(int puntos)
    {
        if (UserInfo.isStorageAvailable()) {
            UserInfo myInfo = UserInfo.getMyInfo();
            if (puntos > myInfo.getScore()) {
                myInfo.setScore(puntos);
                myInfo.store();
            }
        }
    }
}
