public class Tovar {


    private Double weight;
    private int amount;
    Double[] coef1 = {1.2, 1.0, 0.95, 0.55, 0.25, 0.1};


    private Double coef;
    private int price;

    public Tovar(Double coef) {
        this.coef = coef;
    }

    public Double getCoef() {
        return coef;
    }

    public void setCoef(Double coef) {

        this.coef = coef;


    }



    public Tovar() {
        this.weight = weight;
        this.amount = amount;

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
