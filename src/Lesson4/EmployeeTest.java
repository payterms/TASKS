package Lesson4;

public class EmployeeTest {
    public static void main(String[] args) {
/*
            4. Создать массив из 5 сотрудников:
        Пример:
        Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
        persArray[0] = new Person("Ivanov Ivan", "Engineer", " ivivan@mailbox.com ", "892312312", 30000,
        30); // потом для каждой ячейки массива задаем объект
        persArray[1] = new Person(...);
        ...
        persArray[4] = new Person(...);
        С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
    * */
        cEmployee[] employeeArray = new cEmployee[5];
        employeeArray[0] = new cEmployee( "George Washington", "President", "gw@somemail.com","+1123-456-7890", 100000, 229);
        employeeArray[1] = new cEmployee( "Mike Pence", "Vice President", "mp@somemail.com","+1123-456-7891", 50000, 59);
        employeeArray[2] = new cEmployee( "Mike Pompeo", "Secretary of State", "mpeo@somemail.com","+1123-456-7892", 51000, 55);
        employeeArray[3] = new cEmployee( "James Mattis", "Secretary of Defense", "jm@somemail.com","+1123-456-7893", 61000, 68);
        employeeArray[4] = new cEmployee( "Steven Mnuchin", "Secretary of the Treasury", "sm@somemail.com","+1123-456-7894", 61000, 68);

        for (int i=0; i<employeeArray.length;i++){
            if(employeeArray[i].Age >= 40){
                System.out.println("Employee info with index: " + i);
                employeeArray[i].dumpEmployeeInfo();
            }

        }
    }
}
