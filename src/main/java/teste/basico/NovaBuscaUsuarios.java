package teste.basico;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Usuario;

public class NovaBuscaUsuarios {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o id para alterar as informacoes do usuario: ");
		
		Long codigoUsuario = sc.nextLong();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa-coder");
		
		EntityManager em = emf.createEntityManager();
		
		System.out.println("Informacoes atuais: ");
		
		String jpql = "SELECT u FROM Usuario u WHERE u.id = ?1";
		
		TypedQuery<Usuario> users = em.createQuery(jpql, Usuario.class)
				.setParameter(1, codigoUsuario);
		
		Usuario user = users.getSingleResult();
		
		System.out.println(user.getId() + " " + user.getNome() + " " + user.getEmail());
		
		System.out.println("Escolha a informacao que deseja alterar (1) Nome (2) Email ");
		
		Integer escolha = sc.nextInt();
		
	    sc.nextLine();

	    switch (escolha) {
	        case 1:
	            System.out.print("Novo nome: ");
	            String novoNome = sc.nextLine();
	            user.setNome(novoNome);
	            break;
	        case 2:
	            System.out.print("Novo email: ");
	            String novoEmail = sc.nextLine();
	            user.setEmail(novoEmail);
	            break;
	    }
		
		em.getTransaction().begin();
		
		em.merge(user);
		
		em.getTransaction().commit();
		
		emf.close();
		
		em.close();
		
	}
}
