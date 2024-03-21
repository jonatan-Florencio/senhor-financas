package model.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.entity.Pais;

public class PaisRepository implements BaseRepository<Pais> {

	@Override
	public Pais salvar(Pais novaEntidade) {
		String sql = "INSERT INTO PAIS(NOME, SIGLA";
		Connection conexao = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatementWithPk(conexao, sql);
		
		try {
			stmt.setString(1, novoPais, )
		} catch(SQLException e){
			
		}
		return null;
	}

	@Override
	public boolean alterar(Pais entidade) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluir(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pais consultarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Pais> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
}
