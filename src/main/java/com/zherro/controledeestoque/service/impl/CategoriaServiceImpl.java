package com.zherro.controledeestoque.service.impl;

import com.zherro.controledeestoque.domain.Categoria;
import com.zherro.controledeestoque.repository.CategoriaRepository;
import com.zherro.controledeestoque.service.EntityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements EntityService<Categoria>
{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void salvar(Categoria categoria)
    {
       this.categoriaRepository.save(categoria);
    }

    @Override
    public void delete(Long id)
    {
        Categoria categoria = buscaPorId(id);
        categoria.setStatus(false);
        salvar(categoria);
    }

    @Override
    public Categoria buscaPorId(Long id)
    {
        return this.categoriaRepository.getById(id);
    }

    @Override
    public List<Categoria> listarTodos()
    {
        return this.categoriaRepository.findAll();
    }
}
