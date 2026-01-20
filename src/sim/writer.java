package sim;

import java.io.FileWriter;
import java.io.IOException;

public class writer {
	public static void plane(String plane) {
		if (vars.isWin) {
			try (FileWriter writer = new FileWriter(vars.pl)) {
				writer.write(plane);
			} catch (IOException e) {
				System.err.println("Ошибка при записи в файл: " + e.getMessage());
			}
		} else {
			try (FileWriter writer = new FileWriter(vars.lpl)) {
				writer.write(plane);
			} catch (IOException e) {
				System.err.println("Ошибка при записи в файл: " + e.getMessage());
			}
		}
	}

	public static void aero(String aero) {
		if (vars.isWin) {
			try (FileWriter writer = new FileWriter(vars.ae)) {
				writer.write(aero);
			} catch (IOException e) {
				System.err.println("Ошибка при записи в файл: " + e.getMessage());
			}
		} else {
			try (FileWriter writer = new FileWriter(vars.lae)) {
				writer.write(aero);
			} catch (IOException e) {
				System.err.println("Ошибка при записи в файл: " + e.getMessage());
			}
		}
	}

	public static void paper(String paper) {
		if (vars.isWin) {
			try (FileWriter writer = new FileWriter(vars.pp)) {
				writer.write(paper);
			} catch (IOException e) {
				System.err.println("Ошибка при записи в файл: " + e.getMessage());
			}
		} else {
			try (FileWriter writer = new FileWriter(vars.lpp)) {
				writer.write(paper);
			} catch (IOException e) {
				System.err.println("Ошибка при записи в файл: " + e.getMessage());
			}
		}
	}

	public static void paperformat(String paperformat) {
		if (vars.isWin) {
			try (FileWriter writer = new FileWriter(vars.pf)) {
				writer.write(paperformat);
			} catch (IOException e) {
				System.err.println("Ошибка при записи в файл: " + e.getMessage());
			}
		} else {
			try (FileWriter writer = new FileWriter(vars.lpf)) {
				writer.write(paperformat);
			} catch (IOException e) {
				System.err.println("Ошибка при записи в файл: " + e.getMessage());
			}
		}
	}

	public static void paperfrom(String paperfrom) {
		if (vars.isWin) {
			try (FileWriter writer = new FileWriter(vars.pr)) {
				writer.write(paperfrom);
			} catch (IOException e) {
				System.err.println("Ошибка при записи в файл: " + e.getMessage());
			}
		} else {
			try (FileWriter writer = new FileWriter(vars.lpr)) {
				writer.write(paperfrom);
			} catch (IOException e) {
				System.err.println("Ошибка при записи в файл: " + e.getMessage());
			}
		}
	}

	public static void paperqual(String paperqual) {
		if (vars.isWin) {
			try (FileWriter writer = new FileWriter(vars.pq)) {
				writer.write(paperqual);
			} catch (IOException e) {
				System.err.println("Ошибка при записи в файл: " + e.getMessage());
			}
		} else {
			try (FileWriter writer = new FileWriter(vars.lpq)) {
				writer.write(paperqual);
			} catch (IOException e) {
				System.err.println("Ошибка при записи в файл: " + e.getMessage());
			}
		}
	}

	public static void tetrapaper(int tetrapaper) {
		if (vars.isWin) {
			try (FileWriter writer = new FileWriter(vars.tp)) {
				writer.write(String.valueOf(tetrapaper));
			} catch (IOException e) {
				System.err.println("Ошибка при записи в файл: " + e.getMessage());
			}
		} else {
			try (FileWriter writer = new FileWriter(vars.ltp)) {
				writer.write(String.valueOf(tetrapaper));
			} catch (IOException e) {
				System.err.println("Ошибка при записи в файл: " + e.getMessage());
			}
		}
	}
}
