import java.util.ArrayList;
public class Vehiculo
{
    //Atributos de clase
    public static ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    public static int idActual=1;


    //Atributos de instancia
    private int id;
    private int modelo;
    private ArrayList<Sensor> sensores = new ArrayList<Sensor>();
    private String marca,color;
    private double valorComercial;


    //Constructores
    public Vehiculo(){
        this.id = Vehiculo.idActual;
        Vehiculo.idActual++;


        vehiculos.add(this);
    }


    public Vehiculo(int mo, String ma, double va){
        this(mo,ma,va,"verde");


    }


    public Vehiculo(int mo, String ma, double va, String co){
        this.modelo=mo;
        this.marca=ma;
        this.valorComercial=va;
        this.color=co; 


        this.id = Vehiculo.idActual;
        Vehiculo.idActual++;


        vehiculos.add(this);


    }


    //Metodos de instancia


    public void setId(int id){
        this.id=id;
    }


    public int getId(){
        return this.id;
    }


    public void setSensores(ArrayList<Sensor> sensores){
        this.sensores=sensores;
    }


    public ArrayList<Sensor> getSensores(){
        return this.sensores;
    }


    public void setModelo(int mo){
        this.modelo=mo;
    }


    public int getModelo(){
        return this.modelo;
    }


    public void setMarca(String ma){
        this.marca=ma;
    }


    public String getMarca(){
        return this.marca;
    }


    public void setColor(String co){
        this.color=co;
    }


    public String getColor(){
        return this.color;
    }


    public void setValorComercial(double va){
        this.valorComercial=va;
    }


    public double getValorComercial(){
        return this.valorComercial;
    }


    public String toString(){
        String cadena = " ( "+"Id: "+this.getId()+", Modelo: "+this.getModelo()+", Marca: "+this.getMarca()+", Valor comercial: "+this.getValorComercial()+", Color: "+this.getColor()+" ) ";


        for (Sensor sensor : this.getSensores())  {
            cadena = cadena + sensor.toString();
        }


        return cadena;
    }


    public int cantidadSensores(){
        return this.sensores.size();
    }


    public void anadirSensor(Sensor s){
        this.sensores.add(s);
    }


    //Metodos de clase


    public static String toStringVehiculos(boolean todos ){
        String cadena=" [ ";
        if(todos){
            for(Vehiculo vehiculo : Vehiculo.vehiculos){
                cadena= cadena+vehiculo.toString();


            }


        }else{
            for (int i = 0; i < Vehiculo.vehiculos.size(); i++){
                if (vehiculos.get(i).getColor().equals("verde")){


                    cadena= cadena+Vehiculo.vehiculos.get(i).toString(); 
                }
            }


        }
        cadena = cadena+" ] ";
        return cadena;
    }


    public static int cantidadVehiculos(){
        return Vehiculo.vehiculos.size();
    }


    public static ArrayList<Sensor> caso666(){


        //creando arreglo de sensores de tipo temperatura
        ArrayList<Sensor> sensoresTemp = new ArrayList<Sensor>() ; 


        //Guardando en sensoresTemp los sensores con tipo temperatura
        for(int i = 0; i < Vehiculo.cantidadVehiculos(); i++){
            for(int j = 0; j < Vehiculo.vehiculos.get(i).cantidadSensores(); j++){
                if(Vehiculo.vehiculos.get(i).getSensores().get(j).getTipo().equalsIgnoreCase("temperatura")){
                    sensoresTemp.add(Vehiculo.vehiculos.get(i).getSensores().get(j));
                }
            }
        }


        //Ordenandolos por valor
        int n=sensoresTemp.size();
        int posMenor;
        Sensor temp;


        for (int i = 0; i < n-1; i++){
            posMenor=i;
            for (int j = i+1; j < n; j++){
                if (sensoresTemp.get(j).getValor()< sensoresTemp.get(posMenor).getValor())
                {


                    posMenor=j;
                }


            }
            temp = sensoresTemp.get(i);
            sensoresTemp.set(i,sensoresTemp.get(posMenor));
            sensoresTemp.set(posMenor,temp);
        }


        return sensoresTemp; 
    }
}
 