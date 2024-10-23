import java.util.Random;
import java.util.Scanner;
import ClasesPrimarias.Agentes;
import ClasesPrimarias.Items;
public class Main {
    UID uid = new UID();
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);
    /*public Main(){
        uid.generarAreaMatriz();
    }
    public void generateEntities(){
        Items weaponInicial = new Items("Arma Basica", 1, "Ataque normal");
        Items armaduraInicial = new Items("Armadura Basica", 75, "Defensa normal");
        Items buffInicial = new Items("", 1, "Sin buff");
        //ArrayList<Items> inventario = new ArrayList<Items>();
        Agentes jugador = new Agentes('@',500,70,50,  weaponInicial , armaduraInicial, buffInicial, true);
        Agentes[] enemigos = new Agentes[6];
        enemigos[0] = new Agentes('E',100,70,50, buffInicial, false);
        enemigos[1] = new Agentes('E',150,70,50, buffInicial, false);
        enemigos[2] = new Agentes('E',175,70,50, buffInicial, false);
        enemigos[3] = new Agentes('E',210,70,50, buffInicial, false);
        enemigos[4] = new Agentes('E',235,70,50, buffInicial, false);
        enemigos[5] = new Agentes('E',280,70,50, buffInicial, false);
    }
    public Items setWeapon(int index, Agentes agente, Agentes objetivo){
        Items[] weapon = new Items[2]; 
        weapon[0] = new Items("Arma Legendaria", 2,"Realiza el doble de daño que el ataque normal");
        weapon[1] = new Items("Arma Secreta",(objetivo.getSalud()/2  + agente.getAtaque()),
                              "Reduce en un 50% la vida actual del objetivo");
        return weapon[index];
    }
    public Items setAmadura(int index, Agentes agente){
        Items[] armor = new Items[2];
        armor[0] = new Items("Armadura Legendaria",agente.getAtaque()/50,"Recuce un 50% del ataque recibido");
        armor[1] = new Items("Armadura Secreta", agente.getArmaduraEfecto(),"Armadura legendaria se regenera despues de cada partida");

        return armor[index];
    }
    public Items setBuff(int index){
        Items[] buff = new Items[3];
        Random rand = new Random();
        double rngAtaque = rand.nextInt(5, 11);
        double aumento = 1 + (rngAtaque/100);
        double aumentoDefensa = 1.15;
        //Creacion de buffs
        buff[0] = new Items("Salsa Lizano", aumento, "(Aumenta tu ataque en un " + rngAtaque + "%)");
        buff[1] = new Items("Cacique", aumentoDefensa, "(Reduce la defensa del enemigo en un " + ((aumentoDefensa - 1) * 100 ) + "%)" );
        //Creacion de debuff
        buff[2] = new Items("Poción de veneno II", 1, "(Envena al enemigo)");
        
        return buff[index];
    }
    public void sistemaDeBatalla(){
        
    }*/
    public static void main(String[] args) {
        Main juego = new Main();
        char[] moverEnemigo = {'w', 'a', 's', 'd'};
        char moverE;
        Items weaponInicial = new Items("Arma Basica", 1, "Ataque normal");
        Items armaduraInicial = new Items("Armadura Basica", 75, "Defensa normal");
        Items buffInicial = new Items("", 1, "Sin buff");
        //ArrayList<Items> inventario = new ArrayList<Items>();
        Agentes jugador = new Agentes('@',500,70,50,  weaponInicial , armaduraInicial, buffInicial, true);
        Agentes[] enemigos = new Agentes[6];
        enemigos[0] = new Agentes('E',100,70,50, buffInicial, false);
        enemigos[1] = new Agentes('E',150,70,50, buffInicial, false);
        enemigos[2] = new Agentes('E',175,70,50, buffInicial, false);
        enemigos[3] = new Agentes('E',210,70,50, buffInicial, false);
        enemigos[4] = new Agentes('E',235,70,50, buffInicial, false);
        enemigos[5] = new Agentes('E',280,70,50, buffInicial, false);
        juego.uid.generarAreaMatriz(jugador, enemigos[0]);
        for(int i = 0; i < 10; i++){
            moverE = moverEnemigo[juego.rand.nextInt(4)];
            juego.uid.imprimirMatriz(); char mover = juego.scanner.next().charAt(0);
            juego.uid.moverPersonaje(mover, jugador); System.out.println();
            juego.uid.moverPersonaje(moverE, enemigos[0]);
            if(juego.uid.areaEnemigo() == true){
                System.out.println("Hay combate");
            }
        }
    }
}
