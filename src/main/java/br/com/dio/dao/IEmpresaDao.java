package br.com.dio.dao;

import br.com.dio.model.Empresa;

import java.util.List;

public interface IEmpresaDao {
    void insert(Empresa obj);
    void update(Empresa obj);
    void delete(Empresa obj);
    Empresa findById(int id);
    List<Empresa> findByNome(String nome);
    List<Empresa> findAll();
}
