package one;

import classes.Aluno;
import classes.Estado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ExecutionOne {
    public static void main(String[] args) {

        // Iniciais para criar um gerenciador de entidades com o banco de dados especificado no arquivo "persistence.xml"
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("part1-DIO");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Cria instancias para serem adicionadas no banco de dados
        Estado estadoParaAdicionar = new Estado("Rio de Janeiro", "RJ");
        Aluno alunoParaAdicionar = new Aluno("Daniel", 29, estadoParaAdicionar);

        // Inicia uma trasacao para adiconar as instancias no banco de dados
        entityManager.getTransaction().begin();

        entityManager.persist(estadoParaAdicionar);
        entityManager.persist(alunoParaAdicionar);

        entityManager.getTransaction().commit();

        //Encerrar o gerenciador de entidades e encerrar a fabrica de gerenciadores de entidade
        entityManager.close();
        entityManagerFactory.close();

    }
}
