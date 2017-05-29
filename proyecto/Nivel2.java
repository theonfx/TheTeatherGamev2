import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class Nivel_2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel2 extends Niveles
{
    //GreenfootSound music = new GreenfootSound("level2.mp3");
    private Objeto huevo; //Crear un objeto huevo
    private int tipo; //Variable para determinar el tipo de huevo en el escenario: 0 real - 1 fake
    private Jugador personaje;
    private SimpleTimer timer;
    private int partida = 0;
    private int score;
    /**
     * Constructor for objects of class Nivel_2.
     * 
     */
    public Nivel2(int puntaje)
    {
        score = puntaje;
        timer = new SimpleTimer();
        CargaHuevo();
        MuestraIndicaciones();
        timer.mark();
    }
    
    /*
     * Inicializa el objeto huevo de manera aleatoria, puede colocar un huevo real o fake
     *
     */
    public void CargaHuevo() {
        Random rand = new Random();
        
        if(rand.nextInt(2) == 0) 
        {
            huevo = new Huevo();
            tipo = 0;
        }
        else 
        {
            huevo = new HuevoFake();
            tipo = 1;
        }
        
        huevo.posX = 400;
        huevo.posY = 400;
        
        addObject(huevo, huevo.posX, huevo.posY);
    }
    
    void muestraInterfaz()
    {
        //showText("Puntaje: " + personaje.getPuntaje(), 60, 20);
        showText("Nivel: 2", 50, 40);
        showText("Tiempo: " + (5 - timer.millisElapsed()/1000), 60, 60); 
    }
    public void teclaGano()
    {
       // music.stop();
        //win.play();
        huevo.setImage("images/gano.png");
        partida = 1;
        Greenfoot.delay(100);
        Greenfoot.setWorld( new Escenario(2, score + 100) );
    }
    public void teclaPerdio()
    {
        //music.stop();
        //fail.play();
        huevo.setImage("images/perdio.png");
        Greenfoot.delay(100);
        Greenfoot.setWorld( new Escenario(1, score) );
    }
    public void validaTecla() {
        //huevo.setImage("images/huevo_rompido.jpg");
        
        if(Greenfoot.isKeyDown("h") && tipo == 0)
        {
            //Huevo real > ganó un bonus de puntos o vidas 
            teclaGano();
        } else if(Greenfoot.isKeyDown("k") && tipo == 1) {
            //Huevo fake > ganó un bonus de puntos o vidas
           teclaGano();
        } else if(Greenfoot.isKeyDown("h") && tipo != 0)
        {
            //Huevo real > ganó un bonus de puntos o vidas 
            teclaPerdio();
        } else if(Greenfoot.isKeyDown("k") && tipo != 1) {
            //Huevo fake > ganó un bonus de puntos o vidas
           
        }
        
        if(timer.millisElapsed() > 5000 && partida != 1)
        {
          teclaPerdio();
        }
        
    }
    
    public void resetTimer()
    {
        timer.mark();
    }
    
    public void MuestraIndicaciones(){
        showText("¿Qué tipo de huevo es este? [Tecla H: Real] [Tecla K: Fake]", 400, 50);
    }
    
    /**
     * Act - do whatever the Nivel2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       //if(!music.isPlaying()) music.play();
       validaTecla();
       muestraInterfaz();
    }
}
