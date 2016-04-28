package sbl.com.fragmentsexample;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import sbl.com.fragmentsexample.item.fragments.FragmentCategory;

/**
 * Created by sandeep on 7/4/16.
 */
public class NestedFragments extends Activity {

    public static NestedFragments nestedFragments;
    public static String fragmentName = "FRAGMENT";
    public static int fragmentCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nestedFragments = this;
        setContentView(R.layout.activity_nested_fragments);
        init();

    }

    public void init() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentCategory hello = new FragmentCategory();
        fragmentTransaction.add(R.id.child_fragment, hello).addToBackStack(fragmentName + fragmentCount++);
//        fragmentTransaction.add(R.id.child_fragment,hello);
        fragmentTransaction.commit();

//        FragmentCategory fragmentC = new FragmentCategory();
//        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//        transaction.add(R.id.child_fragment, fragmentC).commit();
    }


}
