package com.zherro.controledeestoque.repository;

import com.zherro.controledeestoque.domain.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>
{

     @Query(value = "select * from  tb_categorias c WHERE c.status ORDER BY c.id DESC", nativeQuery = true)
//    @Query("FROM Categoria c WHERE c.status = true ORDER BY c.id DESC")
    List<Categoria> findAll();
}
