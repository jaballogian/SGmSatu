package com.example.jaballogian.sgmsatu;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfilkuFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfilkuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfilkuFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ProfilkuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfilkuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfilkuFragment newInstance(String param1, String param2) {
        ProfilkuFragment fragment = new ProfilkuFragment();
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
        final View view = inflater.inflate(R.layout.fragment_profilku, container, false);

        final TextView namaUser = (TextView) view.findViewById(R.id.namaUserTextViewProfilkuFragment);
        final TextView nomorTelepon = (TextView) view.findViewById(R.id.noTelpUserTextViewProfilkuFragment);
        final TextView pointUser = (TextView) view.findViewById(R.id.pointUserTextViewProfilkuFragment);

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        String uID = currentUser.getUid();

        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(uID);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                namaUser.setText(dataSnapshot.child("Nama Lengkap").getValue().toString());
                nomorTelepon.setText(dataSnapshot.child("No Telpon").getValue().toString());
                String point = dataSnapshot.child("Point").getValue().toString();
                pointUser.setText(point + " Point");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        ImageButton belumBayarImageButton = (ImageButton) view.findViewById(R.id.belumBayarImageButtonProfilkuFragment);
        ImageButton pengemasanImageButton = (ImageButton) view.findViewById(R.id.pengemasanImageButtonProfilkuFragment);
        ImageButton pengirimanImageButton = (ImageButton) view.findViewById(R.id.pengirimanImageButtonProfilkuFragment);
        ImageButton pembatalanImageButton = (ImageButton) view.findViewById(R.id.pembatalanImageButtonProfilkuFragment);

        ImageButton penilaiankuImageButton = (ImageButton) view.findViewById(R.id.penilaiankuImageButtonProfilkuFragment);
        ImageButton terakhirDilihatImageButton = (ImageButton) view.findViewById(R.id.terakhirDilihatImageButtonProfilkuFragment);
        ImageButton favoriktuImageButton = (ImageButton) view.findViewById(R.id.favoritkuImageButtonProfilkuFragment);
        ImageButton postingankuImageButton = (ImageButton) view.findViewById(R.id.postingankuImageButtonProfilkuFragment);
        ImageButton riwayatPembelianImageButton = (ImageButton) view.findViewById(R.id.riwayatPembelianImageButtonProfilkuFragment);

        ImageButton logOut = (ImageButton) view.findViewById(R.id.sgmLogoImageViewProfilkuFragment);

        TextView belumBayarTextView = (TextView) view.findViewById(R.id.belumBayarTextViewProfilkuFragment);
        TextView pengemasanTextView = (TextView) view.findViewById(R.id.pengemasanTextViewProfilkuFragment);
        TextView pengirimanTextView = (TextView) view.findViewById(R.id.pengirimanTextViewProfilkuFragment);
        TextView pembatalanTextView = (TextView) view.findViewById(R.id.pembatalanTextViewProfilkuFragment);

        TextView penilaiankuTextView = (TextView) view.findViewById(R.id.penilaiankuTextViewProfilkuFragment);
        TextView terakhirDilihatTextView = (TextView) view.findViewById(R.id.terakhirDilihatTextViewProfilkuFragment);
        TextView favoritkuTextView = (TextView) view.findViewById(R.id.favoritkuTextViewProfilkuFragment);
        TextView postingankuTextView = (TextView) view.findViewById(R.id.postingankuTextViewProfilkuFragment);
        TextView riwayatPembelianTextView = (TextView) view.findViewById(R.id.riwayatPembelianTextViewProfilkuFragment);

        belumBayarImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toDataProfilkuActivity = new Intent (getActivity(), DataProfilkuActivity.class);
                toDataProfilkuActivity.putExtra("Activity Title", "Belum Bayar");
                startActivity(toDataProfilkuActivity);

            }
        });

        belumBayarTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toDataProfilkuActivity = new Intent (getActivity(), DataProfilkuActivity.class);
                toDataProfilkuActivity.putExtra("Activity Title", "Belum Bayar");
                startActivity(toDataProfilkuActivity);

            }
        });

        pengemasanImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toDataProfilkuActivity = new Intent (getActivity(), DataProfilkuActivity.class);
                toDataProfilkuActivity.putExtra("Activity Title", "Pengemasan");
                startActivity(toDataProfilkuActivity);
            }
        });

        pengemasanTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toDataProfilkuActivity = new Intent (getActivity(), DataProfilkuActivity.class);
                toDataProfilkuActivity.putExtra("Activity Title", "Pengemasan");
                startActivity(toDataProfilkuActivity);
            }
        });

        pengirimanImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toDataProfilkuActivity = new Intent (getActivity(), DataProfilkuActivity.class);
                toDataProfilkuActivity.putExtra("Activity Title", "Pengiriman");
                startActivity(toDataProfilkuActivity);
            }
        });

        pengirimanTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toDataProfilkuActivity = new Intent (getActivity(), DataProfilkuActivity.class);
                toDataProfilkuActivity.putExtra("Activity Title", "Pengiriman");
                startActivity(toDataProfilkuActivity);
            }
        });

        pembatalanImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toDataProfilkuActivity = new Intent (getActivity(), DataProfilkuActivity.class);
                toDataProfilkuActivity.putExtra("Activity Title", "Pembatalan");
                startActivity(toDataProfilkuActivity);
            }
        });

        pembatalanTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toDataProfilkuActivity = new Intent (getActivity(), DataProfilkuActivity.class);
                toDataProfilkuActivity.putExtra("Activity Title", "Pembatalan");
                startActivity(toDataProfilkuActivity);
            }
        });

        penilaiankuImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toDataProfilkuActivity = new Intent (getActivity(), DataProfilkuActivity.class);
                toDataProfilkuActivity.putExtra("Activity Title", "Penilaianku");
                startActivity(toDataProfilkuActivity);
            }
        });

        penilaiankuTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toDataProfilkuActivity = new Intent (getActivity(), DataProfilkuActivity.class);
                toDataProfilkuActivity.putExtra("Activity Title", "Penliaianku");
                startActivity(toDataProfilkuActivity);
            }
        });

        terakhirDilihatImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toDataProfilkuActivity = new Intent (getActivity(), DataProfilkuActivity.class);
                toDataProfilkuActivity.putExtra("Activity Title", "Terakhir Dilihat");
                startActivity(toDataProfilkuActivity);
            }
        });

        terakhirDilihatTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toDataProfilkuActivity = new Intent (getActivity(), DataProfilkuActivity.class);
                toDataProfilkuActivity.putExtra("Activity Title", "Terakhir Dilihat");
                startActivity(toDataProfilkuActivity);
            }
        });

        favoriktuImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toDataProfilkuActivity = new Intent (getActivity(), DataProfilkuActivity.class);
                toDataProfilkuActivity.putExtra("Activity Title", "Favoritku");
                startActivity(toDataProfilkuActivity);
            }
        });

        favoritkuTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toDataProfilkuActivity = new Intent (getActivity(), DataProfilkuActivity.class);
                toDataProfilkuActivity.putExtra("Activity Title", "Favoritku");
                startActivity(toDataProfilkuActivity);
            }
        });

        postingankuImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toDataProfilkuActivity = new Intent (getActivity(), DataProfilkuActivity.class);
                toDataProfilkuActivity.putExtra("Activity Title", "Postinganku");
                startActivity(toDataProfilkuActivity);
            }
        });

        postingankuTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toDataProfilkuActivity = new Intent (getActivity(), DataProfilkuActivity.class);
                toDataProfilkuActivity.putExtra("Activity Title", "Postinganku");
                startActivity(toDataProfilkuActivity);
            }
        });

        riwayatPembelianImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toDataProfilkuActivity = new Intent (getActivity(), DataProfilkuActivity.class);
                toDataProfilkuActivity.putExtra("Activity Title", "Riwayat Pembelian");
                startActivity(toDataProfilkuActivity);
            }
        });

        riwayatPembelianTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toDataProfilkuActivity = new Intent (getActivity(), DataProfilkuActivity.class);
                toDataProfilkuActivity.putExtra("Activity Title", "Riwayat Pembelian");
                startActivity(toDataProfilkuActivity);
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();

                Intent toLogInActivity = new Intent (getActivity(), LogInActivity.class);
                startActivity(toLogInActivity);
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
//            Toast.makeText(context, "Profilku Fragment", Toast.LENGTH_LONG).show();
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
