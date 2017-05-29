import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class Nivel4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel4 extends Niveles
{
    //GreenfootSound music = new GreenfootSound("level4.mp3");
    private Objeto escalera;
    private Jugador personaje;
    private String tecla;
    private long tf, ti; //tiempo final y tiempo inicial
    private int y; //Variable determinante de altura
    private SimpleTimer timer;
    private int score;
    
    /**
     * Constructor for objects of class Nivel4.
     * 
     */
    public Nivel4(int puntaje)
    {
        score = puntaje;
        timer = new SimpleTimer();
        
        personaje = new Personaje();
        escalera = new Escalera();
        
        escalera.posX=420;
        escalera.posY=800;
        
        personaje.posX=350;
        personaje.posY=300;
        
        addObject(personaje, personaje.posX, personaje.posY);
        addObject(escalera, escalera.posX, escalera.posY);
        
        reasignar();
        y=0;
        timer.mark();
    }
    
    void muestraInterfaz()
    {
 
        showText("Nivel: 4", 50, 40);
        showText("Tiempo: " + (20 - timer.millisElapsed()/1000), 60, 60); 
    }
    
    public void generaLetra()
    {
        Random rand = new Random();
        int n = rand.nextInt(6);
        
        switch(n)
        {
            case 0:
            tecla = "A";
            break;
            case 1:
            tecla = "B";
            break;
            case 2:
            tecla = "L";
            break;
            case 3:
            tecla = "R";
            break;
            case 4:
            tecla = "W";
            break;
            case 5:
            tecla = "P";
            break;
        }
    }
    
    public void validaTecla()
    {
        if(timer.millisElapsed() > 20000)
        {
 
            //Bajar
            y++;
            muevePersonaje();
            reasignar();
        }
        
         if(tf-ti>1000)
        {
 
            //Bajar
            y++;
            muevePersonaje();
            reasignar();
        }
        if(Greenfoot.isKeyDown(tecla)){
            //sube
            y--;
            muevePersonaje();
            reasignar();
        }
        
        //Validar cuando gana o pierde
        if(y>10) {
            //music.stop();
            //fail.play();
            personaje.setImage("images/perdio.png");
            Greenfoot.delay(100);
            Greenfoot.setWorld( new Escenario(3, score) );  
        }
        else if(y<-10) {
            //music.stop();
            //win.play();
            personaje.setImage("images/gano.png");
            Greenfoot.delay(100);
            Greenfoot.setWorld( new Escenario(4, score + 100) );  
        }
        
        tf=System.currentTimeMillis();
        
    }
    
    private void muevePersonaje()
    {
        personaje.setLocation(personaje.posX, personaje.posY + y*20);
    }
    
    private void reasignar()
    {
        generaLetra();
        MuestraIndicaciones();
        ti=tf=System.currentTimeMillis();
    }
    
    public void resetTimer()
    {
        timer.mark();
    }
    
    public void MuestraIndicaciones(){
        showText("Presiona la tecla indicada para subir!", 400, 50);
        showText("[ " + tecla + "]", 400, 80);
    }
    
    public void act() 
    {
       // if(!music.isPlaying()) music.play();
       validaTecla();
       muestraInterfaz();
    }
}
