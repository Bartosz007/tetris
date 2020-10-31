package helper;

import builder.TableBuilder;

import java.util.Comparator;

public class SortByScore implements Comparator<TableBuilder> {

    @Override
    public int compare(TableBuilder o1, TableBuilder o2) {
        return o2.getScore()-o1.getScore();
    }

}


