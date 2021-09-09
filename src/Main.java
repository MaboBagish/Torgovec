import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void  main(String[] args) {
        System.out.println ("\nДобро пожаловать в игру путешествие торговца" );

        Torgovec torgovec = new Torgovec ();
        Random random = new Random (  );
        torgovec.setGruzCarrying ((int) (500+Math.random ()*1000));
        System.out.println ("\nГрузоподъемность телеги торговца  "  +torgovec.getGruzCarrying ()+  "  киллограмм." );
        torgovec.setMoney ((int) (5000+Math.random ()*10000));
        System.out.println ("\nКоличество денег  "+torgovec.getMoney ()+"  золотых монет." );
        torgovec.setSpeed ((int) (1+Math.random ()*4));
        System.out.println ("\nСкорость передвижения торговца = "+torgovec.getSpeed ()+"  лиг в день." );
        String[] town = {"Бишкек", "Астана", "Стамбул", "Москва", "Ташкент"};
        System.out.println ("\nЕсть пять торговых городов в которые может пойти торговец. Это  "+ Arrays.toString (town)+"  . Какой же выберет торговец ?" );

        int randomTown = random.nextInt ( town.length);
        System.out.println ("" );
        System.out.println ("Торговец выбрал город "+town[randomTown] );

        int randomDistance = (int) (50+Math.random ()*50);

        System.out.println ("\nДо города "+town[randomTown]+" "+randomDistance+" лиг пути." );

        double durationTravel = randomDistance/torgovec.getSpeed ();

        System.out.println ("\nЕсли судить по звдездам то путь продлится "+durationTravel+" дней и ночей." );






    }
public void bayTovar(Tovar tovar){

}

}
