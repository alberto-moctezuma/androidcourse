package udg.mxc.aplication1.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    private static ScrollView parentLayout;

    public static void showLog( String TAG, String message ){
        Log.e( TAG, ":::.. "+message+"..::" );
    }

    public static boolean isValidEmail( String email ){
        String emailPattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" + "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public static void showSnackBar(View view, String message ){
        Snackbar.make( view, message, Snackbar.LENGTH_LONG )
                .show();
    }

    public static void showToast(Context context, String message ){
        Toast.makeText( context, message, Toast.LENGTH_LONG ).show();
    }

    public static void changeActivity(Activity activity, Class aClass, HashMap<String, String> parameters){
        Intent intent = new Intent( activity, aClass );
        if( parameters != null ) {
            for (Map.Entry<String, String> entry : parameters.entrySet()) {
                intent.putExtra(entry.getKey(), entry.getValue());
            }
        }
        activity.startActivity(intent);
        activity.finish();
    }

    public static int getRandomNumber(){
        return  (int)(Math.random()*((3-1)+1))+1;
    }

    public static int getRandomID(){
        return  (int)(Math.random()*((30000-1)+1))+1;
    }

    public static String setRandomImage(){
        switch (Util.getRandomNumber()){
            case 1:
                return "https://upload.wikimedia.org/wikipedia/commons/thumb/3/33/Callie_the_golden_retriever_puppy.jpg/300px-Callie_the_golden_retriever_puppy.jpg";
            case 2:
                return "https://www.tiendanimal.es/articulos/wp-content/uploads/2010/06/la-forma-de-ser-de-tu-perro.jpg";
            case 3:
                return "https://barkpost.com/wp-content/uploads/2014/11/lavadogshawaii.jpg";
        }
        return "";
    }
}
