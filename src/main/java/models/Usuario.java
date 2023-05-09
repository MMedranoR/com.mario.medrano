package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class Usuario {
	
		@Id
		@Column(name = "iduser")
		private int id;
		@Column(name = "userName")
		private String user;
		@Column(name = "userPassword")
		private String password;
		
		public Usuario(){}

		public Usuario(String user, String password) {
			super();
			this.user = user;
			this.password = password;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public String toString() {
			return "Usuario [id=" + id + ", user=" + user + ", password=" + password + 
			", getClass()=" + getClass() + ", hashCode()=" + hashCode()	+ 
			", toString()=" + super.toString() + "]";
		}
		
}