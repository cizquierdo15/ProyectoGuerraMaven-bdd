package jdbc;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import jdbc.repositorio.GuerreroRepositorioImpl;
import jdbc.repositorio.IGuerrero;
import jdbc.modelo.Guerrero;

public class Guerra {
	
	private static final Logger logger = LogManager.getLogger(Guerra.class);
	
	public static void main(String[] args) {
		
		//inicamos escribiendo en el log
		logger.debug("Iniciando aplicacion");
		
		IGuerrero<Guerrero> guerreros = new GuerreroRepositorioImpl() ;
		
		 List <Guerrero> lG = guerreros.listar();
		 
		 //mostrar estado inicial de los guerreros
		 for (Guerrero guerrero : lG) {
			System.out.println(guerrero);
		 }	
		System.out.println(" COMIENZA LA GUERRA!!");
		Guerrero archer = lG.get(0);
		Guerrero goro = lG.get(1);
		
		
		
		StringBuffer sb = new StringBuffer();
		int turno = 1;
		//hasta que uno muera
		while ( (goro.getPvida() >= 0) &&  (archer.getPvida() >= 0) ) {
			
			if( archer.getPvida() > 0 && turno == 1) {
				goro.setPvida( archer.getPataque()  -  goro.getPdefensa());
				//mostramos los datos
				sb.append("Ateque de "+ archer.getNombre() + " Quita " + (archer.getPataque()  -  goro.getPdefensa()) + " a Goro le quedan " + goro.getPvida() );
				System.out.println(sb.toString() );
				 sb.delete(0, sb.length()); //limpiamos el sb
				 turno = 2; //cambio de turno
			}
			else if( goro.getPvida() > 0 && turno == 2) {
				archer.setPvida( goro.getPataque()  -  archer.getPdefensa());
				//mostramos los datos
				sb.append("Ateque de "+ goro.getNombre() + " Quita " + (goro.getPataque()  -  archer.getPdefensa()) + " a Archer le quedan " + archer.getPvida() );
				System.out.println(sb.toString() );
				 sb.delete(0, sb.length()); //limpiamos el sb
				 turno = 1; //cambio de turno
			}
		}
		//repasar bucle
		if (goro.getPvida() == 0) System.out.println("El ganador es Archer");
		else if(archer.getPvida() == 0) {System.out.println("El ganador es Goro");}
	}

}
