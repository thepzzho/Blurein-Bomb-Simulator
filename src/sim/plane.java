package sim;

public class plane {
	public static void fire() {
	    if (vars.hasPlane == false) {
	    	System.out.println("=======================");
	        System.out.println("У вас нет самолётика!");
	        menu.open();
	        return;
	    }

	    int r = util.rand.nextInt(100);

	    if (vars.isAero == false) {
	        // НЕ аэродинамичный
	        if (r < vars.NOAERO_MISS) {
	        	vars.isReturned = false;
	            firehelp(" не ", "");
	        } else if (r < vars.NOAERO_MISS + vars.NOAERO_HIT) {
	        	vars.isReturned = false;
	            firehelp("", "");
	        } else {
	        	vars.isReturned = true;
	            firehelp("не ", "самолётик вернулся как бумеранг");
	        }

	    } else {
	        // аэродинамичный
	        if (r < vars.AERO_MISS) {
	        	vars.isReturned = false;
	            firehelp(" не ", "");
	        } else if (r < vars.AERO_MISS + vars.AERO_HIT) {
	        	vars.isReturned = false;
	            firehelp("", "");
	        } else {
	        	vars.isReturned = true;
	            firehelp("не ", "самолётик вернулся как бумеранг");
	        }
	    }
	}

	
	public static void construct() {
		if (vars.hasPaper == false) {
			System.out.println("=======================");
			System.out.println("У вас нет бумаги!");
			menu.open();
		} else {
			if (!vars.hasPlane) {
				int r = util.rand.nextInt(100);
				if (r < vars.CONSTRUCT_SUCCESFUL) {
					System.out.println("=======================");
					System.out.println("Вы собрали самолётик");
					vars.hasPaper = false;
					vars.hasPlane = true;
					menu.open();
				} else {
					System.out.println("=======================");
					System.out.println("Вы умудлились помять бумагу и не собрать самолётик. Как так? Шанс на это всего 1%, но у вас получилось");
					vars.hasPaper = false;
					menu.open();
				}
			} else {
				System.out.println("=======================");
				System.out.println("У вас уже есть самолётик, но бумагу вы всё равно потратили");
				vars.hasPaper = false;
				menu.open();
			}
			
		}
	}
	
	public static void aerodynamix() {

	    if (!vars.hasPlane && !vars.hasPaper) {
	    	System.out.println("=======================");
	        System.out.println("У вас нет самолётика!");
	        menu.open();
	        return;
	    }

	    if (!vars.hasPlane && vars.hasPaper) {
	    	System.out.println("=======================");
	        System.out.println("У вас нет самолётика зато есть... бумага");
	        System.out.println("Вы отдали её Кириллу и он её саэродинамировал");
	        System.out.println("Теперь у вас есть кривая, бесполезная бумага.");
	        vars.hasPaper = false;
	        menu.open();
	        return;
	    }

	    // Есть самолётик
	    System.out.println("=======================");
	    System.out.println("Вы отдали самолётик Кириллу");
	    int r = util.rand.nextInt(100);

	    if (r < vars.AERO_SUCCESFUL) {
	        System.out.println("Теперь у вас есть аэродинамичный самолётик!!");
	        vars.isAero = true;
	    } else {
	        System.out.println("Кирилл - раздолбай и погнул самолётик к чертям");
	        vars.isAero = false;
	        vars.hasPlane = false;
	    }

	    menu.open();
	}

	
	public static void collect() {
		System.out.println("=======================");
	    System.out.println("Где взять бумагу");
	    System.out.println("1. Кабинет ОМ (Риск, А4, Ꚙ, Гуд)");
	    System.out.println("2. Тетрадь (Без риска, А5, " + vars.tetrapaper + " шт, Шлехт)");

	    vars.ch = util.sc.nextInt();

	    switch (vars.ch) {
	        case 1:
	            if (vars.hasPaper) {
	                System.out.println("У вас уже есть бумага (больше одной пока нельзя!!)");
	                break;
	            }

	            int r = util.rand.nextInt(100);
	            if (r < vars.OM_SUCCESFUL) {
	                System.out.println("Теперь у вас есть хорошая бумага А4 (пока что ни на что не влияет)");
	                vars.hasPaper = true;
	                writer.paperformat("А4");
	                writer.paperfrom("Кабинет ОМСО");
	                writer.paperqual("Гут");
	            } else {
	                System.out.println("Вы попытались, но вас поймали. Вам капец!");
	            }
	            break;

	        case 2:
	            if (vars.tetrapaper <= 0) {
	                System.out.println("В тетради закончились листы!");
	                break;
	            }

	            vars.tetrapaper--;

	            if (!vars.hasPaper) {
	                System.out.println("У вас теперь есть плохая бумага А5 (пока что ни на что не влияет)");
	                vars.hasPaper = true;
	                writer.paperformat("А5");
	                writer.paperfrom("Тетрадь");
	                writer.paperqual("Шлехт");
	            } else {
	                System.out.println("Вы вырвали лист, но из-за лени разработчика он исчез");
	                
	            }
	            break;

	        default:
	            System.out.println("Такого варианта нет!");
	            break;
	    }

	    menu.open();
	}

	
	public static void zig() {
		System.out.println("卐卐卐卐卐卐卐卐卐卐卐卐卍卍卍卍卍卍卍卍卍卍卍卍");
		System.out.println("Вы кинули зигу. Поздравляю.");
		menu.open();
	}
	
	public static void firehelp(String ne, String boom) {
	    int r = util.rand.nextInt(100);

	    if (r < vars.PLANE_DEAD) {
			System.out.println("=======================");
			if (vars.isReturned == true) {
				System.out.println("Вы " + ne + "попали, " + boom + ", но пал смертью храбрых");
			} else {
				System.out.println("Вы " + ne + "попали" + boom + ", а самолётик пал смертью храбрых");
			}
	        vars.hasPlane = false;
	        vars.isAero = false;

	    } else if (r < vars.PLANE_DEAD + vars.PLANE_RETURN) {
			System.out.println("=======================");
			if (vars.isReturned == true) {
				System.out.println("Вы " + ne + "попали, " + boom + " и вы смогли его вернуть");
			} else {
				System.out.println("Вы " + ne + "попали" + boom + ", но самолётик вернуть смогли");
			}
	        vars.hasPlane = true;

	    } else {
			System.out.println("=======================");
			if (vars.isReturned == true) {
				System.out.println("Вы " + ne + "попали, " + boom + ", но магически исчез");
			} else {
				System.out.println("Вы " + ne + "попали" + boom + ", но самолётик магически исчез");
			}
			vars.hasPlane = false;
			vars.isAero = false;
	    }

	    menu.open();
	}
	
	public static void todo() {
		System.out.println("ТУДУ");
		System.out.println("(Независимо от стадии, фиксим багз банни)");
		System.out.println("==== ALPHA ==== <= current");
		System.out.println("1. Сделать форматировку сообщений в фирехелп (гемор) <= DONE 07/01/2025 0:12");
		System.out.println("2. Добавить последствия от OM_FAIL");
		System.out.println("3. Хранить игровые данные в зашифрованном KLPT файле");
		System.out.println("==== BETA ====");
		System.out.println("4. Добавить инвентарь");
		System.out.println("5. Добавить магазин или кирилла с листочками");
		System.out.println("6. Усложнить механику а то камон, тыкать цыфарки это слишком легко");
		System.out.println("==== RELEASE!!!! ====");
		System.out.println("7. Graphics?");
		menu.open();
		
		
	}

}
