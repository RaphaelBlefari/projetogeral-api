package com.blefari.projetogeral.repository.Catalogo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.blefari.projetogeral.model.Catalogo.Produto;

public interface CatalogoRepository  extends CrudRepository<Produto, Integer>{

    @Override
    List<Produto> findAll();
	
}
