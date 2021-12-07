package MicroEmpresa.MicroEmpresa.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import MicroEmpresa.model.Empresa;

public interface EmpresaRepository extends MongoRepository<Empresa, String> {

}
