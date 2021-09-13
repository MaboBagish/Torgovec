import java.util.Arrays;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
        State state = new State ( );
        Double[] coef1 = {1.2, 0.95, 0.55, 0.25, 0.1};

        System.out.println ("\nДобро пожаловать в игру путешествие торговца");

        Tovar meat1 = new Tovar ( );
        Tovar corn1 = new Tovar ( );
        Tovar driedFructs1 = new Tovar ( );
        Tovar flour1 = new Tovar ( );
        Tovar fabricks1 = new Tovar ( );
        Tovar textile1 = new Tovar ( );
        corn1.setPrice ( );
        meat1.setPrice ( );
        driedFructs1.setPrice ( );
        flour1.setPrice ( );
        fabricks1.setPrice ( );
        textile1.setPrice ( );

        textile1.setCoef (coef1[0]);

        corn1.setCoef (coef1[0]);
        meat1.setCoef (coef1[0]);
        driedFructs1.setCoef (coef1[0]);
        flour1.setCoef (coef1[0]);
        fabricks1.setCoef (coef1[0]);


        System.out.println ("\nПрежде чем двинуться в путь надо закупить товаров для торговли");

        System.out.println ("\nМясо нынче стоит " + meat1.getPrice ( ) + "\nМука нынче стоит " + fabricks1.getPrice ( ) + "\nСухофрукты нынче стоят " + driedFructs1.getPrice ( ) +
                "\nКраска нынче стоит " + flour1.getPrice ( ) + "\nЗерно нынче стоит " + corn1.getPrice ( ) + "\nТкани нынче стоят " + textile1.getPrice ( ));

        Torgovec torgovec = new Torgovec ( );
        Random random = new Random ( );
        torgovec.setGruzCarrying ((int) (500 + Math.random ( ) * 1000));
        System.out.println ("\nГрузоподъемность телеги торговца  " + torgovec.getGruzCarrying ( ) + "  киллограмм.");

        torgovec.setMoney ((double) (5000 + Math.random ( ) * 500000));
        System.out.println ("\nКоличество денег  " + torgovec.getMoney ( ) + "  золотых монет.");

        int corn = 0, driedFructs = 0, fabricks = 0, flour = 0, meat = 0, textile = 0;
        double cornCena = 0, driedFructsCena = 0, fabricksCena = 0, flourCena = 0, meatCena = 0, textileCena = 0, summa = 0, ves = 0;

        for (int i = 0; i < (torgovec.getGruzCarrying ( )); i++) {

            int kilogram = changeTovar ( );

            if (summa < torgovec.getMoney ( ) - 300) {
                if (kilogram == 0) {
                    corn = 1 + corn;
                    cornCena = corn * corn1.getPrice ( );
                } else if (kilogram == 1) {
                    driedFructs = driedFructs + 1;
                    driedFructsCena = driedFructs * driedFructs1.getPrice ( );
                } else if (kilogram == 2) {
                    fabricks = fabricks + 1;
                    fabricksCena = fabricks * fabricks1.getPrice ( );
                } else if (kilogram == 3) {
                    flour = flour + 1;
                    flourCena = flour * flour1.getPrice ( );
                } else if (kilogram == 4) {
                    meat = meat + 1;
                    meatCena = meat * meat1.getPrice ( );
                } else {

                    textile = textile + 1;
                    textileCena = textile * textile1.getPrice ( );
                }
                ves = corn + driedFructs + fabricks + flour + meat + textile;
                summa = driedFructsCena + fabricksCena + flourCena + meatCena + cornCena + textileCena;
            }
            corn1.setWeight (corn);
            driedFructs1.setWeight (driedFructs);
            fabricks1.setWeight (fabricks);
            flour1.setWeight (flour);
            meat1.setWeight (meat);
            textile1.setWeight (textile);

        }
        System.out.println ("\nЗерна куплено " + corn + " килограм| Сухофрукты куплено " + driedFructs + " килограм| Муки куплено "
                + fabricks + " килограм|\nКраски куплено " + flour + " килограм| Мяса куплено " + meat + " килограм| Тканей куплено " + textile + " килограм");
        torgovec.setMoney (torgovec.getMoney ( ) - summa);
        System.out.println ("Товаров куплено на сумму " + summa + " золотых \nОставшиеся золотые " + torgovec.getMoney ( ) + "\nОбщий вес груза " + ves + " килограм");

        torgovec.setSpeed ((int) (1 + Math.random ( ) * 4));
        System.out.println ("\nСкорость передвижения торговца = " + torgovec.getSpeed ( ) + "  лиг в день.");

        String[] town = {"Бишкек", "Астана", "Стамбул", "Москва", "Ташкент"};
        System.out.println ("\nЕсть пять торговых городов в которые может пойти торговец. Это  " + Arrays.toString (town) + ". Какой же выберет торговец ?");
        int randomTown = random.nextInt (town.length);
        System.out.println ("");
        System.out.println ("Торговец выбрал город " + town[randomTown]);

        int randomDistance = (int) (50 + Math.random ( ) * 50);
        System.out.println ("\nДо города " + town[randomTown] + " " + randomDistance + " лиг пути.");

        double durationTravel = randomDistance / torgovec.getSpeed ( );
        System.out.println ("\nЕсли судить по звездам то путь продлится " + durationTravel + " дней и ночей.");


        while (durationTravel > 0) {
            durationTravel = durationTravel - 1;
            System.out.println ("\n###################################################");
            System.out.println ("До завершения нашего путешествия осталось " + durationTravel + " дней.....");
            if (durationTravel <= 0) {
                System.out.println ("Наконец то мы достигли цели нашего путешествия");

                System.out.println ("Начнем торговлю, цены на наши товары в зависимости от состояния составляют" +
                        "\nМясо " + meat1.getPrice ( ) * meat1.getCoef ( ) + " золотых \nЗерно " + corn1.getCoef ( ) * corn1.getPrice ( ) + " золотых " +
                        "\nКраски " + flour1.getPrice ( ) * flour1.getCoef ( ) + " золотых \nМука " + fabricks1.getCoef ( ) * fabricks1.getPrice ( ) + " золотых" +
                        "\nТкани " + textile1.getPrice ( ) * textile1.getCoef ( ) + " золотых \nСухофрукты " + driedFructs1.getCoef ( ) * driedFructs1.getPrice ( ) + " " +
                        "золотых"
                );
                System.out.println ("#######################################################");

                System.out.println ("\nСписок наших товаров \nМясо " + meat1.getWeight ( ) + " килограммов\nСухофруктов " + driedFructs1.getWeight ( ) + " килограмов \nМуки " + fabricks1.getWeight ( ) + "" +
                        " килограмов \nТканей " + textile1.getWeight ( ) + " килограмов \nКраски " + flour1.getWeight ( ) + " килограмов \nЗерна " + corn1.getWeight ( ) + " килограмов");
                break;
            }
            String[] stateDay = {"typicalDay", "rain", "smoothRoad", "brockenWheel",
                    "river", "metLocal", "bandits", "tractir", "productBad"};
//            state.setStateChange (random.nextInt (stateDay.length));
            state.setStateChange (6);


            if (state.getStateChange ( ) == 0) {
                System.out.println ("Обычный день, ничего не произошло");

            } else if (state.getStateChange ( ) == 1) {
                System.out.println ("\nПошел дождь, тележка потеряла ход");

                int speed = torgovec.getSpeed ( ) - 2;
                if (speed <= 0) {
                    durationTravel = durationTravel + 1;
                    System.out.println ("Мы потеряли один день");
                } else {
                    double rez = durationTravel * torgovec.getSpeed ( );
                    double lig = rez + 2;
                    durationTravel = lig / torgovec.getSpeed ( );
                    System.out.println ("\nСкорость торговца уменьшилась");
                }


                if (Math.random ( ) * 30 == 0) {

                    int changeBadProduct = changeTovar ( );

                    System.out.println ("Вода проникла внутрь телеги. Состояние товаров ухудшилось");
                    if (changeBadProduct == 0) {
                        if (corn1.getWeight ( ) == 0) {
                            System.out.println ("На то место где лежал товар попала вода, но портится уже нечему");
                        } else {
                            int indexU = indexOf (corn1.getCoef ( ), coef1) + 1;
                            corn1.setCoef (coef1[indexU]);
                            System.out.println ("Зерно намокло " + corn1.getCoef ( ));
                            if (indexU == 4) {
                                System.out.println ("Товар полностью испортился, пришлось его выкинуть");
                                corn1.setWeight (0);
                            }
                        }
                    } else if (changeBadProduct == 1) {
                        if (corn1.getWeight ( ) == 0) {
                            System.out.println ("На то место где лежал товар попала вода, но портится уже нечему");
                        } else {
                            int indexU = indexOf (driedFructs1.getCoef ( ), coef1) + 1;
                            driedFructs1.setCoef (coef1[indexU]);
                            System.out.println ("Сухофрукты намокли " + driedFructs1.getCoef ( ));
                            if (indexU == 4) {
                                System.out.println ("Товар полностью испортился, пришлось его выкинуть");
                                driedFructs1.setWeight (0);
                            }
                        }
                    } else if (changeBadProduct == 2) {
                        if (corn1.getWeight ( ) == 0) {
                            System.out.println ("На то место где лежал товар попала вода, но портится уже нечему");
                        } else {
                            int indexU = indexOf (fabricks1.getCoef ( ), coef1) + 1;
                            fabricks1.setCoef (coef1[indexU]);
                            System.out.println ("Ткани намокли " + fabricks1.getCoef ( ));
                            if (indexU == 4) {
                                System.out.println ("Товар полностью испортился, пришлось его выкинуть");
                                fabricks1.setWeight (0);
                            }
                        }
                    } else if (changeBadProduct == 3) {
                        if (corn1.getWeight ( ) == 0) {
                            System.out.println ("На то место где лежал товар попала вода, но портится уже нечему");
                        } else {
                            int indexU = indexOf (flour1.getCoef ( ), coef1) + 1;
                            flour1.setCoef (coef1[indexU]);
                            System.out.println ("Краска намокла " + flour1.getCoef ( ));
                            if (indexU == 4) {
                                System.out.println ("Товар полностью испортился, пришлось его выкинуть");
                                flour1.setWeight (0);
                            }
                        }
                    } else if (changeBadProduct == 4) {
                        if (corn1.getWeight ( ) == 0) {
                            System.out.println ("На то место где лежал товар попала вода, но портится уже нечему");
                        } else {
                            int indexU = indexOf (textile1.getCoef ( ), coef1) + 1;
                            textile1.setCoef (coef1[indexU]);
                            System.out.println ("Ткани намокли " + textile1.getCoef ( ));
                            if (indexU == 4) {
                                System.out.println ("Товар полностью испортился, пришлось его выкинуть");
                                textile1.setWeight (0);
                            }
                        }
                    } else {
                        if (corn1.getWeight ( ) == 0) {
                            System.out.println ("На то место где лежал товар попала вода, но портится уже нечему");
                        } else {
                            int indexU = indexOf (meat1.getCoef ( ), coef1) + 1;
                            meat1.setCoef (coef1[indexU]);
                            System.out.println ("Мясо намокло " + meat1.getCoef ( ));
                            if (indexU == 4) {
                                System.out.println ("Товар полностью испортился, пришлось его выкинуть");
                                meat1.setWeight (0);
                            }
                        }
                    }

                }
            } else if (state.getStateChange ( ) == 2) {
                System.out.println ("\nДорога настоль ровная что тянет ко сну");

                double ostavshiysyaPut = torgovec.getSpeed ( ) * durationTravel;
                double randomDistance1 = ostavshiysyaPut - 2;
                System.out.println ("Скорость увелечилась");
                durationTravel = randomDistance1 / torgovec.getSpeed ( );
                System.out.println ("Теперь мы доедем быстрее. Продолжительность пути сократилось до " + durationTravel + " дней");

            } else if (state.getStateChange ( ) == 3) {
                System.out.println ("Сломалось колесо... День впустую стоим на месте");
                durationTravel = durationTravel + 1;

            } else if (state.getStateChange ( ) == 4) {
                System.out.println ("Большая река встретилась на пути. Целый день ушел на поиски брода");
                durationTravel = durationTravel + 1;
            } else if (state.getStateChange ( ) == 5) {
                System.out.println ("Встретил местного, знающего человека. Узнал как можно срезать путь");

                int srezPuti = (int) (3 + Math.random ( ) * 3);

                double ostavshiysyaPut = durationTravel * torgovec.getSpeed ( );
                double randomDistance1 = ostavshiysyaPut - srezPuti;
                if (durationTravel < 5) {
                    System.out.println ("Торговца пытаются ввести в заблуждение. Такой срез пути приведет к беде. Мы не будем использовать его");
                } else {
                    durationTravel = randomDistance1 / torgovec.getSpeed ( );
                    System.out.println ("Теперь расстояние до города стало " + randomDistance1 + " лиг");
                    System.out.println ("Время пути уменьшилось до " + durationTravel + " дней");
                }
            } else if (state.getStateChange ( ) == 6) {
                System.out.println ("Внезапно появились разбойники....");

                int otkup = (int) (1 + Math.random ( ) * 2);
                if (otkup == 1) {
                    if (torgovec.getMoney ( ) <= 0) {
                        System.out.println ("Разбойники потребовали денег, но денег оказалось недостаточно и они решили забрать товар");
                        System.out.println ("Разбойники забирают лучший товар");
                        if (corn1.getPrice ( ) > driedFructs1.getPrice ( ) && corn1.getWeight ( ) != 0) {
                            if (corn1.getPrice ( ) > fabricks1.getPrice ( )) {
                                if (corn1.getPrice ( ) > flour1.getPrice ( )) {
                                    if (corn1.getPrice ( ) > meat1.getPrice ( )) {
                                        if (corn1.getPrice ( ) > textile1.getPrice ( )) {

                                            System.out.println ("Разбойники забрали все зерно");
                                            corn1.setWeight (0.0);
                                            System.out.println (corn1.getWeight ( ));
                                        }
                                    }else {}
                                }else {}
                            }else {}
                        } else if (driedFructs1.getPrice ( ) > fabricks1.getPrice ( ) & driedFructs1.getWeight () != 0 ) {
                            if (driedFructs1.getPrice ( ) > flour1.getPrice ( )) {
                                if (driedFructs1.getPrice ( ) > meat1.getPrice ( )) {
                                    if (driedFructs1.getPrice ( ) > textile1.getPrice ( )) {
                                        System.out.println ("Разбойники забрали все сухофрукты");
                                        driedFructs1.setWeight (0.0);
                                        System.out.println (driedFructs1.getWeight ( ));
                                    }
                                }
                            }else {System.out.println ("Разбойники забрали все мясо");
                                meat1.setWeight (0.0);}
                        } else if (fabricks1.getPrice ( ) > flour1.getPrice ( ) & fabricks1.getWeight ()!=0) {
                            if (fabricks1.getPrice ( ) > meat1.getPrice ( )) {
                                if (fabricks1.getPrice ( ) > textile1.getPrice ( )) {
                                    System.out.println ("Разбойники забрали всю ткань");
                                    fabricks1.setWeight (0.0);
                                }
                            }else {continue;}
                        } else if (flour1.getPrice ( ) > meat1.getPrice ( )& flour1.getWeight () !=0) {
                            if (flour1.getPrice ( ) > textile1.getPrice ( )) {
                                System.out.println ("Разбойники забрали всю краску");
                                flour1.setWeight (0.0);
                            }

                        } else if (meat1.getPrice ( ) > textile1.getPrice ( )& meat1.getWeight ()!=0) {
                            System.out.println ("Разбойники забрали все мясо");
                            meat1.setWeight (0.0);
                        } else if (textile1.getWeight ()!=0){
                            System.out.println ("Разбойники забрали всю ткань");
                            textile1.setWeight (0.0);}
                        else {
                        if(corn1.getWeight ()!=0){
                            System.out.println ("Разбойники забирают последнее зерно" );
                            corn1.setWeight (0.0);
                        }else if (meat1.getWeight ()!=0){
                            System.out.println ("Разбойники забирают последнее мясо" );
                            corn1.setWeight (0.0);
                        }else if(flour1.getWeight ()!=0){
                            System.out.println ("Разбойники забирают последнюю краску" );
                            flour1.setWeight (0.0);
                        }else if(fabricks1.getWeight ()!=0){
                            System.out.println ("Разбойники забирают последнюю муку" );
                            fabricks1.setWeight (0.0);
                        }else if(driedFructs1.getWeight ()!=0){
                            System.out.println ("Разбойники забирают все сухофрукты" );
                            driedFructs1.setWeight (0.0);
                        }
                        else {

                            System.out.println ("Больше нечего забирать и разбойники забирают телегу" );
                        }

                        }
                    } else {
                        System.out.println ("Разбойник забирает все оставшиеся деньги");
                        torgovec.setMoney (0.0);
                    }
                } else {
                    System.out.println ("Разбойники забирают лучший товар");
                    if (corn1.getPrice ( ) > driedFructs1.getPrice ( ) && corn1.getWeight ( ) != 0) {
                        if (corn1.getPrice ( ) > fabricks1.getPrice ( )) {
                            if (corn1.getPrice ( ) > flour1.getPrice ( )) {
                                if (corn1.getPrice ( ) > meat1.getPrice ( )) {
                                    if (corn1.getPrice ( ) > textile1.getPrice ( )) {

                                        System.out.println ("Разбойники забрали все зерно");
                                        corn1.setWeight (0.0);
                                        System.out.println (corn1.getWeight ( ));
                                    }
                                }
                            }
                        }
                    } else if (driedFructs1.getPrice ( ) > fabricks1.getPrice ( ) & driedFructs1.getWeight ( ) != 0) {
                        if (driedFructs1.getPrice ( ) > flour1.getPrice ( )) {
                            if (driedFructs1.getPrice ( ) > meat1.getPrice ( )) {
                                if (driedFructs1.getPrice ( ) > textile1.getPrice ( )) {
                                    System.out.println ("Разбойники забрали все сухофрукты");
                                    driedFructs1.setWeight (0.0);
                                    System.out.println (driedFructs1.getWeight ( ));
                                }
                            }
                        }
                    } else if (fabricks1.getPrice ( ) > flour1.getPrice ( ) & fabricks1.getWeight ( ) != 0) {
                        if (fabricks1.getPrice ( ) > meat1.getPrice ( )) {
                            if (fabricks1.getPrice ( ) > textile1.getPrice ( )) {
                                System.out.println ("Разбойники забрали всю ткань");
                                fabricks1.setWeight (0.0);
                            }
                        }
                    } else if (flour1.getPrice ( ) > meat1.getPrice ( ) & flour1.getWeight ( ) != 0) {
                        if (flour1.getPrice ( ) > textile1.getPrice ( )) {
                            System.out.println ("Разбойники забрали всю краску");
                            flour1.setWeight (0.0);
                        }

                    } else if (meat1.getPrice ( ) > textile1.getPrice ( ) & meat1.getWeight ( ) != 0) {
                        System.out.println ("Разбойники забрали все мясо");
                        meat1.setWeight (0.0);
                    } else if (textile1.getWeight ( ) != 0){

                            System.out.println ("Разбойники забрали всю ткань");
                            textile1.setWeight (0.0);}
                       else{
                            if (textile1.getWeight ( ) != 0) {
                                System.out.println ("Разбойники забрали всю ткань");
                                textile1.setWeight (0.0);
                            } else if (corn1.getWeight ( ) != 0) {
                                System.out.println ("Разбойники забирают последнее зерно");
                                corn1.setWeight (0.0);
                            } else if (meat1.getWeight ( ) != 0) {
                                System.out.println ("Разбойники забирают последнее мясо");
                                corn1.setWeight (0.0);
                            } else if (flour1.getWeight ( ) != 0) {
                                System.out.println ("Разбойники забирают последнюю краску");
                                flour1.setWeight (0.0);
                            } else if (fabricks1.getWeight ( ) != 0) {
                                System.out.println ("Разбойники забирают последнюю муку");
                                fabricks1.setWeight (0.0);
                            } else if (driedFructs1.getWeight ( ) != 0) {
                                System.out.println ("Разбойники забирают все сухофрукты");
                                driedFructs1.setWeight (0.0);
                            }
                        }

                }
                } else if (state.getStateChange ( ) == 7) {
                System.out.println ("Довольно приличный трактир, где можно отдохнуть а может даже и совершить выгодную сделку");
                System.out.println ("Ночлег здесь стоит 50 золотых включая, знатный ужин");
                if (torgovec.getMoney ( ) < 50) {
                    System.out.println ("Мы не можем позволить себе такую роскошь ((");
                } else {
                    torgovec.setMoney (torgovec.getMoney ( ) - 50);
                    int sellBay = (int) (1 + Math.random ( ) * 2);
//                int sellBay = 2;


                    if (sellBay == 1) {
                        if (ves == (torgovec.getGruzCarrying ( ))) {
                            System.out.println ("Поступило выгодное предложение. Но некуда грузить, телега перегружена. В другой раз......");
                        } else if (torgovec.getMoney ( ) < 200) {
                            System.out.println ("Поступило выгодное предложение. Но осталось мало денег. В другой раз....");
                        } else {
                            System.out.println ("Поступило выгодное предложение. Торговец решил закупить товар");


                            int kilogram = changeTovar ( );


                            if (kilogram == 0) {
                                System.out.println ("Покупаем зерно.");
                                double kolichestvoBay = torgovec.getGruzCarrying ( ) - ves;
                                double kolichestvoZolota = kolichestvoBay * corn1.getPrice ( );
                                if (kolichestvoZolota > torgovec.getMoney ( )) {
                                    System.out.println ("Денег осталось мало, потому мы закупим товар на оставшуюся сумму");
                                    double tovarZaOstatok = torgovec.getMoney ( ) / corn1.getPrice ( );
                                    double kolichestvoZolota1 = tovarZaOstatok * corn1.getPrice ( );
                                    System.out.println ("Зерна куплено " + tovarZaOstatok + " на cумму " + kolichestvoZolota1 + " золотых");
                                    torgovec.setMoney (torgovec.getMoney ( ) - kolichestvoZolota1);
                                    corn1.setWeight (tovarZaOstatok + corn1.getWeight ( ));
                                    System.out.println ("Золота осталось " + torgovec.getMoney ( ) + " золотых. Количество зерна стало " + corn1.getWeight ( ) + " килограмм");
                                } else {

                                    System.out.println ("Зерна куплено " + kolichestvoBay + " на cумму " + kolichestvoZolota + " золотых");

                                    torgovec.setMoney (torgovec.getMoney ( ) - kolichestvoZolota);
                                    corn1.setWeight (kolichestvoBay + corn1.getWeight ( ));
                                    System.out.println ("Золота осталось " + torgovec.getMoney ( ) + " золотых. Количество зерна стало " + corn1.getWeight ( ) + " килограмм");
                                }
                            } else if (kilogram == 1) {
                                System.out.println ("покупаем сухофрукты.");
                                double kolichestvoBay = torgovec.getGruzCarrying ( ) - ves;
                                double kolichestvoZolota = kolichestvoBay * driedFructs1.getPrice ( );

                                if (kolichestvoZolota > torgovec.getMoney ( )) {
                                    System.out.println ("Денег осталось мало, потому мы закупим товар на оставшуюся сумму");
                                    double tovarZaOstatok = torgovec.getMoney ( ) / driedFructs1.getPrice ( );
                                    double kolichestvoZolota1 = tovarZaOstatok * driedFructs1.getPrice ( );
                                    System.out.println ("Сухофруктов куплено " + tovarZaOstatok + " на cумму " + kolichestvoZolota1 + " золотых");
                                    torgovec.setMoney (torgovec.getMoney ( ) - kolichestvoZolota1);
                                    driedFructs1.setWeight (tovarZaOstatok + driedFructs1.getWeight ( ));
                                    System.out.println ("Золота осталось " + torgovec.getMoney ( ) + " золотых. Количество сухофруктов стало " + driedFructs1.getWeight ( ) + " килограмм");
                                } else {
                                    System.out.println ("Сухофруктов куплено " + kolichestvoBay + " на cумму " + kolichestvoZolota + " золотых");

                                    torgovec.setMoney (torgovec.getMoney ( ) - kolichestvoZolota);
                                    driedFructs1.setWeight (kolichestvoBay + driedFructs1.getWeight ( ));
                                    System.out.println ("Золота осталось " + torgovec.getMoney ( ) + " золотых. Количество сухофруктов стало " + driedFructs1.getWeight ( ) + " килограмм");
                                }
                            } else if (kilogram == 2) {
                                System.out.println ("Покупаем муку.");
                                double kolichestvoBay = torgovec.getGruzCarrying ( ) - ves;
                                double kolichestvoZolota = kolichestvoBay * fabricks1.getPrice ( );
                                if (kolichestvoZolota > torgovec.getMoney ( )) {
                                    System.out.println ("Денег осталось мало, потому мы закупим товар на оставшуюся сумму");
                                    double tovarZaOstatok = torgovec.getMoney ( ) / fabricks1.getPrice ( );
                                    double kolichestvoZolota1 = tovarZaOstatok * fabricks1.getPrice ( );
                                    System.out.println ("Муки куплено " + tovarZaOstatok + " на cумму " + kolichestvoZolota1 + " золотых");
                                    torgovec.setMoney (torgovec.getMoney ( ) - kolichestvoZolota1);
                                    fabricks1.setWeight (tovarZaOstatok + fabricks1.getWeight ( ));
                                    System.out.println ("Золота осталось " + torgovec.getMoney ( ) + " золотых. Количество муки стало " + fabricks1.getWeight ( ) + " килограмм");
                                } else {
                                    System.out.println ("Муки куплено " + kolichestvoBay + " на cумму " + kolichestvoZolota + " золотых");

                                    torgovec.setMoney (torgovec.getMoney ( ) - kolichestvoZolota);
                                    fabricks1.setWeight (kolichestvoBay + fabricks1.getWeight ( ));
                                    System.out.println ("Золота осталось " + torgovec.getMoney ( ) + " золотых. Количество муки стало " + fabricks1.getWeight ( ) + " килограмм");
                                }
                            } else if (kilogram == 3) {
                                System.out.println ("Покупаем краску.");

                                double kolichestvoBay = torgovec.getGruzCarrying ( ) - ves;
                                double kolichestvoZolota = kolichestvoBay * flour1.getPrice ( );
                                if (kolichestvoZolota > torgovec.getMoney ( )) {
                                    System.out.println ("Денег осталось мало, потому мы закупим товар на оставшуюся сумму");
                                    double tovarZaOstatok = torgovec.getMoney ( ) / flour1.getPrice ( );
                                    double kolichestvoZolota1 = tovarZaOstatok * flour1.getPrice ( );
                                    System.out.println ("Краску куплено " + tovarZaOstatok + " на cумму " + kolichestvoZolota1 + " золотых");
                                    torgovec.setMoney (torgovec.getMoney ( ) - kolichestvoZolota1);
                                    flour1.setWeight (tovarZaOstatok + flour1.getWeight ( ));
                                    System.out.println ("Золота осталось " + torgovec.getMoney ( ) + " золотых. Количество краски стало " + flour1.getWeight ( ) + " килограмм");
                                } else {
                                    System.out.println ("Краски куплено " + kolichestvoBay + " на cумму " + kolichestvoZolota + " золотых");

                                    torgovec.setMoney (torgovec.getMoney ( ) - kolichestvoZolota);
                                    flour1.setWeight (kolichestvoBay + flour1.getWeight ( ));
                                    System.out.println ("Золота осталось " + torgovec.getMoney ( ) + " золотых. Количество краски стало " + flour1.getWeight ( ) + " килограмм");
                                }
                            } else if (kilogram == 4) {
                                System.out.println ("Покупаем мясо.");

                                double kolichestvoBay = torgovec.getGruzCarrying ( ) - ves;
                                double kolichestvoZolota = kolichestvoBay * meat1.getPrice ( );
                                if (kolichestvoZolota > torgovec.getMoney ( )) {
                                    System.out.println ("Денег осталось мало, потому мы закупим товар на оставшуюся сумму");
                                    double tovarZaOstatok = torgovec.getMoney ( ) / meat1.getPrice ( );
                                    double kolichestvoZolota1 = tovarZaOstatok * meat1.getPrice ( );
                                    System.out.println ("Мяса куплено " + tovarZaOstatok + " на cумму " + kolichestvoZolota1 + " золотых");
                                    torgovec.setMoney (torgovec.getMoney ( ) - kolichestvoZolota1);
                                    meat1.setWeight (tovarZaOstatok + meat1.getWeight ( ));
                                    System.out.println ("Золота осталось " + torgovec.getMoney ( ) + " золотых. Количество мяса стало " + meat1.getWeight ( ) + " килограмм");
                                } else {
                                    System.out.println ("Мяса куплено " + kolichestvoBay + " на cумму " + kolichestvoZolota + " золотых");

                                    torgovec.setMoney (torgovec.getMoney ( ) - kolichestvoZolota);
                                    meat1.setWeight (kolichestvoBay + meat1.getWeight ( ));
                                    System.out.println ("Золота осталось " + torgovec.getMoney ( ) + " золотых. Количество мяса стало " + meat1.getWeight ( ) + " килограмм");
                                }

                            } else {
                                System.out.println ("Покупаем ткань.");

                                double kolichestvoBay = torgovec.getGruzCarrying ( ) - ves;
                                double kolichestvoZolota = kolichestvoBay * textile1.getPrice ( );
                                if (kolichestvoZolota > torgovec.getMoney ( )) {
                                    System.out.println ("Денег осталось мало, потому мы закупим товар на оставшуюся сумму");
                                    double tovarZaOstatok = torgovec.getMoney ( ) / textile1.getPrice ( );
                                    double kolichestvoZolota1 = tovarZaOstatok * textile1.getPrice ( );
                                    System.out.println ("ткани куплено " + tovarZaOstatok + " на cумму " + kolichestvoZolota1 + " золотых");
                                    torgovec.setMoney (torgovec.getMoney ( ) - kolichestvoZolota1);
                                    meat1.setWeight (tovarZaOstatok + textile1.getWeight ( ));
                                    System.out.println ("Золота осталось " + torgovec.getMoney ( ) + " золотых. Количество ткани стало " + textile1.getWeight ( ) + " килограмм");
                                } else {
                                    System.out.println ("тканей куплено " + kolichestvoBay + " на cумму " + kolichestvoZolota + " золотых");

                                    torgovec.setMoney (torgovec.getMoney ( ) - kolichestvoZolota);
                                    textile1.setWeight (kolichestvoBay + textile1.getWeight ( ));
                                    System.out.println ("Золота осталось " + torgovec.getMoney ( ) + " золотых. Количество ткани стало " + textile1.getWeight ( ) + " килограмм");
                                }


                            }


                        }
                    }

                    if (sellBay == 2) {
                        System.out.println ("Поступило выгодное предложение. Торговец решил продать часть товара");

                        int kilogram = changeTovar ( );


                        if (kilogram == 0) {
                            if (corn1.getWeight ( ) == 0) {
                                System.out.println ("Они просят товар которого у торговца нет. Так торговля не получится");
                            } else {
                                System.out.println ("Продаем зерно.");
                                double summaViruchki = corn1.getPrice ( ) * corn1.getWeight ( ) * corn1.getCoef ( );
                                System.out.println ("Зерна продано " + corn1.getWeight ( ) + " килограмов на cумму " + summaViruchki + " золотых");
                                torgovec.setMoney (torgovec.getMoney ( ) + summaViruchki);
                                corn1.setWeight (0);
                                ves = corn1.getWeight ( ) + meat1.getWeight ( ) + fabricks1.getWeight ( ) + driedFructs1.getWeight ( ) + flour1.getWeight ( ) + textile1.getWeight ( );
                            }
                        } else if (kilogram == 1) {
                            if (driedFructs1.getWeight ( ) == 0) {
                                System.out.println ("Они просят товар которого у торговца нет. Так торговля не получится");
                            } else {
                                System.out.println ("Продаем сухофрукты.");
                                double summaViruchki = driedFructs1.getPrice ( ) * driedFructs1.getWeight ( ) * driedFructs1.getCoef ( );
                                System.out.println ("Сухофруктов продано " + driedFructs1.getWeight ( ) + " килограмов на cумму " + summaViruchki + " золотых");
                                torgovec.setMoney (torgovec.getMoney ( ) + summaViruchki);
                                driedFructs1.setWeight (0);
                            }
                        } else if (kilogram == 2) {
                            if (fabricks1.getWeight ( ) == 0) {
                                System.out.println ("Они просят товар которого у торговца нет. Так торговля не получится");
                            } else {
                                System.out.println ("Продаем муку.");
                                Double summaViruchki = fabricks1.getPrice ( ) * fabricks1.getWeight ( ) * fabricks1.getCoef ( );
                                System.out.println ("Муки продано " + fabricks1.getWeight ( ) + " килограмов на cумму " + summaViruchki + " золотых");
                                torgovec.setMoney (torgovec.getMoney ( ) + summaViruchki);
                                fabricks1.setWeight (0);
                            }
                        } else if (kilogram == 3) {
                            if (flour1.getWeight ( ) == 0) {
                                System.out.println ("Они просят товар которого у торговца нет. Так торговля не получится");
                            } else {
                                System.out.println ("Продаем краску.");
                                double summaViruchki = flour1.getPrice ( ) * flour1.getWeight ( ) * flour1.getCoef ( );
                                System.out.println ("Краски продано " + flour1.getWeight ( ) + " килограмов на cумму " + summaViruchki + " золотых");
                                torgovec.setMoney (torgovec.getMoney ( ) + summaViruchki);
                                flour1.setWeight (0);
                            }
                        } else if (kilogram == 4) {
                            if (meat1.getWeight ( ) == 0) {
                                System.out.println ("Они просят товар которого у торговца нет. Так торговля не получится");
                            } else {
                                System.out.println ("Продаем мясо.");
                                double summaViruchki = meat1.getPrice ( ) * meat1.getWeight ( ) * meat1.getCoef ( );
                                System.out.println ("Мяса продано " + meat1.getWeight ( ) + " килограмов на cумму " + summaViruchki + " золотых");
                                torgovec.setMoney (torgovec.getMoney ( ) + summaViruchki);
                                meat1.setWeight (0);
                            }
                        } else {
                            if (textile1.getWeight ( ) == 0) {
                                System.out.println ("Они просят товар которого у торговца нет. Так торговля не получится");
                            } else {
                                System.out.println ("Продаем ткань.");
                                double summaViruchki = textile1.getPrice ( ) * textile1.getWeight ( ) * textile1.getCoef ( );
                                System.out.println ("тканей продано " + textile1.getWeight ( ) + " килограмов на cумму " + summaViruchki + " золотых");
                                torgovec.setMoney (torgovec.getMoney ( ) + summaViruchki);
                                textile1.setWeight (0);
                            }
                        }

                    }
                    ves = corn1.getWeight ( ) + meat1.getWeight ( ) + fabricks1.getWeight ( ) + driedFructs1.getWeight ( ) + flour1.getWeight ( ) + textile1.getWeight ( );
                    System.out.println ("Оставшееся количество золота " + torgovec.getMoney ( ));
                    System.out.println ("В телеге осталось " + ves + " килограммов груза");
                }
            } else {
                System.out.println ("Испортился один из товаров ");
                int changeBadProduct = changeTovar ( );

                if (changeBadProduct == 0) {
                    if (corn1.getWeight ( ) == 0) {
                        System.out.println ("На то место где лежал товар попала вода, но портится уже нечему");
                    } else {
                        int indexU = indexOf (corn1.getCoef ( ), coef1) + 1;
                        corn1.setCoef (coef1[indexU]);
                        System.out.println ("Зерно намокло " + corn1.getCoef ( ));
                        if (indexU == 4) {
                            System.out.println ("Товар полностью испортился, пришлось его выкинуть");
                            corn1.setWeight (0);
                        }
                    }
                } else if (changeBadProduct == 1) {
                    if (corn1.getWeight ( ) == 0) {
                        System.out.println ("На то место где лежал товар попала вода, но портится уже нечему");
                    } else {
                        int indexU = indexOf (driedFructs1.getCoef ( ), coef1) + 1;
                        driedFructs1.setCoef (coef1[indexU]);
                        System.out.println ("Сухофрукты намокли " + driedFructs1.getCoef ( ));
                        if (indexU == 4) {
                            System.out.println ("Товар полностью испортился, пришлось его выкинуть");
                            driedFructs1.setWeight (0);
                        }
                    }
                } else if (changeBadProduct == 2) {
                    if (corn1.getWeight ( ) == 0) {
                        System.out.println ("На то место где лежал товар попала вода, но портится уже нечему");
                    } else {
                        int indexU = indexOf (fabricks1.getCoef ( ), coef1) + 1;
                        fabricks1.setCoef (coef1[indexU]);
                        System.out.println ("Ткани намокли " + fabricks1.getCoef ( ));
                        if (indexU == 4) {
                            System.out.println ("Товар полностью испортился, пришлось его выкинуть");
                            fabricks1.setWeight (0);
                        }
                    }
                } else if (changeBadProduct == 3) {
                    if (corn1.getWeight ( ) == 0) {
                        System.out.println ("На то место где лежал товар попала вода, но портится уже нечему");
                    } else {
                        int indexU = indexOf (flour1.getCoef ( ), coef1) + 1;
                        flour1.setCoef (coef1[indexU]);
                        System.out.println ("Краска намокла " + flour1.getCoef ( ));
                        if (indexU == 4) {
                            System.out.println ("Товар полностью испортился, пришлось его выкинуть");
                            flour1.setWeight (0);
                        }
                    }
                } else if (changeBadProduct == 4) {
                    if (corn1.getWeight ( ) == 0) {
                        System.out.println ("На то место где лежал товар попала вода, но портится уже нечему");
                    } else {
                        int indexU = indexOf (textile1.getCoef ( ), coef1) + 1;
                        textile1.setCoef (coef1[indexU]);
                        System.out.println ("Ткани намокли " + textile1.getCoef ( ));
                        if (indexU == 4) {
                            System.out.println ("Товар полностью испортился, пришлось его выкинуть");
                            textile1.setWeight (0);
                        }
                    }
                } else {
                    if (corn1.getWeight ( ) == 0) {
                        System.out.println ("На то место где лежал товар попала вода, но портится уже нечему");
                    } else {
                        int indexU = indexOf (meat1.getCoef ( ), coef1) + 1;
                        meat1.setCoef (coef1[indexU]);
                        System.out.println ("Мясо намокло " + meat1.getCoef ( ));
                        if (indexU == 4) {
                            System.out.println ("Товар полностью испортился, пришлось его выкинуть");
                            meat1.setWeight (0);
                        }
                    }
                }
            }


        }
    }


    private static int changeTovar() {
        Random random = new Random ( );
        String[] stella = {"Corn", "DriedFructs", "Fabricks", "Flour", "Meat", "Textile"};
        int kilogram = random.nextInt (stella.length);
        return kilogram;

    }

    private static int indexOf(double c, Double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == c) {
                return i;
            }
        }
        return -1;
    }


}










