package model.repository.carro;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.entity.carros.Montadora;
import model.repository.Banco;
import model.repository.BaseRepository;

public class MontadoraRepository implements BaseRepository<Montadora> {

		@Override
		public Montadora salvar(Montadora novaMontadora) {
			String sql = " insert into montadora (Nome, pais_fundacao, nome_presidente, data_fundacao) values\r\n"
					+ "    (?,?,?,?); ";
			Connection conexao = Banco.getConnection();
			PreparedStatement stmt = Banco.getPreparedStatementWithPk(conexao, sql);
			
			try {
				stmt.setString(1, novaMontadora.getNome());
				stmt.setString(2, novaMontadora.getPaisFundacao());
				stmt.setString(3, novaMontadora.getNomePresidente());
				stmt.setDate(4, Date.valueOf(novaMontadora.getDataFundacao()));
				
				stmt.execute();
				ResultSet resultado = stmt.getGeneratedKeys();
				if(resultado.next()) {
					novaMontadora.setId(resultado.getInt(1));
				}
			} catch (SQLException e) {
				System.out.println("Erro ao salvar nova montadora");
				System.out.println("Erro: " + e.getMessage());
			}
			
			return novaMontadora;
		}

		@Override
		public boolean excluir(int id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean alterar(Montadora entidade) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Montadora consultarPorId(int id) {
			Connection conn = Banco.getConnection();
			Statement stmt = Banco.getStatement(conn);
			
			Montadora montadora = null;
			ResultSet resultado = null;
			String query = " SELECT * FROM montadora WHERE id = " + id;
			
			try{
				resultado = stmt.executeQuery(query);
				if(resultado.next()){
					montadora = new Montadora();
					montadora.setId(resultado.getInt("ID"));
					montadora.setNome(resultado.getString("NOME"));
					montadora.setPaisFundacao(resultado.getString("PAIS"));
					montadora.setNomePresidente(resultado.getString("NOME_DO_PRESIDENTE"));
					montadora.setDataFundacao(resultado.getDate("DATA_FUNDACAO").toLocalDate()); 
				}
			} catch (SQLException erro){
				System.out.println("Erro ao consultar montadora com o id: " + id);
				System.out.println("Erro: " + erro.getMessage());
			} finally {
				Banco.closeResultSet(resultado);
				Banco.closeStatement(stmt);
				Banco.closeConnection(conn);
			}
			return montadora;
		}

		@Override
		public ArrayList<Montadora> consultarTodos() {
			// TODO Auto-generated method stub
			return null;
		}


}
