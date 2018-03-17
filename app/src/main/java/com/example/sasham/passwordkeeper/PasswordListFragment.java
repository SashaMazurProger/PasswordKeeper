package com.example.sasham.passwordkeeper;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sasham.passwordkeeper.model.DaoSession;
import com.example.sasham.passwordkeeper.model.Password;
import com.example.sasham.passwordkeeper.model.PasswordDao;

import java.util.ArrayList;



/**
 * A simple {@link Fragment} subclass.
 */
public class PasswordListFragment extends Fragment {

    private PasswordDao mPasswordDao;
    private ArrayList<Password> mPasswordsList;

    private static final String TAG=PasswordListFragment.class.getSimpleName();

    public PasswordListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initPasswordDao();
        setPasswords();

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_password_list, container, false);

//        Password password1 = new Password();
//        password1.setTitle("My Facebook");
//        password1.setEmail("sfdfssadfa@gmail.com");
//        password1.setDate(new Date());
//
//        Password password2 = new Password();
//        password2.setTitle("Medium site");
//        password2.setEmail("sfdfssadfa@gmail.com");
//        password2.setDate(new Date());
//
//        mPasswords.add(password1);
//        mPasswords.add(password2);

        PasswordAdapter passwordAdapter = new PasswordAdapter(mPasswordsList);

        RecyclerView passRecyclerView = (RecyclerView) rootView.findViewById(R.id.passwords_recycler_view);

        passRecyclerView.setAdapter(passwordAdapter);
        passRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        return rootView;
    }

    private void setPasswords() {
        mPasswordsList = (ArrayList<Password>) mPasswordDao.loadAll();
    }

    private void initPasswordDao() {
        DaoSession daoSession = ((App) getActivity().getApplication()).getDaoSession();
        mPasswordDao = daoSession.getPasswordDao();
    }

}
