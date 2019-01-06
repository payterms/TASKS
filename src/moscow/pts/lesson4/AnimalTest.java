package moscow.pts.lesson4;

import java.util.Random;

public class AnimalTest {
    private static Random random = new Random();

    public static void main(String[] args) {

        /*Разные виды кошек*/
        Cat[] catArray = new Cat[3];
        catArray[0] = new Cat(); // простая кошка без фантазии
        catArray[1] = new Cat("Lynx", 12000, 0, 4); // Рысь
        catArray[2] = new Cat("Panther", 35000, 0, 6); // Пантера
        for (int i=0;i<catArray.length;i++){
            int curDistance = random.nextInt(20);
            System.out.println("Current Distance: "+ curDistance);
            catArray[i].jump(curDistance);// попрыгаем
            curDistance = random.nextInt(50000);
            System.out.println("Current Distance: "+ curDistance);
            catArray[i].run(curDistance); // побегаем
            curDistance = random.nextInt(200);
            System.out.println("Current Distance: "+ curDistance);
            catArray[i].swim(curDistance);// поплаваем
        }

        /*Разные виды собак*/
        Dog[] dogArray = new Dog[3];
        dogArray[0] = new Dog(); // простая собака без фантазии
        dogArray[1] = new Dog("Bernese mountain Dog", 17000, 150, 2); // Дог
        dogArray[2] = new Dog("West Highland white terrier", 3000, 15, 0.5f); // Терьер
        for (int i=0;i<catArray.length;i++){
            int curDistance = random.nextInt(20);
            System.out.println("Current Distance: "+ curDistance);
            dogArray[i].jump(curDistance);// попрыгаем
            curDistance = random.nextInt(50000);
            System.out.println("Current Distance: "+ curDistance);
            dogArray[i].run(curDistance); // побегаем
            curDistance = random.nextInt(200);
            System.out.println("Current Distance: "+ curDistance);
            dogArray[i].swim(curDistance);// поплаваем
        }
    }
}
