package sbl.com.fragmentsexample.item.datamodels;

import java.util.ArrayList;

/**
 * Created by sandeep on 8/4/16.
 */
public class Category {

    public String name = "";
    public ArrayList<Item> items;
    public int resourseID;

    public Category( String name, int resourseID) {
        this.resourseID = resourseID;
        this.name = name;
    }

}
