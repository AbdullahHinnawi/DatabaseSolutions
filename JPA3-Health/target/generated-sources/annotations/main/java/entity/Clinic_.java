package main.java.entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Clinic.class)
public abstract class Clinic_ {

	public static volatile SingularAttribute<Clinic, Integer> clinicId;
	public static volatile SingularAttribute<Clinic, String> location;
	public static volatile ListAttribute<Clinic, Customer> customers;

	public static final String CLINIC_ID = "clinicId";
	public static final String LOCATION = "location";
	public static final String CUSTOMERS = "customers";

}

