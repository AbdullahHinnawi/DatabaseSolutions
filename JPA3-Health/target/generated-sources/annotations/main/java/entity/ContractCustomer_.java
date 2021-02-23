package main.java.entity;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ContractCustomer.class)
public abstract class ContractCustomer_ extends main.java.entity.Customer_ {

	public static volatile SingularAttribute<ContractCustomer, Date> endDate;
	public static volatile SingularAttribute<ContractCustomer, Date> startDate;

	public static final String END_DATE = "endDate";
	public static final String START_DATE = "startDate";

}

