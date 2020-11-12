package funix.prm.prm391x_tourguide_thanhchfx01399;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HospitalAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Hospital> listHospital;

    public HospitalAdapter(Context context, int layout, List<Hospital> listHospital) {
        this.context = context;
        this.layout = layout;
        this.listHospital = listHospital;
    }

    @Override
    public int getCount() {
        return listHospital.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);
        TextView tvNameHospital = convertView.findViewById(R.id.tvNameHospital);
        TextView tvAddHospital = convertView.findViewById(R.id.tvAddHospital);
        ImageView iconHospital = (ImageView) convertView.findViewById(R.id.iconHospital);
        Hospital hospital = listHospital.get(position);
        tvNameHospital.setText(hospital.getName());
        tvAddHospital.setText(hospital.getAddress());
        iconHospital.setImageResource(hospital.getImage());
        return convertView;
    }
}
