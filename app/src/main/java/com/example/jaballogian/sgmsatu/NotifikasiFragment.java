package com.example.jaballogian.sgmsatu;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NotifikasiFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NotifikasiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NotifikasiFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public NotifikasiFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NotifikasiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NotifikasiFragment newInstance(String param1, String param2) {
        NotifikasiFragment fragment = new NotifikasiFragment();
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
        View view = inflater.inflate(R.layout.fragment_notifikasi, container, false);

        LinearLayout notifikasi1 = (LinearLayout) view.findViewById(R.id.notifikasi1LinearLayoutNotifikasiFragment);
        LinearLayout notifikasi2 = (LinearLayout) view.findViewById(R.id.notifikasi2LinearLayoutNotifikasiFragment);

        TextView judulNotifikasi1 = (TextView) view.findViewById(R.id.judulNotifikasi1TextViewNotifikasiFragment);
        TextView isiNotifkikasi1 = (TextView) view.findViewById(R.id.isiNotifikasi1TextViewNotifikasiFragment);
        TextView judulNotifkikasi2 = (TextView) view.findViewById(R.id.judulNotifikasi2TextViewNotifikasiFragment);
        TextView isiNotifkikasi2 = (TextView) view.findViewById(R.id.isiNotifikasi2TextViewNotifikasiFragment);

        notifikasi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog builder = new AlertDialog.Builder(getActivity()).create();
                builder.setTitle("Promo Terpopuler");
                builder.setMessage("Terus belanja dengan promo SGM");
                builder.show();
            }
        });

//        judulNotifikasi1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                AlertDialog builder = new AlertDialog.Builder(getActivity()).create();
//                builder.setTitle("Promo Terpopuler");
//                builder.setMessage("Terus belanja dengan promo SGM");
//                builder.show();
//            }
//        });
//
//        isiNotifkikasi1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                AlertDialog builder = new AlertDialog.Builder(getActivity()).create();
//                builder.setTitle("Promo Terpopuler");
//                builder.setMessage("Terus belanja dengan promo SGM");
//                builder.show();
//            }
//        });

        notifikasi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog builder = new AlertDialog.Builder(getActivity()).create();
                builder.setTitle("Event");
                builder.setMessage("Ayo ikut event SGM bersama buah hati");
                builder.show();
            }
        });

//        judulNotifkikasi2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                AlertDialog builder = new AlertDialog.Builder(getActivity()).create();
//                builder.setTitle("Event");
//                builder.setMessage("Ayo ikut event SGM bersama buah hati");
//                builder.show();
//            }
//        });
//
//        isiNotifkikasi2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                AlertDialog builder = new AlertDialog.Builder(getActivity()).create();
//                builder.setTitle("Event");
//                builder.setMessage("Ayo ikut event SGM bersama buah hati");
//                builder.show();
//            }
//        });


        return view;
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
//            Toast.makeText(context, "Notifikasi Fragment", Toast.LENGTH_LONG).show();
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
