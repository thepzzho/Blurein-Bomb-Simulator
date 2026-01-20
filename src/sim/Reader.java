package sim;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
	public static String getPlane() {
        if (vars.isWin) {
            try (BufferedReader reader = new BufferedReader(new FileReader(vars.pl))) {
                while ((vars.tmp = reader.readLine()) != null) {
                    vars.plval = vars.tmp;

                }
            } catch (IOException e) {
                System.err.println("Ошибка при чтении файла: " + e.getMessage());
            }
            return vars.plval;
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(vars.lpl))) {
                while ((vars.tmp = reader.readLine()) != null) {
                    vars.plval = vars.tmp;

                }
            } catch (IOException e) {
                System.err.println("Ошибка при чтении файла: " + e.getMessage());
            }
            return vars.plval;
        }
    }

    public static String getAero() {
        if (vars.isWin) {
            try (BufferedReader reader = new BufferedReader(new FileReader(vars.ae))) {
                while ((vars.tmp = reader.readLine()) != null) {
                    vars.aeval = vars.tmp;

                }
            } catch (IOException e) {
                System.err.println("Ошибка при чтении файла: " + e.getMessage());
            }
            return vars.aeval;
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(vars.lae))) {
                while ((vars.tmp = reader.readLine()) != null) {
                    vars.aeval = vars.tmp;

                }
            } catch (IOException e) {
                System.err.println("Ошибка при чтении файла: " + e.getMessage());
            }
            return vars.aeval;
        }
    }

    public static String getPaper() {
        if (vars.isWin) {
            try (BufferedReader reader = new BufferedReader(new FileReader(vars.pp))) {
                while ((vars.tmp = reader.readLine()) != null) {
                    vars.ppval = vars.tmp;

                }
            } catch (IOException e) {
                System.err.println("Ошибка при чтении файла: " + e.getMessage());
            }
            return vars.ppval;
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(vars.lpp))) {
                while ((vars.tmp = reader.readLine()) != null) {
                    vars.ppval = vars.tmp;

                }
            } catch (IOException e) {
                System.err.println("Ошибка при чтении файла: " + e.getMessage());
            }
            return vars.ppval;
        }
    }

    public static String getPformat() {
        if (vars.isWin) {
            try (BufferedReader reader = new BufferedReader(new FileReader(vars.pf))) {
                while ((vars.tmp = reader.readLine()) != null) {
                    vars.pfval = vars.tmp;

                }
            } catch (IOException e) {
                System.err.println("Ошибка при чтении файла: " + e.getMessage());
            }
            return vars.pfval;
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(vars.lpf))) {
                while ((vars.tmp = reader.readLine()) != null) {
                    vars.pfval = vars.tmp;

                }
            } catch (IOException e) {
                System.err.println("Ошибка при чтении файла: " + e.getMessage());
            }
            return vars.pfval;
        }
    }

    public static String getPfrom() {
        if (vars.isWin) {
            try (BufferedReader reader = new BufferedReader(new FileReader(vars.pr))) {
                while ((vars.tmp = reader.readLine()) != null) {
                    vars.prval = vars.tmp;

                }
            } catch (IOException e) {
                System.err.println("Ошибка при чтении файла: " + e.getMessage());
            }
            return vars.prval;
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(vars.lpr))) {
                while ((vars.tmp = reader.readLine()) != null) {
                    vars.prval = vars.tmp;

                }
            } catch (IOException e) {
                System.err.println("Ошибка при чтении файла: " + e.getMessage());
            }
            return vars.prval;
        }
    }

    public static String getPqual() {
        if (vars.isWin) {
            try (BufferedReader reader = new BufferedReader(new FileReader(vars.pq))) {
                while ((vars.tmp = reader.readLine()) != null) {
                    vars.pqval = vars.tmp;

                }
            } catch (IOException e) {
                System.err.println("Ошибка при чтении файла: " + e.getMessage());
            }
            return vars.pqval;
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(vars.lpq))) {
                while ((vars.tmp = reader.readLine()) != null) {
                    vars.pqval = vars.tmp;

                }
            } catch (IOException e) {
                System.err.println("Ошибка при чтении файла: " + e.getMessage());
            }
            return vars.pqval;
        }
    }

    public static int getTpval() {
        if (vars.isWin) {
            try (BufferedReader reader = new BufferedReader(new FileReader(vars.tp))) {
                while ((vars.tmp = reader.readLine()) != null) {
                    vars.tpval = Integer.parseInt(vars.tmp);

                }
            } catch (IOException e) {
                System.err.println("Ошибка при чтении файла: " + e.getMessage());
            }
            return vars.tpval;
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(vars.ltp))) {
                while ((vars.tmp = reader.readLine()) != null) {
                    vars.tpval = Integer.parseInt(vars.tmp);

                }
            } catch (IOException e) {
                System.err.println("Ошибка при чтении файла: " + e.getMessage());
            }
            return vars.tpval;
        }
    }
}