package itmo.organization;

import itmo.utils.WrongInputException;

public class Location {
    private double x;
    private Double y; //Поле не может быть null
    private Integer z; //Поле не может быть null

    public Location(){}

    public Location(double x, Double y, Integer z) throws WrongInputException {
        this.setX(x);
        this.setY(y);
        this.setZ(z);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) throws WrongInputException {
        if (y == null)
            throw new WrongInputException("Поле не должно быть null");

        this.y = y;
    }

    public Integer getZ() {
        return z;
    }

    public void setZ(Integer z) throws WrongInputException {
        if (z == null)
            throw new WrongInputException("Поле не должно быть null");

        this.z = z;
    }
}