package entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Category.class)
public abstract class Category_ {

	public static volatile SingularAttribute<Category, String> description;
	public static volatile SingularAttribute<Category, Integer> categoryId;

	public static final String DESCRIPTION = "description";
	public static final String CATEGORY_ID = "categoryId";

}

