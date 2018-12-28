package Lesson4;

import java.util.Random;

public class AnimalTest {
    private static Random random = new Random();

    public static void main(String[] args) {

        /*Разные виды кошек*/
        cCat[] catArray = new cCat[3];
        catArray[0] = new cCat(); // простая кошка без фантазии
        catArray[1] = new cCat("Lynx", 12000, 0, 4); // Рысь
        catArray[2] = new cCat("Panther", 35000, 0, 6); // Пантера
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
        cDog[] dogArray = new cDog[3];
        dogArray[0] = new cDog(); // простая собака без фантазии
        dogArray[1] = new cDog("Bernese mountain dog", 17000, 150, 2); // Дог
        dogArray[2] = new cDog("West Highland white terrier", 3000, 15, 0.5f); // Терьер
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
