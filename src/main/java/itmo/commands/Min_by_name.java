package itmo.commands;

import itmo.collection.MyHashSet;
import itmo.organization.Organization;
import itmo.organization.comparators.OrganizationNameComparator;
import itmo.utils.FormatCommandOutput;

import java.util.Optional;

public class Min_by_name implements UserCommand {

    private final MyHashSet<Organization> myHashSet;

    public Min_by_name(MyHashSet<Organization> myHashSet) {
        this.myHashSet = myHashSet;
    }

    @Override
    public void execute() {
        System.out.println(new FormatCommandOutput(50, this).toString());
        Optional<Organization> min = myHashSet.stream().min(new OrganizationNameComparator());
        if (!min.isPresent()) {
            System.out.println("Ойой, ничего не павучивось 👉👈");
            return;
        }
        System.out.println(min.get());
    }
}
