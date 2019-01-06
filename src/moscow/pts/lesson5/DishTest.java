package moscow.pts.lesson5;

import java.util.Random;

public class DishTest {
    private static Random random = new Random();

    public static void main(String[] args) {
        int dishParam;
        /*Разные виды кошек*/
        HungryCat[] catArray = new HungryCat[7];
        catArray[0] = new HungryCat("Барсик", 100);
        catArray[1] = new HungryCat("Мурзик", 70);
        catArray[2] = new HungryCat("Котэ", 120);
        catArray[3] = new HungryCat("Игнор", 200);
        catArray[4] = new HungryCat("Норрис", 1100);
        catArray[5] = new HungryCat("Кузьма", 120);
        catArray[6] = new HungryCat("Капитон", 220);

        dishParam = random.nextInt(2000);
        Dish commonDish = new Dish(dishParam, dishParam);
        System.out.println("В миске " + commonDish.getVolume() + " мл");

        for (int i = 0; i < catArray.length; i++) {// кормим котов по очереди
            if (commonDish.getFoodAmount() == 0) {
                System.out.println("В миске совсем не осталось еды - заполняем до краев - " + commonDish.getVolume() + " мл");
                commonDish.setFoodAmount(commonDish.getVolume()); // заполняем до краев
            }
            if (catArray[i].eat(commonDish) == true) {// кот поел
                System.out.println("Кот " + catArray[i].name + " съел " + catArray[i].maxEatAmount + " мл");
                System.out.println("В миске осталось " + commonDish.getFoodAmount());
            } else {
                System.out.println("Кот " + catArray[i].name + " не смог поесть");
                if (commonDish.getVolume() >= catArray[i].maxEatAmount) { // если объема миски достаточно, чтобы накормить кота, которому не хватило еды
                    System.out.println("В миске осталось мало еды - заполняем до краев " + commonDish.getVolume() + " мл");
                    commonDish.setFoodAmount(commonDish.getVolume()); // заполняем до краев
                    if (catArray[i].eat(commonDish) == true) {// кот начал орать и не отходит от миски ж-)) - кормим его повторно
                        System.out.println("Кот " + catArray[i].name + " очень настойчивый. Выпросил " + catArray[i].maxEatAmount + " мл");
                        System.out.println("В миске осталось " + commonDish.getFoodAmount());
                    }
                }
            }
            if (catArray[i].isSatiety) {
                System.out.println("Кот " + catArray[i].name + " сыт");
            } else {
                System.out.println("Кот " + catArray[i].name + " остался голодным");
            }


        }

    }
}
