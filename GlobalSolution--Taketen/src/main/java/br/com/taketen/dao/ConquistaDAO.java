package br.com.taketen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.taketen.beans.Conquista;
import br.com.taketen.conexoes.ConexaoFactory;

public class ConquistaDAO {

	public Connection minhaConexao;

	public ConquistaDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}

	// Insert
	public String inserir(Conquista conquista) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement(" Insert into T_TKN_CONQUISTA values (?, ?, ?, ?, ?, ?, ?, ?)");
		stmt.setInt(1, conquista.getIdConquista());
		stmt.setInt(2, conquista.getNumeroPontuacaoConquista());
		stmt.setString(3, conquista.getDescricaoConquista());
		stmt.setString(4, conquista.getNumeroConquista());
		stmt.setString(5, conquista.getDescricaoTipoConquista());
		stmt.setDouble(6, conquista.getNumeroProgressoAtual());
		stmt.setInt(7, conquista.getIdSessaoGinastica());
		stmt.setInt(8, conquista.getIdDesafio());
		stmt.execute();
		stmt.close();
		return "Cadastrado com Sucesso!";
	}

	// Delete
	public String deletar(int id) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement("Delete from T_TKN_CONQUISTA where id_conquista = ?");
		stmt.setInt(1, id);
		stmt.execute();
		stmt.close();
		return "Deletado com Sucesso!";
	}

	// UpDate
	public String atualizar(Conquista conquista) throws SQLException {
		PreparedStatement stmt = minhaConexao
				.prepareStatement(" Update T_TKN_CONQUISTA set nr_pontuacao_conquista = ?, ds_conquista = ?, nm_conquista = ?, "
						+ "ds_tipo_conquista = ?, nr_progresso_atual = ?, "
						+ "id_desafio = ?, id_sessao_ginastica = ? where id_conquista = ?");
		stmt.setInt(1, conquista.getNumeroPontuacaoConquista());
		stmt.setString(2, conquista.getDescricaoConquista());
		stmt.setString(3, conquista.getNumeroConquista());
		stmt.setString(4, conquista.getDescricaoTipoConquista());
		stmt.setDouble(5, conquista.getNumeroProgressoAtual());
		stmt.setInt(6, conquista.getIdSessaoGinastica());
		stmt.setInt(7, conquista.getIdDesafio());
		stmt.setInt(8, conquista.getIdConquista());
		stmt.executeUpdate();
		stmt.close();
		return "Atualizado com Sucesso!";
	}

	// Select
	public List<Conquista> selecionar() throws SQLException {
		List<Conquista> listaConquista = new ArrayList<Conquista>();
		PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM T_TKN_CONQUISTA");

		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			Conquista Conquista = new Conquista();
			Conquista.setIdConquista(rs.getInt(1));
			Conquista.setNumeroPontuacaoConquista(rs.getInt(2));
			Conquista.setDescricaoConquista(rs.getString(3));
			Conquista.setNumeroConquista(rs.getString(4));
			Conquista.setDescricaoTipoConquista(rs.getString(5));
			Conquista.setNumeroProgressoAtual(rs.getDouble(6));
			Conquista.setIdSessaoGinastica(rs.getInt(7));
			Conquista.setIdDesafio(rs.getInt(8));
			listaConquista.add(Conquista);
		}
		return listaConquista;
	}
}
