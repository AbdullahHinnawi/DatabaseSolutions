package main.java.entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BasicProfile.class)
public abstract class BasicProfile_ {

	public static volatile SingularAttribute<BasicProfile, String> birthYear;
	public static volatile SingularAttribute<BasicProfile, Integer> profileId;
	public static volatile SingularAttribute<BasicProfile, Double> weight;
	public static volatile SingularAttribute<BasicProfile, Double> height;
	public static volatile SingularAttribute<BasicProfile, Customer> customer;

	public static final String BIRTH_YEAR = "birthYear";
	public static final String PROFILE_ID = "profileId";
	public static final String WEIGHT = "weight";
	public static final String HEIGHT = "height";
	public static final String CUSTOMER = "customer";

}

