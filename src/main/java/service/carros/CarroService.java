package service.carros;

import java.util.ArrayList;
import java.util.List;

import exception.CarrosException;
import model.entity.carros.Carro;
import model.entity.carros.Montadora;
import model.seletor.carros.CarroSeletor;

public class CarroService {
	
	public ArrayList<Carro> consultarComFiltros(CarroSeletor seletor) {
		ArrayList<Carro> carros = new ArrayList<>();
		
		//TODO obter os carros cadastrados no banco
		
		return carros;
	}

}
