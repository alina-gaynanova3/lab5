package itmo.organization.comparators;

import itmo.organization.Organization;

import java.util.Comparator;

public class OrganizationNameComparator implements Comparator<Organization> {
    @Override
    public int compare(Organization o1, Organization o2) {
        if (o1 == o2)
            return 0;
        if (o1 == null)
            return -1;
        return o1.compareTo(o2);
    }
}
