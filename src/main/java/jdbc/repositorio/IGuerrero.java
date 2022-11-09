package jdbc.repositorio;
import java.util.List;

public interface IGuerrero<T> {
		
	//funciones que tendrá con genericos
	 	List<T> listar();

	    T porId(Long id);

	    void guardar(T t);

	    void eliminar(Long id);
}
