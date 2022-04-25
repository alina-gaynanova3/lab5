package itmo.organization;

import com.fasterxml.jackson.annotation.JsonFormat;
import itmo.utils.WrongInputException;

import java.time.ZonedDateTime;

/**
 * класс для Организации
 */
public class Organization implements Comparable<Organization> {
    /**
     * айди
     */
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    /**
     * имя
     */
    private String name; //Поле не может быть null, Строка не может быть пустой
    /**
     * координаты
     */
    private Coordinates coordinates; //Поле не может быть null
    /**
     * дата создания
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSSZ")
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    /**
     * ежегодный оборот
     */
    private int annualTurnover; //Значение поля должно быть больше 0
    /**
     * полное имя
     */
    private String fullName; //Длина строки не должна быть больше 1370, Поле не может быть null
    /**
     * тип
     */
    private OrganizationType type; //Поле может быть null
    /**
     * пост адрес
     */
    private Address postalAddress; //Поле не может быть null

    /**
     * стандартный конструктор
     */
    public Organization() {
    }

    /**
     * @param id айди
     */
    public void setId(int id) throws WrongInputException {
        if (id <= 0)
            throw new WrongInputException("Id должно быть больше нуля");

        this.id = id;
    }

    /**
     * @param name имя
     * @throws WrongInputException
     */
    public void setName(String name) throws WrongInputException {
        if (name == null || name.equals(""))
            throw new WrongInputException("Name должно быть не пустым!!!");

        this.name = name;
    }

    /**
     * @param coordinates координаты
     * @throws WrongInputException
     */
    public void setCoordinates(Coordinates coordinates) throws WrongInputException {
        if (coordinates == null)
            throw new WrongInputException("Поле не должно быть null");

        this.coordinates = coordinates;
    }

    /**
     * @param creationDate дата создания
     * @throws WrongInputException
     */
    public void setCreationDate(ZonedDateTime creationDate) throws WrongInputException {
        if (creationDate == null)
            throw new WrongInputException("Поле не должно быть null");

        this.creationDate = creationDate;
    }

    /**
     * @param annualTurnover ежегодный оборот
     * @throws WrongInputException
     */
    public void setAnnualTurnover(int annualTurnover) throws WrongInputException {
        if (annualTurnover <= 0)
            throw new WrongInputException("Значение поля должно быть больше 0");

        this.annualTurnover = annualTurnover;
    }

    /**
     * @param fullName полное имя
     * @throws WrongInputException
     */
    public void setFullName(String fullName) throws WrongInputException {
        if (fullName == null || fullName.length() > 1370)
            throw new WrongInputException("Длина строки не должна быть больше 1370, Поле не должно быть null");

        this.fullName = fullName;
    }

    /**
     * @param type тип
     */
    public void setType(OrganizationType type) {

        this.type = type;
    }

    /**
     * @param postalAddress почтовый адрес
     * @throws WrongInputException
     */
    public void setPostalAddress(Address postalAddress) throws WrongInputException {
        if (postalAddress == null)
            throw new WrongInputException("Поле не должно быть null");

        this.postalAddress = postalAddress;
    }

    /**
     * @return взять айди
     */
    public int getId() {
        return id;
    }

    /**
     * @return взять почтовый адрес
     */
    public Address getPostalAddress() {
        return postalAddress;
    }

    /**
     * @return взять имя
     */
    public String getName() {
        return name;
    }

    /**
     * @return взять координаты
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * @return взять дату создания
     */
    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * @return взять ежегодный оборот
     */
    public int getAnnualTurnover() {
        return annualTurnover;
    }

    /**
     * @return взять полное имя
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @return взять тип
     */
    public OrganizationType getType() {
        return type;
    }

    /**
     * @param o сравнение
     * @return
     */
    @Override
    public int compareTo(Organization o) {
        if (o == null)
            return 1;
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Organization: " +
                "\nid: " + id +
                "\nname: " + name +
                "\ncoordinates: " + coordinates +
                "\ncreationDate: " + creationDate +
                "\nannualTurnover: " + annualTurnover +
                "\nfullName: " + fullName +
                "\ntype: " + type +
                "\npostalAddress: " + postalAddress;
    }
}