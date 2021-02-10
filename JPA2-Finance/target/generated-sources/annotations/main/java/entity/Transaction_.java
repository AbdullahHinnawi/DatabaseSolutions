package main.java.entity;

import java.sql.Timestamp;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Transaction.class)
public abstract class Transaction_ {

	public static volatile SingularAttribute<Transaction, Double> amount;
	public static volatile SingularAttribute<Transaction, Account> sourceAccount;
	public static volatile SingularAttribute<Transaction, Integer> transId;
	public static volatile SingularAttribute<Transaction, String> description;
	public static volatile SingularAttribute<Transaction, Category> category;
	public static volatile SingularAttribute<Transaction, Account> destinationAccount;
	public static volatile SingularAttribute<Transaction, Timestamp> timestamp;

	public static final String AMOUNT = "amount";
	public static final String SOURCE_ACCOUNT = "sourceAccount";
	public static final String TRANS_ID = "transId";
	public static final String DESCRIPTION = "description";
	public static final String CATEGORY = "category";
	public static final String DESTINATION_ACCOUNT = "destinationAccount";
	public static final String TIMESTAMP = "timestamp";

}

