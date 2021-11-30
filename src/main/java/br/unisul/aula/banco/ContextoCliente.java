package br.unisul.aula.banco;

import br.unisul.aula.modelo.Cliente;
import br.unisul.aula.modelo.UnidadeFederativa;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ContextoCliente implements DbCrud<Cliente> {
    @Override
    public void insert(Cliente cliente) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
    }

    @Override
    public void remove(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Cliente.class, id));
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Cliente cliente) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Cliente> findAll() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        return entityManager
                .createQuery("SELECT e FROM Cliente e", Cliente.class)
                .getResultList();
    }

    @Override
    public Cliente findById(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        TypedQuery<Cliente> query = entityManager
                .createQuery("SELECT s FROM Cliente s where s.id =:id", Cliente.class);
        return query.setParameter("id", id).getSingleResult();
    }

    public List<Cliente> findClientsByCity(String cidade) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        return entityManager
                .createQuery("SELECT s FROM Cliente s WHERE s.endereco.cidade = :cidade", Cliente.class)
                .setParameter("cidade", cidade)
                .getResultList();

    }

    public UnidadeFederativa getUfByCityName(String cidade) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            return entityManager
                    .createQuery("SELECT s.uf FROM Endereco s WHERE s.cidade = :cidade", UnidadeFederativa.class)
                    .setParameter("cidade", cidade)
                    .getSingleResult();

        } catch (Exception _e){
            return null;
        }

    }
}
