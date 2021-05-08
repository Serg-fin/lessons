package lesson7.String;

public class StringHomeWork {

    public static void main(String[] args) {
        String str = "I like Java!!!"; // создаем строку
        System.out.println(str);
        System.out.println();

        System.out.print(str.charAt(str.length() - 1)); // распечатали последний символ строки
        System.out.println();
        System.out.println();

        System.out.println(str.endsWith("!!!")); // проверили заканчивается ли наша строка на "!!!"
        System.out.println();

        System.out.println(str.startsWith("I Like")); // проверили начинается ли наша строка на "I Like"
        System.out.println();

        System.out.println(str.contains("Java")); // проверили содержит ли наша строка значение "Java"
        System.out.println();

        System.out.println(str.indexOf("Java")); // нашли позицию подстроки "Java"
        System.out.println();

        System.out.println(str.replace('a', 'o')); // заменили в строке все символы "a" на "o"
        System.out.println();

        System.out.println(str.toUpperCase()); // привели строку к верхнему регистру
        System.out.println();

        System.out.println(str.toLowerCase()); // привели строку к нижнему регистру
        System.out.println();

        String cutValue = "Java"; // создали и проинициализировали переменную
        int cutValuePos = str.indexOf(cutValue); // определили с какой позиции начинается переменная cutValue 7
        int cutValueLength = cutValue.length(); // определили длину переменной cutValue 4
        System.out.println(str.substring(0, cutValuePos) + str.substring(cutValuePos + cutValueLength)); // вырезали часть строки от "0" до "7" позиции, всего 6 символов, и присоединили
                                                                                                         // оставшуюся часть строки предварительно вырезав 4 символа cutValue
    }
}
