package ups.edu.ec.controlador;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conexion c = new Conexion();
		
		c.getConnection();
		c.insertarMedico(1, "Ricardo", "Ordoñez", "0102363058", "ricaro@gmail.com", "1234", 2);
		
	}

}
