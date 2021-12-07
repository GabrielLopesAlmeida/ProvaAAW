package MicroEmpresa.MicroEmpresa.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import MicroEmpresa.MicroEmpresa.Responses.Response;
import MicroEmpresa.MicroEmpresa.services.EmpresaService;
import MicroEmpresa.model.*;
@RestController
@RequestMapping(path = "/api/Empresas")
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping
	public ResponseEntity<Response<List<Empresa>>> listarTodos(){
		return ResponseEntity.ok(new Response<List<Empresa>>(this.empresaService.listarTodos()));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Empresa>> listarPorId(@PathVariable(name="id")String id){
		return ResponseEntity.ok(new Response<Empresa>(this.empresaService.listarPorId(id)));		
	}
	
	@PostMapping
	public ResponseEntity<Response<Empresa>> cadastrar(@Valid @RequestBody Empresa empresa, BindingResult result){
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Empresa>(erros));
		}
		
		return ResponseEntity.ok(new Response<Empresa>(this.empresaService.cadastrar(empresa)));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<Empresa>> atualizar(@PathVariable(name="id")String id , @Valid @RequestBody Empresa empresa, BindingResult result){
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Empresa>(erros));
		}
		
		empresa.setId(id);
		return ResponseEntity.ok(new Response <Empresa>(this.empresaService.cadastrar(empresa)));
	}
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Integer>> remover(@PathVariable(name= "id")String id){
		this.empresaService.remover(id);
		return ResponseEntity.ok(new Response<Integer>(1));
		
	}
	
}
