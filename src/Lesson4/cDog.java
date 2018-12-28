package Lesson4;
/*5. Создать классы Собака и Кот с наследованием от класса Животное;
        6. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков);
        7. У каждого животного есть ограничения на действия (бег: кот – 200 м., собака – 500 м.; прыжок: кот – 2 м., собака – 0.5 м.; плавание: кот не умеет плавать, собака – 10 м.);
        8. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль. (Например, dog1.run(150); -> результат: run: true);
        9. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой – 600 м.*/

public class cDog extends cAnimal{
    public cDog() {
        this.name = "DOG";
        this.maxRunDistance = 500.0f;
        this.maxSwimDistance = 10.0f;
        this.maxJumpDistance = 0.5f;
    }
    public cDog(String _name, float _maxRunDistance, float _maxSwimDistance, float _maxJumpDistance) {
        this.name = _name;
        this.maxRunDistance = _maxRunDistance;
        this.maxSwimDistance = _maxSwimDistance;
        this.maxJumpDistance = _maxJumpDistance;
    }
    public cDog(float _maxRunDistance, float _maxSwimDistance, float _maxJumpDistance) {
        this.name = "DOG";
        this.maxRunDistance = _maxRunDistance;
        this.maxSwimDistance = _maxSwimDistance;
        this.maxJumpDistance = _maxJumpDistance;
    }
    public boolean run(float _distance){
        boolean res = false;
        if (_distance <=this.maxRunDistance) res = true;
        System.out.println("I'm "+ this.name);
        System.out.println("run: "+ (res==true? "true":"false"));
        return res;
    }
    public boolean swim(float _distance){
        boolean res = false;
        if (_distance <=this.maxSwimDistance) res = true;
        System.out.println("I'm "+ this.name);
        System.out.println("swim: "+ (res==true? "true":"false"));
        return res;
    }
    public boolean jump(float _distance){
        boolean res = false;
        if (_distance <=this.maxJumpDistance) res = true;
        System.out.println("I'm "+ this.name);
        System.out.println("jump: "+ (res==true? "true":"false"));
        return res;
    }
}