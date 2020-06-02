public class Sensor
{
 
    //Atributos de instancia
    private String tipo; 
    private double valor;
    //private Vehiculo vehiculo;

 

    //Constructores
    public Sensor(){
        this("",0);
    }

 

    public Sensor(String t, double v){
        this.valor = v;
        this.tipo = t;
        
    }

 

    //Metodos

 

    public String getTipo(){
        return this.tipo;
    }

 

    public double getValor(){
        return this.valor;
    }

 

    public void setTipo(String t){
        this.tipo = t;
    }

 

    public void setValor(double v){
        this.valor = v;
    }

 

    public String toString(){
        return " ( Tipo: "+this.getTipo()+", Valor: "+this.getValor()+" ) ";
    }

 

}