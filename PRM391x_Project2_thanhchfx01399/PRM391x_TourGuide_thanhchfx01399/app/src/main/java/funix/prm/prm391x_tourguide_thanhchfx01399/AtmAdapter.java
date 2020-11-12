package funix.prm.prm391x_tourguide_thanhchfx01399;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AtmAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Atm> listAtm;

    public AtmAdapter(Context context, int layout, List<Atm> listAtm) {
        this.context = context;
        this.layout = layout;
        this.listAtm = listAtm;
    }

    @Override
    public int getCount() {
        return listAtm.size();
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
        TextView tvNameAtm = convertView.findViewById(R.id.tvNameAtm);
        TextView tvAddAtm = convertView.findViewById(R.id.tvAddAtm);
        ImageView iconAtm = (ImageView) convertView.findViewById(R.id.iconAtm);

        Atm atm = listAtm.get(position);
        tvNameAtm.setText(atm.getName());
        tvAddAtm.setText(atm.getAddress());
        iconAtm.setImageResource(atm.getImage());
        return convertView;
    }
}

