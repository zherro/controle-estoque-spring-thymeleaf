package com.zherro.controledeestoque.service;

import java.util.List;

public interface EntityService<T>
{
    void salvar(T data);
    void delete(Long id);
    T buscaPorId(Long id);
    List<T> listarTodos();
}
