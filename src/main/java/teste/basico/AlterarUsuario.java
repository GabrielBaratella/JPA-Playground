package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa-coder");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Usuario user = em.find(Usuario.class, 2L);
		user.setNome("Sou um novo usuario atualizado");
		user.setEmail("newuserhelloworld@gmail.com");
		
		em.merge(user);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
