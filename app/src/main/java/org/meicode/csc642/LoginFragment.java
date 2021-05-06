package org.meicode.csc642;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getView().findViewById(R.id.signUpButtonInLoginPage).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_signUpFragment));

        Button logInButton = getView().findViewById(R.id.logInButton);
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = getView().findViewById(R.id.userNameInLogin);
                String userNameInLogin = editText.getText().toString();
                EditText editText2 = getView().findViewById(R.id.passwordInLogIn);
                String passwordInLogIn = editText2.getText().toString();
                if (TextUtils.isEmpty(userNameInLogin)){
                    Toast.makeText(getActivity(),"Please input your username",Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(passwordInLogIn)){
                    Toast.makeText(getActivity(),"Please input your password",Toast.LENGTH_LONG).show();
                    return;
                }
                if (!userNameInLogin.equals("abc")){
                    Toast.makeText(getActivity(),"User name is wrong",Toast.LENGTH_LONG).show();
                    return;
                }
                if (!passwordInLogIn.equals("abc")){
                    Toast.makeText(getActivity(),"Password is wrong",Toast.LENGTH_LONG).show();
                    return;
                }
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_loginFragment_to_logInAndCreateAccountToHomePage);
            }
        });
    }
}