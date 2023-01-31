package avers;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Datos {

	String nombre_cuenta,contrasena,telefono,correo;	
	double saldo;
	
	public Datos(String nombre_cuenta,String contrasena,String telefono) {
		this.nombre_cuenta=nombre_cuenta;
		this.contrasena=contrasena;
		this.telefono=telefono;
		correo="N/A";
	}
		
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	////////////////////////////////////////////

	public void ingresar(double cantidad) {
		if (cantidad>0) this.saldo+=cantidad;
	}
	public void retirar(double cantidad) {
		if (this.saldo-cantidad<0) System.out.println("Su saldo es insuficiente");
		else this.saldo=-cantidad;
	}
	
	
	
	private static void crear_archivo() throws IOException {
		File archivo=new File("Datos.txt");
		if (!archivo.exists())	archivo.createNewFile();
	}

	
	private void crear_informacion_usuario() throws IOException {
		FileWriter fichero=new FileWriter ("Datos.txt");
		fichero.write(this.nombre_cuenta+"  ");
		fichero.write(this.contrasena+"  ");
		fichero.write(this.telefono+"  ");
		fichero.write(this.correo+"  ");
		fichero.close();
		System.out.println("Datos guardados correctamente");
		//Escribir correctamente varios datos
	}	
	
	////////////////////////////////////////////////////////
	
	public static void main(String[] args) throws IOException {
		Datos Persona=new Datos("Bar","mipit18","7711922383");
		Datos Persona2=new Datos("hola","1234","prueba");
		crear_archivo();
		Persona.crear_informacion_usuario();
		Persona2.crear_informacion_usuario();
	}

	
}
