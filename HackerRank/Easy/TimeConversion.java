package HackerRank.Easy;

public class TimeConversion 
{
    public static void main(String[] args) {

        String time = "12:05:45PM";
        System.out.println(convert(time));
    }   

    public static String convert(String s)
    {
        

        String hour = s.substring(0,2);
        String minute = s.substring(3,5);
        String seconds = s.substring(6,8);
        String format = s.substring(8,10);


        if (hour.equals("12") && format.equals("AM"))
        {
            hour = "00";
        }


        else if (format.equals("PM") && !hour.equals("12"))
        {
            hour = String.valueOf(Integer.parseInt(hour) + 12);
        }


        else if(format.equals("PM") && hour.equals("12"))
        {
            //leave it
        }


        String militaryTime = hour + ":" + minute + ":" + seconds;

        return militaryTime;

    }
}