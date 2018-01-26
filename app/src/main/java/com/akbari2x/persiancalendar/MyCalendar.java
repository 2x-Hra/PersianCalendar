package com.akbari2x.persiancalendar;

import java.util.GregorianCalendar;

/**
 * Created by ali on 1/26/2018.
 */

public class MyCalendar {
    private int year, month, day;

    public MyCalendar() {
        fromGregorian(new GregorianCalendar());
    }
    public MyCalendar(int year, int month, int day) {
        set(year, month, day);
    }

    public void fromGregorian(GregorianCalendar gc) {
        int jd = gregorianToJulianDayNumber(gc);
        fromJulianDay(jd);
    }
    private int gregorianToJulianDayNumber(GregorianCalendar gc) {
        int gregorianYear = gc.get(GregorianCalendar.YEAR);
        int gregorianMonth = gc.get(GregorianCalendar.MONTH) + 1;
        int gregorianDay = gc.get(GregorianCalendar.DAY_OF_MONTH);

        return (((1461 * (gregorianYear + 4800 + (gregorianMonth - 14) / 12)) / 4
                + (367 * (gregorianMonth - 2 - 12 * ((gregorianMonth - 14) / 12))) / 12
                - (3 * ((gregorianYear + 4900 + (gregorianMonth - 14) / 12) / 100)) / 4 + gregorianDay
                - 32075) - (gregorianYear + 100100 + (gregorianMonth - 8) / 6) / 100 * 3 / 4 + 752);
    }

    private void fromJulianDay(int JulianDayNumber) {
        GregorianCalendar gc = julianDayToGregorianCalendar(JulianDayNumber);
        int gregorianYear = gc.get(GregorianCalendar.YEAR);

        int jalaliYear, jalaliMonth, jalaliDay;

        jalaliYear = gregorianYear - 621;

        GregorianCalendar gregorianFirstFarvardin = new MyCalendar(jalaliYear, 1, 1).getGregorianFirstFarvardin();
        int JulianDayFarvardinFirst = gregorianToJulianDayNumber(gregorianFirstFarvardin);
        int diffFromFarvardinFirst = JulianDayNumber - JulianDayFarvardinFirst;


        if (diffFromFarvardinFirst >= 0) {
            if (diffFromFarvardinFirst <= 185) {
                jalaliMonth = 1 + diffFromFarvardinFirst / 31;
                jalaliDay = (diffFromFarvardinFirst % 31) + 1;
                set(jalaliYear, jalaliMonth, jalaliDay);
                return;
            } else {
                diffFromFarvardinFirst = diffFromFarvardinFirst - 186;
            }
        } else {
            diffFromFarvardinFirst = diffFromFarvardinFirst + 179;
            if (getLeapFactor(jalaliYear) == 1)
                diffFromFarvardinFirst = diffFromFarvardinFirst + 1;
            jalaliYear -= 1;
        }


        jalaliMonth = 7 + diffFromFarvardinFirst / 30;
        jalaliDay = (diffFromFarvardinFirst % 30) + 1;
        set(jalaliYear, jalaliMonth, jalaliDay);
    }
    private GregorianCalendar julianDayToGregorianCalendar(int JulianDayNumber) {

        int j = 4 * JulianDayNumber + 139361631 + (4 * JulianDayNumber + 183187720) / 146097 * 3 / 4 * 4 - 3908;
        int i = (j % 1461) / 4 * 5 + 308;

        int gregorianDay = (i % 153) / 5 + 1;
        int gregorianMonth = ((i / 153) % 12) + 1;
        int gregorianYear = j / 1461 - 100100 + (8 - gregorianMonth) / 6;

        return new GregorianCalendar(gregorianYear, gregorianMonth - 1, gregorianDay);
    }
    public void set(int year, int month, int day) {
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    private int getLeapFactor(int jalaliYear) {
        int leap = 0;
        int[] breaks = {-61, 9, 38, 199, 426, 686, 756, 818, 1111, 1181, 1210,
                1635, 2060, 2097, 2192, 2262, 2324, 2394, 2456, 3178};

        int jp = breaks[0];

        int jump = 0;
        for (int j = 1; j <= 19; j++) {
            int jm = breaks[j];
            jump = jm - jp;
            if (jalaliYear < jm) {
                int N = jalaliYear - jp;

                if ((jump - N) < 6)
                    N = N - jump + (jump + 4) / 33 * 33;

                leap = ((((N + 1) % 33) - 1) % 4);

                if (leap == -1)
                    leap = 4;

                break;
            }

            jp = jm;
        }

        return leap;
    }

    private GregorianCalendar getGregorianFirstFarvardin() {
        int marchDay = 0;
        int[] breaks = {-61, 9, 38, 199, 426, 686, 756, 818, 1111, 1181, 1210,
                1635, 2060, 2097, 2192, 2262, 2324, 2394, 2456, 3178};

        int jalaliYear = getYear();
        int gregorianYear = jalaliYear + 621;
        int jalaliLeap = -14;
        int jp = breaks[0];

        int jump = 0;
        for (int j = 1; j <= 19; j++) {
            int jm = breaks[j];
            jump = jm - jp;
            if (jalaliYear < jm) {
                int N = jalaliYear - jp;
                jalaliLeap = jalaliLeap + N / 33 * 8 + (N % 33 + 3) / 4;

                if ((jump % 33) == 4 && (jump - N) == 4)
                    jalaliLeap = jalaliLeap + 1;

                int GregorianLeap = (gregorianYear / 4) - (gregorianYear / 100 + 1) * 3 / 4 - 150;

                marchDay = 20 + (jalaliLeap - GregorianLeap);

                if ((jump - N) < 6)
                    N = N - jump + (jump + 4) / 33 * 33;

                break;
            }

            jalaliLeap = jalaliLeap + jump / 33 * 8 + (jump % 33) / 4;
            jp = jm;
        }

        return new GregorianCalendar(gregorianYear, 2, marchDay);
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

}
