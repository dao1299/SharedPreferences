package com.example.sharedpreferencesassignment.db;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.security.keystore.KeyGenParameterSpec;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;

import com.example.sharedpreferencesassignment.R;
import com.example.sharedpreferencesassignment.model.Data;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class DataContentProvider extends ContentProvider {
    Data dataReceive;

    @Override
    public boolean onCreate() {
        KeyGenParameterSpec keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC;
        String masterKeys;
        try {
            masterKeys = MasterKeys.getOrCreate(keyGenParameterSpec);
            SharedPreferences sharedPreferences = EncryptedSharedPreferences.create(
                    getContext().getString(R.string.file_shared),
                    masterKeys,
                    getContext(),
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            );
            dataReceive = new Data(
                    sharedPreferences.getString(getContext().getString(R.string.key_username), ""),
                    sharedPreferences.getString(getContext().getString(R.string.key_email), ""),
                    sharedPreferences.getString(getContext().getString(R.string.key_address), ""),
                    sharedPreferences.getString(getContext().getString(R.string.key_account_payment), "")
            );
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection,
                        @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        if (dataReceive != null)
            return createCursor(dataReceive);
        else return null;

    }

    public Cursor createCursor(Data data) {
        String[] columns = new String[]{"userName", "email", "address", "accountPayment"};
        MatrixCursor matrixCursor = new MatrixCursor(columns);

        matrixCursor.addRow(new Object[]{data.getUserName(), data.getEmail(), data.getAddress(), data.getAccountPayment()});
        return matrixCursor;

    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
