package br.com.taketen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.taketen.beans.Profissao;
import br.com.taketen.conexoes.ConexaoFactory;

public class ProfissaoDAO {

	public Connection minhaConexao;

	public ProfissaoDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}
	
	// Insert
	public String inserir(Profissao profissao) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement(" Insert into T_TKN_PROFISSAO values (?, ?, ?, ?, ?, ?)");
		stmt.setInt(1, profissao.getIdProfissao());
		stmt.setString(2, profissao.getDescricaoProfissao());
		stmt.setString(3, profissao.getDescricaoNivelAtividadeFisica());
		stmt.setString(4, profissao.getDescricaoEstresseOcupacional());
		stmt.setDouble(5, profissao.getNumeroFrequenciaPausaAtiva());
		stmt.setInt(6, profissao.getIdUsuario());
		stmt.execute();
		stmt.close();
		return "Cadastrado com Sucesso!";
	}

	// Delete
	public String deletar(int id) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement("Delete from T_TKN_PROFISSAO where id_profissao = ?");
		stmt.setInt(1, id);
		stmt.execute();
		stmt.close();
		return "Deletado com Sucesso!";
	}

	// UpDate
	public String atualizar(Profissao profissao) throws SQLException {
		PreparedStatement stmt = minhaConexao
				.prepareStatement(" Update T_TKN_PROFISSAO set ds_profissao = ?, ds_nivel_atividade_fisica = ?, "
						+ "ds_estresse_ocupacional = ?, nr_frequencia_pausa_ativa = ?, id_usuario = ? where id_profissao = ?");
		stmt.setString(1, profissao.getDescricaoProfissao());
		stmt.setString(2, profissao.getDescricaoNivelAtividadeFisica());
		stmt.setString(3, profissao.getDescricaoEstresseOcupacional());
		stmt.setDouble(4, profissao.getNumeroFrequenciaPausaAtiva());
		stmt.setInt(5, profissao.getIdUsuario());
		stmt.setInt(6, profissao.getIdProfissao());
		stmt.executeUpdate();
		stmt.close();
		return "Atualizado com Sucesso!";
	}
	
	// Select
	public List<Profissao> selecionar() throws SQLException {
		List<Profissao> listaProfissao = new ArrayList<Profissao>();
		PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM T_TKN_PROFISSAO");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Profissao Profissao = new Profissao();
			Profissao.setIdProfissao(rs.getInt(1));
			Profissao.setIdUsuario(rs.getInt(6));
			Profissao.setDescricaoProfissao(rs.getString(2));
			Profissao.setDescricaoNivelAtividadeFisica(rs.getString(3));
			Profissao.setDescricaoEstresseOcupacional(rs.getString(4));
			Profissao.setNumeroFrequenciaPausaAtiva(rs.getDouble(5));
			listaProfissao.add(Profissao);
		}
		return listaProfissao;
	}
}
