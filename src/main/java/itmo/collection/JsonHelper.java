package itmo.collection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import itmo.organization.Organization;
import itmo.utils.WrongInputException;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * класс для json
 */
public class JsonHelper {
    private Organization[] organizations;
    private LocalDateTime creationTime;

    public JsonHelper() {
    }

    /**
     * @param myHashSet конструктор
     */
    public JsonHelper(MyHashSet<Organization> myHashSet) {
        organizations = new Organization[myHashSet.size()];
        int index = 0;
        for (Organization organization : myHashSet) {
            organizations[index++] = organization;
        }
        this.creationTime = myHashSet.getCreationDate();
    }

    public Organization[] getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Organization[] organizations) {
        this.organizations = organizations;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public void toJson(String filename) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); //делаем красиво все в одну строчку
        objectMapper.registerModule(new JavaTimeModule()); //чтобы время было в файле
        objectMapper.writeValue(new File(filename), this);
    }

    public static MyHashSet<Organization> toHashSet(String filename) throws Exception {
        if (!Files.exists(Paths.get(filename))){
            throw new WrongInputException("файла нет!");
        }
        if (!Files.isReadable(Paths.get(filename))) {
            throw new WrongInputException("невозможно прочитать файл");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); //делаем красиво
        objectMapper.registerModule(new JavaTimeModule()); //чтобы время было
        JsonHelper jsonHelper = objectMapper.readValue(new File(filename), JsonHelper.class);

        return jsonHelper.getHashSet();
    }

    private MyHashSet<Organization> getHashSet() {
        MyHashSet<Organization> myHashSet = new MyHashSet<>();
        myHashSet.addAll(Arrays.asList(organizations));
        myHashSet.setCreationDate(this.creationTime);

        return myHashSet;
    }
}
