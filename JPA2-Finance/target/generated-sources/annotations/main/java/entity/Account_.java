package main.java.entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Account.class)
public abstract class Account_ {

	public static volatile SingularAttribute<Account, Integer> accountId;
	public static volatile SingularAttribute<Account, Double> balance;
	public static volatile SingularAttribute<Account, String> accountName;

	public static final String ACCOUNT_ID = "accountId";
	public static final String BALANCE = "balance";
	public static final String ACCOUNT_NAME = "accountName";

}

