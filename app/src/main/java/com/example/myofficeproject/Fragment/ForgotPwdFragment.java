package com.example.myofficeproject.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.myofficeproject.R;
import com.example.myofficeproject.databinding.FragmentForgotPwdBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ForgotPwdFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ForgotPwdFragment extends Fragment {

    FragmentForgotPwdBinding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ForgotPwdFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ForgotPwdFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ForgotPwdFragment newInstance(String param1, String param2) {
        ForgotPwdFragment fragment = new ForgotPwdFragment();
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
       // return inflater.inflate(R.layout.fragment_forgot_pwd, container, false);
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_forgot_pwd,container,false);
        View view=binding.getRoot();

        SignupClickEvent();
        return view;
    }

    private void SignupClickEvent(){
        binding.showuseridBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (CheckAllFields()) {

                    Toast.makeText(getContext(),"click",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private Boolean  CheckAllFields(){


        String email=binding.emailEDT.getText().toString().trim();
        String pwd=binding.pwdEDT.getText().toString().trim();
        String cpwd=binding.cpwdEDT.getText().toString().trim();


        if (email.length()==0){
            binding.emailEDT.setError("Email is required...!!!");
            binding.emailEDT.requestFocus();
            return false;
        }

        if (pwd.length()==0){
            binding.pwdEDT.setError("Password is required...!!!");
            binding.pwdEDT.requestFocus();
            return false;
        }

        if (cpwd.length()==0){
            binding.cpwdEDT.setError("Confirm Password is required...!!!");
            binding.cpwdEDT.requestFocus();
            return false;
        }

        if (!(pwd.equals(cpwd))){
            binding.cpwdEDT.setError("Both Password are not match..!!!");
            binding.cpwdEDT.requestFocus();
            return false;
        }
        return true;
    }
}