package service;

import java.util.List;

import exception.VacinacaoException;
import model.entity.Vacina;
import model.repository.VacinaRepository;
import model.repository.VacinacaoRepository;

public class VacinaService {

	private VacinaRepository repository = new VacinaRepository();
	
	public Vacina salvar(Vacina novaVacina){
		return repository.salvar(novaVacina);
	}

	public boolean atualizar(Vacina vacinaEditada) {
		return repository.alterar(vacinaEditada);
	}

	public boolean excluir(int id) throws VacinacaoException {
		validarVacinaAplicada();
		return repository.excluir(id);
	}

	public Vacina consultarPorId(int id) {
		return repository.consultarPorId(id);
	}

	public List<Vacina> consultarTodas() {
		return repository.consultarTodos();
	}
	
private void validarVacinaAplicada() throws VacinacaoException {
		
		VacinacaoRepository vacinacaoRepository = new VacinacaoRepository();
		if(vacinacaoRepository.salvar(null) != null ) {
		throw new VacinacaoException("vacina aplicada não pode ser excluida.");
		}
	}
}
