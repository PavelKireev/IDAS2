package com.idas2.zdravotnisystem.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TimeUtil {

    public static final ZoneId ZONE_MSC = ZoneId.of("+0300");
    public static final ZoneId ZONE_UTC = ZoneId.of("UTC");

    public static final String INPUT_LOCAL_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String DATE_TIME_FORMAT = "dd.MM.yyyy HH:mm:ss";
    public static final String DATE_TIME_FORMAT_NO_SEC = "dd.MM.yyyy HH:mm";
    public static final String SQL_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT = "dd.MM.yyyy";
    public static final String SQL_DATE_FORMAT = "yyyy-MM-dd";
    public static final String GBQ_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss.SSSSSS";
    public static final String EXTERNAL_DATE_FORMAT = "yyyy.MM.dd";
    public static final String TIME_FORMAT = "HH:mm";
    public static final String SENDGRID_DATE_FORMAT = "MM/dd/yyyy";
    public static final DateTimeFormatter INPUT_LOCAL_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(INPUT_LOCAL_DATE_TIME_FORMAT);
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
    public static final DateTimeFormatter SQL_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(SQL_DATE_TIME_FORMAT);
    public static final DateTimeFormatter GBQ_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(GBQ_DATE_TIME_FORMAT);
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
    public static final DateTimeFormatter SQL_DATE_FORMATTER = DateTimeFormatter.ofPattern(SQL_DATE_FORMAT);
    public static final DateTimeFormatter EXTERNAL_DATE_FORMATTER = DateTimeFormatter.ofPattern(EXTERNAL_DATE_FORMAT);
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMAT);
    public static final DateTimeFormatter SENDGRID_DATE_FORMATTER = DateTimeFormatter.ofPattern(SENDGRID_DATE_FORMAT);

    private static final int ONLINE_SECONDS = 180;

    public static int calculateAge(LocalDate birthDate) {
        if (birthDate == null) return 0;
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public static int calculatePeriod(LocalDateTime localDateTime) {
        if (localDateTime == null) return 0;

        return (int) ChronoUnit.DAYS.between(localDateTime, LocalDateTime.now());
    }

    public static String formatDate(LocalDate date) {

        if (date == null)
            return "";

        return DATE_FORMATTER.format(date);
    }

    public static String formatDateTime(LocalDateTime dateTime) {

        if (dateTime == null)
            return "";

        return DATE_TIME_FORMATTER.format(dateTime);
    }

    public static String formatDateTimeToInputValue(LocalDateTime dateTime) {
        if (dateTime == null)
            return "";

        return INPUT_LOCAL_DATE_TIME_FORMATTER.format(dateTime);
    }


    public static String formatDateToInputValue(LocalDate date) {

        if (date == null)
            return "";

        return SQL_DATE_FORMATTER.format(date);
    }

    public static String formatDateToInputValue(Date date) {

        if (date == null)
            return "";

        return SQL_DATE_FORMATTER.format(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }

    public static LocalDate toLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
    }


    public static ZonedDateTime mskToUtc(Date date) {
        return mskToUtc(toLocalDateTime(date));
    }

    public static ZonedDateTime mskToUtc(LocalDateTime dateTime) {
        return dateTime.minus(3, ChronoUnit.HOURS).atZone(ZONE_UTC);
    }


    public static LocalDateTime mskToUtcWithoutZone(Date date) {
        return mskToUtcWithoutZone(toLocalDateTime(date));
    }

    public static LocalDateTime mskToUtcWithoutZone(LocalDateTime dateTime) {
        return dateTime.minus(3, ChronoUnit.HOURS);
    }

    public static LocalDate getFromRelativeMonth(Integer month) {

        if (Objects.isNull(month))
            return LocalDate.now();

        LocalDate epochDate = LocalDate.ofYearDay(0, 1);
        return ChronoUnit.MONTHS.addTo(epochDate, month - 1);
    }

    public static LocalDate getFromRelativeWeek(Integer week) {

        if (Objects.isNull(week))
            return LocalDate.now();

        LocalDate epochDate = LocalDate.ofEpochDay(0);
        return ChronoUnit.WEEKS.addTo(epochDate, week).with(DayOfWeek.MONDAY);
    }

    public static boolean isOnline(LocalDateTime lastOnline) {
        return LocalDateTime.now().minus(ONLINE_SECONDS, ChronoUnit.SECONDS).isAfter(lastOnline);
    }

    /**
     * Вернуть count количество случайных дат
     * <p>
     * Внимание! если дата попала в период с 23ёх включительно до 9 утра прибавить к дате 10 часов
     *
     * @param offset от
     * @param limit  до
     * @param count  кол-во
     * @return коллекция дат
     */
    public static Set<LocalDateTime> getRandomTimesInPeriod(
            LocalDateTime offset,
            LocalDateTime limit,
            int count

    ) {
        final Set<LocalDateTime> times = new HashSet<>();
        final long start = offset.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        final long end = limit.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

        for (int i = 0; i < count; i++) {
            LocalDateTime time = LocalDateTime.ofInstant(
                    Instant.ofEpochMilli(start + (long) (Math.random() * (end - start))),
                    ZoneId.systemDefault()).withSecond(0).withNano(0);
            if (time.getHour() >= 23 || time.getHour() < 9) {
                times.add(time.plusHours(10));
            } else {
                times.add(time);
            }
        }


        return times;
    }

    public static LocalDate fromStringSqlLocalDate(String sqlLocalDate) {
        DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(sqlLocalDate, DATEFORMATTER);
    }
}
