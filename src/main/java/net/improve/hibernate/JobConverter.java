package net.improve.hibernate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class JobConverter implements AttributeConverter<Job, Character>{

	@Override
	public Character convertToDatabaseColumn(Job attribute) {
		if (attribute == null) {
			return null;
		}
		return attribute.getCode();
	}

	@Override
	public Job convertToEntityAttribute(Character dbData) {
		if (dbData == null) {
			return null;
		}
		return Job.fromCode(dbData);
	}

}
