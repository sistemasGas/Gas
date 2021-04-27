package br.com.senai.gasolineapi.repository.venda;

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

import br.com.senai.gasolineapi.model.Venda;
import br.com.senai.gasolineapi.repository.filter.VendaFilter;

public class VendaRespositoryImpl implements VendaRepositoryQuery{
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Venda> filtrar(VendaFilter vendaFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Venda> criteria = builder.createQuery(Venda.class);
		Root<Venda> root = criteria.from(Venda.class);		
		
		Predicate[] predicates = criarRestriçoes(vendaFilter,builder, root );
		criteria.where(predicates);
		TypedQuery<Venda> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	private Predicate[] criarRestriçoes(VendaFilter vendaFilter, CriteriaBuilder builder, Root<Venda> root) {
		List<Predicate> predicates = new ArrayList();
		if(!StringUtils.isEmpty(vendaFilter.getFornecedor())) {
			predicates.add(builder.like(builder.lower(root.get("fornecedor")), "%"+ vendaFilter.getFornecedor().toLowerCase()+"%"));
		}
		
		if(vendaFilter.getDataVendaDe() != null) {
			predicates.add(
					builder.greaterThanOrEqualTo(root.get("dataVenda"), vendaFilter.getDataVendaDe()));
		}
		
		if(vendaFilter.getDataVendaAte() != null) {
			predicates.add(
					builder.lessThanOrEqualTo(root.get("dataVenda"), vendaFilter.getDataVendaAte()));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}
}
