package entidades;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Classe que representa um registro de ação
 * 
 * @author jfpsb
 *
 */
@Entity
public class Registro {
	@Id
	@GeneratedValue
	private int id;

	@Column(length = 250)
	private String msg;

	@Column
	private Timestamp data;

	/**
	 * Cria instância de registro.
	 * 
	 * @param msg
	 *            Mensagem do registro.
	 * @param data
	 *            Data em que o registro foi feito.
	 */
	public Registro(String msg, Timestamp data) {
		this.msg = msg;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

}
