package ClasesPrimarias;

public class Items
{
    String nombre;
    double efecto;
    String descripcion;
    int a = 1;
    int j = 2;
    String coca = "pepsi";
    String val = "ola";
    
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
