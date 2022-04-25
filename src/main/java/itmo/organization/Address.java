package itmo.organization;

import itmo.utils.WrongInputException;

/**
 * класс для адреса
 */
public class Address {
    private String street; //Строка не может быть пустой, Поле не может быть null
    private String zipCode; //Длина строки не должна быть больше 14, Поле может быть null
    private Location town; //Поле может быть null


    /**
     * @param street улица
     * @param zipCode почтовый индекс
     * @param town город
     * @throws WrongInputException
     */
    public Address(String street, String zipCode, Location town) throws WrongInputException {
        this.setStreet(street);
        this.setTown(town);
        this.setZipCode(zipCode);
    }

    /**
     * @return взять улицу
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street улица
     * @throws WrongInputException
     */
    public void setStreet(String street) throws WrongInputException {
        if (street == null || street.equals(""))
            throw new WrongInputException("Поле не должно быть равно null, строка не должна быть пустой");

        this.street = street;
    }

    /**
     * @return взять почтовый индекс
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode почтовый индекс
     * @throws WrongInputException
     */
    public void setZipCode(String zipCode) throws WrongInputException {
        if (zipCode == null || zipCode.length() > 14)
            throw new WrongInputException("Поле не должно быть равно null, длина строки не должна превосходить 14");

        this.zipCode = zipCode;
    }

    /**
     * @return взять город
     */
    public Location getTown() {
        return town;
    }

    /**
     * @param town город
     */
    public void setTown(Location town) {
        this.town = town;
    }
}
