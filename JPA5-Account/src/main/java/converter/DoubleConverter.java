package main.java.converter;

import javax.persistence.AttributeConverter;


public class DoubleConverter implements AttributeConverter<Double, Integer> {


    @Override
    public Integer convertToDatabaseColumn(Double aDouble) {
        double inCents = aDouble * 100;
        return (int) inCents;
    }

    @Override
    public Double convertToEntityAttribute(Integer integer) {
       return  (double) integer / 100;
    }
}
