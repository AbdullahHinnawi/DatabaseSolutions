package entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Device.class)
public abstract class Device_ {

	public static volatile SingularAttribute<Device, String> description;
	public static volatile SingularAttribute<Device, Integer> deviceId;

	public static final String DESCRIPTION = "description";
	public static final String DEVICE_ID = "deviceId";

}

