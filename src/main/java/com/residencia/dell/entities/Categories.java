package com.residencia.dell.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Diz que é uma entidade.
@Table(name = "categories") // Diz qual é a tabela que será mapeada
public class Categories {

	/*
	 * As propriedades de uma entidade devem representar as colunas da tabela. e
	 * através de anotação @Column diz qual a coluna será mapeada.
	 */
	@Id //Informa ao JPA qual atributo dessa entidade será relacionado a primay_key da tabela. 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Diz que quem ficará responsável a geração do valor do identificador único da entidade será gerenciada pelo BD
	@Column(name = "category") // No Exemplo essa é a primary key na tabela.
	private Integer category; // Esse nome a baixo é o nome em que a coluna será lido pelo Spring.

	@Column(name = "categoryname")
	private Integer categoryName;
	
	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Integer getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(Integer categoryName) {
		this.categoryName = categoryName;
	}

}
