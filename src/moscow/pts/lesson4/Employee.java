package moscow.pts.lesson4;

/*
        1. Создать класс «Сотрудник» с полями: ФИО, должность, email, телефон, зарплата, возраст;
        */

public class Employee {
    String  fullName;   //ФИО
    String  position;   //должность
    String  email;      //email
    String  phoneNumber;   //телефон
    int     salary;     //зарплата
    int     Age;        //возраст
    /*2. Конструктор класса должен заполнять эти поля при создании объекта;*/
    public Employee(){ //Конструктор с пустыми значениями
        this.fullName = "";// Empty value
        this.position = "";// Empty value
        this.email = "";// Empty value
        this.phoneNumber = "";// Empty value
        this.salary = 0; // Empty value
        this.Age = 0;// Empty value
    }
    public Employee(String _fullName, String  _position, String  _email, String  _phoneNumber, int _salary, int _Age) { //Перегруженный конструктор с вариантами значений
        this.fullName = _fullName;        // Переданное значение переменной
        this.position = _position;        // Переданное значение переменной
        this.email = _email;             // Переданное значение переменной
        this.phoneNumber = _phoneNumber; // Переданное значение переменной
        this.salary = _salary;           // Переданное значение переменной
        this.Age = _Age;                 // Переданное значение переменной
    }
    public Employee(String _fullName, String  _position, String  _email, String  _phoneNumber) { //Перегруженный конструктор с вариантами значений
        this.fullName = _fullName;        // Переданное значение переменной
        this.position = _position;        // Переданное значение переменной
        this.email = _email;             // Переданное значение переменной
        this.phoneNumber = _phoneNumber; // Переданное значение переменной
        this.salary = 0;                 // Пустое значение переменной
        this.Age = 0;                    // Пустое значение переменной
    }
    public Employee(String _fullName, String  _phoneNumber, int _salary, int _Age) { //Перегруженный конструктор с вариантами значений
        this.fullName = _fullName;        // Переданное значение переменной
        this.position = "";              // Пустое значение переменной
        this.email = "";                 // Пустое значение переменной
        this.phoneNumber = _phoneNumber; // Переданное значение переменной
        this.salary = _salary;           // Переданное значение переменной
        this.Age = _Age;                 // Переданное значение переменной
    }
    public Employee(String _fullName, String  _position, String  _email) { //Перегруженный конструктор с вариантами значений
        this.fullName = _fullName;        // Переданное значение переменной
        this.position = _position;        // Переданное значение переменной
        this.email = _email;             // Переданное значение переменной
        this.phoneNumber = "";           // Переданное значение переменной
        this.salary = 0;           // Переданное значение переменной
        this.Age = 0;                 // Переданное значение переменной
    }
    /*3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;*/
    public void dumpEmployeeInfo() {
        System.out.println("Name: "+this.fullName+ "\n" +"Position: "+this.position+ "\n"+"E-mail: " + this.email+ "\n"+ "Phone number: " + this.phoneNumber + "\n"+ "Salary: "+ "$"+ this.salary+ "\n" + "Age: " + this.Age+ "\n");
        return;
    }
}
