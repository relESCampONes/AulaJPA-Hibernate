package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {

//		Criando objetos que serão persistidos no banco de dados, o valor do id está nulo, pois será atribuído um id automaticamente de acordo com a inserção
//		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
//		Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
//		Pessoa p3 = new Pessoa(null, "Ana Maria", "maria@gmail.com");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

//		Persistir um objeto em uma unica linha da tabela do banco de dados
//		Sempre que for feita uma operação que não seja apenas um consulta, deverá ser feita a abertura e fechamento de uma transação
//		em.getTransaction().begin();
//		em.persist(p1);
//		em.persist(p2);
//		em.persist(p3);
//		em.getTransaction().commit();

//		Procurar uma pessoa pelo Id
//		Pessoa p = em.find(Pessoa.class, 2);
//		System.out.println(p);

		Pessoa p = em.find(Pessoa.class, 2);
		em.getTransaction().begin();
//		Para remover esse objeto informado como argumento, ele tem que estar monitorado(um objeto que acabou de ser inserido ou um objeto que foi buscado no banco de dados e ainda não foi fechado o entityManager(em.close())
		em.remove(p);
		em.getTransaction().commit();

		System.out.println("Pronto!");
		em.close();
		emf.close();

	}

}
