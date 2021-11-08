package com.idas2.zdravotnisystem.db.entity.base;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Objects;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;
import static java.time.temporal.ChronoField.*;

@MappedSuperclass
public abstract class TimedEntity<P extends Serializable> extends BaseEntity<P> {

    private static final long serialVersionUID = -802610055413536277L;

    protected static final DateTimeFormatter NORMALNOE_FORMATIROVANIE
                                        = new DateTimeFormatterBuilder()
                                                    .parseCaseInsensitive()
                                                    .append(ISO_LOCAL_DATE)
                                                    .appendLiteral(' ')
                                                    .appendValue(HOUR_OF_DAY, 2)
                                                    .appendLiteral(':')
                                                    .appendValue(MINUTE_OF_HOUR, 2)
                                                    .optionalStart()
                                                    .appendLiteral(':')
                                                    .appendValue(SECOND_OF_MINUTE, 2)
                                                    .toFormatter();

    private LocalDateTime createdAt = LocalDateTime.now(ZoneOffset.UTC);
    private LocalDateTime updatedAt = LocalDateTime.now(ZoneOffset.UTC);

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now(ZoneOffset.UTC);
        updatedAt = LocalDateTime.now(ZoneOffset.UTC);
    }

    @PreUpdate
    public void onPreUpdate() {
        updatedAt = LocalDateTime.now(ZoneOffset.UTC);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getUpdatedAtString() {
        return Objects.nonNull(updatedAt)
                ? updatedAt.format(NORMALNOE_FORMATIROVANIE)
                : "";
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TimedEntity<?> that = (TimedEntity<?>) o;
        return createdAt.equals(that.createdAt) &&
                updatedAt.equals(that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), createdAt, updatedAt);
    }
}
