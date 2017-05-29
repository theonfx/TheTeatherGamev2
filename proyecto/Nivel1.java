import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class Nivel1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel1 extends Niveles
{
    //GreenfootSound music = new GreenfootSound("level1.mp3");
    
    private Objeto pelota;
    private Jugador personaje;
    private int c;
    private SimpleTimer timer;
    private int score;
    
    /**
     * Constructor for objects of class Nivel1.
     * 
     */
    public Nivel1(int puntaje)
    {
        score = puntaje;
        
        timer = new SimpleTimer();
        
        Greenfoot.delay(100);
        pelota = new Pelota();
        personaje = new Jake2();
        iniciaPelota();
        
        personaje.posX=400;
        personaje.posY=450;
        
        addObject(personaje, personaje.posX, personaje.posY);
        
        MuestraIndicaciones();
        
        c = 0;
        
        timer.mark();
        Greenfoot.setSpeed(50);
    }
    
    public void resetTimer()
    {
        timer.mark();
    }
    
    public void muestraInterfaz()
    {
        showText("Puntaje: " + personaje.getPuntaje(), 60, 20);
        showText("Nivel: " + (personaje.getNivel() + 1), 50, 40);
        showText("Tiempo: " + (10 - timer.millisElapsed()/1000), 60, 60); 
        showText("Bolas: " + c, 60, 80); 
    }
    
    private void iniciaPelota()
    {
        Random rand = new Random();
        pelota.posY=0;
        pelota.posX= rand.nextInt(799);
        addObject(pelota, pelota.posX, pelota.posY);
        
    }
    
     public  void validaTecla()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            personaje.posX+=15;
        }
        else if(Greenfoot.isKeyDown("left"))
        {
            personaje.posX-=15;
        }
        
        personaje.setLocation(personaje.posX, personaje.posY);
    }

    private void validaBola()
    {
        if(pelota.posY<550)
        {
            pelota.posY+=10;
        }
        if(pelota.posX > 50 && pelota.posX < 800)
        {
            Random rand = new Random();
            int x = rand.nextInt(11);
            if(rand.nextInt(2)==0) pelota.posX-=x;
            else pelota.posX+=x;
        }
        pelota.setLocation(pelota.posX, pelota.posY);
        
        if(pelota.posY>500){
            removeObject(pelota);
            iniciaPelota();
            
        }
        
    }
    
    private void validaCaptura()
    {
        if(personaje.isTouchingPelota(personaje))
        {
            personaje.actualizaPuntaje(personaje.getPuntaje() + 10);
            c++;//si la pelota es atrapada, le suma vidas, tiene que llegar a 10
            if(10 - timer.millisElapsed()/1000 <= 0)
            {
                if(c<10)
                {
                    //music.stop();
                    //fail.play();
                    personaje.setImage("images/perdio.png");
                    Greenfoot.delay(100);
                    Greenfoot.setWorld( new Escenario( 0, score ));// Add your action code here.
                } else 
                {
                   // music.stop();
                    //win.play();
                    personaje.setImage("images/gano.png");
                    Greenfoot.delay(100);
                    Greenfoot.setWorld( new Escenario(1, score + personaje.getPuntaje()) );
                }
            }
            removeObject(pelota);
            iniciaPelota();
        }
    }
    
    public void MuestraIndicaciones(){
        showText("¡Mueve a Jake con las flechas y captura al menos 10 bolas!", 400, 50);
    }
    
    public void act()
    {
        //if(!music.isPlaying()) music.play();
        validaTecla();
        validaBola();
        validaCaptura();
        muestraInterfaz();
    }
}