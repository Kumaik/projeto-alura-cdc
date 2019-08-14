package br.com.casadocodigo.loja.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pedido implements Serializable{

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")   
    private int id;

    @JsonProperty("valor")   
    private BigDecimal valor;

    @JsonProperty("data")   
    @DateTimeFormat
    private Calendar data;

	@JsonProperty("produtos")   
    private List<Produto> produtos;
    
	private String listaProdutos;
	
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getProdutos() {
		
		for (Produto produto : produtos) {
			listaProdutos += produto.getTitulo() + ",";
		}
		listaProdutos = listaProdutos.substring(4, listaProdutos.length() - 1);
		
		return listaProdutos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
