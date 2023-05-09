package views;

import java.util.Scanner;

import controllers.UsuarioContoller;

public class Interface {
	private static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		viewMenu();
	}
	
	private enum Opciones {
		C, // Create
		R, // Read
		U, // Update
		D; // Delete

		public static Opciones findByValue(String opcion) {
			for (Opciones o : values()) {
				if (o.name().equalsIgnoreCase(opcion)) {
					return o;
				}
			}
			return null;
		}
	}
	
	public static void viewMenu() {
		Boolean flag = true;
		Opciones opcion = null;

		while (flag) {
			System.out.print("Ingrese la accion que desea realizar: C(Crear), R(Leer), U(Actualizar), D(Eliminar):");
			String input = keyboard.nextLine().toUpperCase();
			if (Opciones.findByValue(input) != null) {
				flag = false;
				opcion = Opciones.valueOf(input);
			}
		}

		opcionSeleccionada(opcion);
	}
	
	private static void opcionSeleccionada(Opciones opcion) {
		switch (opcion) {
		case C: 
			System.out.print(createUsuario());
			break;
		case R:
			System.out.print(getUser());
			break;
		case U:
			System.out.print(updateUser());
			break;
		case D:
			System.out.print(deleteUser());
			break;
		}
	}
	
	private static String createUsuario() {
		System.out.print("Ingrese los datos del usuario: \n");
		System.out.print("Nombre del usuario: ");
		String userName = keyboard.nextLine();
		System.out.print("Contraseña del usuario: ");
		String userPassword = keyboard.nextLine();
		
		return new UsuarioContoller().createUser(userName, userPassword);
	}
	
	private static String getUser() {
		System.out.print("Ingrese el ID del usuario: \n");
		int id = Integer.parseInt(keyboard.nextLine());

		return new UsuarioContoller().getUser(id);
	}
	
	private static String updateUser() {
		System.out.print("Ingrese los datos a actualizar del usuario: \n");
		System.out.print("Id: ");
		int id = Integer.parseInt(keyboard.nextLine());
		System.out.print("Nombre del usuario: ");
		String userName = keyboard.nextLine();
		System.out.print("Contraseña del usuario: ");
		String userPassword = keyboard.nextLine();
		
		return new UsuarioContoller().updateUser(id, userName, userPassword);
	}
	
	private static String deleteUser() {
		System.out.print("Ingrese el ID del usuario a eliminar: \n");
		int id = Integer.parseInt(keyboard.nextLine());

		return new UsuarioContoller().deleteUser(id);
	}

}
