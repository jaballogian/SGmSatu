package com.example.jaballogian.sgmsatu;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;

import com.example.jaballogian.sgmsatu.model.Product;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BerandaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BerandaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BerandaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private ImageButton imgBtnMain;

    private ImageButton[] imgBtnSide, imgBtnMiddle, imgBtnBottom;

    private Button btnSelengkapnya, btnBeliProduct;

    private SearchView srcViewSearch;

    public BerandaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BerandaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BerandaFragment newInstance(String param1, String param2) {
        BerandaFragment fragment = new BerandaFragment();
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
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);

        imgBtnMain = (ImageButton) view.findViewById(R.id.mainProductImageButtonBerandaFragment);
        btnSelengkapnya = (Button) view.findViewById(R.id.selengkapnyaButtonBerandaFragment);
        btnBeliProduct = (Button) view.findViewById(R.id.beliProductButtonBerandaFragment);
        srcViewSearch = (SearchView) view.findViewById(R.id.searchSearchViewBerandaFragment);

        imgBtnMiddle = new ImageButton[3];
        imgBtnSide = new ImageButton[3];
        imgBtnBottom = new ImageButton[3];

        imgBtnMiddle[0] = (ImageButton) view.findViewById(R.id.middleProduct0ImageButtonBerandaFragment);
        imgBtnMiddle[1] = (ImageButton) view.findViewById(R.id.middleProduct1ImageButtonBerandaFragment);
        imgBtnMiddle[2] = (ImageButton) view.findViewById(R.id.middleProduct2ImageButtonBerandaFragment);

        imgBtnSide[0] = (ImageButton) view.findViewById(R.id.sideProduct0ImageButtonBerandaFragment);
        imgBtnSide[1] = (ImageButton) view.findViewById(R.id.sideProduct1ImageButtonBerandaFragment);
        imgBtnSide[2] = (ImageButton) view.findViewById(R.id.sideProduct2ImageButtonBerandaFragment);

        imgBtnBottom[0] = (ImageButton) view.findViewById(R.id.bottomProduct0ImageButtonBerandaFragment);
        imgBtnBottom[1] = (ImageButton) view.findViewById(R.id.bottomProduct1ImageButtonBerandaFragment);
        imgBtnBottom[2] = (ImageButton) view.findViewById(R.id.bottomProduct2ImageButtonBerandaFragment);

        bindEvent();

        return view;
    }

    private void bindEvent()
    {
        btnBeliProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(v.getContext(), BeliProdukActivity.class);
                startActivity(main);
            }
        });

        imgBtnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(v.getContext(), DetailActivity.class);
                main.putExtra("id", 1);
                startActivity(main);
            }
        });

        imgBtnSide[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(v.getContext(), DetailActivity.class);
                main.putExtra("id", 2);
                startActivity(main);
            }
        });

        imgBtnSide[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(v.getContext(), DetailActivity.class);
                main.putExtra("id", 3);
                startActivity(main);
            }
        });

        imgBtnSide[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(v.getContext(), DetailActivity.class);
                main.putExtra("id", 4);
                startActivity(main);
            }
        });

        imgBtnMiddle[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(v.getContext(), DetailActivity.class);
                main.putExtra("id", 5);
                startActivity(main);
            }
        });

        imgBtnMiddle[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(v.getContext(), DetailActivity.class);
                main.putExtra("id", 6);
                startActivity(main);
            }
        });

        imgBtnMiddle[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(v.getContext(), DetailActivity.class);
                main.putExtra("id", 7);
                startActivity(main);
            }
        });

        imgBtnBottom[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(v.getContext(), DetailActivity.class);
                main.putExtra("id", 8);
                startActivity(main);
            }
        });

        imgBtnBottom[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(v.getContext(), DetailActivity.class);
                main.putExtra("id", 9);
                startActivity(main);
            }
        });

        imgBtnBottom[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(v.getContext(), DetailActivity.class);
                main.putExtra("id", 10);
                startActivity(main);
            }
        });

        btnSelengkapnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Product> products = Product.listAll();
                for (Product product:products) {
                    Log.d("sgm", String.valueOf(product.getId())+ " => " + product.toString());
                }
            }
        });
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
//            Toast.makeText(context, "Beranda Fragment", Toast.LENGTH_LONG).show();
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
