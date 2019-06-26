package omninos.com.xlinx.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

public class AppPerefrences {
    private static AppPerefrences appPreference;
    private SharedPreferences sharedPreferences;

    public AppPerefrences(Context context) {
        sharedPreferences = context.getSharedPreferences("OdaktarDoctor", Context.MODE_PRIVATE);
    }

    public static AppPerefrences init(Context context) {
        if (appPreference == null) {
            appPreference = new AppPerefrences(context);
        }
        return appPreference;
    }

    public void saveString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, "");
    }

    public void ClearString() {
        sharedPreferences.edit().clear().commit();
    }

    View view;

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}