import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuPrincipal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuPrincipal extends Menu
{
    //public GreenfootSound menusound = new GreenfootSound("startmenu.mp3");
    private Objeto logo, jugar, records, ayuda, creditos, salir;
    
    /**
     * Constructor for objects of class MenuPrincipal.
     * 
     */
    public MenuPrincipal()
    {
        logo = new Logo();
        jugar = new Jugar();
        records = new Records();
        ayuda = new Ayuda();
        creditos = new Creditos();
        salir = new Salir();
        
        logo.posX=400;
        logo.posY=100;
        jugar.posX=400;
        jugar.posY=200;
        records.posX=400;
        records.posY=285;
        ayuda.posX=400;
        ayuda.posY=370;
        creditos.posX=400;
        creditos.posY=455;
        salir.posX=400;
        salir.posY=540;
        
        addObject(logo, logo.posX, logo.posY);
        addObject(jugar, jugar.posX, jugar.posY);
        addObject(records, records.posX, records.posY);
        addObject(ayuda, ayuda.posX, ayuda.posY);
        addObject(creditos, creditos.posX, creditos.posY);
        addObject(salir, salir.posX, salir.posY);
    }
    
    public void act()
    {
        //if(!menusound.isPlaying()) menusound.play();
    }
}
