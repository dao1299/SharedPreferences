package com.example.sharedpreferencesassignment.viewmodel;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.security.keystore.KeyGenParameterSpec;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;

import com.example.sharedpreferencesassignment.R;
import com.example.sharedpreferencesassignment.model.Data;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class FormViewModel extends AndroidViewModel {
    private static final String TAG = "FormViewModel";

    public FormViewModel(@NonNull Application application) {
        super(application);
    }

    public void saveData(Data data) {

        Context context = getApplication().getApplicationContext();

        KeyGenParameterSpec keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC;
        String masterKeys;
        try {
            masterKeys = MasterKeys.getOrCreate(keyGenParameterSpec);
            SharedPreferences sharedPreferences = EncryptedSharedPreferences.create(
                    context.getString(R.string.file_shared),
                    masterKeys,
                    context,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            );
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(context.getString(R.string.key_username), data.getUserName());
            editor.putString(context.getString(R.string.key_address), data.getAddress());
            editor.putString(context.getString(R.string.key_account_payment), data.getAccountPayment());
            editor.apply();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
