package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class NovoUsuario {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("exercicios-jpa-coder");
		EntityManager em = emf.createEntityManager();
		
		Usuario user = new Usuario( "Usuario teste2", "usuariotestehelloworld@gmail.com");
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		
		Usuario x = em.find(Usuario.class, 1L);
		
		System.out.println(x.getNome());
		
		em.close();
		emf.close();
	}

}
