package cdietschrun.pandemiclegacyseason0companionapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pls0_activity_main);

//        if (savedInstanceState == null)
//        {
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .setReorderingAllowed(true)
//                    .add(R.id.container, new ObjectiveMenuFragment())
//                    .commit();
//        }
    }

//    @Override
//    public void navigateTo(Fragment fragment, boolean addToBackstack)
//    {
//        FragmentTransaction transaction = getSupportFragmentManager()
//                .beginTransaction()
//                .setReorderingAllowed(true)
//                .replace(R.id.container, fragment);
//
//        if (addToBackstack)
//        {
//            transaction.addToBackStack(null);
//        }
//
//        transaction.commit();
//    }
}