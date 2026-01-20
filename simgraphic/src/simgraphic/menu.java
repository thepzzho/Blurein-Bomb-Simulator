package simgraphic;


import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.app.scene.SceneFactory;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.trade.Shop;
import javafx.beans.binding.Bindings;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGLForKtKt.runOnce;

public class menu extends GameApplication{

    Rectangle paper = new Rectangle(40,40,Color.WHITESMOKE);
    Rectangle rplane = new Rectangle(40,40,Color.WHITESMOKE);
    Rectangle tetrapaper = new Rectangle(80,120,Color.YELLOW);
    Rectangle kiril = new Rectangle(80,120,Color.RED);
    Rectangle player = new Rectangle(40,80,Color.RED);
    Rectangle omso = new Rectangle(80,120,Color.PURPLE);
    Rectangle narkoshop = new Rectangle(80,120,Color.GREEN);
    Rectangle tetrabuy;
    Rectangle setting = new Rectangle(60,60,Color.GRAY);
    static Rectangle bluerin = new Rectangle(40, 80, Color.BLUE);
    Rectangle stbg = new Rectangle(800,600,Color.DARKGRAY);
    String exp = "Explosion.png";
    String exp2 = "Explosion2.png";
    public static Text tptext;
    public static Text pformat;
    public static Text pelo = new Text(vars.planeformat);
    public static Text cntext = new Text("Монеты: " + vars.coins);
    public static Text tprice;
    public static Text sttext = new Text("⚙");
    Entity plformat;
    public static String ptrx;
    static Entity eplane;
    Entity explosion;
    Entity explosion3;
    Entity explosion2;
    Entity cnent;
    Entity esttext;


    private final String CHEAT = "GIVEMECOINS";
    private int cheatIndex = 0;



    public static void open() {
        if (vars.hasPlane) {
            writer.plane("Да");
        } else {
            writer.plane("Нет");
        }

        if (vars.hasPaper) {
            writer.paper("Да");
        } else {
            writer.paper("Нет");
        }

        if (vars.isAero) {
            writer.aero("Да");
        } else {
            writer.aero("Нет");
        }
        writer.tetrapaper(vars.tetrapaper);

        System.out.println(vars.paperformat);
        writer.paperformat(vars.paperformat);
        writer.paperfrom(vars.paperfrom);
        writer.paperqual(vars.paperqual);
        writer.planeformat(vars.planeformat);
        writer.planefrom(vars.planefrom);
        writer.planequal(vars.planequal);
        writer.coins(vars.coins);

        launch(new String[0]);


    }

    // ===== UI =====

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(800);
        settings.setHeight(600);
        settings.setTitle("Blurein Bomb Simulator");
        settings.setVersion("0.4bb");

        settings.setSceneFactory(new SceneFactory() {
            @Override
            public FXGLMenu newGameMenu() {
                //return new SimpleGameMenu();
                return new ShopMenu();
            }
        });


    }

    public class ShopMenu extends FXGLMenu {

        public ShopMenu() {
            super(MenuType.GAME_MENU);
            Rectangle bg = new Rectangle(800,600,Color.DARKGRAY);
            Rectangle exit = new Rectangle(40, 40, Color.RED);
            Rectangle tetrabg = new Rectangle(200,360,Color.WHITE);
            Rectangle tetrait = new Rectangle(160, 240, Color.YELLOW);
            tetrabuy = new Rectangle(200,40,Color.GRAY);
            Text magaz = new Text("Магазин");
            Text tetrad = new Text("Тетрадь 48 листов");
            tprice = new Text("750 монет");
            bg.setTranslateX(0);
            bg.setTranslateY(0);
            exit.setTranslateX(0);
            exit.setTranslateY(0);
            tetrabg.setTranslateX(100);
            tetrabg.setTranslateY(100);
            tetrabuy.setTranslateX(100);
            tetrabuy.setTranslateY(440);
            tetrait.setTranslateX(120);
            tetrait.setTranslateY(150);
            tetrad.setTranslateX(106);
            tetrad.setTranslateY(120);
            tprice.setTranslateX(128);
            tprice.setTranslateY(470);





            exit.setOnMouseClicked(e ->
                    FXGL.getGameController().gotoPlay()
            );
            getContentRoot().getChildren().add(bg);
            getContentRoot().getChildren().add(exit);
            getContentRoot().getChildren().add(magaz);
            getContentRoot().getChildren().add(tetrabg);
            getContentRoot().getChildren().add(tetrabuy);
            getContentRoot().getChildren().add(tetrait);
            getContentRoot().getChildren().add(tetrad);
            getContentRoot().getChildren().add(tprice);
            magaz.setX(260);
            magaz.setY(50);
            magaz.setStyle("-fx-font-size: 64px;");
            tetrad.setStyle("-fx-font-size: 21px;");
            tprice.setStyle("-fx-font-size: 28px");
            magaz.setVisible(true);

            exit.fillProperty().bind(
                    Bindings.when(exit.hoverProperty()).then(Color.INDIANRED).otherwise(Color.RED)
            );

                if (vars.coins < 750) {
                    tetrabuy.fillProperty().unbind();
                    tetrabuy.setFill(Color.GRAY);
                }

                if (vars.tetrapaper >= 48) {
                    tetrabuy.fillProperty().unbind();
                    tetrabuy.setFill(Color.GRAY);
                }


        }
    }



    protected void initInput() {
        Input input = FXGL.getInput();
        input.addAction(new UserAction("Debug blowup") {
            @Override
            protected void onAction() {
                explosion3.setVisible(true);
            }

        }, KeyCode.OPEN_BRACKET);


        Input cheat = FXGL.getInput();


        for (char c = 'A'; c <= 'Z'; c++) {
            final char letter = c;

            cheat.addAction(new UserAction("Cheat_" + c) {
                @Override
                protected void onActionBegin() {
                    handleCheat(letter);
                }
            }, KeyCode.valueOf(String.valueOf(c)));
        }

    }

    private void handleCheat(char pressed) {
        if (pressed == CHEAT.charAt(cheatIndex)) {
            cheatIndex++;

            if (cheatIndex == CHEAT.length()) {
                onCheatActivated();
                cheatIndex = 0;
            }
        } else {
            cheatIndex = 0;
        }
    }

    private void onCheatActivated() {
        System.out.println("CHEAT ACTIVATED!");
        vars.coins += 100;   // например
    }


    @Override
    protected void initGame() {

        narkoshop.setOnMouseClicked(e -> {
            FXGL.getGameController().gotoGameMenu();
        });

        FXGL.entityBuilder() // Блюреин
                .at(0, 250)
                .view(bluerin)
                .buildAndAttach();
        FXGL.entityBuilder() // Игрок
                .at(700,250)
                .view(player)
                .buildAndAttach();
        FXGL.entityBuilder() // Тетрадь
                .at(0,30)
                .view(tetrapaper)
                .buildAndAttach();
        FXGL.entityBuilder() // Кирилл
                .at(400,30)
                .view(kiril)
                .buildAndAttach();
        FXGL.entityBuilder() // Кабинет ОМСО
                .at(100,30)
                .view(omso)
                .buildAndAttach();
        FXGL.entityBuilder() // Индикатор Бумаги
                .at(660,250)
                .view(paper)
                .buildAndAttach();
        eplane = FXGL.entityBuilder() // Индикатор Самолёта
                .at(660,290)
                .view(rplane)
                .buildAndAttach();
        explosion = FXGL.entityBuilder()
                .at(660,250)
                .view(exp)
                .buildAndAttach();
        explosion3 = FXGL.entityBuilder()
                .at(-15,260)
                .view(exp2)
                .buildAndAttach();

        explosion2 = FXGL.entityBuilder()
                .at(660,290)
                .view(exp)
                .buildAndAttach();
        plformat = FXGL.entityBuilder()
                .at(eplane.getX() + 12.5, eplane.getY() + 25)
                .view(pelo)
                .buildAndAttach();
        cnent = FXGL.entityBuilder()
                .at(725,10)
                .view(cntext)
                .buildAndAttach();
        FXGL.entityBuilder()
                .at(200,30)
                .view(narkoshop)
                .buildAndAttach();
        FXGL.entityBuilder()
                .at(370,545)
                .view(setting)
                .buildAndAttach();
        esttext = FXGL.entityBuilder()
                .at(369,600)
                .view(sttext)
                .buildAndAttach();
        FXGL.entityBuilder()
                .at(0,0)
                .view(stbg)
                .buildAndAttach();



        Text blutext = new Text("Bluerin");
        Text dutext = new Text("Du");
        tptext = new Text(String.valueOf(vars.tetrapaper));
        Text tttext = new Text("Тетрадь");
        Text kirtext = new Text("Кирилл");
        Text omtext = new Text("Кабинет ОМСО");
        Text mgtext = new Text("Магазин");
        pformat = new Text(vars.paperformat);
        cntext.setText("Монеты: " + vars.coins);
        //plformat = new Text(vars.planeformat);
        FXGL.addUINode(blutext, 0, 250);
        FXGL.addUINode(dutext,700,250);
        FXGL.addUINode(tttext,0,20);
        FXGL.addUINode(tptext,20,100);
        FXGL.addUINode(kirtext, 400,20);
        FXGL.addUINode(omtext,100,20);
        FXGL.addUINode(pformat,672.5,275);
        FXGL.addUINode(mgtext,210,20);
        sttext.setStyle("-fx-font-size: 70px");
        //FXGL.addUINode(plformat,672.5,315);
        //FXGL.addUINode(cntext,725,10);
        pformat.setVisible(false);
        plformat.setVisible(true);
        explosion.setVisible(false);
        explosion2.setVisible(false);
        explosion3.setVisible(false);
        plformat.setVisible(false);
        pelo.setVisible(false);
        stbg.setVisible(false);

        tptext.setStyle("-fx-font-size: 32px");

        narkoshop.fillProperty().bind(
                Bindings.when(narkoshop.hoverProperty()).then(Color.LIGHTGREEN).otherwise(Color.GREEN)
        );

        omso.fillProperty().bind(
                Bindings.when(omso.hoverProperty()).then(Color.MEDIUMPURPLE).otherwise(Color.PURPLE)
        );

        tetrapaper.fillProperty().bind(
                Bindings.when(tetrapaper.hoverProperty()).then(Color.LIGHTGOLDENRODYELLOW).otherwise(Color.YELLOW)
        );

        setting.fillProperty().bind(
                Bindings.createObjectBinding(() ->
                                (setting.isHover() || sttext.isHover())
                                        ? Color.LIGHTGRAY
                                        : Color.GRAY,
                        sttext.hoverProperty(),
                        setting.hoverProperty()
                )
        );






        tetrapaper.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                plane.collecttp();
            }
        });
        tptext.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                plane.collecttp();
            }
        });

        sttext.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!vars.isOpen) {
                    stbg.setVisible(true);
                    stbg.toFront();
                }
            }
        });



        kiril.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (vars.hasPlane && !vars.isAero) {
                    plane.aerodynamix();
                }
            }
        });

        tetrabuy.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (vars.coins >= 750 && vars.tetrapaper < 48) {
                    vars.coins -= 750;
                    vars.tetrapaper = 48;
                    FXGL.getGameController().gotoPlay();
                    System.out.println("Bought: 48 Tetrad");
                }
            }
        });

        tprice.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (vars.coins >= 750 && vars.tetrapaper < 48) {
                    vars.coins -= 750;
                    vars.tetrapaper = 48;
                    FXGL.getGameController().gotoPlay();
                    System.out.println("Bought: 48 Tetrad");
                }
            }
        });


        paper.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                plane.construct();
            }
        });

        pformat.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                plane.construct();
            }
        });

        rplane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                plane.firehelp();
            }
        });

        pelo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                plane.firehelp();
            }
        });

        omso.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                plane.collectom();
            }
        });

    }

    @Override
    protected void onUpdate(double tpf) {
        writer.plane(vars.hasPlane ? "Да" : "Нет");
        writer.paper(vars.hasPaper ? "Да" : "Нет");
        writer.aero(vars.isAero ? "Да" : "Нет");

        writer.tetrapaper(vars.tetrapaper);
        writer.paperformat(vars.paperformat);
        writer.paperfrom(vars.paperfrom);
        writer.paperqual(vars.paperqual);
        writer.planeformat(vars.planeformat);
        writer.planefrom(vars.planefrom);
        writer.planequal(vars.planequal);
        tptext.setText(String.valueOf(vars.tetrapaper));
        cntext.setText("Монеты: " + vars.coins);
        writer.coins(vars.coins);
        //System.out.println("DEBUG: DATA SYNCED");



        if (vars.tetrapaper == 0) {
            tetrapaper.fillProperty().unbind();
            tetrapaper.setFill(Color.BLACK);
        } else {
            tetrapaper.fillProperty().bind(
                    Bindings.createObjectBinding(() ->
                                    (tetrapaper.isHover() || tptext.isHover())
                                            ? Color.LIGHTGOLDENRODYELLOW
                                            : Color.YELLOW,
                            tetrapaper.hoverProperty(),
                            tptext.hoverProperty()
                    )
            );
        }

        if (vars.coins >= 750 && vars.tetrapaper < 48) {
            tetrabuy.fillProperty().bind(
                    Bindings.createObjectBinding(() ->
                            (tetrabuy.isHover() || tprice.isHover())
                                ? Color.LIGHTGRAY
                                : Color.GRAY,
                            tetrabuy.hoverProperty(),
                            tprice.hoverProperty()
                    )
            );
        } else {
            tetrabuy.fillProperty().unbind();
            tetrabuy.setFill(Color.GRAY);
        }

        if (vars.hasPaper) {
            if (vars.paperqual.equals("Гут")) {
                pformat.setText(vars.paperformat);
                pformat.setVisible(true);
                paper.fillProperty().bind(
                        Bindings.createObjectBinding(() ->
                                        (paper.isHover() || pformat.isHover())
                                                ? Color.LIGHTGREEN
                                                : Color.GREEN,
                                paper.hoverProperty(),
                                pformat.hoverProperty()
                        )
                );


            } else {
                pformat.setText(vars.paperformat);
                pformat.setVisible(true);
                paper.fillProperty().bind(
                        Bindings.createObjectBinding(() ->
                                        (paper.isHover() || pformat.isHover())
                                                ? Color.RED
                                                : Color.DARKRED,
                                paper.hoverProperty(),
                                pformat.hoverProperty()
                        )
                );


            }
        } else {
            pformat.setVisible(false);
            paper.fillProperty().unbind();
            paper.setFill(Color.WHITESMOKE);

        }
            if (vars.isAero) {
                    kiril.fillProperty().unbind();
                    kiril.setFill(Color.GREEN);
            } else {
                if (vars.hasPlane) {
                    kiril.fillProperty().bind(
                            Bindings.when(kiril.hoverProperty()).then(Color.INDIANRED).otherwise(Color.RED)
                    );
                } else {
                    kiril.fillProperty().unbind();
                    kiril.setFill(Color.RED);
                }
            }

        if (vars.hasPlane) {
            if (vars.planequal.equals("Гут")) {
                pelo.setText(vars.planeformat);
                plformat.setVisible(true);
                pelo.setVisible(true);
                rplane.fillProperty().bind(
                        Bindings.createObjectBinding(() ->
                                        (rplane.isHover() || pelo.isHover())
                                                ? Color.LIGHTGREEN
                                                : Color.GREEN,
                                rplane.hoverProperty(),
                                pelo.hoverProperty()
                        )
                );

            } else if (vars.planequal.equals("Шлехт")) {
                pelo.setText(vars.planeformat);
                plformat.setVisible(true);
                pelo.setVisible(true);
                rplane.fillProperty().bind(
                        Bindings.createObjectBinding(() ->
                                        (rplane.isHover() || pelo.isHover())
                                                ? Color.RED
                                                : Color.DARKRED,
                                rplane.hoverProperty(),
                                pelo.hoverProperty()
                        )
                );
            }
        } else {
            plformat.setVisible(false);
            pelo.setVisible(false);
            rplane.fillProperty().unbind();
            rplane.setFill(Color.WHITESMOKE);
            eplane.setX(660);
            eplane.setY(290);

        }
        if (vars.hasPlane) {
            pelo.setText(vars.planeformat);
            plformat.setX(eplane.getX() + 12.5); // сдвиг относительно квадрата
            plformat.setY(eplane.getY() + 25);
            plformat.setVisible(true);
        }


        if (vars.isFlying && eplane.getX() > 40) {
            System.out.println("Plane flying with " + vars.dy + " untochnost, will hit? " + vars.isHit + ", is positive? " + vars.isPositive);
            eplane.setX(eplane.getX() - 10);
            eplane.setY(eplane.getY() + vars.dy);

            plformat.setX(eplane.getX() + 12.5);
            plformat.setY(eplane.getY() + 25);
        } else if (vars.isFlying && eplane.getX() <= 40) {

            vars.isFlying = false;

            vars.hasPlane = false;
            vars.isAero = false;
            if (vars.isHit) {
                vars.coins += 20;
                bluerin.setFill(Color.BLACK);
                explosion3.setVisible(true);
                runOnce(() -> {
                    bluerin.setFill(Color.BLUE);
                    explosion3.setVisible(false);
                    return null;
                }, Duration.seconds(0.5));
            }



        }

        //System.out.println(vars.coins);

        //System.out.println(plformat.getX());
        //System.out.println(plformat.getY());
        //System.out.println(plformat.isVisible());
        //System.out.println(plformat.getText());


        if(vars.isDead) {
            explosion.setVisible(true);
            runOnce(() -> {
                explosion.setVisible(false);
                return null;
            }, Duration.seconds(2));
            vars.isDead = false;
        }


        if(vars.isDead2) {
            explosion2.setVisible(true);
            runOnce(() -> {
                explosion2.setVisible(false);
                return null;
            }, Duration.seconds(2));
            vars.isDead2 = false;
        }



        if (vars.coins < 10) {
            cnent.setX(735);
        }

        if (vars.coins >= 10 && vars.coins < 100) {
            cnent.setX(725);
        }

        if (vars.coins >= 100 && vars.coins < 1000) {
            cnent.setX(715);
        }
        if (vars.coins >= 1000 && vars.coins < 10000) {
            cnent.setX(705);
        }
        //if (eplane.getX() > 660|| rplane.getX() < 660) {
           // eplane.setX(660);
           // rplane.setX(660);
        //}

    }


}
