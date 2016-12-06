package edu.matc.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Conversion between java.sql.Timestamp and java.time.LocalDateTime. This will be used by Hibernate.
 * @author Bo Broadway
 */
@Converter
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    /**
     * Convert from java.time.LocalDateTime to java.sql.Timestamp.
     * @return Timestamp from LocalDateTime
     */
    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime locDate) {
        return locDate == null ? null : new Timestamp(locDate.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
    }

    /**
     * Convert from  java.sql.Timestamp to java.time.LocalDateTime.
     * @return LocalDateTime from Timestamp
     */
    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
        return sqlTimestamp == null ? null : Instant.ofEpochMilli(sqlTimestamp.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}