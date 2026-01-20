package simgraphic;

public class vars {
	public static int ch;

	public static boolean isWin;
	
	public static boolean isDumb;
	public static boolean isAero;
	
    public static final int NOAERO_MISS = 80;
    public static final int NOAERO_HIT  = 10;
    public static final int NOAERO_BACK = 10;
    
    public static final int AERO_MISS = 30;
    public static final int AERO_HIT  = 40;
    public static final int AERO_BACK = 10;

    public static final int PLANE_DEAD   = 60;
    public static final int PLANE_RETURN = 30;
    public static final int PLANE_MAGIC  = 10;
    
	public static boolean hasPlane;
	public static boolean hasPaper;

	public static final int CONSTRUCT_SUCCESSFUL = 99;
	public static final int CONSTRUCT_FAIL = 1;
	
	public static final int AERO_SUCCESSFUL = 80;
	public static final int AERO_FAIL = 20;
	
	public static final int OM_SUCCESSFUL = 50;
	public static final int OM_FAIL = 50;
	
	public static int tetrapaper;
	
	public static boolean isReturned;

	public static String paperfrom;
	public static String paperqual;
	public static String paperformat;
	public static String planefrom;
	public static String planequal;
	public static String planeformat;
	public static int coins;
	
	public static final String base = System.getProperty("user.home") + "\\BlureinBomb";
	public static final String pl = base + "\\plane.klpt";
	public static final String ae = base + "\\aero.klpt";
	public static final String pp = base + "\\paper.klpt";
	public static final String pf = base + "\\paperformat.klpt";
	public static final String pr = base + "\\paperfrom.klpt";
	public static final String pq = base + "\\paperqual.klpt";
	public static final String tp = base + "\\tetrapaper.klpt";
	public static final String plf = base + "\\planeformat.klpt";
	public static final String plr = base +"\\planefrom.klpt";
	public static final String plq = base +"\\planequal.klpt";
	public static final String cn = base + "\\coins.klpt";

	public static final String lbase = System.getProperty("user.home") + "/BlureinBomb";
	public static final String lpl = lbase + "/plane.klpt";
	public static final String lae = lbase + "/aero.klpt";
	public static final String lpp = lbase + "/paper.klpt";
	public static final String lpf = lbase + "/paperformat.klpt";
	public static final String lpr = lbase + "/paperfrom.klpt";
	public static final String lpq = lbase + "/paperqual.klpt";
	public static final String ltp = lbase + "/tetrapaper.klpt";
	public static final String lplf = lbase + "/planeformat.klpt";
	public static final String lplr = lbase + "/planefrom.klpt";
	public static final String lplq = lbase + "/planequal.klpt";
	public static final String lcn = lbase + "/coins.klpt";
	
	public static String plval;
	public static String aeval;
	public static String ppval;
	public static String pfval;
	public static String prval;
	public static String pqval;
	public static int tpval;
	public static String plfval;
	public static String plrval;
	public static String plqval;
	public static int cnval;
	
	public static String tmp;
	public static int tmpi;
	
	public static boolean suc;

	// ===== FOR GRAPHICS =====
	public static byte qual;

	public static String arrgs[];

	public static boolean isFlying = false;
	public static boolean isDead = false;
	public static boolean isDead2 = false;


	public static int len = 0;
	public static boolean isPositive;

	public static boolean isHit;
	public static double dy;

	public static boolean isOpen;


}
