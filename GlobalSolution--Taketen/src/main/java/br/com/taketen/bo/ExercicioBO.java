package br.com.taketen.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.taketen.beans.Exercicio;
import br.com.taketen.dao.ExercicioDAO;

public class ExercicioBO {
	
	ExercicioDAO exercicioDao;

	// Selecionar
	public ArrayList<Exercicio> secionarBo() throws SQLException, ClassNotFoundException {
		exercicioDao = new ExercicioDAO();
		return (ArrayList<Exercicio>) exercicioDao.selecionar();
	}

	public void inserirBo(Exercicio exercicio) throws ClassNotFoundException, SQLException {
		ExercicioDAO exercicioDao = new ExercicioDAO();
		exercicioDao.inserir(exercicio);
	}

	public void atualizarBo(Exercicio exercicio) throws ClassNotFoundException, SQLException {
		ExercicioDAO exercicioDao = new ExercicioDAO();
		exercicioDao.atualizar(exercicio);
	}

	public void deletarBo(int id) throws ClassNotFoundException, SQLException {
		ExercicioDAO exercicioDao = new ExercicioDAO();
		exercicioDao.deletar(id);
	}

}
