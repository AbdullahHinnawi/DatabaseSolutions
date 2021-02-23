package main.java.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Register.class)
public abstract class Register_ {

	public static volatile SingularAttribute<Register, Integer> registerId;
	public static volatile SingularAttribute<Register, String> name;

	public static final String REGISTER_ID = "registerId";
	public static final String NAME = "name";

}

