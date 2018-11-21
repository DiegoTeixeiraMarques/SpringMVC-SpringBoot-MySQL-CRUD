package com.mballem.curso.boot.domain;

import java.io.Serializable;
import javax.persistence.*;               // Pacote com as notações JPA

@SuppressWarnings("serial")				 // JDK gera um serial automaticamente para Serializable
@MappedSuperclass                        // Sinaliza que esta é uma super classe
public abstract class AbstractEntity<ID extends Serializable> implements Serializable {    // Quando trabalha com ORM é bnoa prática extender a classe Serializable do pacote io dento da interface
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)  // GeneratedValue tipo IDENTITY informa que será autoincremento no banco de dados
	private ID id;

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		AbstractEntity<?> other = (AbstractEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return " id = " + id;
	}
}
