package funix.prm.prm391x_tourguide_thanhchfx01399;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentHotel extends Fragment {

    ListView lvHotel;
    ArrayList<Hotel> arrHotel;
    HotelAdapter adapter;

    public FragmentHotel() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_hotel, container, false);
        lvHotel = view.findViewById(R.id.lvHotel);
        arrHotel = new ArrayList<>();
        addHotel();
        adapter = new HotelAdapter(getActivity(), R.layout.row_hotel, arrHotel);
        lvHotel.setAdapter(adapter);
        return view;
    }

    // Them du lieu vao arraylist arrHotel
    private void addHotel() {
        arrHotel.add(new Hotel("The Queen Hotel & Spa", "67 Thuốc Bắc, Hàng Bồ, Hàng Bồ, Quận Hoàn Kiếm, Hà Nội, Việt Nam", R.drawable.hotel));
        arrHotel.add(new Hotel("Hanoi Nostalgia Hotel & Spa", "13-15 Luong Ngoc Quyen, Hang Buom, Hoan Kiem, Hàng Buồm, Quận Hoàn Kiếm, Hà Nội, Việt Nam", R.drawable.hotel));
        arrHotel.add(new Hotel("Church Legend Hotel Hanoi", "46 Ấu Triệu, Phường Hàng Trống, Quận Hoàn Kiếm, Hà Nội, Việt Nam", R.drawable.hotel));
        arrHotel.add(new Hotel("Little Hanoi Diamond Hotel", "11 Bát Đàn, Quận Hoàn Kiếm, Hàng Bồ, Quận Hoàn Kiếm, Hà Nội, Việt Nam", R.drawable.hotel));
        arrHotel.add(new Hotel("Flamingo Dai Lai Resort", "Thôn Ngọc Quang, Xã Ngọc Thanh, Vĩnh Phúc, Phúc Yên, Hà Nội, Việt Nam", R.drawable.hotel));
        arrHotel.add(new Hotel("Annam Legend Hotel", "27 Hàng Bè, Hàng Bạc, Quận Hoàn Kiếm, Hà Nội, Việt Nam", R.drawable.hotel));
        arrHotel.add(new Hotel("Hanoi Zesty Hotel", "20 Hàng Cân, Hàng Đào, Quận Hoàn Kiếm, Hà Nội, Việt Nam", R.drawable.hotel));
        arrHotel.add(new Hotel("Bluebell Hotel", "41 Ngõ Huyện, Phường Hàng Trống, Quận Hoàn Kiếm, Hà Nội, Việt Nam", R.drawable.hotel));
    }
}
