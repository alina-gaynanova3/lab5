package itmo.organization;

import itmo.utils.WrongInputException;

public class Coordinates {
    private Double x; //Максимальное значение поля: 316, Поле не может быть null
    private float y;

    public Coordinates(){}
    public Coordinates(Double x, float y) throws WrongInputException {
        this.setX(x);
        this.setY(y);
    }

    public void setX(Double x) throws WrongInputException {
        if (x == null || x > 316)
            throw new WrongInputException("Поле null или максимальное значение 316");

        this.x = x;
    }

    public void setY(float y) throws WrongInputException{
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
