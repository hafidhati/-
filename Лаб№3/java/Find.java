
import java.util.Scanner;

public class Find
{
    public static void StringSearch(String Line, String inLine) {

        if (inLine == null || inLine.length() == 0)
        {
            System.out.println("Начинается с нулевого индекса");
            return;
        }

        if (Line == null || inLine.length() > Line.length())
        {
            System.out.println("Подстрока не найдена");
            return;
        }

        char[] chars = inLine.toCharArray();


        int[] next = new int[inLine.length() + 1];
        for (int i = 1; i < inLine.length(); i++)
        {
            int j = next[i + 1];

            while (j > 0 && chars[j] != chars[i])
                j = next[j];

            if (j > 0 || chars[j] == chars[i])
                next[i + 1] = j + 1;
        }

        for (int i = 0, j = 0; i < Line.length(); i++)
        {
            if (j < inLine.length() && Line.charAt(i) == inLine.charAt(j))
            {
                if (++j == inLine.length())
                {
                    System.out.println("Начинается с индекса: " + (i - j + 1));
                }
            }
            else if (j > 0)
            {
                j = next[j];
                i--;
            }
        }
    }


    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String text = in.nextLine();
        System.out.println();

        System.out.print("Добавьте строку: ");
        String newText = in.nextLine();
        text = text + newText;
        System.out.println();
        System.out.println("Новая строка: " + text);
        System.out.println();

        System.out.print("Введите подстроку для поиска: ");
        String pattern = in.nextLine();
        System.out.println();


        System.out.println("Поиск КМП:");
        String finalText = text;
        long before = System.nanoTime();
        StringSearch(finalText, pattern);
        long after = System.nanoTime();
        System.out.println("Time KMP in nano: " + (after - before));
        System.out.println();

        System.out.println("Стандартный поиск:");
        System.out.println("Найдено на индексе: " + text.indexOf(pattern));
        String finalText1 = text;
        before = System.nanoTime();
        finalText1.indexOf(pattern);
        after = System.nanoTime();
        System.out.println("Time indexOF in nano: " + (after - before));


    }
}

