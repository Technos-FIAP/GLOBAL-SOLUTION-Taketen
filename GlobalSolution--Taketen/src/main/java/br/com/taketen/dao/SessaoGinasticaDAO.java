package br.com.taketen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.taketen.beans.SessaoGinastica;
import br.com.taketen.conexoes.ConexaoFactory;

public class SessaoGinasticaDAO {

	public Connection minhaConexao;

	public SessaoGinasticaDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}

	// Insert
	public String inserir(SessaoGinastica sessaoGinastica) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement(" Insert into T_TKN_SESSAO_GINASTICA values (?, ?, ?, ?)");
		stmt.setInt(1, sessaoGinastica.getIdSessaoGinastica());
		stmt.setString(2, sessaoGinastica.getDataSessao());
		stmt.setDouble(3, sessaoGinastica.getNumeroDuracao());
		stmt.setInt(4, sessaoGinastica.getIdUsuario());
		stmt.execute();
		stmt.close();
		return "Cadastrado com Sucesso!";
	}

	// Delete
	public String deletar(int id) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement("Delete from T_TKN_SESSAO_GINASTICA where id_sessao_ginastica = ?");
		stmt.setInt(1, id);
		stmt.execute();
		stmt.close();
		return "Deletado com Sucesso!";
	}

	// UpDate
	public String atualizar(SessaoGinastica sessaoGinastica) throws SQLException {
		PreparedStatement stmt = minhaConexao
				.prepareStatement(" Update T_TKN_SESSAO_GINASTICA set dt_sessao = ?, "
						+ "nr_duracao = ?, id_usuario = ? where id_sessao_ginastica = ?");
		stmt.setString(1, sessaoGinastica.getDataSessao());
		stmt.setDouble(2, sessaoGinastica.getNumeroDuracao());
		stmt.setInt(3, sessaoGinastica.getIdUsuario());
		stmt.setInt(4, sessaoGinastica.getIdSessaoGinastica());
		stmt.executeUpdate();
		stmt.close();
		return "Atualizado com Sucesso!";
	}

	// Select
	public List<SessaoGinastica> selecionar() throws SQLException {
		List<SessaoGinastica> listaSessaoGinastica = new ArrayList<SessaoGinastica>();
		PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM T_TKN_SESSAO_GINASTICA");

		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			SessaoGinastica sessaoGinastica = new SessaoGinastica();
			sessaoGinastica.setIdSessaoGinastica(rs.getInt(1));
			sessaoGinastica.setIdUsuario(rs.getInt(4));
			sessaoGinastica.setDataSessao(rs.getString(2));
			sessaoGinastica.setNumeroDuracao(rs.getDouble(3));
			listaSessaoGinastica.add(sessaoGinastica);
		}
		return listaSessaoGinastica;
	}
}
