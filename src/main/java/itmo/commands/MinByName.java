package itmo.commands;

import itmo.collection.MyHashSet;
import itmo.organization.Organization;
import itmo.organization.comparators.OrganizationNameComparator;
import itmo.utils.FormatCommandOutput;

import java.util.Optional;

/**
 * класс, выполняющий команду Min_by_name
 */
public class MinByName implements UserCommand {

    private final MyHashSet<Organization> myHashSet;

    /**
     * @param myHashSet коллекция
     */
    public MinByName(MyHashSet<Organization> myHashSet) {
        this.myHashSet = myHashSet;
    }

    /**
     * выполнение
     */
    @Override
    public void execute() {
        System.out.println(new FormatCommandOutput(50, this));
        Optional<Organization> min = myHashSet.stream().min(new OrganizationNameComparator());
        if (!min.isPresent()) {
            System.out.println("Ойой, ничего не павучивось 👉👈");
            return;
        }
        System.out.println(min.get());
    }
}
