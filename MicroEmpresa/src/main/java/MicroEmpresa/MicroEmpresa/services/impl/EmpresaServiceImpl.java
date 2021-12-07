package MicroEmpresa.MicroEmpresa.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MicroEmpresa.MicroEmpresa.repositories.EmpresaRepository;
import MicroEmpresa.MicroEmpresa.services.EmpresaService;
import MicroEmpresa.model.Empresa;

@Service
public class EmpresaServiceImpl implements EmpresaService {
	
	
	@Autowired
	private EmpresaRepository empresaRespository;
	
	@Override
	public List<Empresa> listarTodos() {
		return this.empresaRespository.findAll();
	}

	@Override
	public Empresa listarPorId(String id) {
		return this.empresaRespository.findById(id).get();
	}

	@Override
	public Empresa cadastrar(Empresa empresa) {
		return this.empresaRespository.save(empresa);
	}

	@Override
	public Empresa atualizar(Empresa empresa) {
		return this.empresaRespository.save(empresa);
	}

	@Override
	public void remover(String id) {
		this.empresaRespository.deleteById(id);

	}

}
