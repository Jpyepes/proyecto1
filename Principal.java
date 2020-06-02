import java.util.Scanner;
import java.util.ArrayList;
import java.net.*;
import java.io.*;
import java.io.File;
public class Principal
{
    public static void main (String [] args) throws Exception{
        Principal.mostrarMenu();
    }

    public static void mostrarMenu()throws Exception  {

        Scanner scan = new Scanner (System.in);
        int n=1;

        while (n==1) {
            System.out.println("<<<<<<<<<<  MENU  >>>>>>>>>>");
            System.out.println("0 : Finaliza la ejecucion del programa ");
            System.out.println("1 : Crear un nuevo vehiculo ");
            System.out.println("2 : Información de todos los vehiculos almacenados ");
            System.out.println("3 : Cantidad de vehiculos creados hasta el momento");
            System.out.println("4 : Informacion de los vehiculos de color “verde” ");
            System.out.println("5 : Informacion de vehiculo con id ");
            System.out.println("6 : Crear un nuevo sensor para vehiculo  con id ");
            System.out.println("7 : Informacion de los sensores de cierto vehiculo con id  ");
            System.out.println("8 : Informacion de todos los sensores de tipo tempeartura ");
            System.out.println("9 : Informacion de vehiculo con mayor cantidad de sensores");
            System.out.println("10 : Crear 5 vehiculos desde un txt ");
            System.out.println("666 : Informacion de todos los sensores de tipo tempeartura ordenados por valor ");
            System.out.println("777 : Crear 5 vehiculos desde un enlace");
            System.out.println ("Ingrese un numero del 0 al 10 o 666 o 777: ");
            int num = scan.nextInt();
            switch (num){

                case 0:
                //finaliza la ejecucion del programa 
                n=0;
                break;

                case 1:
                //se crea una instancia de vehiculo

                System.out.println ("Datos del vehiculo "+(Vehiculo.cantidadVehiculos()+1)+": ");
                System.out.println ("Ingrese el modelo: ");
                int mo = scan.nextInt();
                System.out.println ("Ingrese la marca: ");
                String ma = scan.next();
                System.out.println ("Ingrese color: ");
                String co = scan.next();
                System.out.println ("Ingrese el valor comercial: ");
                double va = scan.nextDouble();

                Vehiculo vehiculoNuevo = new Vehiculo (mo,ma,va,co);
                break;

                case 2:
                //Información de todos los vehiculos almacenados 
                System.out.println ("Información de todos los vehiculos : ");
                System.out.println (Vehiculo.toStringVehiculos(true));
                break;

                case 3:
                //Cantidad de vehiculos creados hasta el momento 
                System.out.println ("Hasta el momento se han creado "+Vehiculo.cantidadVehiculos()+" vehiculos");
                break;

                case 4:
                //Informacion de todos los vehiculos que tengan color “verde” 
                System.out.println ("Información de todos los vehiculos de color verde : ");
                System.out.println (Vehiculo.toStringVehiculos(false));
                break;

                case 5:
                //Informacion de vehiculo con id
                System.out.println ("Ingrese un id: ");
                int id5= scan.nextInt();

                String cadena="";
                for(int i = 0; i < Vehiculo.cantidadVehiculos(); i++){

                    if(Vehiculo.vehiculos.get(i).getId()==id5){
                        cadena=Vehiculo.vehiculos.get(i).toString(); 

                    }

                }

                if(cadena==""){
                    System.out.println("No se encontro ningun vehiculo con el id: "+id5);
                }else{
                    System.out.println(cadena);
                }
                break;

                case 6:
                //Crear un nuevo sensor para vehiculo  con id
                System.out.println ("Ingrese un id: ");
                int id6= scan.nextInt();

                //Determinar si existe el vehiculo con el id ingresado
                boolean x=false;
                for(int i = 0; i < Vehiculo.cantidadVehiculos(); i++){

                    if(Vehiculo.vehiculos.get(i).getId()==id6){
                        x=true;
                    }

                }

                if(x){
                    System.out.println ("Datos del sensor "+(Principal.obtenerVehiculoPorId(id6).cantidadSensores()+1)+": ");
                    System.out.println ("Ingrese el tipo: ");
                    String t = scan.next();
                    System.out.println ("Ingrese el valor:");
                    double v = scan.nextDouble();

                    Sensor sensorNuevo = new Sensor (t,v);
                    Principal.obtenerVehiculoPorId(id6).anadirSensor(sensorNuevo);
                }else{
                    System.out.println("No se encontro ningun vehiculo con el id: "+id6);
                }
                break;

                case 7:
                //Informacion de los sensores de cierto vehiculo con id   

                System.out.println ("Ingrese un id: ");
                int id7= scan.nextInt();
                //Determinar si existe el vehiculo con el id ingresado
                boolean y=false;
                for(int i = 0; i < Vehiculo.cantidadVehiculos(); i++){
                    if(Vehiculo.vehiculos.get(i).getId()==id7){
                        y=true;
                    }

                }

                if(y){
                    System.out.println ("Informacion de los sensores del vehiculo con id: "+id7);
                    String cad="";
                    for (Sensor sensor : Principal.obtenerVehiculoPorId(id7).getSensores())  {
                        cad = cad + sensor.toString();
                    }
                    System.out.println(cad);

                }else{
                    System.out.println("No se encontro ningun vehiculo con el id: "+id7);
                }
                break;

                case 8:
                //Informacion de todos los sensores de tipo tempeartura
                System.out.println ("Informacion de todos los sensores de tipo tempeartura: ");

                for(int i = 0; i < Vehiculo.cantidadVehiculos(); i++){
                    for(int j = 0; j < Vehiculo.vehiculos.get(i).cantidadSensores(); j++){
                        if(Vehiculo.vehiculos.get(i).getSensores().get(j).getTipo().equalsIgnoreCase("temperatura")){
                            System.out.print("Vehiculo "+(i+1)+" Sensor "+(j+1)+" : ");
                            System.out.println(Vehiculo.vehiculos.get(i).getSensores().get(j).toString());
                        }
                    }
                }
                break;

                case 9:
                //Informacion de vehiculo con mayor cantidad de sensores
                int vehiculoMasSensores=0;
                int cantidadSensores=0;
                for(int i = 0; i < Vehiculo.cantidadVehiculos(); i++){
                    if(Vehiculo.vehiculos.get(i).cantidadSensores()>cantidadSensores){
                        vehiculoMasSensores=i;
                        cantidadSensores=Vehiculo.vehiculos.get(i).cantidadSensores();
                    }
                }
                System.out.println("Informacion vehiculo con mas sensores: ");
                System.out.println(Vehiculo.vehiculos.get(vehiculoMasSensores).toString());
                break;

                case 10:
                //Crear 5 vehiculos desde un txt
                File file = new File("vehiculos.txt");
                
                try{
                    Scanner input = new Scanner(file);
                    String line;
                    while(input.hasNextLine()) {
                        line = input.nextLine();
                        String[] arreglo = line.split(",");
                        
                        //Crear nueva instancia vehiculo
                        Vehiculo vehiculo=new Vehiculo();
                        
                        //Convertir el modelo de String a Int
                        Integer modelo = Integer.valueOf(arreglo[0]);
                        //Asignanado el modelo al vehiculo
                        vehiculo.setModelo(modelo);
                        
                        //Asignanado la marca al vehiculo
                        vehiculo.setMarca(arreglo[1]);
                        
                        //Convertir el precio de String a Double
                        double precio = Double.parseDouble(arreglo[2]);
                        //Asignanado el precio al vehiculo
                        vehiculo.setValorComercial(precio);
                        
                        //Asignanado el color al vehiculo
                        vehiculo.setColor(arreglo[3]);
                       
                        
                    }
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                break;

                case 666:
                //Informacion de todos los sensores de tipo tempeartura ordenados por valor
                System.out.println ("Informacion de todos los sensores de tipo tempeartura ordenados por valor: ");

                //recogiendo arreglo de sensores tempeartura ordenados
                ArrayList<Sensor> sensoresTempOrden=Vehiculo.caso666();

                //imprimiendo arreglo
                String  caden =" [ ";

                for(int i = 0; i<sensoresTempOrden.size();i++){
                    caden=caden+"Sensor "+(i+1)+":"+sensoresTempOrden.get(i).toString();
                }
                System.out.println (caden+" ] ");
                break;

                case 777:
                //Crear 5 vehiculos desde un enlace

                String ruta="https://www.carroya.com/buscar/vehiculos/medellin/t4c239.do";
                URL url = new URL(ruta);
                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                String codigoFuente = "";
                String linea;
                while((linea = reader.readLine()) != null){
                    codigoFuente = codigoFuente + linea;
                }
                reader.close();

                codigoFuente=codigoFuente.trim();

                ArrayList<String> marcas = new ArrayList<String>();
                ArrayList<Double> precios = new ArrayList<Double>();
                ArrayList<Integer> modelos = new ArrayList<Integer>();

                //Recortando la cadena
                codigoFuente=codigoFuente.substring(codigoFuente.indexOf("vehiculos nuevos"));
                String codigo=codigoFuente;

                //Guardanto en los arraylist los datos de los vehiculos
                for(int i=0;precios.size()<5;i++){

                    //<<<Guardando el precio>>>
                    String precio="";
                    //p: punto donde empieza el precio
                    int p=codigoFuente.indexOf("data-price=")+12;

                    while(codigoFuente.charAt(p)!='"'){
                        char c=codigoFuente.charAt(p) ;
                        precio=precio+c;
                        p++;
                    }

                    //Convirtiendo el precio de String a Double
                    double preci = Double.parseDouble(precio);

                    //Anadiendo el precio al arraylist de precios
                    precios.add(preci);

                    //Recortando la cadena - Eliminando lo que ya se leyo
                    codigoFuente=codigoFuente.substring(p);

                    //<<<Guardando la marca>>>
                    String marca="";
                    //p: punto donde empieza la marca
                    p=codigoFuente.indexOf("data-brand=")+12;

                    while(codigoFuente.charAt(p)!='"'){
                        char c=codigoFuente.charAt(p) ;
                        marca=marca+c;
                        p++;
                    }

                    //Anadiendo la marca al arraylist de marcas
                    marcas.add(marca);

                    //Recortando la cadena - Eliminando lo que ya se leyo
                    codigoFuente=codigoFuente.substring(p);

                    //<<<Guardando el modelo>>>
                    String modelo="";

                    //p: punto donde empieza el modelo
                    p=codigoFuente.indexOf("data-ano=")+10;

                    while(codigoFuente.charAt(p)!='"'){
                        char c=codigoFuente.charAt(p) ;
                        modelo=modelo+c;
                        p++;
                    }
                    //Convirtiendo el modelo de String a Entero
                    Integer model = Integer.valueOf(modelo);

                    //Anadiendo lel modelo al arraylist de modelos
                    modelos.add(model);

                    //punto inicial para buscar los datos del siguiente vehiculo
                    codigoFuente=codigoFuente.substring(codigoFuente.indexOf("data-idvehiculo"));
                }

                //Creando los vehiculos desde los arraylist
                for(int i=0;i<5;i++){
                    Vehiculo vehiculo=new Vehiculo(modelos.get(i),marcas.get(i),precios.get(i));
                }
                break;
            }
            System.out.println ("");
        }
        System.out.println ("Fin del programa"); 
    }

    public static Vehiculo obtenerVehiculoPorId(int id){
        int vehiculo=0;
        for(int i = 0; i < Vehiculo.vehiculos.size(); i++){
            if(Vehiculo.vehiculos.get(i).getId()==id){
                vehiculo=i;

            }
        }
        return Vehiculo.vehiculos.get(vehiculo);
    }
}