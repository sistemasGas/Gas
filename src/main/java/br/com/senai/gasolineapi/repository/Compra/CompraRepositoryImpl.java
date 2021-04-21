package br.com.senai.gasolineapi.repository.Compra;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

import br.com.senai.gasolineapi.model.Compra;
import br.com.senai.gasolineapi.repository.filter.CompraFilter;

public class CompraRepositoryImpl implements CompraRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Compra> filtrar(CompraFilter compraFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Compra> criteria = builder.createQuery(Compra.class);
		Root<Compra> root = criteria.from(Compra.class);		
		
		Predicate[] predicates = criarRestriçoes(compraFilter,builder, root );
		criteria.where(predicates);
		TypedQuery<Compra> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	private Predicate[] criarRestriçoes(CompraFilter compraFilter, CriteriaBuilder builder, Root<Compra> root) {
		List<Predicate> predicates = new ArrayList();
		if(!StringUtils.isEmpty(compraFilter.getFornecedor())) {
			predicates.add(builder.like(builder.lower(root.get("fornecedor")), "%"+ compraFilter.getFornecedor().toLowerCase()+"%"));
		}
		
		if(compraFilter.getDataCompraDe() != null) {
			predicates.add(
					builder.greaterThanOrEqualTo(root.get("dataCompra"), compraFilter.getDataCompraDe()));
		}
		
		if(compraFilter.getDataCompraAte() != null) {
			predicates.add(
					builder.lessThanOrEqualTo(root.get("dataCompra"), compraFilter.getDataCompraAte()));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
}
