package teste.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Usuario;

public class ObterUsuarios {
	
	public static void main(String[] args) {
		
		System.out.println("Lista de usuarios: ");
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("exercicios-jpa-coder");
		
		EntityManager em = emf.createEntityManager();
		
		String jpql = "SELECT u from Usuario u";
		
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
		
		List<Usuario> users = query.getResultList();
		
		for(Usuario u : users) {
			System.out.println(u.getId() + " " + u.getNome() + ", " + u.getEmail());
		}
		
	}

}
