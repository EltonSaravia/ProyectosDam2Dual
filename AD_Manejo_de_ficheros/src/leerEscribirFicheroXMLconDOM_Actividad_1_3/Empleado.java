package leerEscribirFicheroXMLconDOM_Actividad_1_3;

	class Empleado {
	    private int id;
	    private String apellido;
	    private String departamento;
	    private double salario;

	    public Empleado(int id, String apellido, String departamento, double salario) {
	        this.id = id;
	        this.apellido = apellido;
	        this.departamento = departamento;
	        this.salario = salario;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getApellido() {
	        return apellido;
	    }

	    public String getDepartamento() {
	        return departamento;
	    }

	    public double getSalario() {
	        return salario;
	    }
	}

