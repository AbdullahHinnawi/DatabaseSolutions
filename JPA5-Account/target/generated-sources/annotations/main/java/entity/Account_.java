package main.java.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Account.class)
public abstract class Account_ {

	public static volatile SingularAttribute<Account, String> number;
	public static volatile SingularAttribute<Account, Double> balance;
	public static volatile SingularAttribute<Account, Integer> id;
	public static volatile SingularAttribute<Account, Long> version;

	public static final String NUMBER = "number";
	public static final String BALANCE = "balance";
	public static final String ID = "id";
	public static final String VERSION = "version";

}

