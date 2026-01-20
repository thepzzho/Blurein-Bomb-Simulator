package simgraphic;

import static simgraphic.vars.*;

public class plane {
	public static void fire() {}

	
	public static void construct() {
		if (vars.hasPaper) {
			int r = util.rand.nextInt(100);
			if (r > vars.CONSTRUCT_FAIL) {
				vars.hasPlane = true;
				vars.hasPaper = false;
				vars.planeformat = vars.paperformat;
				vars.planefrom = vars.paperfrom;
				vars.planequal = vars.paperqual;
			} else {
				vars.isDead = true;
				vars.hasPaper = false;
			}
		}
	}
	
	public static void aerodynamix() {
	    int r = util.rand.nextInt(100);
	    if (r < vars.AERO_SUCCESSFUL) {
	        vars.isAero = true;
	    } else {
			vars.isDead2 = true;
	        vars.isAero = false;
	        vars.hasPlane = false;
	    }

	}

	
	public static void collectom() {
		int r = util.rand.nextInt(100);
		if (r < vars.OM_SUCCESSFUL) {
			vars.hasPaper = true;
			vars.paperformat = "A4";
			vars.paperqual = "Гут";
			vars.paperfrom = "Кабинет ОМСО";
		} else {
			vars.hasPaper = false;
		}
	}

	public static void collecttp() {
		if (vars.tetrapaper > 0 && !vars.hasPaper) {
			vars.hasPaper = true;
			vars.paperformat = "A5";
			vars.paperqual = "Шлехт";
			vars.paperfrom = "Тетрадь";
			vars.tetrapaper--;
		}
	}

	
	public static void zig() {


	}

	public static void firehelp() {
		if (!vars.hasPlane || vars.planeformat == null || vars.planefrom == null || vars.planequal == null) {
			return;
		}
		if (vars.isAero) {
			int r = util.rand.nextInt(100);
			if (r > AERO_MISS) {
				vars.dy = util.rand.nextFloat(-1,0.5f);
                vars.isPositive = vars.dy > 0;
				vars.isHit = true;

			} else {
				do {
					vars.dy = util.rand.nextFloat(-5f,2.5f);
				} while (vars.dy >= -1.1f && vars.dy <= 0.7f);
				vars.isHit = false;
			}
		} else {
			int r = util.rand.nextInt(100);
			if (r > NOAERO_MISS) {
				vars.dy = util.rand.nextFloat(-1,0.5f);
				vars.isPositive = vars.dy > 0;
				vars.isHit = true;

			} else {
				do {
					vars.dy = util.rand.nextFloat(-2.5f,2.5f);
				} while (vars.dy >= -1.1f && vars.dy <= 0.7f);
				vars.isHit = false;
			}
		}
		vars.isFlying = true;
	}


	public static void todo() {
		System.out.println("ТУДУ");
		System.out.println("(Независимо от стадии, фиксим багз банни)");
		System.out.println("==== ALPHA ==== <= current");
		System.out.println("1. Сделать форматировку сообщений в фирехелп (гемор) <= DONE 07/01/2025 0:12");
		System.out.println("2. Добавить последствия от OM_FAIL");
		System.out.println("3. Хранить игровые данные в зашифрованном (почти) KLPT файле <= DONE 08/01/2025 2:16");
		System.out.println("==== BETA ====");
		System.out.println("4. Добавить инвентарь");
		System.out.println("5. Добавить магазин или кирилла с листочками");
		System.out.println("6. Усложнить механику а то камон, тыкать цыфарки это слишком легко");
		System.out.println("==== RELEASE!!!! ====");
		System.out.println("7. Graphics?");
		menu.open();
		
		
	}

}
