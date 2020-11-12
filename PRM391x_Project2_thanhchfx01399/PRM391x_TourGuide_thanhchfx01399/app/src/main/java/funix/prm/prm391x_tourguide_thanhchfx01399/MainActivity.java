package funix.prm.prm391x_tourguide_thanhchfx01399;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnHotel, btnAtm, btnHospital, btnBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Anh xa cac button
        btnHotel = (Button) findViewById(R.id.btnHotel);
        btnHospital = (Button) findViewById(R.id.btnHospital);
        btnAtm = (Button) findViewById(R.id.btnAtm);
        btnBus = (Button) findViewById(R.id.btnBus);

        // Goi phuong thuc nap fragment Main
        loadMain();
    }

    // Su kien khi nhan cac button chon o man hinh chinh
    public void addFragment(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = null;

        // Xu ly su kien theo id nut duoc click
        switch (view.getId()) {
            case R.id.btnHotel:
                fragmentTransaction.replace(R.id.main_activity, new FragmentHotel(), "FragmentHotel");
                fragmentTransaction.addToBackStack("FragmentHotel");
                break;
            case R.id.btnAtm:
                fragmentTransaction.replace(R.id.main_activity, new FragmentAtm(), "FragmentAtm");
                fragmentTransaction.addToBackStack("FragmentAtm");
                break;
            case R.id.btnHospital:
                fragmentTransaction.replace(R.id.main_activity, new FragmentHospital(), "FragmentHospital");
                fragmentTransaction.addToBackStack("FragmentHospital");
                break;
            case R.id.btnBus:
                fragmentTransaction.replace(R.id.main_activity, new FragmentBus(), "FragmentBus");
                fragmentTransaction.addToBackStack("FragmentBus");
                break;
        }
        fragmentTransaction.commit();
    }

    // Nap man hinh chinh len main activity
    public void loadMain() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = null;
        fragmentTransaction.replace(R.id.main_activity, new FragmentMain());
        fragmentTransaction.commit();
    }

    // Su kien khi nhan mui ten back ve man hinh chinh
    public void backMain(View view) {
        loadMain();
    }
}
