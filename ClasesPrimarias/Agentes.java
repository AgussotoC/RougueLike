package ClasesPrimarias;

public class Agentes
{
    //Atributos de la clase

    //Características únicas del personaje
    private char icono;
    private double salud;
    private double ataque;
    private double defensa;
    private boolean turno;
    /*Características compartidas y modificables por toda entidad
      también ocupa la creaciones de clases de items para funcionar, lo cual lo ideal sería hacerlo en el main*/
    public Items weapon;
    public Items armadura;
    public Items buffs;
    //Constructor del jugador
    public Agentes(char icono, double salud, double ataque, double defensa, Items weapon, Items armadura, Items buffs, boolean turno){
        this.icono = icono;
        this.salud = salud;
        this.ataque = ataque;
        this.defensa = defensa;
        this.weapon = weapon;
        this.armadura = armadura;
        this.buffs = buffs;
        this.turno = turno;
    } 
    //constructor de los enemigos
    public Agentes(char icono, double salud, double ataque, double defensa, Items buffs, boolean turno){
        this.icono = icono;
        this.salud = salud;
        this.ataque = ataque;
        this.defensa = defensa;
        this.buffs = buffs;
        this.turno = turno;
    }
    //Getters características únicas
    public double getSalud(){
        return salud;
    }
    public double getAtaque(){
        return ataque;
    }
    public double getDefensa(){
        return defensa;
    }
    public boolean getTurno(){
        return turno;
    }
    public char getIcono(){
        return icono;
    }
    //Getters características compartidas y modificables
        //Arma
            public String getWeaponNombre(){
                return weapon.getNombre();
            }
            public double getWeaponEfecto(){
                return weapon.getEfecto();
            }
            public String getWeaponDescripcion(){
                return weapon.getDescripcion();
            }
        //Armadura
            public String getArmaduraNombre(){
                return armadura.getNombre();
            }
            public double getArmaduraEfecto(){
                return armadura.getEfecto();
            }
            public String getArmaduraDescripcion(){
                return armadura.getDescripcion();
            }
        //Buffs
            public String getBuffduraNombre(int index){
                return buffs.getNombre();
            }
            public double getBuffEfecto(int index){
                return buffs.getEfecto();
            }
            public String getBuffDescripcion(int index){
                return buffs.getDescripcion();
            }       
    //Metodo que recibe el daño y lo reduce a la salud
    public double recibirDaño(double daño){
        armadura.efecto -= daño;
        if(armadura.efecto < 0){
            armadura.efecto = 0; 
        }
        if(armadura.efecto == 0){
            salud -= daño;
            if(salud < 0){
                salud = 0;
            }
        }
        return salud;
    }
    //Metodo de ataque
    public void atacar(Agentes objetivo){
        objetivo.recibirDaño(ataque);
    }
    //Metodo de defensa, defender bloquea 25% del ataque recibido
    public void defender(double daño){
        recibirDaño(daño*0.75);
    }
    //Setters
    //Recibe el efecto de los items
    public void setSalud(double efecto){
        this.salud = efecto;
    }
    public void setAtaque(double efecto){
        this.ataque = efecto;
    }
    public void setBuff_Debuffs(Items[] item){
     
    }
    //sadad
}
