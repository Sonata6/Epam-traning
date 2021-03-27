package by.kirill.array.parser;

public class CustomArrayParser {

    public int[] stringParser(String customarraystr) {
        char chararray[] = customarraystr.toCharArray();
        CustomArrayParser parser = new CustomArrayParser();
        int lenght = parser.findNumberOfElements(chararray);
        int actualarray[] = new int[lenght];
        int index = lenght - 1;
        int ten = 10;
        int order = 0;
        int degree = 1;
        int number;
        for (int i = chararray.length - 1; i >= 0; i--) {
            if (chararray[i] == ' ') {
                index--;
                order = 0;
                degree = 1;
            } else if (chararray[i] == '-') {
                index--;
                order = 0;
                degree = 1;
            } else if (chararray[i] == ',') {
                index--;
                order = 0;
                degree = 1;
            } else {
                number = (int) chararray[i] - '0';
                if(order != 0) {
                    degree *= ten;
                }
                order++;
                number *= degree;
                actualarray[index] += number;
            }
        }
        return actualarray;
    }

    public int findNumberOfElements(char[] chararray) {
        int lenght = 0;
        for (int i = chararray.length - 1; i >= 0; i--) {
            if (chararray[i] == ' ') {
                lenght++;
            } else if (chararray[i] == '-') {
                lenght++;
            } else if (chararray[i] == ',') {
                lenght++;
            }
        }
        lenght++;
        return lenght;
    }
}
