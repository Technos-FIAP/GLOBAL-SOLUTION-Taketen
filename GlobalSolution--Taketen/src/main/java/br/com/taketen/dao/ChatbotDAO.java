package br.com.taketen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.taketen.beans.Chatbot;
import br.com.taketen.conexoes.ConexaoFactory;

public class ChatbotDAO {

	public Connection minhaConexao;

	public ChatbotDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}

//		CREATE TABLE T_TKN_CHATBOT (
//		    id_chatbot INTEGER PRIMARY KEY,
//		    tx_entrada VARCHAR(500) NOT NULL,
//		    tx_saida VARCHAR(500) NOT NULL,
//		    dt_mensagem DATE NOT NULL,
//		    ds_intencao VARCHAR(100) NOT NULL,
//		    id_usuario REFERENCES T_TKN_USUARIO(id_usuario) NOT NULL
//		);
	
	// Insert
	public String inserir(Chatbot chatbot) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement(" Insert into T_TKN_CHATBOT values (?, ?, ?, ?, ?, ?)");
		stmt.setInt(1, chatbot.getIdChatbot());
		stmt.setString(2, chatbot.getTextoEntrada());
		stmt.setString(3, chatbot.getTextoSaida());
		stmt.setString(4, chatbot.getDataMensagem());
		stmt.setString(5, chatbot.getDescricaoIntencao());
		stmt.setInt(6, chatbot.getIdUsuario());
		stmt.execute();
		stmt.close();
		return "Cadastrado com Sucesso!";
	}

	// Delete
	public String deletar(int id) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement("Delete from T_TKN_CHATBOT where id_chatbot = ?");
		stmt.setInt(1, id);
		stmt.execute();
		stmt.close();
		return "Deletado com Sucesso!";
	}

	// UpDate
	public String atualizar(Chatbot chatbot) throws SQLException {
		PreparedStatement stmt = minhaConexao
				.prepareStatement(" Update T_TKN_CHATBOT set tx_entrada = ?, tx_saida = ?, dt_mensagem = ?, "
						+ "ds_intencao = ?, id_usuario = ? where id_chatbot = ?");
		stmt.setString(1, chatbot.getTextoEntrada());
		stmt.setString(2, chatbot.getTextoSaida());
		stmt.setString(3, chatbot.getDataMensagem());
		stmt.setString(4, chatbot.getDescricaoIntencao());
		stmt.setInt(5, chatbot.getIdUsuario());
		stmt.setInt(6, chatbot.getIdChatbot());
		stmt.executeUpdate();
		stmt.close();
		return "Atualizado com Sucesso!";
	}
	
	// Select
	public List<Chatbot> selecionar() throws SQLException {
		List<Chatbot> listaChatbot = new ArrayList<Chatbot>();
		PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM T_TKN_CHATBOT");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Chatbot chatbot = new Chatbot();
			chatbot.setIdChatbot(rs.getInt(1));
			chatbot.setIdUsuario(rs.getInt(6));
			chatbot.setTextoEntrada(rs.getString(2));
			chatbot.setTextoSaida(rs.getString(3));
			chatbot.setDataMensagem(rs.getString(4));
			chatbot.setDescricaoIntencao(rs.getString(5));
			listaChatbot.add(chatbot);
		}
		return listaChatbot;
	}
}
