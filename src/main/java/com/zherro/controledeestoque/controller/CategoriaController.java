package com.zherro.controledeestoque.controller;

import com.zherro.controledeestoque.domain.Categoria;
import com.zherro.controledeestoque.service.EntityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categorias")
public class CategoriaController
{

    @Autowired
    private EntityService<Categoria> categoriaService;

    @GetMapping
    public String listaCategorias(Model model) {
        List<Categoria> categorias = categoriaService.listarTodos();

        model.addAttribute("categorias", categorias);
        return "crud/categoria/categoria.html";
    }
}
