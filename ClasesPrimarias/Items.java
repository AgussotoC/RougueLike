package ClasesPrimarias;

public class Items
{
    String nombre;
    double efecto;
    String descripcion;
<<<<<<< HEAD
    int num;
=======
    int a = 1;
>>>>>>> e632580c1411dbfdc6e4d09d75194c45a60d6ac6
    
    public Items(String nombre, double efecto, String descripcion){
        this.nombre = nombre;
        this.efecto = efecto;
        this.descripcion = descripcion;
    
    }
    public String getNombre(){
        return nombre;
    }
    public double getEfecto(){
        return efecto;
    }
    public String getDescripcion(){
        return descripcion;
    }
}
