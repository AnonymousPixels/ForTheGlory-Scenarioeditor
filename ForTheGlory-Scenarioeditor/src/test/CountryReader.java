package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class CountryReader {

	public static File file;
	public static BufferedReader reader;
	public static Properties[] p;
	public static String[] string, fullString;
	public static String s;
	public static int i = 0, x = 0, n = 0, k = 0, e = 0, l = 0, L = 0, count = 0, I = 0;
	public static boolean b = false, B = false;

	public CountryReader(File f) throws FileNotFoundException, IOException {

		file = f;

		reader = new BufferedReader(new FileReader(file));
		while ((s = reader.readLine()) != null) {

			s = trim(s);
			if ((s.equals("")) == false && s.charAt(0) != 35)
				i++;
		}

		string = new String[i];

		reader = new BufferedReader(new FileReader(file));
		while ((s = reader.readLine()) != null)
			I++;

		fullString = new String[I];

		reader = new BufferedReader(new FileReader(file));
		while ((s = reader.readLine()) != null) {

			s = trim(s);
			if ((s.equals("")) == false && s.charAt(0) != 35) {

				for (int b = 0; b < s.length(); b++) {

					if (s.charAt(b) == 35) {

						s = s.substring(0, b);
						break;
					}
				}

				string[x] = s;
				if (x == i)
					break;
				x++;
			}
		}

		n = getEventNumber();
		p = new Properties[n];

		for (int h = 0; h < n; h++) {

			p[h] = new Properties();
		}

		reader = new BufferedReader(new FileReader(file));
		while ((s = reader.readLine()) != null) {

			s = trim(s);
			if ((s.equals("")) == false && s.charAt(0) != 35) {

				if (s.contains("action_a"))
					p[e].setProperty("eventEnd", Integer.toString(l));

				for (int d = 0; d < s.length(); d++) {

					if (s.charAt(d) == 123)
						k++;
					if (s.charAt(d) == 125)
						k--;

					if (k == 1 && b == false) {
						p[e].setProperty("lineStart", Integer.toString(l));
						b = true;
					}
					if (k == 0 && b == true) {
						p[e].setProperty("lineEnd", Integer.toString(l));
						e++;
						b = false;
					}
				}

				l++;
			}
		}

		// System.out.println(n);

		for (int q = 0; q < n; q++) {

			analyseEvent(q);
//			System.out.println("---trigger---");
//			System.out.println(p[q].getProperty("trigger"));
//			System.out.println("---action_a---");
//			System.out.println(p[q].getProperty("action_a"));
//			System.out.println("---action_b---");
//			System.out.println(p[q].getProperty("action_b"));
//			System.out.println("---action_c---");
//			System.out.println(p[q].getProperty("action_c"));
//			System.out.println("---action_d---");
//			System.out.println(p[q].getProperty("action_d"));

		}

		// for (int a = 0; a < i; a++)
		// System.out.println(string[a]);
	}

	static String trim(String beta) {

		beta = beta.replaceAll("\t", "").replaceAll(" ", "");
		return beta;
	}

	public static int getEventNumber() {

		int n = 0;
		for (int c = 0; c < i; c++) {

			if (string[c].contains("event={") == true)
				n++;
		}
		return n;
	}

	void analyseEvent(int o) throws IOException {

		String event = "";

		for (int w = Integer.parseInt(p[o].getProperty("lineStart")); w < (Integer
				.parseInt(p[o].getProperty("lineEnd"))); w++) {

			if (w != Integer.parseInt(p[o].getProperty("lineStart")))
				event = event + "\n" + string[w];
			else
				event = event + string[w];
		}

		for (int w = Integer.parseInt(p[o].getProperty("lineStart")); w < (Integer
				.parseInt(p[o].getProperty("eventEnd"))); w++) {

			String S = "";

			if (string[w].contains("id=")) {
				S = string[w].substring(3, string[w].length());
				p[o].setProperty("id", S);
			}
			if (string[w].contains("random=")) {
				S = string[w].substring(7, string[w].length());
				p[o].setProperty("random", S);
			}
			if (string[w].contains("country=")) {
				S = string[w].substring(8, string[w].length());
				p[o].setProperty("country", S);
			}
			if (string[w].contains("offset=")) {
				S = string[w].substring(7, string[w].length());
				p[o].setProperty("offset", S);
			}
			if (string[w].contains("data=")) {
				S = string[w].substring(5, string[w].length());
				p[o].setProperty("data", S);
			}
			if (string[w].length() > 6) {
				if (string[w].substring(0, 6).contains("date={")) {
					S = string[w].substring(6, string[w].length());

					if (S.contains("january"))
						p[o].setProperty("dateMonth", "january");
					if (S.contains("february"))
						p[o].setProperty("dateMonth", "february");
					if (S.contains("march"))
						p[o].setProperty("dateMonth", "march");
					if (S.contains("april"))
						p[o].setProperty("dateMonth", "april");
					if (S.contains("may"))
						p[o].setProperty("dateMonth", "may");
					if (S.contains("june"))
						p[o].setProperty("dateMonth", "june");
					if (S.contains("july"))
						p[o].setProperty("dateMonth", "july");
					if (S.contains("august"))
						p[o].setProperty("dateMonth", "august");
					if (S.contains("september"))
						p[o].setProperty("dateMonth", "september");
					if (S.contains("october"))
						p[o].setProperty("dateMonth", "october");
					if (S.contains("november"))
						p[o].setProperty("dateMonth", "november");
					if (S.contains("december"))
						p[o].setProperty("dateMonth", "december");

					for (int h = 0; h < S.length(); h++) {

						if (S.charAt(h) == '=' && count == 2) {

							p[o].setProperty("dateYear", String.valueOf(S.charAt(h + 1)));
							if (S.length() > h + 2)
								if (S.charAt(h + 2) != '}') {

									p[o].setProperty("dateYear",
											p[o].getProperty("dateYear") + String.valueOf(S.charAt(h + 2)));
								}
							if (S.length() > h + 3)
								if (S.charAt(h + 3) != '}') {

									p[o].setProperty("dateYear",
											p[o].getProperty("dateYear") + String.valueOf(S.charAt(h + 3)));
								}
							if (S.length() > h + 4)
								if (S.charAt(h + 4) != '}') {

									p[o].setProperty("dateYear",
											p[o].getProperty("dateYear") + String.valueOf(S.charAt(h + 4)));
								}

							if (S.length() > h + 5)
								if (S.charAt(h + 5) != '}') {

									p[o].setProperty("dateYear",
											p[o].getProperty("dateYear") + String.valueOf(S.charAt(h + 5)));
								}

							if (S.length() > h + 6)
								if (S.charAt(h + 6) != '}') {

									p[o].setProperty("dateYear",
											p[o].getProperty("dateYear") + String.valueOf(S.charAt(h + 6)));
								}

							count = 0;
							break;
						}

						if (S.charAt(h) == '=' && count == 1)
							count++;

						if (S.charAt(h) == '=' && count == 0) {

							p[o].setProperty("dateDay", String.valueOf(S.charAt(h + 1)));
							if (S.charAt(h + 2) != 'm')
								p[o].setProperty("dateDay",
										p[o].getProperty("dateDay") + String.valueOf(S.charAt(h + 2)));
							count++;
						}
					}
				}
			}
			if (string[w].length() > 11) {
				if (string[w].substring(0, 11).contains("deathdate={")) {
					S = string[w].substring(11, string[w].length());

					if (S.contains("january"))
						p[o].setProperty("deathdateMonth", "january");
					if (S.contains("february"))
						p[o].setProperty("deathdateMonth", "february");
					if (S.contains("march"))
						p[o].setProperty("deathdateMonth", "march");
					if (S.contains("april"))
						p[o].setProperty("deathdateMonth", "april");
					if (S.contains("may"))
						p[o].setProperty("deathdateMonth", "may");
					if (S.contains("june"))
						p[o].setProperty("deathdateMonth", "june");
					if (S.contains("july"))
						p[o].setProperty("deathdateMonth", "july");
					if (S.contains("august"))
						p[o].setProperty("deathdateMonth", "august");
					if (S.contains("september"))
						p[o].setProperty("deathdateMonth", "september");
					if (S.contains("october"))
						p[o].setProperty("deathdateMonth", "october");
					if (S.contains("november"))
						p[o].setProperty("deathdateMonth", "november");
					if (S.contains("december"))
						p[o].setProperty("deathdateMonth", "december");

					for (int h = 0; h < S.length(); h++) {

						if (S.charAt(h) == '=' && count == 2) {

							p[o].setProperty("deathdateYear", String.valueOf(S.charAt(h + 1)));
							if (S.length() > h + 2)
								if (S.charAt(h + 2) != '}') {

									p[o].setProperty("deathdateYear",
											p[o].getProperty("deathdateYear") + String.valueOf(S.charAt(h + 2)));
								}
							if (S.length() > h + 3)
								if (S.charAt(h + 3) != '}') {

									p[o].setProperty("deathdateYear",
											p[o].getProperty("deathdateYear") + String.valueOf(S.charAt(h + 3)));
								}
							if (S.length() > h + 4)
								if (S.charAt(h + 4) != '}') {

									p[o].setProperty("deathdateYear",
											p[o].getProperty("deathdateYear") + String.valueOf(S.charAt(h + 4)));
								}

							if (S.length() > h + 5)
								if (S.charAt(h + 5) != '}') {

									p[o].setProperty("deathdateYear",
											p[o].getProperty("deathdateYear") + String.valueOf(S.charAt(h + 5)));
								}

							if (S.length() > h + 6)
								if (S.charAt(h + 6) != '}') {

									p[o].setProperty("deathdateYear",
											p[o].getProperty("deathdateYear") + String.valueOf(S.charAt(h + 6)));
								}

							count = 0;
							break;
						}

						if (S.charAt(h) == '=' && count == 1)
							count++;

						if (S.charAt(h) == '=' && count == 0) {

							p[o].setProperty("deathdateDay", String.valueOf(S.charAt(h + 1)));
							if (S.charAt(h + 2) != 'm')
								p[o].setProperty("deathdateDay",
										p[o].getProperty("deathdateDay") + String.valueOf(S.charAt(h + 2)));
							count++;
						}
					}
				}
			}
		}

		p[o].setProperty("formattedEvent", event);

		e = 0;
		l = 0;
		x = 0;
		event = "";

		reader = new BufferedReader(new FileReader(file));
		while ((s = reader.readLine()) != null) {

			fullString[x] = s;
			if (x == I)
				break;
			x++;
		}

		reader = new BufferedReader(new FileReader(file));
		while ((s = reader.readLine()) != null) {

			if (s.contains("action_a"))
				p[e].setProperty("eventEndFull", Integer.toString(l));

			for (int d = 0; d < s.length(); d++) {

				if (s.charAt(d) == 123)
					k++;
				if (s.charAt(d) == 125)
					k--;

				if (k == 1 && b == false) {
					p[e].setProperty("lineStartFull", Integer.toString(l));
					b = true;
				}
				if (k == 0 && b == true) {
					p[e].setProperty("lineEndFull", Integer.toString(l));
					e++;
					b = false;
				}
			}
			l++;
		}

		for (int w = Integer.parseInt(p[o].getProperty("lineStartFull")); w <= (Integer
				.parseInt(p[o].getProperty("lineEndFull"))); w++) {

			if (w != Integer.parseInt(p[o].getProperty("lineStartFull")))
				event = event + "\n" + fullString[w];
			else
				event = event + fullString[w];
		}

		p[o].setProperty("fullEvent", event);

		String S = "";

		for (int w = Integer.parseInt(p[o].getProperty("lineStart")); w < (Integer
				.parseInt(p[o].getProperty("eventEndFull"))); w++) {

			if (fullString[w].contains("name")) {
				S = fullString[w].substring(8, fullString[w].length()).replaceAll("\"", "");
				p[o].setProperty("name", S);
			}
			if (fullString[w].contains("desc")) {
				S = fullString[w].substring(8, fullString[w].length()).replaceAll("\"", "");
				p[o].setProperty("desc", S);
			}
		}

		k = 1;
		B = false;

		for (int h = Integer.parseInt(p[o].getProperty("lineStartFull")); h < Integer
				.parseInt(p[o].getProperty("eventEndFull")); h++) {

			String Q = trim(fullString[h]);
			if (Q.length() > 9) {

				if (Q.substring(0, 9).contains("trigger={")) {

					p[o].setProperty("triggerStart", String.valueOf(h));

					for (int D = h + 1; D < Integer.parseInt(p[o].getProperty("eventEndFull")); D++) {

						for (int d = 0; d < fullString[D].length(); d++) {

							if (fullString[D].charAt(d) == 123)
								k++;
							if (fullString[D].charAt(d) == 125)
								k--;
							if (k == 0 && B == false) {
								p[o].setProperty("triggerEnd", Integer.toString(D));
								B = true;
							}
						}
					}
				}
			}
		}

		String trigger = "";

		p[o].setProperty("triggerStart", "null");
		p[o].getProperty("triggerEnd", "null");

		if (p[o].getProperty("triggerStart") != "null") {

			for (int h = (Integer.parseInt(p[o].getProperty("triggerStart"))) + 1; h < (Integer
					.parseInt(p[o].getProperty("triggerEnd"))); h++) {

				if (h == (Integer.parseInt(p[o].getProperty("triggerStart"))) + 1)
					trigger = fullString[h];
				else
					trigger = trigger + "\n" + fullString[h];
			}
		}

		p[o].setProperty("trigger", trigger);

		p[o].setProperty("action_aStart", "null");
		p[o].setProperty("action_aEnd", "null");

		p[o].setProperty("action_bStart", "null");
		p[o].setProperty("action_bEnd", "null");

		p[o].setProperty("action_cStart", "null");
		p[o].setProperty("action_cEnd", "null");

		p[o].setProperty("action_dStart", "null");
		p[o].setProperty("action_dEnd", "null");

		L = 0;
		k = 1;
		B = false;

		for (int h = Integer.parseInt(p[o].getProperty("lineStartFull")); h < Integer
				.parseInt(p[o].getProperty("lineEndFull")); h++) {

			String Q = trim(fullString[h]);
			if (Q.length() > 10) {

				if (Q.substring(0, 10).contains("action_a={")) {

					p[o].setProperty("action_aStart", String.valueOf(h));

					for (int D = h + 1; D < Integer.parseInt(p[o].getProperty("lineEndFull")); D++) {

						for (int d = 0; d < fullString[D].length(); d++) {

							if (fullString[D].charAt(d) == 123)
								k++;
							if (fullString[D].charAt(d) == 125)
								k--;
							if (k == 0 && B == false) {
								p[o].setProperty("action_aEnd", Integer.toString(D));
								B = true;
							}
						}
					}
				}
			}
		}

		String action_a = "";

		if (p[o].getProperty("action_aStart") != "null") {

			for (int h = (Integer.parseInt(p[o].getProperty("action_aStart"))) + 1; h < (Integer
					.parseInt(p[o].getProperty("action_aEnd"))); h++) {

				if (h == (Integer.parseInt(p[o].getProperty("action_aStart"))) + 1)
					action_a = fullString[h];
				else
					action_a = action_a + "\n" + fullString[h];
			}

			p[o].setProperty("action_a", action_a);
		}

		L = 0;
		k = 1;
		B = false;

		for (int h = Integer.parseInt(p[o].getProperty("lineStartFull")); h < Integer
				.parseInt(p[o].getProperty("lineEndFull")); h++) {

			String Q = trim(fullString[h]);
			if (Q.length() > 10) {

				if (Q.substring(0, 10).contains("action_b={")) {

					p[o].setProperty("action_bStart", String.valueOf(h));

					for (int D = h + 1; D < Integer.parseInt(p[o].getProperty("lineEndFull")); D++) {

						for (int d = 0; d < fullString[D].length(); d++) {

							if (fullString[D].charAt(d) == 123)
								k++;
							if (fullString[D].charAt(d) == 125)
								k--;
							if (k == 0 && B == false) {
								p[o].setProperty("action_bEnd", Integer.toString(D));
								B = true;
							}
						}
					}
				}
			}
		}

		String action_b = "";

		if (p[o].getProperty("action_bStart") != "null") {

			for (int h = (Integer.parseInt(p[o].getProperty("action_bStart"))) + 1; h < (Integer
					.parseInt(p[o].getProperty("action_bEnd"))); h++) {

				if (h == (Integer.parseInt(p[o].getProperty("action_bStart"))) + 1)
					action_b = fullString[h];
				else
					action_b = action_b + "\n" + fullString[h];
			}

			p[o].setProperty("action_b", action_b);
		}

		L = 0;
		k = 1;
		B = false;

		for (int h = Integer.parseInt(p[o].getProperty("lineStartFull")); h < Integer
				.parseInt(p[o].getProperty("lineEndFull")); h++) {

			String Q = trim(fullString[h]);
			if (Q.length() > 10) {

				if (Q.substring(0, 10).contains("action_c={")) {

					p[o].setProperty("action_cStart", String.valueOf(h));

					for (int D = h + 1; D < Integer.parseInt(p[o].getProperty("lineEndFull")); D++) {

						for (int d = 0; d < fullString[D].length(); d++) {

							if (fullString[D].charAt(d) == 123)
								k++;
							if (fullString[D].charAt(d) == 125)
								k--;
							if (k == 0 && B == false) {
								p[o].setProperty("action_cEnd", Integer.toString(D));
								B = true;
							}
						}
					}
				}
			}
		}

		String action_c = "";

		if (p[o].getProperty("action_cStart") != "null") {

			for (int h = (Integer.parseInt(p[o].getProperty("action_cStart"))) + 1; h < (Integer
					.parseInt(p[o].getProperty("action_cEnd"))); h++) {

				if (h == (Integer.parseInt(p[o].getProperty("action_cStart"))) + 1)
					action_c = fullString[h];
				else
					action_c = action_c + "\n" + fullString[h];
			}

			p[o].setProperty("action_c", action_c);
		}

		L = 0;
		k = 1;
		B = false;

		for (int h = Integer.parseInt(p[o].getProperty("lineStartFull")); h < Integer
				.parseInt(p[o].getProperty("lineEndFull")); h++) {

			String Q = trim(fullString[h]);
			if (Q.length() > 10) {

				if (Q.substring(0, 10).contains("action_d={")) {

					p[o].setProperty("action_dStart", String.valueOf(h));

					for (int D = h + 1; D < Integer.parseInt(p[o].getProperty("lineEndFull")); D++) {

						for (int d = 0; d < fullString[D].length(); d++) {

							if (fullString[D].charAt(d) == 123)
								k++;
							if (fullString[D].charAt(d) == 125)
								k--;
							if (k == 0 && B == false) {
								p[o].setProperty("action_dEnd", Integer.toString(D));
								B = true;
							}
						}
					}
				}
			}
		}

		String action_d = "";

		if (p[o].getProperty("action_dStart") != "null") {

			for (int h = (Integer.parseInt(p[o].getProperty("action_dStart"))) + 1; h < (Integer
					.parseInt(p[o].getProperty("action_dEnd"))); h++) {

				if (h == (Integer.parseInt(p[o].getProperty("action_dStart"))) + 1)
					action_d = fullString[h];
				else
					action_d = action_d + "\n" + fullString[h];
			}

			p[o].setProperty("action_d", action_d);
		}
	}

	public static String getComment() throws NumberFormatException, IOException {

		int L = 0;

		reader = new BufferedReader(new FileReader(file));
		while ((s = reader.readLine()) != null) {

			s = trim(s);
			if ((s.equals("")) == false && s.charAt(0) != 35)
				if (s.contains("{") && !B)
					B = true;
			L++;
		}

		int X = 0;
		String DESC = "";

		reader = new BufferedReader(new FileReader(file));
		while ((s = reader.readLine()) != null) {

			if (s.length() != 0) {

				if (X < L && s.charAt(0) == '#') {

					if (X != 0)
						DESC = DESC + "\n" + s;
					else
						DESC = DESC + s;
				}

				X++;
			}
		}

		return DESC;
	}
}