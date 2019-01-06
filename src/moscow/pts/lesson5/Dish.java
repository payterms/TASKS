package moscow.pts.lesson5;

public class Dish {
    //public int id; // идентификатор миски
    private float totalVolume; // максимальный объем миски в мл
    private float foodAmount;  // текущий объем пищи в миске в мл

    public Dish(){
        this.totalVolume = 0;
        this.foodAmount = 0;
    }
    public Dish(float totalVolume,float foodAmount){
        this.totalVolume = totalVolume;
        if(this.totalVolume >= foodAmount) { // проверяем, чтобы вместимость тарелки не превышала кол-во еды в ней
            this.foodAmount = foodAmount;
        }
        else{
            this.foodAmount = this.totalVolume; // больше чем объем миски поместить в нее нельзя
        }
    }

    public float getVolume() {
        return this.totalVolume;
    }

    public float getFoodAmount() {
        return this.foodAmount;
    }

    public void setFoodAmount(float foodAmount) {
        if ((foodAmount <= this.totalVolume)) { // проверяем, что объем пищи уместиться в миску
            if (foodAmount >= 0) {                // проверяем, что передано корректное значение количества пищи
                this.foodAmount = foodAmount;
            } else {
                this.foodAmount = 0;
                System.out.println("Количество пищи не может быть отрицательным");
            }
        } else {
            this.foodAmount = this.totalVolume;
            System.out.println("Количество пищи превышает объем миски!");
        }
        return;
    }


}
