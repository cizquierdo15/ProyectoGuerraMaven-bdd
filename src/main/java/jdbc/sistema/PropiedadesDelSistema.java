package jdbc.sistema;

import java.io.FileInputStream;
import java.util.Properties;

public class PropiedadesDelSistema {

	public static void main(String[] args) {
		try {
            FileInputStream archivo = new FileInputStream("src/config.properties");

            Properties p = new Properties(System.getProperties());
            p.load(archivo);
            p.setProperty("mi.propiedad.personalizada","Mi valor guardado en el objeto properties");
            System.setProperties(p);
            
        } catch(Exception e){
            System.err.println("no existe el archivo = " + e);
            System.exit(1);
        }

	}

}
