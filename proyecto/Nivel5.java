import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Nivel5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel5 extends Niveles
{
    //GreenfootSound music = new GreenfootSound("level5.mp3");
    private Jugador personaje;
    private HashMap<Integer, Objeto> helados;
    private int nhelados, nh = 0;
    private List<Objeto> comehelados = new ArrayList<Objeto>();
    private long tfg, tig;
    private SimpleTimer timer;
    private int score;
    
    /**
     * Constructor for objects of class Nivel5.
     * 
     */
    public Nivel5(int puntaje)
    {
        score = puntaje;
        timer = new SimpleTimer();
        
        personaje = new Jake3();
        helados = new HashMap<Integer, Objeto>();
        nhelados = 10;
        
        personaje.posX=400;
        personaje.posY=300;
        
        addObject(personaje, personaje.posX, personaje.posY);
        
        iniciaHelados();
        MuestraIndicaciones();
        
        tfg=tig=System.currentTimeMillis();
        timer.mark();
    }

    public void resetTimer()
    {
        timer.mark();
    }
    
    void muestraInterfaz()
    {
        showText("Puntaje: " + personaje.getPuntaje(), 60, 20);
        showText("Nivel: 5" , 50, 40);
        showText("Tiempo: " + (45 - timer.millisElapsed()/1000), 60, 60); 
        showText("Helados Restantes: " + (nhelados - nh), 110, 80); 
    }
    
    public void validaTecla()
    {
        if(Greenfoot.isKeyDown("w"))//rico poio, tengo 5 pecitos, te los meto por el cul....ito, hey oye...eso no, pero algo ms si ;), la vergota? xdsi /.\ hahahaha :3
        {
            personaje.move(3);
        }
    }

      
    public void MuestraIndicaciones(){
        showText("¡Presiona W y come todos los helados!", 400, 50);
    }
    
    public void rotaPersonaje()
    {
        personaje.setRotation(personaje.getRotation()+1);
    }
    
    private void validaCaptura()
    {
        tfg=System.currentTimeMillis();
        
        comehelados = personaje.getObjectsAtOffsetHelados(3,3, personaje);
        
        if(!comehelados.isEmpty()) //Si hay helados cerca
        {
            for (Objeto helado: comehelados) { //Para cada helado cercano encontrado
                //if( helados.get(helado) != null) //Verificar si existe en el hashmap
                //{
                    //Entonces eliminarlo del HashMap y del universo
                    helados.remove(helado);
                    removeObject(helado);
                    nh++;
                    personaje.actualizaPuntaje(personaje.getPuntaje() + 10);
                //}
            }
        }
        
        if(tfg-tig > 45000 && nh < nhelados)
        {
            //music.stop();
            personaje.setImage("images/perdio.png");
            //fail.play();
            Greenfoot.delay(100);
            Greenfoot.setWorld( new Escenario(4, score) );
        } else if(helados.isEmpty()){
            teclaGano();  
        }
        
        if(nh == nhelados)
        {
            teclaGano();
        }
    }
    public void teclaGano()
    {
            guardaRecord( score + personaje.getPuntaje() );
            
            //music.stop();
            //win.play();
            personaje.setImage("images/gano.png");
            Greenfoot.delay(100);
            Greenfoot.setWorld( Menu.creditos );
    }
    public void iniciaHelados()
    {
        Helado helaux;
        
        for(int i=0;i<nhelados;i++)
        {   helaux = new Helado();
            helaux.posX=Greenfoot.getRandomNumber(800);
            helaux.posY=Greenfoot.getRandomNumber(600);
            helados.put(i, helaux);
            
            addObject(helaux, helaux.posX, helaux.posY);// aqui inicializamos los helados, pero no se mueven
            
        }
    }
    
    public void act()
    {
        //if(!music.isPlaying()) music.play();
        rotaPersonaje();
        validaTecla();
        validaCaptura();
        muestraInterfaz();
    }
}
