package sim;


public class menu {
	public static void open() {
		if (vars.hasPlane == true) {
			writer.plane("Да");
		} else {
			writer.plane("Нет");
		}
		
		if (vars.hasPaper == true) {
			writer.paper("Да");
		} else {
			writer.paper("Нет");
		}
		
		if (vars.isAero == true) {
			writer.aero("Да");
		} else {
			writer.aero("Нет");
		}		
		writer.tetrapaper(vars.tetrapaper);
		
		System.out.println("=======================");
		System.out.println("Есть самолётик: " + Reader.getPlane());
		if (Reader.getPlane() != "Нет") {
			System.out.println("Аэродинамичный: " + Reader.getAero());
		}
		System.out.println("Есть бумага: " + Reader.getPaper());
		if (!Reader.getPaper().equals("Нет")) {
			System.out.println("Тип бумаги: " + Reader.getPformat());
			System.out.println("Бумага из: " + Reader.getPfrom());
			System.out.println("Качество бумаги: " + Reader.getPqual());
		}
		System.out.println("=======================");
		System.out.println("Выберите действие:");
		System.out.println("1. FIRE");
		System.out.println("2. Собрать");
		System.out.println("3. Дать кириллу");
		System.out.println("4. Добыть бумагу");
		System.out.println("5. Кинуть зигу");
		System.out.println("6. TODO");
		vars.ch = util.sc.nextInt();
		switch(vars.ch) {
		case 1:
			plane.fire();
			break;
		case 2:
			plane.construct();
			break;
		case 3:
			plane.aerodynamix();
			break;
		case 4:
			plane.collect();
			break;
		case 5:
			plane.zig();
			break;
		case 6:
			plane.todo();
			break;
		default:
			System.out.println("Еблан, нет такой цифарки!!!");
			menu.open();
			break;
		}
		
	}
}
