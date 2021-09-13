public class Tovar {



    private Double weight;
    private int amount;
    private double coef;
    private int price;


    public double getCoef() {
        return coef;
    }

    public void setCoef(Double coef) {
        this.coef = coef;
    }

    public Tovar() {
        this.weight = weight;
        this.amount = amount;
        this.coef = coef;
        this.price = price;
    }


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {

        return price;
    }

    public void setPrice() {
        price = ((int) (100 + Math.random ( ) * 200));
        this.price = price;


    }


}
