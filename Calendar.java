import java.util.Scanner;

public class Calendar {
    public static String[] arrayMonth = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
    public static String[] arrayDayOfTheWeek = {"пн", "вт", "ср", "чт", "пт", "сб", "вс"};
    public static String[][] daysInAmonth = {
            {"1", "2", "3", "4", "5", "6", "7",
                    "8", "9", "10", "11", "12", "13", "14",
                    "15", "16", "17", "18", "19", "20", "21",
                    "22", "23", "24", "25", "26", "27", "28",
                    "29", "30", "31"},

            {"1", "2", "3", "4", "5", "6", "7",
                    "8", "9", "10", "11", "12", "13", "14",
                    "15", "16", "17", "18", "19", "20", "21",
                    "22", "23", "24", "25", "26", "27", "28",
                    "29"},

            {"1", "2", "3", "4", "5", "6", "7",
                    "8", "9", "10", "11", "12", "13", "14",
                    "15", "16", "17", "18", "19", "20", "21",
                    "22", "23", "24", "25", "26", "27", "28",
                    "29", "30", "31"},

            {"1", "2", "3", "4", "5", "6", "7",
                    "8", "9", "10", "11", "12", "13", "14",
                    "15", "16", "17", "18", "19", "20", "21",
                    "22", "23", "24", "25", "26", "27", "28",
                    "29", "30", "31"},

            {"1", "2", "3", "4", "5", "6", "7",
                    "8", "9", "10", "11", "12", "13", "14",
                    "15", "16", "17", "18", "19", "20", "21",
                    "22", "23", "24", "25", "26", "27", "28",
                    "29", "30", "31"},

            {"1", "2", "3", "4", "5", "6", "7",
                    "8", "9", "10", "11", "12", "13", "14",
                    "15", "16", "17", "18", "19", "20", "21",
                    "22", "23", "24", "25", "26", "27", "28",
                    "29", "30", "31"},

            {"1", "2", "3", "4", "5", "6", "7",
                    "8", "9", "10", "11", "12", "13", "14",
                    "15", "16", "17", "18", "19", "20", "21",
                    "22", "23", "24", "25", "26", "27", "28",
                    "29", "30", "31"},

            {"1", "2", "3", "4", "5", "6", "7",
                    "8", "9", "10", "11", "12", "13", "14",
                    "15", "16", "17", "18", "19", "20", "21",
                    "22", "23", "24", "25", "26", "27", "28",
                    "29", "30", "31"},

            {"1", "2", "3", "4", "5", "6", "7",
                    "8", "9", "10", "11", "12", "13", "14",
                    "15", "16", "17", "18", "19", "20", "21",
                    "22", "23", "24", "25", "26", "27", "28",
                    "29", "30", "31"},

            {"1", "2", "3", "4", "5", "6", "7",
                    "8", "9", "10", "11", "12", "13", "14",
                    "15", "16", "17", "18", "19", "20", "21",
                    "22", "23", "24", "25", "26", "27", "28",
                    "29", "30", "31"},

            {"1", "2", "3", "4", "5", "6", "7",
                    "8", "9", "10", "11", "12", "13", "14",
                    "15", "16", "17", "18", "19", "20", "21",
                    "22", "23", "24", "25", "26", "27", "28",
                    "29", "30", "31"},

            {"1", "2", "3", "4", "5", "6", "7",
                    "8", "9", "10", "11", "12", "13", "14",
                    "15", "16", "17", "18", "19", "20", "21",
                    "22", "23", "24", "25", "26", "27", "28",
                    "29", "30", "31"},

    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите интересующий вас месяц и год в формате: Январь 1994");
        String inputData = scanner.nextLine();
        String[] arrayInputData = inputData.split(" ");
        String month = arrayInputData[0];
        int year = Integer.parseInt(arrayInputData[1]);
        int codeOfTheCentury = codeOfTheCentury(year);
        int codeOfTheMonth = codeOfTheMonth(month);
        int codeDayOfTheWeek = (1 + codeOfTheMonth + codeOfTheCentury) % 7;
        switch (codeDayOfTheWeek) {
            case 0:
                codeDayOfTheWeek += 5;
            case 1:
                codeDayOfTheWeek += 5;
            default:
                if (codeDayOfTheWeek > 1) {
                    codeDayOfTheWeek -= 2;
                }
        }

        int numberMonth = numberMonth(month);

        String[][] arraysOutput = new String[5][7];
        int t = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                if (codeDayOfTheWeek != 0) {
                    
                }
                    if (t < daysInAmonth[numberMonth].length) {
                        arraysOutput[i][j] = daysInAmonth[numberMonth][t];
                        t++;
                    }
                    if (t > daysInAmonth[numberMonth].length) {
                        arraysOutput[i][j] = "-- ";
                    }
                    System.out.print(arraysOutput[i][j] + " ");

                }

            System.out.println("");
        }


    }


    /**
     * Тут мы определяем код века
     */
    private static int codeOfTheCentury(int year) {
        switch (((year / 100) + 1) % 4) {
            case 1:
                return 4;
            case 2:
                return 2;
            case 3:
                return 0;
            default:
                if ((((year / 100) + 1) % 4) == 0 && year / 100 + 1 != 3 && year / 100 + 1 != 2 && year / 100 + 1 != 1) {
                    return 6;
                }
                if (year / 100 + 1 == 3) {
                    return 0;
                }
                if (year / 100 + 1 == 2) {
                    return 2;
                }
                if (year / 100 + 1 == 1) {
                    return 4;
                }
        }
        return 4;
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
        if (numericlMonth == 3 || numericlMonth == 6) {
            return 0;
        }
        if (numericlMonth == 0 || numericlMonth == 9) {
            return 1;
        }
        if (numericlMonth == 4) {
            return 2;
        }
        if (numericlMonth == 7) {
            return 3;
        }
        if (numericlMonth == 1 || numericlMonth == 2 || numericlMonth == 10) {
            return 4;
        }
        if (numericlMonth == 5) {
            return 5;
        }
        if (numericlMonth == 11 || numericlMonth == 8) {
            return 6;
        }
        return 0;
    }

    private static int numberMonth(String month) {
        for (int i = 0; i < arrayMonth.length; i++) {
            if (month.equals(arrayMonth[i])) {
                return i;
            }
        }
        return 0;
    }
}
