package com.gustavo.api.exception;

import java.time.LocalDateTime;

public class ErroResposta {
	
	private int status;
	private String mensagem;
	private LocalDateTime dataHora;
	
	public ErroResposta(int status, String mensagem, LocalDateTime dataHora) {
		this.status = status;
		this.mensagem = mensagem;
		this.dataHora = dataHora; 
	}

	public int getStatus() {
		return status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}
	
	
}
