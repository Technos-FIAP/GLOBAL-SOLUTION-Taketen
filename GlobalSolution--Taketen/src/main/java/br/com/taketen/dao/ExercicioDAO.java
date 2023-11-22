package br.com.taketen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.taketen.beans.Exercicio;
import br.com.taketen.conexoes.ConexaoFactory;

public class ExercicioDAO {

	public Connection minhaConexao;

	public ExercicioDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}

	// Insert
	public String inserir(Exercicio exercicio) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement(" Insert into T_TKN_EXERCICIO values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		stmt.setInt(1, exercicio.getIdExercicio());
		stmt.setString(2, exercicio.getNumeroExercicio());
		stmt.setString(3, exercicio.getDescricaoExercicio());
		stmt.setString(4, exercicio.getUrlVideoDemonstracao());
		stmt.setString(5, exercicio.getDescricaoDificuldade());
		stmt.setInt(6, exercicio.getNumeroSeriesRecomendado());
		stmt.setInt(7, exercicio.getNumeroRepeticoesRecomendado());
		stmt.setString(8, exercicio.getDescricaoBeneficios());
		stmt.setDouble(9, exercicio.getNumeroTempoExecucao());
		stmt.setInt(10, exercicio.getIdTipoExercicio());
		stmt.execute();
		stmt.close();
		return "Cadastrado com Sucesso!";
	}

	// Delete
	public String deletar(int id) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement("Delete from T_TKN_EXERCICIO where id_exercicio = ?");
		stmt.setInt(1, id);
		stmt.execute();
		stmt.close();
		return "Deletado com Sucesso!";
	}

	// UpDate
	public String atualizar(Exercicio exercicio) throws SQLException {
		PreparedStatement stmt = minhaConexao
				.prepareStatement(" Update T_TKN_EXERCICIO set nm_exercicio = ?, ds_exercicio = ?, url_video_demonstracao = ?, "
						+ "ds_dificuldade = ?, nr_series_recomendado = ?, "
						+ "nr_repeticoes_recomendado = ?, ds_beneficios = ?, "
						+ "nr_tempo_execucao = ?, id_tipo_exercicio = ? where id_exercicio = ?");
		stmt.setString(1, exercicio.getNumeroExercicio());
		stmt.setString(2, exercicio.getDescricaoExercicio());
		stmt.setString(3, exercicio.getUrlVideoDemonstracao());
		stmt.setString(4, exercicio.getDescricaoDificuldade());
		stmt.setInt(5, exercicio.getNumeroSeriesRecomendado());
		stmt.setInt(6, exercicio.getNumeroRepeticoesRecomendado());
		stmt.setString(7, exercicio.getDescricaoBeneficios());
		stmt.setDouble(8, exercicio.getNumeroTempoExecucao());
		stmt.setInt(9, exercicio.getIdTipoExercicio());
		stmt.setInt(10, exercicio.getIdExercicio());
		stmt.executeUpdate();
		stmt.close();
		return "Atualizado com Sucesso!";
	}

	// Select
	public List<Exercicio> selecionar() throws SQLException {
		List<Exercicio> listaUsuario = new ArrayList<Exercicio>();
		PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM T_TKN_EXERCICIO");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Exercicio exercicio = new Exercicio();
			exercicio.setIdExercicio(rs.getInt(1));
			exercicio.setNumeroExercicio(rs.getString(2));
			exercicio.setDescricaoExercicio(rs.getString(3));
			exercicio.setUrlVideoDemonstracao(rs.getString(4));
			exercicio.setDescricaoDificuldade(rs.getString(5));
			exercicio.setNumeroSeriesRecomendado(rs.getInt(6));
			exercicio.setNumeroRepeticoesRecomendado(rs.getInt(7));
			exercicio.setDescricaoBeneficios(rs.getString(8));
			exercicio.setNumeroTempoExecucao(rs.getDouble(9));
			exercicio.setIdTipoExercicio(rs.getInt(10));
			listaUsuario.add(exercicio);
		}
		return listaUsuario;
	}
}
