package funix.prm.prm391x_tourguide_thanhchfx01399;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentHospital extends Fragment {

    ListView lvHospital;
    ArrayList<Hospital> arrHospital;
    HospitalAdapter adapter;

    public FragmentHospital() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_hospital, container, false);
        lvHospital = view.findViewById(R.id.lvHospital);
        arrHospital = new ArrayList<>();
        addHospital();
        adapter = new HospitalAdapter(getActivity(), R.layout.row_hospital, arrHospital);
        lvHospital.setAdapter(adapter);
        return view;
    }

    //add du lieu vao mang
    private void addHospital() {
        arrHospital.add(new Hospital("Bệnh viện Bạch Mai", "78 – Đường Giải Phóng – Phương Mai – Đống Đa – Hà Nội", R.drawable.hospital));
        arrHospital.add(new Hospital("Bệnh Viện Hữu Nghị", "Số 1 – Trần Khánh Dư – Quận Hai Bà Trưng – Hà Nội", R.drawable.hospital));
        arrHospital.add(new Hospital("Bệnh Viện E, Hà Nội", "89 – Trần Cung – Nghĩa Tân – Cầu Giấy – Hà Nội", R.drawable.hospital));
        arrHospital.add(new Hospital("Viện Răng Hàm Mặt", "40B – Tràng Thi – Hoàn Kiếm – Hà Nội", R.drawable.hospital));
        arrHospital.add(new Hospital("Bệnh Viện Tai Mũi Họng Trung Ương", "78 – Đường Giải Phóng – Quận Đống Đa – Hà Nội", R.drawable.hospital));
        arrHospital.add(new Hospital("Bệnh Viện Mắt Trung Ương", "85 – Phố Bà Triệu – Quận Hai Bà Trưng – Hà Nội", R.drawable.hospital));
        arrHospital.add(new Hospital("Viện Y Học Cổ Truyền Trung Ương", "29 – Phố Nguyễn Bỉnh Khiêm – Quận Hai Bà Trưng – Hà Nội", R.drawable.hospital));
        arrHospital.add(new Hospital("Bệnh Viện Nội Tiết", "80 – Thái Thịnh II – Thịnh Quang – Đống Đa – Hà Nội", R.drawable.hospital));
        arrHospital.add(new Hospital("Bệnh Viện Việt Đức", "8 – Phố Phủ Doãn – Quận Hoàn Kiếm – Hà Nội", R.drawable.hospital));
        arrHospital.add(new Hospital("Bệnh Viện Nhi Trung Ương", "18/879 – Đường La Thành – Quận Đống Đa – Hà Nội", R.drawable.hospital));
    }

}