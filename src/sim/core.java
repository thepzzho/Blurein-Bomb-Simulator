package sim;

import java.io.*;

public class core {
	public static void main(String args[]) {

		File dir = null;
		File plane = null;
		File aero = null;
		File paper = null;
		File pformat = null;
		File pfrom = null;
		File pqual = null;
		File tepe = null;

		System.out.println("Выберите систему:");
		System.out.println("1. Windows");
		System.out.println("2. Linux");
		vars.ch = util.sc.nextInt();
		if (vars.ch == 1) {
			vars.isWin = true;
			dir = new File(vars.base);
			plane = new File(vars.pl);
			aero = new File(vars.ae);
			paper = new File(vars.pp);
			pformat = new File(vars.pf);
			pfrom = new File(vars.pr);
			pqual = new File(vars.pq);
			tepe = new File(vars.tp);
		} else {
			vars.isWin = false;
			dir = new File(vars.lbase);
			plane = new File(vars.lpl);
			aero = new File(vars.lae);
			paper = new File(vars.lpp);
			pformat = new File(vars.lpf);
			pfrom = new File(vars.lpr);
			pqual = new File(vars.lpq);
			tepe = new File(vars.ltp);
		}


		
		if (!dir.exists()) {
		    dir.mkdirs();
		}

		if (!plane.exists()) {
		    try {
				plane.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    writer.plane("Нет");
		    
		}
		
		if (!aero.exists()) {
		    try {
				aero.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    writer.aero("Нет");
		    
		}
		
		if (!paper.exists()) {
		    try {
				paper.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    writer.paper("Нет");
		}
		
		if (!pformat.exists()) {
		    try {
				pformat.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    writer.paperformat("null");
		    
		}
		
		if (!pfrom.exists()) {
		    try {
				pfrom.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    writer.paperfrom("null");
		    
		}
		
		if (!pqual.exists()) {
		    try {
				pqual.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    writer.paperqual("null");
		}
		
		if (!tepe.exists()) {
		    try {
				tepe.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    writer.tetrapaper(48);
		}
		System.out.println("Guten tag.");
		System.out.println("Willkommen ins Blurein Bomb Simulator.");
		
		if (Reader.getPlane().equals("Да")) {
			vars.hasPlane = true;
		} else {
			vars.hasPlane = false;
		}
		
		if (Reader.getPaper().equals("Да")) {
			vars.hasPaper = true;
		} else {
			vars.hasPaper = false;
		}
		
		if (Reader.getAero().equals("Да")) {
			vars.isAero = true;
		} else {
			vars.isAero = false;
		}
		
		vars.tetrapaper = Reader.getTpval();
		
		
		
		
		menu.open();
		
	}
}
