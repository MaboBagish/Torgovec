public class Tovar {

    private int weight;

    private int amount;
    private double coefficient;
    private double price;

    public Tovar(int weight, int amount, double coefficient, double price) {
        this.weight = weight;
                this.amount = amount;
        this.coefficient = coefficient;
        this.price = price;
    }



    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }





    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
