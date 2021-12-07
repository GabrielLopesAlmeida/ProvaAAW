package MicroEmpresa.MicroEmpresa.services;

import java.util.List;

import MicroEmpresa.model.Empresa;

public interface EmpresaService {
	
	List<Empresa> listarTodos();
	
	Empresa listarPorId(String id);
	
	Empresa cadastrar(Empresa empresa);
	
	Empresa atualizar(Empresa empresa);
	
	void remover(String id);
}
