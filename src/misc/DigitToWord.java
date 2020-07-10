package misc;

public class DigitToWord {

    static String convert_to_words(char[] num)
    {
        int len = num.length;



        String[] single_digits = new String[]{ "Zero", "One",
                "Two", "Three", "Four",
                "Five", "Six", "Seven",
                "Eight", "Nine"};

        String[] two_digits = new String[]{"", "Ten", "Eleven", "Twelve",
                "Thirteen", "Fourteen",
                "Fifteen", "Sixteen", "Seventeen",
                "Eighteen", "Nineteen"};

        String[] tens_multiple = new String[]{"", "", "Twenty", "Thirty", "Forty",
                "Fifty","Sixty", "Seventy",
                "Eighty", "Ninety"};

        String[] tens_power = new String[] {"Hundred", "Thousand"};

        if (len == 1)
        {
            return single_digits[num[0] - '0']+"Dollars";
        }

        int x = 0;
        String result = "";
        while (x < num.length)
        {
            if (len >= 3)
            {
                if (num[x]-'0' != 0)
                {
                    result+=single_digits[num[x] - '0'];
                    result+=tens_power[len - 3];
                }
                --len;
            }

            else
            {
                if (num[x] - '0' == 1)
                {
                    int sum = num[x] - '0' +
                            num[x] - '0';
                    result+=two_digits[sum];
                    return result+"Dollars";
                }

                else if (num[x] - '0' == 2 &&
                        num[x + 1] - '0' == 0)
                {
                    return "TwentyDollars";
                }

                else
                {
                    int i = (num[x] - '0');
                    if(i > 0)
                        result+=tens_multiple[i];
                    else
                        result+="";
                    ++x;
                    if (num[x] - '0' != 0)
                        result +=single_digits[num[x] - '0'];
                }
            }
            ++x;
        }
        return result + "Dollars";
    }

    public static void main(String[] args) {

        System.out.println("args = " + convert_to_words("110".toCharArray()));
        System.out.println("args = " + convert_to_words("23".toCharArray()));
        System.out.println("args = " + convert_to_words("123".toCharArray()));
        System.out.println("args = " + convert_to_words("1234".toCharArray()));
    }
}
