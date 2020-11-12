package funix.prm.prm391x_tourguide_thanhchfx01399;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BusAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Bus> listBus;

    public BusAdapter(Context context, int layout, List<Bus> listBus) {
        this.context = context;
        this.layout = layout;
        this.listBus = listBus;
    }

    @Override
    public int getCount() {
        return listBus.size();
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
        TextView tvNameBus = convertView.findViewById(R.id.tvNameBus);
        TextView tvAddBus = convertView.findViewById(R.id.tvAddBus);
        ImageView iconBus = (ImageView) convertView.findViewById(R.id.iconBus);

        Bus bus = listBus.get(position);
        tvNameBus.setText(bus.getName());
        tvAddBus.setText(bus.getAddress());
        iconBus.setImageResource(bus.getImage());
        return convertView;
    }
}