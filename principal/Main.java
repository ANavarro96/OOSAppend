package principal;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws SecurityException, IOException, ClassNotFoundException {

    	Ciudad c;
    	File fichero = new File("ciudades.dat");
    	ObjectOutputStream oos;
    	if(!fichero.exists()) {
    		// Si el fichero no existe, tengo que crear la cabecera, por lo que uso un objeto de la clase Java.
    		// Podría haber pasado el fichero como parámetro a mi clase, y en ella escribir la cabecera si el fichero
    		// no existe.
    		oos = new ObjectOutputStream(new FileOutputStream(fichero));
    	}
    	else {
    		// Si el fichero existe, NO creo la cabecera.
    		oos = new ObjectOutputStreamAppendeable(new FileOutputStream(fichero,true));
    	}
    	
    	
    	// Ejemplo sencillo
    	oos.writeObject(new Ciudad("Utebo", 10, false));
    	oos.writeObject(new Ciudad("Utebo", 10, false));
    	
    	oos.close();
    	ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
    	
    	try
    	{
    		while(true) {
 
    		System.out.println(((Ciudad) ois.readObject()).getNombre());
    		
    		}
    	}
    	catch (EOFException e) {
    		System.out.println("Fin del fichero");
    		// No da error!
    	}
    	
    
        
            
    }
}
