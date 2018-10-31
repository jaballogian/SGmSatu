package com.example.jaballogian.sgmsatu;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BantuanFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BantuanFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BantuanFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private ImageButton webButton, callButton, headPhoneButton, emailButton;
    private TextView webTextView, callTextView, headPhoneTextView, emailTextView;

    public BantuanFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BantuanFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BantuanFragment newInstance(String param1, String param2) {
        BantuanFragment fragment = new BantuanFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_bantuan, container, false);

        ImageButton webButton = (ImageButton) view.findViewById(R.id.webSGMImageButtonBantuanFragment);
        ImageButton callButton = (ImageButton) view.findViewById(R.id.callSGMImageButtonBantuanFragment);
        ImageButton headPhoneButton = (ImageButton) view.findViewById(R.id.headPhoneSGMImageButtonBantuanFragment);
        ImageButton emailButton = (ImageButton) view.findViewById(R.id.emailSGMImageButtonBantuanFragment);

        TextView webTextView = (TextView) view.findViewById(R.id.webSGMTextViewBantuanFragment);
        TextView callTextView = (TextView) view.findViewById(R.id.callSGMTextViewBantuanFragment);
        TextView headPhoneTextView = (TextView) view.findViewById(R.id.headPhoneSGMTextViewBantuanFragment);
        TextView emailTextView = (TextView) view.findViewById(R.id.emailSGMTextViewBantuanFragment);

        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                webSGM(v);
            }
        });

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                callSGM(v);
            }
        });

        headPhoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                headPhoneSGM(v);
            }
        });

        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                emailSGM(v);
            }
        });

        webTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                webSGM(v);
            }
        });

        callTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                callSGM(v);
            }
        });

        headPhoneTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                headPhoneSGM(v);
            }
        });

        emailTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                emailSGM(v);
            }
        });

        return view;
    }

    public void webSGM(View view){

        Intent openSGMWeb = new Intent(Intent.ACTION_VIEW);
        openSGMWeb.setData(Uri.parse("https://www.generasimaju.co.id/hubungi-kami"));
        startActivity(openSGMWeb);
    }

    public void callSGM(View view){

        Intent phoneCallSGM = new Intent(Intent.ACTION_CALL);
        phoneCallSGM.setData(Uri.parse("085724446995"));
        startActivity(phoneCallSGM);
    }

    public void headPhoneSGM(View view){

        Intent phoneCallSGM = new Intent(Intent.ACTION_CALL);
        phoneCallSGM.setData(Uri.parse("085724446995"));
        startActivity(phoneCallSGM);
    }

    public void emailSGM(View v){

        Intent sendSGMEmail = new Intent(Intent.ACTION_SEND);
        String[] TO = {""};
        String[] CC = {""};

        sendSGMEmail.setData(Uri.parse("mailto:"));
        sendSGMEmail.setType("text/plain");
        sendSGMEmail.putExtra(Intent.EXTRA_EMAIL, TO);
        sendSGMEmail.putExtra(Intent.EXTRA_CC, CC);
        sendSGMEmail.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        sendSGMEmail.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
//        else {
//            Toast.makeText(context, "Bantuan Fragment", Toast.LENGTH_LONG).show();
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
