package br.com.dio.dao;

import br.com.dio.bean.UserUtils;
import br.com.dio.model.Employee;
import br.com.dio.model.Empresa;
import br.com.dio.util.Cast;
import br.com.dio.util.SQLUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDaoHibernate implements IEmpresaDao{

    private EntityManagerFactory emf;

    public EmpresaDaoHibernate(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void insert(Empresa obj) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        obj.setAppId(UserUtils.getAppId());
        System.out.println(obj.getAppId());
        transaction.begin();
        entityManager.persist(obj);
        transaction.commit();
    }

    @Override
    public void update(Empresa obj) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(obj);
        transaction.commit();
    }

    @Override
    public void delete(Empresa obj) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        obj.setDeletado(true);
        entityManager.merge(obj);
        transaction.commit();
    }

    @Override
    public Empresa findById(int id) {
        Empresa obj = new Empresa();
        EntityManager entityManager = emf.createEntityManager();
        obj = entityManager.find(Empresa.class, id);
        return obj;
    }

    @Override
    public List<Empresa> findByNome(String nome) {
        return null;
    }

    @Override
    public List<Empresa> findAll() {
        String where = SQLUtils.builderWhere(UserUtils.getAppId(), "");
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT vo.id, " +
                    "vo.appId, " +
                    "vo.balanco, " +
                    "vo.capitalSocial, " +
                    "vo.cnpj, " +
                    "vo.email, " +
                    "vo.endereco, " +
                    "vo.estado, " +
                    "vo.faturamentoMensal, " +
                    "vo.lucro, " +
                    "vo.nomeEmpresa, " +
                    "vo.ramoAtuacao, " +
                    "vo.telefone " +
                    "FROM tb_empresa vo " +
                    where);
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createNativeQuery(sql.toString());
        List<Object[]> empresaResultSet = query.getResultList();
        List<Empresa> list = new ArrayList<>();
        if (!empresaResultSet.isEmpty()) {
            for (Object[] o : empresaResultSet) {
                Empresa emp;
                emp = instatiateEmpresa(o);
                list.add(emp);
            }
        }

        return list;
    }

    private Empresa instatiateEmpresa(Object[] o) {
        Empresa em = new Empresa();

        em.setIdEmpresa(Cast.toInteger(o[0]));
        em.setAppId(Cast.toInteger(o[1]));
        em.setBalanco(Cast.toDouble(o[2]));
        em.setCapitalSocial(Cast.toDouble(o[3]));
        em.setCnpj(Cast.toLong(o[4]));
        em.setEmail(o[5] == null ? null : o[5].toString());
        em.setEndereco(o[6] == null ? null : o[6].toString());
        em.setEstado(o[7] == null ? null : o[7].toString());
        em.setFaturamentoMensal(Cast.toDouble(o[8]));
        em.setLucro(Cast.toDouble(o[9]));
        em.setNomeEmpresa(o[10] == null ? null : o[10].toString());
        em.setRamoAtuacao(o[11] == null ? null : o[11].toString());
        em.setTelefone(Cast.toLong(o[12]));

        return em;
    }
}
