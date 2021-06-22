package br.com.senai.gasolineapi.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.internal.build.AllowSysOut;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.senai.gasolineapi.util.StatusEnum;

@Entity
@Table(name = "venda")
@DynamicUpdate
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(name = "data_venda")
	@NotNull
	private LocalDate dataVenda;

	@Column(name = "valor_desconto")
	private BigDecimal valorDesconto;

	@Column(name = "valor_total")
	private BigDecimal valorTotal = BigDecimal.ZERO;

	@Column
	private String tipoPagamento;

	private String observacao;

	@ManyToOne
	@JoinColumn(name = "codigo_cliente")
	@NotNull
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "codigo_usuario")
	private Usuario usuario;

	@Enumerated(EnumType.STRING)
	private StatusEnum status = StatusEnum.ORCAMENTO;
	
	@NotNull
	@JsonIgnoreProperties("venda")
	@OneToMany(mappedBy = "venda", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<ItemVenda> itensVenda = new ArrayList<>();

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public List<ItemVenda> getItensVenda() {
		return itensVenda;
	}

	/*
	 * public void setItensVenda(List<ItemVenda> itens) { this.itensVenda = itens; }
	 */

	/*
	 * public boolean isNova() { return codigo == null; }
	 */

	public void setItensVenda(List<ItemVenda> itens) {
		this.itensVenda = itens;
		this.itensVenda.forEach(i -> i.setVenda(this));
	}

	/*
	 * public BigDecimal getValorTotalItens() { return
	 * getItensVenda().stream().map(ItemVenda::getValorTotal).reduce(BigDecimal::add
	 * ).orElse(BigDecimal.ZERO); }
	 */

	/*
	 * public void calcularValorTotal() { this.valorTotal =
	 * calcularValorTotal(getValorTotalItens(), getValorDesconto()); }
	 */

	/*
	 * public Long getDiasCriacao() { LocalDate inicio = dataVenda != null ?
	 * dataVenda : LocalDate.now(); return ChronoUnit.DAYS.between(inicio,
	 * LocalDate.now()); }
	 */
	/*
	 * public boolean isSalvarPermitido() { return
	 * !status.equals(StatusEnum.CANCELADA); }
	 * 
	 * public boolean isSalvarProibido() { return !isSalvarPermitido(); }
	 */

	private BigDecimal calcularValorTotal(BigDecimal valorTotalItens, BigDecimal valorDesconto) {
		BigDecimal valorTotal = valorTotalItens.subtract(Optional.ofNullable(valorDesconto).orElse(BigDecimal.ZERO));
		return valorTotal;
	}
	
	public Double calcularTotalVendas(List<Venda> lista) {
		double valor = 0;
		for (Venda v : lista) {
			if (v.getStatus() == StatusEnum.EMITIDA)
				valor += v.getValorTotal().longValue();
		}
		return valor;
	}
	
	public int calcularTotalItensVendidos(List<Venda> lista) {
		int valor = 0;
		for (Venda v : lista) {
			if (v.getStatus() == StatusEnum.EMITIDA)
				valor += v.getItensVenda().size();
		}
		return valor;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}