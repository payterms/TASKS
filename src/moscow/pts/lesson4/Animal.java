package moscow.pts.lesson4;

/*5. Создать классы Собака и Кот с наследованием от класса Животное;
        6. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков);
        7. У каждого животного есть ограничения на действия (бег: кот – 200 м., собака – 500 м.; прыжок: кот – 2 м., собака – 0.5 м.; плавание: кот не умеет плавать, собака – 10 м.);
        8. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль. (Например, dog1.run(150); -> результат: run: true);
        9. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой – 600 м.*/

abstract class Animal {
    public String name;
    protected float maxRunDistance;
    protected float maxSwimDistance;
    protected float maxJumpDistance;

    public Animal() {
    }

    public Animal(String _name) {
        this.name = _name;
    }

    abstract boolean run(float _distance);

    abstract boolean swim(float _distance);

    abstract boolean jump(float _distance);
}



