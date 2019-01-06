package moscow.pts.lesson5;

import moscow.pts.lesson4.Cat;

/*
* 1. Класс кота из прошлого ДЗ расширить функционалом потребления пищи. У каждого кота есть аппетит, т.е. количество еды, которое он съедает за один раз;
2. Кот должен есть из миски. Создайте такую сущность, которая будет обладать объёмом и едой в ней, а также методами наполнения и получения информации о количестве еды;
3. Метод из первого пункта ДЗ должен взаимодействовать с миской, т.е., конкретный кот ест из конкретной миски, уменьшая объём еды в ней;
4. Предусмотрите проверку, при которой в миске не может получиться отрицательного количества еды (например, в миске 10 единиц еды, а кот пытается съесть 15);
5. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось поесть (хватило еды), сытость = true;
Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы);
6. Создать массив котов и одну тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль;
7. Когда еда в тарелке кончается, нужно оповещать об этом и наполнять её едой.
* */
public class HungryCat extends Cat {
    protected float maxEatAmount; // Аппетит - количество пищи в мл, необходимых чтобы наполнить ЖКТ кота
    protected boolean isSatiety;  // Признак сытости

    public HungryCat(String name, float maxRunDistance, float maxSwimDistance, float maxJumpDistance, float maxEatAmount) {
        super(name, maxRunDistance, maxSwimDistance, maxJumpDistance);// используем конструктор супер класса
        if (maxEatAmount > 0) {
            this.maxEatAmount = maxEatAmount; // вменяемый кот со здоровым аппетитом
        } else {
            this.maxEatAmount = 0; // коту зашили рот
        }
        this.isSatiety = false; //(когда создаем котов, они голодны)
    }

    public HungryCat(String name, float maxEatAmount) { //для целей тестирования поедания из тарелки
        super(name, 0, 0, 0);// используем конструктор супер класса
        if (maxEatAmount > 0) {
            this.maxEatAmount = maxEatAmount; // вменяемый кот со здоровым аппетитом
        } else {
            this.maxEatAmount = 0; // коту зашили рот
        }
        this.isSatiety = false; //(когда создаем котов, они голодны)
    }

    /*
     * dishWithFood - тарлека из которой будет трапезничать данный кот
     * return - поел ли кот из данной тарелки
     * */
    public boolean eat(Dish dishWithFood) {
        boolean res = false;
        if (this.isSatiety != true) {// кот голодный
            if ((dishWithFood.getFoodAmount() >= this.maxEatAmount)) {// Еды достаточно для кота - разрешаем ему поесть из данной миски
                dishWithFood.setFoodAmount(dishWithFood.getFoodAmount() - this.maxEatAmount);// после трапезы еды в миске становится меньше
                this.isSatiety = true; // кот становится сытым
                res = true;
            }
        }
        return res;
    }

}