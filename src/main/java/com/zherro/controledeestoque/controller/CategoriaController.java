package com.zherro.controledeestoque.controller;

import com.zherro.controledeestoque.domain.Categoria;
import com.zherro.controledeestoque.service.EntityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/form-categoria")
    public String formCategoria( Model model ) {
        Categoria categoria = new Categoria();

        model.addAttribute("categoria", categoria);
        model.addAttribute("emEdicao", false);

        return "crud/categoria/form-categoria.html";
    }

    @GetMapping("/editar-categoria")
    public String editarCategoria( @RequestParam Long idCategoria, Model model) {
        Categoria categoria = categoriaService.buscaPorId(idCategoria);

        model.addAttribute("categoria", categoria);
        model.addAttribute("emEdicao", true);

        return "crud/categoria/form-categoria.html";
    }

    @PostMapping("/salvar-categorias")
    public String criarCategoria(Categoria categoria, Model model) {
        categoria.setStatus(true);
        categoriaService.salvar(categoria);
        return "redirect:/categorias";
    }

    @PostMapping("/remover-categoria")
    public String removerCategoria( @RequestParam Long idCategoria, Model model) {
        categoriaService.delete(idCategoria);
        return "redirect:/categorias";
    }


}
