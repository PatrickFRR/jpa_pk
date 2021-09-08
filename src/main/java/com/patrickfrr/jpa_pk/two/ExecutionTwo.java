package com.patrickfrr.jpa_pk.two;

import com.patrickfrr.jpa_pk.classes.Aluno;
import com.patrickfrr.jpa_pk.classes.Estado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ExecutionTwo {
    public static void main(String[] args) {

        //inicia a criação um gerenciado de entidades com o banco de dados especificado no arquivo  "persistence.xml"
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("part2-DIO");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Cria instancias para serem adicionadas no banco de dados
        Estado estadoParaAdicionar = new Estado("Rio de Janeiro", "RJ");
        Aluno alunoParaAdicionar = new Aluno("Daniel", 29, estadoParaAdicionar);

        // Inicia uma trasacao para adiconar as instancias no banco de dados
        entityManager.getTransaction().begin();

        entityManager.persist(estadoParaAdicionar);
        entityManager.persist(alunoParaAdicionar);

        entityManager.getTransaction().commit();

        //Resgataa instâncias no banco de dados
//        Estado estadoEncontrado = entityManager.find(Estado.class, 1);
//        Aluno alunoEncontrado = entityManager.find(Aluno.class, 1);
//
//        System.out.println(estadoEncontrado);
//        System.out.println(alunoEncontrado);

        //Altera uma entidade
//        entityManager.getTransaction().begin();
//
//        alunoEncontrado.setNome("Karam");
//        alunoEncontrado.setIdade(20);
//
//        entityManager.getTransaction().commit();

        // Remove uma entidade
//        entityManager.getTransaction().begin();
//
//        entityManager.remove(alunoEncontrado);
//
//        entityManager.getTransaction().commit();

        // Encerra o gerenciador de entidades e encerrar a fabrica de gerenciadores de entidade.
        entityManager.close();
        entityManagerFactory.close();

    }
}
