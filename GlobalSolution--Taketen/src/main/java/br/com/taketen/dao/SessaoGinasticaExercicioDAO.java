package br.com.taketen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.taketen.beans.SessaoGinasticaExercicio;
import br.com.taketen.conexoes.ConexaoFactory;

public class SessaoGinasticaExercicioDAO {

	public Connection minhaConexao;

	public SessaoGinasticaExercicioDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}

	// Insert
	public String inserir(SessaoGinasticaExercicio sessaoGinasticaExercicio) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement(" Insert into T_TKN_SESSAO_GINASTICA_EXERCICIO values (?, ?, ?)");
		stmt.setInt(1, sessaoGinasticaExercicio.getIdSessaoGinasticaExercicio());
		stmt.setInt(2, sessaoGinasticaExercicio.getIdExercicio());
		stmt.setInt(3, sessaoGinasticaExercicio.getIdSessaoGinastica());
		stmt.execute();
		stmt.close();
		return "Cadastrado com Sucesso!";
	}

	// Delete
	public String deletar(int id) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement("Delete from T_TKN_SESSAO_GINASTICA_EXERCICIO where id_sessao_exercicio = ?");
		stmt.setInt(1, id);
		stmt.execute();
		stmt.close();
		return "Deletado com Sucesso!";
	}

	// UpDate
	public String atualizar(SessaoGinasticaExercicio sessaoGinasticaExercicio) throws SQLException {
		PreparedStatement stmt = minhaConexao
				.prepareStatement(" Update T_TKN_SESSAO_GINASTICA_EXERCICIO set id_exercicio = ?, "
						+ "id_sessao_ginastica = ? where id_sessao_exercicio = ?");
		stmt.setInt(1, sessaoGinasticaExercicio.getIdExercicio());
		stmt.setInt(2, sessaoGinasticaExercicio.getIdSessaoGinastica());
		stmt.setInt(3, sessaoGinasticaExercicio.getIdSessaoGinasticaExercicio());
		stmt.executeUpdate();
		stmt.close();
		return "Atualizado com Sucesso!";
	}

	// Select
	public List<SessaoGinasticaExercicio> selecionar() throws SQLException {
		List<SessaoGinasticaExercicio> listaSessaoGinasticaExercicio = new ArrayList<SessaoGinasticaExercicio>();
		PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM T_TKN_SESSAO_GINASTICA_EXERCICIO");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			SessaoGinasticaExercicio sessaoGinasticaExercicio = new SessaoGinasticaExercicio();
			sessaoGinasticaExercicio.setIdSessaoGinasticaExercicio(rs.getInt(1));
			sessaoGinasticaExercicio.setIdExercicio(rs.getInt(2));
			sessaoGinasticaExercicio.setIdSessaoGinastica(rs.getInt(3));
			listaSessaoGinasticaExercicio.add(sessaoGinasticaExercicio);
		}
		return listaSessaoGinasticaExercicio;
	}
}
