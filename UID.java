import java.util.Random;
import java.util.Scanner;

import ClasesPrimarias.Agentes;
public class UID{
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();
    Agentes agentes;
    char[][] matriz;
    int num;
    char itemTaken;

    char[] entidades = {'@', 'E', 'A', 'I', 'D'};
    public UID(){
        
    }
    public void generarAreaMatriz(Agentes jugador, Agentes enemigo){
        num = rand.nextInt(8, 17);
        matriz = new char[num][num];
        //Definir las paredes de los costados
        for(int i = 0; i < num; i++){
            for(int j = 0; j < num; j++){
                if(i == 0 || i == num - 1){ 
                    matriz[i][j] = '#';
                } else if(j == 0 || j == num - 1){ 
                    matriz[i][j] = '#';
                } else{
                    matriz[i][j] = ' ';
                }
            }
        }
        //Generar puerta en alguna posicion a la par de las paredes
        boolean esPosible = false; 
        int mChiquita = num -1;
        int range = ((num - 2) * 4) - 4; //area dentro de las paredes es disminuye en 2 bloques, y la puerta puede estar en las 4 paredes, esto en otras pal es el perímetro
        int rng = rand.nextInt(1, range + 1);
        for(int i = 1; i < mChiquita; i++){ 
            for(int j = 1; j < mChiquita; j++){
                if(i == 1 || i == mChiquita - 1){
                    if(rng == 1){
                        matriz[i][j] = '+';
                        esPosible = true;
                        break;
                    } else{
                        range -= 1;
                        if(range < 1){
                            range = 2;
                        }
                        rng = rand.nextInt(1, range + 1);
                    }                
                } else if(j == 1 || j == mChiquita - 1){
                    if(rng == 1){
                        matriz[i][j] = '+';
                        esPosible = true;
                        break;
                    } else{
                        range -= 1;
                        if(range < 1){
                            range = 2;
                        }
                        rng = rand.nextInt(1, range + 1);
                    }                
                }
            }  
            if(esPosible){
                break;
            }
        }
        //Generar entidades
        char[] entidades = {jugador.getIcono(), enemigo.getIcono(), 'A', 'I', 'D'};
        for(int k = 0; k < entidades.length; k++){
            esPosible = false;
            range = (num - 2) * (num - 2);
            rng = rand.nextInt(1 , range + 1);            
            for(int i = 0; i < mChiquita; i++){
                for(int j =  0; j < mChiquita; j++){
                    if(sePuede(matriz[i][j]) == false){
                        range -= 1;
                    }else if(rng == 1){
                            matriz[i][j] = entidades[k];
                            esPosible = true;
                            break;
                    } else{
                        range -= 1;
                        if(range < 1){
                            range = 2;
                        }
                        rng = rand.nextInt(1, range + 1);
                    }
                }
                if(esPosible){
                    break;
                }
            }           
        }
    }
    public boolean sePuede(char espacio){
        boolean sePuede = true;
        if(espacio == 'D'){

        } else if(espacio != ' '){
            sePuede = false;
        }
        return sePuede;
    }
    public boolean sePuedeJugador(char espacio){
        boolean sePuede = true;
        if(espacio == 'I' || espacio == 'A' || espacio == '+' || espacio == 'D'){
            switch(espacio){
                case 'I': 

                    break;
                case 'A':

                    break;
                case '+':

                    break;
                case 'D': 

                    break;
            }
        } else if(espacio != ' '){ //revisar por espacios como I, A, +
            sePuede = false;
        }
        return sePuede;        
    }
    public void imprimirMatriz(){
        for(int i = 0; i < num; i++){
            for(int j = 0; j < num; j++){
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    }
    public void moverPersonaje(char wasd, Agentes agente){
        int indexi = 0;
        int indexj = 0;
        for(int i = 0; i < num; i++){
            for(int j = 0; j < num; j++){
                if(matriz[i][j] == agente.getIcono()){
                    indexi = i;
                    indexj = j;
                }
            }
        } 
        if(agente.getIcono() == '@'){
            switch(wasd){
                case 'w': 
                    if(sePuedeJugador(matriz[indexi -1][indexj]) == true){
                        matriz[indexi][indexj] = ' ';
                        matriz[indexi - 1][indexj] = agente.getIcono();
                    }
                    break;
                case 'a':
                    if(sePuedeJugador(matriz[indexi][indexj - 1]) == true){
                        matriz[indexi][indexj] = ' ';
                        matriz[indexi][indexj - 1] = agente.getIcono();
                    }          
                    break;
                case 's':
                    if(sePuedeJugador(matriz[indexi + 1][indexj]) == true){
                        matriz[indexi][indexj] = ' ';
                        matriz[indexi + 1][indexj] = agente.getIcono();
                    } 
                    break;
                case 'd':
                    if(sePuedeJugador(matriz[indexi][indexj + 1]) == true){
                        matriz[indexi][indexj] = ' ';
                        matriz[indexi][indexj + 1] = agente.getIcono();
                    }   
                    break;  
            } 
        } else{
            switch(wasd){
                case 'w': 
                    if(sePuede(matriz[indexi -1][indexj]) == true){
                        matriz[indexi][indexj] = ' ';
                        matriz[indexi - 1][indexj] = agente.getIcono();
                    }
                    break;
                case 'a':
                    if(sePuede(matriz[indexi][indexj - 1]) == true){
                        matriz[indexi][indexj] = ' ';
                        matriz[indexi][indexj - 1] = agente.getIcono();
                    }          
                    break;
                case 's':
                    if(sePuede(matriz[indexi + 1][indexj]) == true){
                        matriz[indexi][indexj] = ' ';
                        matriz[indexi + 1][indexj] = agente.getIcono();
                    } 
                    break;
                case 'd':
                    if(sePuede(matriz[indexi][indexj + 1]) == true){
                        matriz[indexi][indexj] = ' ';
                        matriz[indexi][indexj + 1] = agente.getIcono();
                    }   
                    break;            
            }
        }
    }
    public void encontrarItem(){
        int randomItem = rand.nextInt(2) + 1;
        if(randomItem == 1){ //Encontró una armadura
            
            System.out.print("Encontraste una ");
        }else{

        }
        System.out.print("");
    }
     public boolean areaEnemigo(){
        boolean hayCombate = false;
        int indexiEnemigo = 0;
        int indexjEnemigo = 0;
        int indexiJugador = 0;
        int indexjJugador = 0;
        //Encontrar al enemigo
        for(int i = 0; i < num; i++){
            for(int j = 0; j < num; j++){
                if(matriz[i][j] == 'E'){
                    indexiEnemigo = i;
                    indexjEnemigo = j;
                }
            }
        } 
        //Encontrar al jugador
        for(int i = 0; i < num; i++){
            for(int j = 0; j < num; j++){
                if(matriz[i][j] == '@'){
                    indexiJugador = i;
                    indexjJugador = j;
                }
            }
        } 
        //Revisar si el jugador esta en el area del enemigo
        for(int i = indexiEnemigo - 1; i <= indexiEnemigo + 1; i++){
            for(int j = indexjEnemigo - 1; j <= indexjEnemigo + 1; j++){
                if(indexiJugador == i){
                    if(indexjJugador == j){
                        hayCombate = true;
                    }
                }
            }
        }
        return hayCombate;
    }
}