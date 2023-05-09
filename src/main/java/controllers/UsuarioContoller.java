package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.Usuario;

public class UsuarioContoller {
	public String createUser(String user, String password) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Usuario.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			Usuario usuario = new Usuario(user, password);
			session.beginTransaction();
			session.persist(usuario);
			session.getTransaction().commit();
			session.close();
			return "Usuario creado satisfactoria mente";
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return "Error, no se pudo crear el ususario";
	}
	
	public String updateUser(int id, String user, String password) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Usuario.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Usuario usuario = session.get(Usuario.class, id);
			if(usuario == null) return "Usuario no encontrado para ser actualizado.";
			
			usuario.setUser(user);;
			usuario.setPassword(password);
			session.merge(usuario);
			session.getTransaction().commit();
			session.close();
			
			return "Usuario actualizado satisfactoria mente";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Error, no se pudo actualizar al usuario usuario";
	}
	
	public String deleteUser(int id) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Usuario.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Usuario usuario = session.get(Usuario.class, id);
			if(usuario == null) return "Usuario no encontrado para ser eliminado.";
			session.remove(usuario);
			session.getTransaction().commit();
			session.close();
			
			return "Usuario eliminado satisfactoria mente";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Error, no se pudo eliminar al usuario";
	}
	
	public String getUser(int id) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Usuario.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Usuario usuario = session.get(Usuario.class, id);
			if(usuario == null) return "Usuario no encontrado.";
			session.getTransaction().commit();
			session.close();
			return usuario.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Error, no se encontro ningun usuario";
	}
}
