import java.io.File;
import java.io.PrintWriter;
public class PrincipalFile
{
    public static void main (String [] args){
        /*File file = new File("productos.txt");
        System.out.println("Does it exist? " + file.exists());
        System.out.println("The file has " + file.length() + " bytes");
        System.out.println("Can it be read? " + file.canRead());
        System.out.println("Can it be written? " + file.canWrite());
        System.out.println("Is it a directory? " + file.isDirectory());
        System.out.println("Is it a file? " + file.isFile());*/
        File file = new File("productos.txt");
        PrintWriter output = null;
        try{
            output = new PrintWriter(file);
            output.println("iphone,2000");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            if (output != null) {
                output.close();
            }
        }
    }
}
