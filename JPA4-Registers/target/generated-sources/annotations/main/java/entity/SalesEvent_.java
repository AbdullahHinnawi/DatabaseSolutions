package main.java.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SalesEvent.class)
public abstract class SalesEvent_ {

	public static volatile SingularAttribute<SalesEvent, Integer> eventId;
	public static volatile SingularAttribute<SalesEvent, Double> amount;
	public static volatile SingularAttribute<SalesEvent, Register> register;

	public static final String EVENT_ID = "eventId";
	public static final String AMOUNT = "amount";
	public static final String REGISTER = "register";

}

