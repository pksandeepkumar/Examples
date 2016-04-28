package sbl.com.fragmentsexample.item.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import sbl.com.fragmentsexample.R;
import sbl.com.fragmentsexample.item.datamodels.Category;

/**
 * Created by sandeep on 8/4/16.
 */
public class CatRecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {

    private List<Category> itemList;
    private Context context;



    public CatRecyclerAdapter(Context context, List<Category> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.countryName.setText(itemList.get(position).name);
        holder.countryPhoto.setImageResource(itemList.get(position).resourseID);
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}