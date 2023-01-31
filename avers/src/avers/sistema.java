package avers;

import java.util.Scanner;
import java.sql.*;

public class sistema {
	
	public static void main(String[] args) {
		login();	
		operar();
		//login();
	}
	//////////////////////////////	//////////////////////////////	//////////////////////////////
	private static void login() {
		//Cuenta "Bar"
		//Contrasena "mipit18"
		String cuenta,contrasena;
		boolean login_correcto=false;
		
		Connection conecta_mysql=null;
		
		try {
		conecta_mysql=conectar_bd();
		}
		catch (Exception f){
			System.out.println("No se logro conectar a la Base de Datos");
		}
		
		while (login_correcto==false){
			cuenta=get_datos_usuario(1);
			contrasena=get_datos_usuario(2);
			
			try {
			login_correcto=obtener_datos_login(conecta_mysql,cuenta, contrasena);
			}
			catch (Exception f) {
				System.out.println("No se pudo conectar a la Base de Datos");
				f.printStackTrace();
			}
		}
		try {
			conecta_mysql.close();
		} catch (SQLException e) {
			System.out.println("No se cerro la Base de Datos");
			e.printStackTrace();
		}
	}
	
	private static boolean obtener_datos_login(Connection conexion,String cuenta, String contrasena) {
		String[] datos={"",""};
		int comparar_nombres;
		boolean isvalid=false;
		
		ResultSet usuario_obtenido;
		
		try {
			usuario_obtenido=conexion.createStatement().executeQuery("SELECT * FROM usuarios WHERE Cuenta='"+cuenta+"'");
			//revisar si esta vacio con otro codigo
			if (usuario_obtenido.wasNull())
				System.out.println("No existe esa cuenta\n");
			else
			{
				usuario_obtenido.getString(2);
				System.out.println(usuario_obtenido.getString(2));
				
				comparar_nombres=usuario_obtenido.getString(2).compareTo(contrasena);
				if (comparar_nombres!=0)
				{
					System.out.println("Contrasena incorrecta\n");
				}
				else
				{
					System.out.println("Bienvenido");
					isvalid=true;
				}
				
			}
			conexion.createStatement().close();
			
		} catch (SQLException e) {
			System.out.println("Imposible obtener datos de la BD");
			e.printStackTrace();
		}
		
		return isvalid;
	}
	
	private static String get_datos_usuario(int num_imprimir) {	
		
		    Scanner recoger = new Scanner(System.in);
			String texto_usuario="";
			switch (num_imprimir) {
				case 1:
					System.out.println("Escriba su cuenta");
					break;
				case 2:
					System.out.println("Escriba su contrasena");
					break;
			}
			texto_usuario=recoger.nextLine();
			return texto_usuario;
			
	}
	
	//////////////////////////////////////	//////////////////////////////	//////////////////////////////
	private static void operar() {
		int opcion; 
		do {
			String[] operacion = new String[3];
			operacion[0]="Revisar estado cuenta";
			operacion[1]="Realizar retiro";
			operacion[2]="Salir";
			
			System.out.println("Operaciones:");
			System.out.println("1. "+operacion[0]);
			System.out.println("2. "+operacion[1]);
			System.out.println("3. "+operacion[2]);
			System.out.println("Elija una opcion");
			
			Scanner recoger = new Scanner(System.in);
			String texto_usuario="";
			texto_usuario=recoger.nextLine();
			opcion=Integer.parseInt(texto_usuario);
			
			switch (opcion) {
				case 1:revisar_estado_cuenta(); 
				break;
				case 2:retirar();
				break;
				case 3:System.out.println("Gracias por usar la aplicacion");
				recoger.close();
				break;
				default:System.out.println("Elija UNA opcion");
			}
		} while (opcion!=3); 
	}
	
	private static void revisar_estado_cuenta() {
		//open.db;
		//mostrar_usuario(datos_usuario)
	}
	
	private static void retirar() {
		//open.db;
		//db(datos_usuario)
	}
	
	private static Connection conectar_bd() {
		String url,usuario="root",contrasena="root";
		Connection conexion=null;
		
		url="jdbc:mysql://localhost:3306/banco";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager.getConnection(url, usuario, contrasena);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Controlador no encontrado");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error en la sintaxis");
			e.printStackTrace();
		} 
		return conexion;
	}
}
