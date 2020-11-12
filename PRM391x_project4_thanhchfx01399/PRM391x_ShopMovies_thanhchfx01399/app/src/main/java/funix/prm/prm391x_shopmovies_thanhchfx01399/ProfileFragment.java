package funix.prm.prm391x_shopmovies_thanhchfx01399;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.login.LoginManager;
import com.facebook.login.widget.ProfilePictureView;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    TextView tvId, tvEmail;
    ImageView imgAvatar;
    ProfilePictureView imgProfile;
    public Fragment fragmentLogin;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        tvId = (TextView) view.findViewById(R.id.tvId);
        tvEmail = (TextView) view.findViewById(R.id.tvEmail);
        imgAvatar = (ImageView) view.findViewById(R.id.imgAvatar);
        imgProfile = (ProfilePictureView) view.findViewById(R.id.imgProfile);
        fragmentLogin = new FragmentLogin();

        // when click by button facebook or google set value profile.
        if (MyApplication.fb == 0) {
            imgProfile.setVisibility(View.INVISIBLE);
            tvId.setText(MyApplication.id);
            tvEmail.setText(MyApplication.email);
            Picasso.get().load(MyApplication.avatar).into(imgAvatar);
        } else {
            imgAvatar.setVisibility(View.INVISIBLE);
            tvId.setText(MyApplication.id);
            tvEmail.setText(MyApplication.email);
            imgProfile.setProfileId(MyApplication.idFacebook);
        }

        super.onViewCreated(view, savedInstanceState);
    }

}
