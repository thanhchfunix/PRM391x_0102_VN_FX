package funix.prm.prm391x_tourguide_thanhchfx01399;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentAtm extends Fragment {

    ListView lvAtm;
    ArrayList<Atm> arrAtm;
    AtmAdapter adapter;

    public FragmentAtm() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_atm, container, false);
        lvAtm = view.findViewById(R.id.lvAtm);
        arrAtm = new ArrayList<>();
        addAtm();
        adapter = new AtmAdapter(getActivity(), R.layout.row_atm, arrAtm);
        lvAtm.setAdapter(adapter);
        return view;
    }

    // Them du lieu vao mang cac cay ATM
    private void addAtm() {
        arrAtm.add(new Atm("ATM Hoàn Kiếm", "17 phố Lý Thường Kiệt, Phường Phan Chu Trinh, Quận Hoàn Kiếm, Hà Nội", R.drawable.atm_machine));
        arrAtm.add(new Atm("ATM Đinh Tiên Hoàng", "7 Đinh Tiên Hoàng, Quận Hoàn Kiếm, Hà Nội", R.drawable.atm_machine));
        arrAtm.add(new Atm("ATM Hội sở", "57 Lý Thường Kiệt, Quận Hoàn Kiếm, Hà Nội", R.drawable.atm_machine));
        arrAtm.add(new Atm("ATM Nam Hà Nội", "236 Lê Thanh Nghị, Quận Hai Bà Trưng, Hà Nội", R.drawable.atm_machine));
        arrAtm.add(new Atm("ATM Hai Bà Trưng","300-302 Trần Khát Chân, Quận Hai Bà Trưng, Hà Nội", R.drawable.atm_machine));
        arrAtm.add(new Atm("ATM Lê Ngọc Hân", "44 Lê Ngọc Hân, Quận Hai Bà Trưng, Hà Nội", R.drawable.atm_machine));
        arrAtm.add(new Atm("ATM Thăng Long", "129-131 Hoàng Quốc Việt, Quận Cầu Giấy, Hà Nội", R.drawable.atm_machine));
        arrAtm.add(new Atm("ATM Phạm Hùng", "Tòa nhà FPT Phạm Hùng, Quận Cầu Giấy, Hà Nội", R.drawable.atm_machine));
        arrAtm.add(new Atm("ATM Khâm Thiên","158 Khâm Thiên, Quận Đống Đa, Hà Nội", R.drawable.atm_machine));
    }

}
