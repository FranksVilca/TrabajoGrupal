package com.example.trabajogrupal;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class AmbienteInfoDialogFragment extends DialogFragment {
    private static final String ARG_AMBIENTE = "ambiente";

    public static AmbienteInfoDialogFragment newInstance(Ambiente ambiente) {
        AmbienteInfoDialogFragment fragment = new AmbienteInfoDialogFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_AMBIENTE, ambiente);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_ambiente_info, container, false);

        Ambiente ambiente = (Ambiente) getArguments().getSerializable(ARG_AMBIENTE);

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView = view.findViewById(R.id.textView);

        imageView.setImageResource(ambiente.getImagenId());
        textView.setText(ambiente.getDescripcion());

        return view;
    }
}
