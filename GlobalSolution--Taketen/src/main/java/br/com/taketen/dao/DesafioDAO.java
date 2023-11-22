package br.com.taketen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.taketen.beans.Desafio;
import br.com.taketen.conexoes.ConexaoFactory;

public class DesafioDAO {

	public Connection minhaConexao;

	public DesafioDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}

	// Insert
	public String inserir(Desafio desafio) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement(" Insert into T_TKN_DESAFIO values (?, ?, ?, ?, ?, ?)");
		stmt.setInt(1, desafio.getIdDesafio());
		stmt.setString(2, desafio.getNumeroDesafio());
		stmt.setString(3, desafio.getDescricaoDesafio());
		stmt.setInt(4, desafio.getNumeroNivelDificuldade());
		stmt.setString(5, desafio.getDataInicio());
		stmt.setString(6, desafio.getDataFinal());
		stmt.execute();
		stmt.close();
		return "Cadastrado com Sucesso!";
	}

	// Delete
	public String deletar(int id) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement("Delete from T_TKN_DESAFIO where id_desafio = ?");
		stmt.setInt(1, id);
		stmt.execute();
		stmt.close();
		return "Deletado com Sucesso!";
	}

	// UpDate
	public String atualizar(Desafio desafio) throws SQLException {
		PreparedStatement stmt = minhaConexao
				.prepareStatement(" Update T_TKN_DESAFIO set nm_desafio = ?, ds_desafio = ?, " 
						+ "  nr_nivel_dificuldade = ?, dt_inicio = ?, dt_fim = ? where id_desafio = ?");
		stmt.setString(1, desafio.getNumeroDesafio());
		stmt.setString(2, desafio.getDescricaoDesafio());
		stmt.setInt(3, desafio.getNumeroNivelDificuldade());
		stmt.setString(4, desafio.getDataInicio());
		stmt.setString(5, desafio.getDataFinal());
		stmt.setInt(6, desafio.getIdDesafio());
		stmt.executeUpdate();
		stmt.close();
		return "Atualizado com Sucesso!";
	}

	// Select
	public List<Desafio> selecionar() throws SQLException {
		List<Desafio> listaDesafio = new ArrayList<Desafio>();
		PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM T_TKN_DESAFIO");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Desafio desafio = new Desafio();
			desafio.setIdDesafio(rs.getInt(1));
			desafio.setNumeroDesafio(rs.getString(2));
			desafio.setDescricaoDesafio(rs.getString(3));
			desafio.setNumeroNivelDificuldade(rs.getInt(4));
			desafio.setDataInicio(rs.getString(5));
			desafio.setDataFinal(rs.getString(6));
			listaDesafio.add(desafio);
		}
		return listaDesafio;
	}
}
