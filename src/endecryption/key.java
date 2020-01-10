package endecryption;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;

public class key {
	private static final Random RANDOM = new SecureRandom();
	public static final int First_Length = 1;
	public static final int sec_Length = 2;
	public static final int third_Length = 1;
	public static final int fourth_Length = 1;
	public static final int five_Length = 1;
	public static final int six_Length = 1;
	public static final int seven_Length = 1;
	public static final int Eight_Length = 1;
	public static final int nine_Length = 1;
	public static final int ten_Length = 2;
	String all;
	public static final String UPletters = "ABCDEFGHJKMNPQRSTUVWXYZ";
	public static final String Sletterers = "abcdefghjkmnpqrstuvwxyz";
	public static final String num = "0123456789";

	public static String passer() throws IOException {

		// String letters =
		// "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789";

		String First = "";
		for (int i = 0; i < First_Length; i++) {
			int index = (int) (RANDOM.nextDouble() * UPletters.length());
			First += UPletters.substring(index, index + 1);
		}
		// System.out.print(First);

		String sec = "";
		for (int i = 0; i < sec_Length; i++) {
			int index = (int) (RANDOM.nextDouble() * Sletterers.length());
			sec += Sletterers.substring(index, index + 1);
		}
		// System.out.print(sec);
		String all = First + sec;
		// System.out.println(all);

		String third = "";
		for (int i = 0; i < third_Length; i++) {
			int index = (int) (RANDOM.nextDouble() * UPletters.length());
			third += UPletters.substring(index, index + 1);
		}
		// System.out.print(First);
		String alla = all + third;
		// System.out.println(alla);

		String fourth = "";
		for (int i = 0; i < fourth_Length; i++) {
			int index = (int) (RANDOM.nextDouble() * num.length());
			fourth += num.substring(index, index + 1);
		}
		// System.out.print(First);
		String infour = alla + fourth;
		// System.out.println(infour);

		String five = "";
		for (int i = 0; i < fourth_Length; i++) {
			int index = (int) (RANDOM.nextDouble() * num.length());
			five += num.substring(index, index + 1);
		}
		String f = five + five;
		String infive = infour + f;
		// System.out.println(infive);

		String miss = "";
		for (int i = 0; i < fourth_Length; i++) {
			int index = (int) (RANDOM.nextDouble() * num.length());
			miss += num.substring(index, index + 1);
		}
		String inmiss = infive + miss;
		// System.out.println(in);

		String six = "";
		for (int i = 0; i < six_Length; i++) {
			int index = (int) (RANDOM.nextDouble() * UPletters.length());
			six += UPletters.substring(index, index + 1);
		}

		String insix = inmiss + six;
		// System.out.println(insix);

		String seven = "";
		for (int i = 0; i < seven_Length; i++) {
			int index = (int) (RANDOM.nextDouble() * Sletterers.length());
			seven += Sletterers.substring(index, index + 1);
		}

		String inseven = insix + seven;
		// System.out.println(inseven);

		String eight = "";
		for (int i = 0; i < Eight_Length; i++) {
			int index = (int) (RANDOM.nextDouble() * UPletters.length());
			eight += UPletters.substring(index, index + 1);
		}

		String ineight = inseven + eight;
		// System.out.println(ineight);

		String nine = "";
		for (int i = 0; i < nine_Length; i++) {
			int index = (int) (RANDOM.nextDouble() * Sletterers.length());
			nine += Sletterers.substring(index, index + 1);
		}

		String innine = ineight + nine;
		// System.out.println(innine);

		String ten = "";
		for (int i = 0; i < ten_Length; i++) {
			int index = (int) (RANDOM.nextDouble() * num.length());
			ten += num.substring(index, index + 1);
		}
		String two = ten + ten;
		String inten = innine + two;
		System.out.println("your decryption key is= " + inten);
		String MYkey = inten;
		return MYkey;

	}
}
