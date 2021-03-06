package com.example.jaballogian.sgmsatu;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PesanFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PesanFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PesanFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PesanFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PesanFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PesanFragment newInstance(String param1, String param2) {
        PesanFragment fragment = new PesanFragment();
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
        View view = inflater.inflate(R.layout.fragment_pesan, container, false);

        LinearLayout pesan1 = (LinearLayout) view.findViewById(R.id.pesan1LinearLayoutPesanFragment);
        LinearLayout pesan2 = (LinearLayout) view.findViewById(R.id.pesan2LinearLayoutPesanFragment);
        LinearLayout pesan3 = (LinearLayout) view.findViewById(R.id.pesan3LinearLayoutPesanFragment);

        pesan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toChatingActivity = new Intent(getActivity(), ChatingActivity.class);
                toChatingActivity.putExtra("Nama Pengirim Pesan","Vicky Saputra");
                toChatingActivity.putExtra("Isi Pesan","Wah promo seperti apa? Sangat menarik");
                startActivity(toChatingActivity);
            }
        });

        pesan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toChatingActivity = new Intent(getActivity(), ChatingActivity.class);
                toChatingActivity.putExtra("Nama Pengirim Pesan","Veren");
                toChatingActivity.putExtra("Isi Pesan","Nutrisi baik seperti apa");
                startActivity(toChatingActivity);
            }
        });

        pesan3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toChatingActivity = new Intent(getActivity(), ChatingActivity.class);
                toChatingActivity.putExtra("Nama Pengirim Pesan","Ayu");
                toChatingActivity.putExtra("Isi Pesan","Semoga si kecil cepat sembuh");
                startActivity(toChatingActivity);
            }
        });


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
//            Toast.makeText(context, "Pesan Fragment", Toast.LENGTH_LONG).show();
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
