import java.util.Scanner;

public class Calendar {
    public static String[] arrayMonth = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
    public static String[] arrayDayOfTheWeek = {"пн", "вт", "ср", "чт", "пт", "сб", "вс"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите интересующий вас месяц и год в формате: Январь 1994");

        String inputData = scanner.nextLine();

        String[] arrayInputData = inputData.split(" ");

        String month = arrayInputData[0];

        int year = Integer.parseInt(arrayInputData[1]);

        boolean leapYear = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;

        int codeDayOfTheWeek = codeDayOfTheWeek(leapYear, year, month);
        int daysCountInMonth = daysCountInMonth(month, leapYear);

        printWeekDays();
        printDays(codeDayOfTheWeek, daysCountInMonth);
    }

    private static void printWeekDays() {
        for (String s : arrayDayOfTheWeek) {
            System.out.print(" " + s);
        }
        System.out.println();
    }

    private static void printDays(int codeDayOfTheWeek, int daysCountInMonth) {
        System.out.print(" ".repeat(codeDayOfTheWeek * 3));
        for (int i = 1; i <= daysCountInMonth; i++) {
            System.out.print((i < 10 ? "  " : " ") + i);
            if ((codeDayOfTheWeek + i - 1) % 7 == 6) {
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * Тут находим код 1 дня месяца
     */

    private static int codeDayOfTheWeek(boolean leapYear, int year, String month) {

        int codeDayOfTheWeek = ((1 + codeOfTheMonth(month) + codeOfTheYear(year, codeOfTheCentury(year))) % 7);

        if (leapYear) {
            codeDayOfTheWeek -= 1;
        }

        switch (codeDayOfTheWeek) {
            case 0:
            case 1:
                return codeDayOfTheWeek + 5;

            default:
                return codeDayOfTheWeek - 2;
        }

    }

    /**
     * Тут считаем сколько дней в месяце и заполняем массив
     */

    private static int daysCountInMonth(String month, boolean leapYear) {
        switch (numberMonth(month)) {
            case 1:
                return leapYear ? 29 : 30;
            case 3:
            case 5:
            case 8:
            case 10:
                return 30;
            default:
                return 31;
        }
    }

    /**
     * Тут мы определяем код века
     */
    private static int codeOfTheCentury(int year) {
        switch ((year / 100) % 4) {
            case 1:
                return 4;
            case 2:
                return 2;
            case 3:
                return 0;
            default:
                if (((year / 100) % 4) == 0 && year / 100 != 3 && year / 100 != 2 && year / 100 != 1) {
                    return 6;
                }
                if (year / 100 == 3) {
                    return 0;
                }
                if (year / 100 == 2) {
                    return 2;
                }
                if (year / 100 == 1) {
                    return 4;
                }
        }
        return 4;
    }


    /**
     * Тут определяем код года
     */
    private static int codeOfTheYear(int year, int codeOfTheCentury) {
        return (codeOfTheCentury + year % 100 + year % 100 / 4) % 7;
    }

    /**
     * Тут определяем код месяца
     */
    private static int codeOfTheMonth(String inputMonth) {
        int numericlMonth = 0;
        for (int i = 0; i < arrayMonth.length; i++) {
            if (arrayMonth[i].equals(inputMonth)) {
                numericlMonth = i;
            }
        }
        switch (numericlMonth) {
            case 3:
            case 6:
                return 0;

            case 0:
            case 9:
                return 1;

            case 4:
                return 2;

            case 7:
                return 3;

            case 1:
            case 2:
            case 10:
                return 4;

            case 5:
                return 5;

            case 11:
            case 8:
                return 6;
        }
        return 0;
    }

    /**
     * Тут определяем индекс месяца
     */
    private static int numberMonth(String month) {
        for (int i = 0; i < arrayMonth.length; i++) {
            if (month.equals(arrayMonth[i])) {
                return i;
            }
        }
        return 0;
    }
}
