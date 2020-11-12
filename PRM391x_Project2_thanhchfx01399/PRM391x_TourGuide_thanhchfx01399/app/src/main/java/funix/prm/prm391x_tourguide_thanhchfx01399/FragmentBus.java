package funix.prm.prm391x_tourguide_thanhchfx01399;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentBus extends Fragment {
    ListView lvBus;
    ArrayList<Bus> arrBus;
    BusAdapter adapter;

    public FragmentBus() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_bus, container, false);
        lvBus = view.findViewById(R.id.lvBus);
        arrBus = new ArrayList<>();
        addBus();
        adapter = new BusAdapter(getActivity(), R.layout.row_bus, arrBus);
        lvBus.setAdapter(adapter);
        return view;
    }

    //add du lieu vao mang arrBus
    private void addBus() {
        arrBus.add(new Bus("Tuyến 01", "BX Gia Lâm - BX Yên Nghĩa", R.drawable.metro));
        arrBus.add(new Bus("Tuyến 02", "Bác cổ - BX Yên Nghĩa", R.drawable.metro));
        arrBus.add(new Bus("Tuyến 03A", "BX Giáp Bát - BX Gia Lâm", R.drawable.metro));
        arrBus.add(new Bus("Tuyến 03B", "Bx Giáp Bát - Vincom - Phúc Lợi", R.drawable.metro));
        arrBus.add(new Bus("Tuyến 04", "Long Biên - BX Nước Ngầm", R.drawable.metro));
        arrBus.add(new Bus("Tuyến 05", "Linh Đàm - Phú Diễn", R.drawable.metro));
        arrBus.add(new Bus("Tuyến 06", "BX. Giáp Bát - Phú Minh (Phú Xuyên)", R.drawable.metro));
        arrBus.add(new Bus("Tuyến 07", "Cầu Giấy - Nội Bài", R.drawable.metro));
        arrBus.add(new Bus("Tuyến 08", "Long Biên - Đông Mỹ", R.drawable.metro));
    }
}
