package itmo.organization;

import itmo.utils.WrongInputException;

/**
 * класс, описывающий координаты
 */
public class Coordinates {
    private Double x; //Максимальное значение поля: 316, Поле не может быть null
    private float y;

    public Coordinates(){}

    /**
     * @param x икс
     * @param y игрик
     * @throws WrongInputException
     */
    public Coordinates(Double x, float y) throws WrongInputException {
        this.setX(x);
        this.setY(y);
    }

    /**
     * @param x икс
     * @throws WrongInputException
     */
    public void setX(Double x) throws WrongInputException {
        if (x == null || x > 316)
            throw new WrongInputException("Поле null или максимальное значение 316");

        this.x = x;
    }

    /**
     * @param y игрик
     * @throws WrongInputException
     */
    public void setY(float y) throws WrongInputException{
        this.y = y;
    }


    public Double getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + "; " + y + ")";
    }
}
