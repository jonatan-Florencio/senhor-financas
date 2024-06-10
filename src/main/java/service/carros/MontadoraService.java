package service.carros;

import exception.CarrosException;
import model.entity.carros.Montadora;
import model.repository.carro.MontadoraRepository;

public class MontadoraService {

	private MontadoraRepository repository = new MontadoraRepository();

	public Montadora salvar(Montadora novaMontadora) throws CarrosException {
		validarCamposObrigatorios(novaMontadora);
		return repository.salvar(novaMontadora);
	}
	
	public Montadora consultarPorId(int id) {
		return repository.consultarPorId(id);
	}

	private void validarCamposObrigatorios(Montadora m) throws CarrosException {
		String mensagemValidacao = "";
		if (m.getNome() == null || m.getNome().isEmpty()) {
			mensagemValidacao += " - informe o nome da montadora \n";
		}
		if (m.getDataFundacao() == null) {
			mensagemValidacao += " - informe a data de fundação \n";
		}
		if (m.getNomePresidente() == null || m.getNomePresidente().isEmpty()) {
			mensagemValidacao += " - informe o nome do Presidente";
		}
		if (m.getPaisFundacao() == null || m.getPaisFundacao().isEmpty()) {
			mensagemValidacao += " - informe o pais da montadora \n";

			if (!mensagemValidacao.isEmpty()) {
				throw new CarrosException("Preencha o(s) seguinte(s) campo(s) \n " + mensagemValidacao);
			}
		}

	}
}
