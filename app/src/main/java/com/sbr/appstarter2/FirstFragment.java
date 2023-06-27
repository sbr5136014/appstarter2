package com.sbr.appstarter2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.sbr.appstarter2.databinding.FragmentFirstBinding;

import java.util.Objects;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    void startapp(String appname, Context ctx){
        Intent i = ctx.getPackageManager().getLaunchIntentForPackage(appname);
        if (i != null) {
            ctx.startActivity(i);
        } else{
            Toast.makeText(ctx, "Package not found", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        startapp("us.zoom.videomeetings",getContext());

        binding = FragmentFirstBinding.inflate(inflater, container, false);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Intent back = new Intent(getContext(), BootBroadcastReceiver.class);
        back.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getContext().startActivity(back);
        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent in = new Intent(Settings.ACTION_SETTINGS);
                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                requireContext().startActivity(new Intent(in));

            }
        });
        binding.a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startapp("us.zoom.videomeetings",getContext());

            }
        });
        binding.b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startapp("us.zoom.videomeetings",getContext());



            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}