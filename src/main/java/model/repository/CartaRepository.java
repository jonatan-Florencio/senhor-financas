package model.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import model.entity.vemnox1.Carta;
import model.entity.vemnox1.Partida;

public class CartaRepository implements BaseRepository<Carta> {

	@Override
	public Carta salvar(Carta novaEntidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean excluir(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterar(Carta entidade) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Carta consultarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Carta> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//TODO porque está com erro? Cenas dos próximos capítulos....
}
