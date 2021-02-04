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
        
        String[] daysInAMonth = daysInAMonth(numberMonth(month), leapYear);

        /**
         * Тут выводим дни недели
         */
        for (int i = 0; i < arrayDayOfTheWeek.length; i++) {
            System.out.print(arrayDayOfTheWeek[i] + " ");
        }
        System.out.println("");

        /**
         * Тут выводим даты
         */

        String[][] arraysOutput = new String[6][7];
        int t = 0;
        for (int i = 0; i < 6; i++) {

            if (codeDayOfTheWeek != 0) {
                for (int k = 0; k < codeDayOfTheWeek; k++) {
                    arraysOutput[i][k] = "  ";
                    System.out.print(arraysOutput[i][k] + " ");
                }
                for (int k = codeDayOfTheWeek; k < 7; k++) {
                    arraysOutput[i][k] = daysInAMonth[t];
                    if (t < 10) {
                        System.out.print(" " + arraysOutput[i][k] + " ");
                    } else {
                        System.out.print(arraysOutput[i][k] + " ");
                    }
                    t++;
                }
                System.out.println("");
                codeDayOfTheWeek = 0;
            } else {
                for (int k = 0; k < 7; k++) {

                    if (t < daysInAMonth.length) {
                        arraysOutput[i][k] = daysInAMonth[t];
                        t++;
                    } else {
                        arraysOutput[i][k] = "  ";
                    }

                    if (t < 10) {
                        System.out.print(" " + arraysOutput[i][k] + " ");
                    } else {
                        System.out.print(arraysOutput[i][k] + " ");
                    }
                }
                System.out.println("");
            }
        }


        System.out.println("");
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

    private static String[] daysInAMonth(int numberMonth, boolean leapYear) {
        int numberOfDays;

        if (numberMonth == 1) {
            if (leapYear) {
                numberOfDays = 29;
            } else {
                numberOfDays = 28;
            }
        } else {
            numberOfDays = 31;
        }

        switch (numberMonth) {
            case 3:
            case 5:
            case 8:
            case 10:
                numberOfDays = 30;
                break;
        }

        String[] daysInAMonth = new String[numberOfDays];


        for (int i = 0; i < daysInAMonth.length; i++) {
            daysInAMonth[i] = String.valueOf(i + 1);
        }


        return daysInAMonth;

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
