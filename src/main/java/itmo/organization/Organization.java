package itmo.organization;

import com.fasterxml.jackson.annotation.JsonFormat;
import itmo.utils.WrongInputException;

import java.time.ZonedDateTime;

public class Organization implements Comparable<Organization> {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSSZ")
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int annualTurnover; //Значение поля должно быть больше 0
    private String fullName; //Длина строки не должна быть больше 1370, Поле не может быть null
    private OrganizationType type; //Поле может быть null
    private Address postalAddress; //Поле не может быть null

    public Organization(){}
    public Organization(String name, Coordinates coordinates, int annualTurnover, String fullName, OrganizationType organizationType, Address address) throws WrongInputException {
        this.setId(id);
        this.setName(name);

    }

    public void setId(int id) throws WrongInputException {
        if (id <= 0)
            throw new WrongInputException("Id должно быть больше нуля");

        this.id = id;
    }

    public void setName(String name) throws WrongInputException {
        if (name == null || name.equals(""))
            throw new WrongInputException("Name должно быть не пустым!!!");

        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) throws WrongInputException {
        if (coordinates == null)
            throw new WrongInputException("Поле не должно быть null");

        this.coordinates = coordinates;
    }

    public void setCreationDate(ZonedDateTime creationDate) throws WrongInputException {
        if (creationDate == null)
            throw new WrongInputException("Поле не должно быть null");

        this.creationDate = creationDate;
    }

    public void setAnnualTurnover(int annualTurnover) throws WrongInputException {
        if (annualTurnover <= 0)
            throw new WrongInputException("Значение поля должно быть больше 0");

        this.annualTurnover = annualTurnover;
    }

    public void setFullName(String fullName) throws WrongInputException {
        if (fullName == null || fullName.length() > 1370)
            throw new WrongInputException("Длина строки не должна быть больше 1370, Поле не должно быть null");

        this.fullName = fullName;
    }

    public void setType(OrganizationType type) {

        this.type = type;
    }

    public void setPostalAddress(Address postalAddress) throws WrongInputException {
        if (postalAddress == null)
            throw new WrongInputException("Поле не должно быть null");

        this.postalAddress = postalAddress;
    }

    public int getId() {
        return id;
    }

    public Address getPostalAddress() {
        return postalAddress;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public int getAnnualTurnover() {
        return annualTurnover;
    }

    public String getFullName() {
        return fullName;
    }

    public OrganizationType getType() {
        return type;
    }

    @Override
    public int compareTo(Organization o) {
        if (o == null)
            return 1;
        return this.name.compareTo(o.name);
    }
}