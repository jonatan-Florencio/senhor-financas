package model.repository.carro;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.entity.carros.Carro;
import model.repository.Banco;
import model.seletor.carros.CarroSeletor;

public class CarroRepository {

	public ArrayList<Carro> consultarComFiltros(CarroSeletor seletor) throws NumberFormatException {
		ArrayList<Carro> carros = new ArrayList<>();
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);

		ResultSet resultado = null;
		String query = " select c.* from carro c " + " inner join montadora m on c.idmontadora = m.id";

		boolean primeiro = true;
		if (seletor.getModelo() != null) {
			if (primeiro) {
				query += " WHERE ";
			} else {
				query += " AND ";
			}
			query += "upper(c.modelo) LIKE UPPER('%" + seletor.getModelo() + "%')";
			primeiro = false;
		}

		if (seletor.getNomeMarca() != null) {
			if (primeiro) {
				query += " WHERE ";
			} else {
				query += " AND ";
			}
			query += " upper(m.nome) LIKE UPPER('%" + seletor.getNomeMarca() + "%')";
		}
		
		if (seletor.getPaisMarca() != null) {
			if (primeiro) {
				query += " WHERE ";
			} else {
				query += " AND ";
			}
			query += " upper(m.pais) LIKE UPPER('%" + seletor.getPaisMarca() + "%')";
		}
		
		if (seletor.getAnoInicial() != null) {
			if (primeiro) {
				query += " WHERE ";
			} else {
				query += " AND ";
			}
			query += "BETWEEN ('%" + seletor.getAnoInicial() +","+seletor.getAnoFinal() + "%')";
		}

		try {
			resultado = stmt.executeQuery(query);
			CarroRepository carroRepository = new CarroRepository();
			while (resultado.next()) {
				Carro carro = new Carro();
				carro.setId(Integer.parseInt(resultado.getString("ID")));
				carro.setModelo(resultado.getString("MODELO"));
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao consultar todos os carrps");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return carros;
	}
}
