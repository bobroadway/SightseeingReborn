package edu.matc.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Convert from sqlDate to LocalDate. This will be used by Hibernate.
 * Class based on: http://www.thoughts-on-java.org/persist-localdate-localdatetime-jpa/
 *
 * @author bbroadway
 */
@Converter
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime locDate) {
        return locDate == null ? null : new Timestamp(locDate.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
        return sqlTimestamp == null ? null : Instant.ofEpochMilli(sqlTimestamp.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}