package sbl.com.fragmentsexample.item.fragments;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import sbl.com.fragmentsexample.R;
import sbl.com.fragmentsexample.item.adapters.CatRecyclerAdapter;
import sbl.com.fragmentsexample.item.datamodels.Category;

/**
 * Created by sandeep on 8/4/16.
 */
public class FragmentCategory extends android.app.Fragment {

    private GridLayoutManager lLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_recycler,
                container, false);
        init(view);

        return view ;
    }

    public void init(View view) {

        List<Category> rowListItem = getAllItemList();
        lLayout = new GridLayoutManager(getActivity(), 4);

        RecyclerView rView = (RecyclerView) view.findViewById(R.id.recycler_view);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        CatRecyclerAdapter rcAdapter = new CatRecyclerAdapter(getActivity(), rowListItem);
        rView.setAdapter(rcAdapter);

    }

    private List<Category> getAllItemList() {

        List<Category> allItems = new ArrayList<Category>();
        allItems.add(new Category("Break Fast", R.drawable.food_image_1));
        allItems.add(new Category("Lunch", R.drawable.food_image_2));
        allItems.add(new Category("Desert", R.drawable.food_image_3));
        allItems.add(new Category("Veg Break Fast", R.drawable.food_image_4));
        allItems.add(new Category("Non Veg breakfast", R.drawable.food_image_5));
        allItems.add(new Category("Veg Lunch", R.drawable.food_image_1));
        allItems.add(new Category("Non Veg Lunch", R.drawable.food_image_2));
        allItems.add(new Category("Dinner", R.drawable.food_image_3));

        return allItems;
    }
}


