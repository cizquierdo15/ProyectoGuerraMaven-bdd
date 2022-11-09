package jdbc.modelo;



public class Guerrero {
	
	private Long id;
    private String nombre;
    private Integer pataque;
    private Integer pdefensa;
    private Integer pvida;
    
    
    //constructor vacio para hibernate
    public Guerrero() {
    }
    
    
	public Guerrero(Long id, String nombre, Integer pataque, Integer pdefensa, Integer pvida) {
		this.id = id;
		this.nombre = nombre;
		this.pataque = pataque;
		this.pdefensa = pdefensa;
		this.pvida = pvida;
	}


	//getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPataque() {
		return pataque;
	}

	public void setPataque(Integer pataque) {
		this.pataque = pataque;
	}

	public Integer getPdefensa() {
		return pdefensa;
	}

	public void setPdefensa(Integer pdefensa) {
		this.pdefensa = pdefensa;
	}

	public Integer getPvida() {
		return pvida;
	}

	public void setPvida(Integer pvida) {
		this.pvida = pvida;
	}
	
	//tostring sobrescrito con los valores de obj
	@Override
    public String toString() {
        return  id +
                " | " +
                nombre +
                " | " +
                pataque +
                " | " +
                pdefensa +
                " | " +
                pvida;
    }
}
