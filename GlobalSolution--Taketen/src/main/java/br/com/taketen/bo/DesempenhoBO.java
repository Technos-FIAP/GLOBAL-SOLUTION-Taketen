package br.com.taketen.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.taketen.beans.Desempenho;
import br.com.taketen.dao.DesempenhoDAO;

public class DesempenhoBO {
	
	DesempenhoDAO desempenhoDao;

	// Selecionar
	public ArrayList<Desempenho> secionarBo() throws SQLException, ClassNotFoundException {
		desempenhoDao = new DesempenhoDAO();
		return (ArrayList<Desempenho>) desempenhoDao.selecionar();
	}

	public void inserirBo(Desempenho desempenho) throws ClassNotFoundException, SQLException {
		DesempenhoDAO desempenhoDao = new DesempenhoDAO();
		desempenhoDao.inserir(desempenho);
	}

	public void atualizarBo(Desempenho desempenho) throws ClassNotFoundException, SQLException {
		DesempenhoDAO desempenhoDao = new DesempenhoDAO();
		desempenhoDao.atualizar(desempenho);
	}

	public void deletarBo(int id) throws ClassNotFoundException, SQLException {
		DesempenhoDAO desempenhoDao = new DesempenhoDAO();
		desempenhoDao.deletar(id);
	}

}