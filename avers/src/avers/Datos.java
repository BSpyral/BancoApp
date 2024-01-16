package avers;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Datos {

	private String nombre_cuenta,telefono,correo;	
	private double saldo;
	
	public Datos(String nombre_cuenta,String telefono) {
		this.nombre_cuenta=nombre_cuenta;
		this.telefono=telefono;
		correo="N/A";
		saldo=-1;
	}
	
	public Datos() {
		this.nombre_cuenta="";
		this.telefono=null;
		correo="N/A";
		saldo=-1;
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

	public String getNombre_cuenta() {
		return nombre_cuenta;
	}

	public void setNombre_cuenta(String nombre_cuenta) {
		this.nombre_cuenta = nombre_cuenta;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
		fichero.write(this.telefono+"  ");
		fichero.write(this.correo+"  ");
		fichero.close();
		System.out.println("Datos guardados correctamente");
		//Escribir correctamente varios datos
	}	
	
	////////////////////////////////////////////////////////
	
	public static void main(String[] args) throws IOException {
		Datos Persona=new Datos("Bar","7711922383");
		Datos Persona2=new Datos("hola","prueba");
		crear_archivo();
		Persona.crear_informacion_usuario();
		Persona2.crear_informacion_usuario();
	}

	
}
