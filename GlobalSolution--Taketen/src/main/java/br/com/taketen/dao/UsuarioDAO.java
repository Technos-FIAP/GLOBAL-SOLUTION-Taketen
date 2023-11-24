package br.com.taketen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.taketen.beans.Usuario;
import br.com.taketen.conexoes.ConexaoFactory;

public class UsuarioDAO {

	public Connection minhaConexao;

	public UsuarioDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}
	
	// Insert
	public String inserir(Usuario usuario) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement(" Insert into T_TKN_USUARIO values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		stmt.setInt(1, usuario.getIdUsuario());
		stmt.setString(2, usuario.getNumeroUsuario());
		stmt.setString(3, usuario.getDescricaoEmail());
		stmt.setString(4, usuario.getDescricaoSenha());
		stmt.setString(5, usuario.getDataNascimento());
		stmt.setDouble(6, usuario.getNumeroAltura());
		stmt.setDouble(7, usuario.getNumeroPeso());
		stmt.setString(8, usuario.getDescricaoSexo());
		stmt.setInt(9, usuario.getIdEquipe());
		stmt.execute();
		stmt.close();
		return "Cadastrado com Sucesso!";
	}

	// Delete
	public String deletar(int id) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement("Delete from T_TKN_USUARIO where id_usuario = ?");
		stmt.setInt(1, id);
		stmt.execute();
		stmt.close();
		return "Deletado com Sucesso!";
	}

	// UpDate
	public String atualizar(Usuario usuario) throws SQLException {
		PreparedStatement stmt = minhaConexao
				.prepareStatement(" Update T_TKN_USUARIO set nm_usuario = ?, ds_email = ?, ds_senha = ?, "
						+ "dt_nascimento = ?, nr_altura = ?, "
						+ "nr_peso = ?, ds_sexo = ?, id_equipe = ? where id_usuario = ?");
		stmt.setString(1, usuario.getNumeroUsuario());
		stmt.setString(2, usuario.getDescricaoEmail());
		stmt.setString(3, usuario.getDescricaoSenha());
		stmt.setString(4, usuario.getDataNascimento());
		stmt.setDouble(5, usuario.getNumeroAltura());
		stmt.setDouble(6, usuario.getNumeroPeso());
		stmt.setString(7, usuario.getDescricaoSexo());
		stmt.setInt(8, usuario.getIdEquipe());
		stmt.setInt(9, usuario.getIdUsuario());
		stmt.executeUpdate();
		stmt.close();
		return "Atualizado com Sucesso!";
	}
	
	// Select
	public List<Usuario> selecionar() throws SQLException {
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM T_TKN_USUARIO");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(rs.getInt(1));
			usuario.setNumeroUsuario(rs.getString(2));
			usuario.setDescricaoEmail(rs.getString(3));
			usuario.setDescricaoSenha(rs.getString(4));
			usuario.setDataNascimento(rs.getString(5));
			usuario.setNumeroAltura(rs.getDouble(6));
			usuario.setNumeroPeso(rs.getDouble(7));
			usuario.setDescricaoSexo(rs.getString(8));
			usuario.setIdEquipe(rs.getInt(9));
			listaUsuario.add(usuario);
		}
		return listaUsuario;
	}
	
	public List<Usuario> selecionarPorId(int id) throws SQLException {
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM T_TKN_USUARIO WHERE id_usuario = ?");

		stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(rs.getInt(1));
			usuario.setNumeroUsuario(rs.getString(2));
			usuario.setDescricaoEmail(rs.getString(3));
			usuario.setDescricaoSenha(rs.getString(4));
			usuario.setDataNascimento(rs.getString(5));
			usuario.setNumeroAltura(rs.getDouble(6));
			usuario.setNumeroPeso(rs.getDouble(7));
			usuario.setDescricaoSexo(rs.getString(8));
			usuario.setIdEquipe(rs.getInt(9));
			listaUsuario.add(usuario);
		}
		return listaUsuario;
	}
	
}
