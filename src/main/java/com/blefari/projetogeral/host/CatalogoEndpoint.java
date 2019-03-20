package com.blefari.projetogeral.host;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blefari.projetogeral.Service.CatalogoService;
import com.blefari.projetogeral.model.Catalogo.Produto;
import com.blefari.projetogeral.utils.model.Mensagem;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="catalogo")
public class CatalogoEndpoint {

	@Autowired
	private CatalogoService catalogoService;

	@ApiOperation(value = "Retorna Produtos")
	@RequestMapping(value="produtos",method=RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> RetornaProdutos(){

		try {					
			return new ResponseEntity<>(catalogoService.RetornaProdutos(), HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);			
		}
	}

	@ApiOperation(value = "Retorna Produto por ID")
	@RequestMapping(value="produtos/{produtoid}",method=RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> RetornaProduto(@PathVariable Integer produtoid){

		try {
			Produto produto = catalogoService.RetornaProduto(produtoid);			
			return produto.IsNull()? 
					new ResponseEntity<>("", HttpStatus.NO_CONTENT) 
					:new ResponseEntity<>(produto, HttpStatus.OK); 
		}
		catch(Exception ex)
		{
			return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);			
		}
	}

	@ApiOperation(value = "Inseri Produtos")
	@RequestMapping(value="produto",method=RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<?> InseriProduto(@RequestBody Produto produto){

		produto = catalogoService.InseriProduto(produto);			
		return produto.IsNull()? 
				new ResponseEntity<>("", HttpStatus.PARTIAL_CONTENT) 
				:new ResponseEntity<>(produto, HttpStatus.OK); 
	}
	
	@ApiOperation(value = "Atualiza Produto")
	@RequestMapping(value="produto",method=RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	public ResponseEntity<?> AtualizaProduto(@RequestBody Produto produto){

		if(produto.IsNull()) {
			return new ResponseEntity<>("", HttpStatus.PARTIAL_CONTENT);
		}		
				 				
		return produto.IsNull()? 
				new ResponseEntity<>("", HttpStatus.PARTIAL_CONTENT) 
				:new ResponseEntity<>(catalogoService.AtualizaProduto(produto), HttpStatus.OK);
	}

	@ApiOperation(value = "Deleta Produtos")
	@RequestMapping(value="produto/{produtoid}",method=RequestMethod.DELETE, produces = "application/json")	
	public ResponseEntity<?> DeletaProduto(@PathVariable Integer produtoid){

		return catalogoService.DeletaProduto(produtoid) ? 
				new ResponseEntity<>(new Mensagem("Deletado com sucesso"), HttpStatus.OK)
				:new ResponseEntity<>(new Mensagem("Deletado com sucesso"), HttpStatus.INTERNAL_SERVER_ERROR); 
				
	}
}
