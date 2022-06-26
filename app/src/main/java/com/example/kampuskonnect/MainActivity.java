package com.example.kampuskonnect;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.kampuskonnect.databinding.ActivityMainBinding;
import com.example.kampuskonnect.fragments.CallsFragment;
import com.example.kampuskonnect.fragments.ChatsFragment;
import com.example.kampuskonnect.fragments.StatusFragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
       setupwithviewpager(binding.viewPager);
       binding.tabLayout.setupWithViewPager(binding.viewPager);
       setSupportActionBar(binding.toolbar);
       binding.viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

           }

           @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
           @Override
           public void onPageSelected(int position) {
               changefabicon(position);

           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });
    }

    private void setupwithviewpager(ViewPager  viewPager){
            MainActivity.SectionsPageAdapter adapter=new SectionsPageAdapter(getSupportFragmentManager());
            adapter.addfragment(new ChatsFragment(),"Chats");
            adapter.addfragment(new StatusFragment(),"Status");
            adapter.addfragment(new CallsFragment(),"Calls");
            viewPager.setAdapter(adapter);
    }
    private static  class SectionsPageAdapter extends FragmentPagerAdapter{

        private final List<Fragment> mfragmentlist=new ArrayList<>();
        private final List<String> mfragmenttitlelist=new ArrayList<>();
        public SectionsPageAdapter(@NonNull @NotNull FragmentManager fm) {
            super(fm);
        }

        public SectionsPageAdapter(@NonNull @NotNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @org.jetbrains.annotations.NotNull
        @Override
        public Fragment getItem(int position) {
            return mfragmentlist.get(position);
        }

        @Override
        public int getCount() {
            return mfragmentlist.size();
        }
        public void addfragment(Fragment fragment,String title){
              mfragmentlist.add(fragment);
              mfragmenttitlelist.add(title);
        }

        @Nullable
        @org.jetbrains.annotations.Nullable
        @Override
        public CharSequence getPageTitle(int position) {
//            return super.getPageTitle(position);
            return mfragmenttitlelist.get(position);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();
        switch (id){
            case R.id.menu_search:
                Toast.makeText(this, "Action Search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_more:
                Toast.makeText(this, "Action more", Toast.LENGTH_SHORT).show();

        }
        if (id==R.id.menu_search){
            Toast.makeText(this, "Search Clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void changefabicon(final int index){
        binding.floatingactionbutton.hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (index){
                    case 0:binding.floatingactionbutton.setImageDrawable(getDrawable(R.drawable.ic_baseline_chat_24));break;
                    case 1:binding.floatingactionbutton.setImageDrawable(getDrawable(R.drawable.ic_baseline_camera_alt_24));break;
                    case 2:binding.floatingactionbutton.setImageDrawable(getDrawable(R.drawable.ic_baseline_call_24));break;
                }
                binding.floatingactionbutton.show();
            }
        },400);

    }
}