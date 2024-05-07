import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();


        int T = Integer.parseInt(sc.nextLine());
        for (int tc = 1; tc <= T; tc++) {
            System.out.print("#" + tc + " ");
            SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss", Locale.KOREA);
            Date d1 = f.parse(sc.nextLine());
            Date d2 = f.parse(sc.nextLine());

            long diff = 0;
            if(d1.after(d2)){
                Calendar cal = Calendar.getInstance();
                cal.setTime(d2);

                cal.add(Calendar.HOUR, 24);

                d2 = cal.getTime();

            }
            diff = d2.getTime() - d1.getTime();

            long h = (diff / (1000 * 60 * 60));
            long m = (diff % (1000 * 60 * 60) / (1000 * 60));
            long s = ((diff % (1000 * 60 * 60) % (1000 * 60))) / 1000;

            System.out.format("%02d:%02d:%02d", h, m ,s);
            System.out.print("\n");

        }
    }


}