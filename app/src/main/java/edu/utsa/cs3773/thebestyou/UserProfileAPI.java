package edu.utsa.cs3773.thebestyou;

import android.os.AsyncTask;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import edu.utsa.cs3773.thebestyou.model.UserProfile;


public class UserProfileAPI {

    public static void createUserProfile(String apiUrl, UserProfile userProfile) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    JSONObject jsonUserProfile = new JSONObject();
                    jsonUserProfile.put("email", userProfile.getEmail());
                    jsonUserProfile.put("password", userProfile.getPassword());
                    jsonUserProfile.put("age", userProfile.getAge());
                    jsonUserProfile.put("gender", userProfile.getGender());
                    jsonUserProfile.put("height_inches", userProfile.getHeightInches());
                    jsonUserProfile.put("weight", userProfile.getWeight());
                    jsonUserProfile.put("target_weight", userProfile.getTargetWeight());
                    jsonUserProfile.put("frequency", userProfile.getFrequency());
                    jsonUserProfile.put("level", userProfile.getLevel());

                    URL url = new URL(apiUrl);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json");
                    conn.setDoOutput(true);

                    OutputStream os = conn.getOutputStream();
                    os.write(jsonUserProfile.toString().getBytes());
                    os.flush();
                    os.close();

                    int responseCode = conn.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_CREATED) {
                        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String inputLine;
                        StringBuffer response = new StringBuffer();
                        while ((inputLine = in.readLine()) != null) {
                            response.append(inputLine);
                        }
                        in.close();
                        System.out.println("Response: " + response.toString());
                    } else {
                        System.out.println("Failed to create user profile. Response code: " + responseCode);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }
}
