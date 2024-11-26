package model.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.Usuario;
import model.repository.Banco;
import model.repository.BaseRepository;

public class UsuarioRepository implements BaseRepository<Usuario> {

	@Override
	public Usuario salvar(Usuario novoUsuario) {
		String sql = " INSERT INTO usuario (nome, email, login, senha, "
				   + "		               datacadastro, dataexpiracao) "
				   + " VALUES(?, ?, ?, ?, ?, ?) ";
		Connection conexao = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatementWithPk(conexao, sql);
		
		try {
			stmt.setString(1, novoUsuario.getNome());
			stmt.setString(2, novoUsuario.getEmail());
			stmt.setString(3,  novoUsuario.getLogin() + "");
			stmt.setString(4,  novoUsuario.getSenha());
			stmt.setDate(5, Date.valueOf( novoUsuario.getDataCadastro()));
			stmt.setDate(6, Date.valueOf( novoUsuario.getDataExpiracao()));
			
			stmt.execute();
			ResultSet resultado = stmt.getGeneratedKeys();
			if(resultado.next()) {
				novoUsuario.setId(resultado.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar novo Usuario");
			System.out.println("Erro: " + e.getMessage());
		}
		
		return novoUsuario;
	}

	@Override
	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean excluiu = false;
		String query = "DELETE FROM usuario WHERE id = " + id;
		try {
			if(stmt.executeUpdate(query) == 1) {
				excluiu = true;
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao excluir Usuario");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return excluiu;
	}

	@Override
	public boolean alterar(Usuario usuarioEditado) {
		boolean alterou = false;
		String query = " UPDATE usuario "
				     + " SET nome=?, email=?, login=?, senha=? "
				     + " datacadastro=?, dataexpiracao=? "
				     + " WHERE id=? ";
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatementWithPk(conn, query);
		try {
			stmt.setString(1, usuarioEditado.getNome());
			stmt.setString(2,  usuarioEditado.getEmail());
			stmt.setString(3,  usuarioEditado.getLogin());
			stmt.setString(4,  usuarioEditado.getSenha());
			stmt.setDate(5, Date.valueOf( usuarioEditado.getDataCadastro()));
			stmt.setDate(6, Date.valueOf( usuarioEditado.getDataExpiracao()));
			
			stmt.setInt(7, usuarioEditado.getId());
			alterou = stmt.executeUpdate() > 0;
		} catch (SQLException erro) {
			System.out.println("Erro ao atualizar usuario");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return alterou;
	}

	@Override
	public Usuario consultarPorId(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		
		Usuario usuario = null;
		ResultSet resultado = null;
		String query = " SELECT * FROM pessoa WHERE id = " + id;
		
		try{
			resultado = stmt.executeQuery(query);
			if(resultado.next()){
				usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setEmail(resultado.getString("email"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				usuario.setDataCadastro(resultado.getDate("datacadastro").toLocalDate()); 
				usuario.setDataExpiracao(resultado.getDate("dataexpiracao").toLocalDate()); 
				
			}
		} catch (SQLException erro){
			System.out.println("Erro ao consultar usuario com o id: " + id);
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return usuario;
	}

	@Override
	public ArrayList<Usuario> consultarTodos() {
		ArrayList<Usuario> usuarios = new ArrayList<>();
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		
		ResultSet resultado = null;
		String query = " SELECT * FROM usuario";
		
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				Usuario usuario = construirDoResultSet(resultado);
				usuarios.add(usuario);
			}
		} catch (SQLException erro){
			System.out.println("Erro ao consultar todas as pessoas");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return usuarios;
	}
	

	private Usuario construirDoResultSet(ResultSet resultado) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setId(resultado.getInt("id"));
		usuario.setNome(resultado.getString("nome"));
		usuario.setLogin(resultado.getString("login"));
		usuario.setSenha(resultado.getString("senha"));
		usuario.setDataCadastro(resultado.getDate("datacadastro").toLocalDate()); 
		usuario.setDataExpiracao(resultado.getDate("dataexpiracao").toLocalDate());
		return usuario;
	}

	//public boolean emailjaCadastrado(String email) {
	// email JaUtilizado = false;	
		
	// conn = Banco.getConnection();
	//	Statement stmt = Banco.getStatement(conn);
	// query = " SELECT count(id) FROM usuario WHERE email = " + email;
		
	//	try {
		//	ResultSet resultado = stmt.executeQuery(query);
		//	emailJaUtilizado = (resultado.getInt(1) > 0);
	//	} catch (SQLException e) {
	//		System.out.println("Erro ao consultar email. Causa: " + e.getMessage());
	//	}
		
	//	return cpfJaUtilizado;
	//}
}