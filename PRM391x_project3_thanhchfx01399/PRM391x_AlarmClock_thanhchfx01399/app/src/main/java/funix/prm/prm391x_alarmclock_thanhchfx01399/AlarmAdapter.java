package funix.prm.prm391x_alarmclock_thanhchfx01399;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import static android.content.Context.ALARM_SERVICE;

// Adapter cua listview
public class AlarmAdapter extends BaseAdapter {

    private final ArrayList<AlarmClock> listAlarm;

    AlarmAdapter(ArrayList<AlarmClock> listAlarm) {
        this.listAlarm = listAlarm;
    }

    @Override
    public int getCount() {
        return listAlarm.size();
    }

    @Override
    public Object getItem(int i) {
        return listAlarm.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listAlarm.get(i).getId();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int i, View view, final ViewGroup viewGroup) {

        View viewInformation;
        if (view == null) {
            viewInformation = View.inflate(viewGroup.getContext(), R.layout.alarm, null);
        } else {
            viewInformation = view;
        }

        //Bind sữ liệu phần tử vào View
        final AlarmClock information = (AlarmClock) getItem(i);
        ((TextView) viewInformation.findViewById(R.id.hour)).setText(information.getHour() + ":");

        // kiem tra neu minute < 10 them '0'
        if (information.getMinute() < 10) {
            ((TextView) viewInformation.findViewById(R.id.minute)).setText("0" + String.valueOf(information.getMinute()));
        } else {
            ((TextView) viewInformation.findViewById(R.id.minute)).setText(String.valueOf(information.getMinute()));
        }

        ((Button) viewInformation.findViewById(R.id.btnUpdate)).setText(information.getStatus());

        // Xu ly su kien khi bam vao nut update
        viewInformation.findViewById(R.id.btnUpdate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimeData mDB = new TimeData(viewGroup.getContext());
                Intent intent = new Intent(viewGroup.getContext(), AlarmReceiver.class);
                AlarmManager alarmManager = (AlarmManager) viewGroup.getContext().getSystemService(ALARM_SERVICE);
                if(information.getStatus().equals("on")) {
                    information.setStatus("off");
                    intent.putExtra("extra", information.getStatus());
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(
                            viewGroup.getContext(),
                            information.getId(),
                            intent,
                            PendingIntent.FLAG_UPDATE_CURRENT
                    );
                    alarmManager.cancel(pendingIntent);
                    viewGroup.getContext().sendBroadcast(intent);
                }else if(information.getStatus().equals("off")) {
                    information.setStatus("on");
                    intent.putExtra("extra", information.getStatus());
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(
                            viewGroup.getContext(),
                            information.getId(),
                            intent,
                            PendingIntent.FLAG_UPDATE_CURRENT
                    );
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.HOUR_OF_DAY, information.getHour());
                    calendar.set(Calendar.MINUTE, information.getMinute());
                    alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                }
                mDB.updateAlarm(information);
                notifyDataSetChanged();
            }
        });

        // xu ly su kien khi click vao nut delete
        viewInformation.findViewById(R.id.btnDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(viewGroup.getContext(), AlarmReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(
                        viewGroup.getContext(),
                        information.getId(),
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
                AlarmManager alarmManager = (AlarmManager) viewGroup.getContext().getSystemService(ALARM_SERVICE);
                alarmManager.cancel(pendingIntent);
                TimeData mDB = new TimeData(viewGroup.getContext());
                mDB.deleteAlarm(information);
                listAlarm.remove(information);
                notifyDataSetChanged();
            }
        });

        return viewInformation;
    }
}
