package funix.prm.prm391x_alarmclock_thanhchfx01399;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// AlarmReceiver
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String s_intent = intent.getExtras().getString("extra");
        Intent myIntent = new Intent(context, Music.class);
        myIntent.putExtra("extra", s_intent);
        context.startService(myIntent);
    }
}
