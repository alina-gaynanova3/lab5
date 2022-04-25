package itmo.organization;

import itmo.utils.WrongInputException;

/**
 * класс для Локации
 */
public class Location {
    private double x;
    private Double y; //Поле не может быть null
    private Integer z; //Поле не может быть null

    public Location() {
    }

    /**
     * @param x икс
     * @param y v
     * @param z за (своих 🇷🇺)
     * @throws WrongInputException эксепшн
     */
    public Location(double x, Double y, Integer z) throws WrongInputException {
        this.setX(x);
        this.setY(y);
        this.setZ(z);
    }

    /**
     * @return взять икс
     */
    public double getX() {
        return x;
    }

    /**
     * @param x икс
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return взять игрик
     */
    public Double getY() {
        return y;
    }

    /**
     * @param y игрик
     * @throws WrongInputException
     */
    public void setY(Double y) throws WrongInputException {
        if (y == null)
            throw new WrongInputException("Поле не должно быть null");

        this.y = y;
    }

    /**
     * @return взять зэт
     */
    public Integer getZ() {
        return z;
    }

    /**
     * @param z зэт
     * @throws WrongInputException
     */
    public void setZ(Integer z) throws WrongInputException {
        if (z == null)
            throw new WrongInputException("Поле не должно быть null");

        this.z = z;
    }

    @Override
    public String toString() {
        return "(" + x + "; " + y + "; " + z + ")";
    }
}