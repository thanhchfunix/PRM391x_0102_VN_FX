package funix.prm.prm391x_alarmclock_thanhchfx01399;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.Nullable;

// service cua alarm clock
public class Music extends Service {

    MediaPlayer mediaPlayer;
    int id;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        // Nhan du lieu on/off tu intent
        String getKey = intent.getExtras().getString("extra");

        // Kiem tra trang thai gio hen
        if (getKey.equals("on")) {
            id = 1;
        } else if(getKey.equals("off")) {
            id = 0;
        }

        // phat nhac va chay media khi trang thai on va den gio hen nguoc lai thi off
        if (id == 1) {
            mediaPlayer = MediaPlayer.create(this, R.raw.ringtone);
            mediaPlayer.start();
            id = 0;
        } else if (id == 0) {
            if (mediaPlayer == null) mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
            mediaPlayer.stop();
            mediaPlayer.reset();
        }
        return START_NOT_STICKY;
    }
}
