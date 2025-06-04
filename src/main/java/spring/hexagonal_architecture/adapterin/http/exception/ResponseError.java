package spring.hexagonal_architecture.adapterin.http.exception;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ResponseError {

	private List<String> messages = new ArrayList<>();
	private String erro;
	private int codigo;
	private LocalDate timestemp;
	private String path;
	
	public ResponseError(List<String> messages, String erro, int codigo, LocalDate timestemp, String path) {
		this.messages = messages;
		this.erro = erro;
		this.codigo = codigo;
		this.timestemp = timestemp;
		this.path = path;
	}
	
	public ResponseError() {
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public LocalDate getTimestemp() {
		return timestemp;
	}

	public void setTimestemp(LocalDate timestemp) {
		this.timestemp = timestemp;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	
}
