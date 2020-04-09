package premiereapplication.automation.test.notreapp;

/**
 * Created by Sarah on 25/05/2017.
 */


import com.google.gson.annotations.SerializedName;

public class Login1Serialize
{
    @SerializedName("email")
    private String email;
    @SerializedName("name")
    private String name;
    @SerializedName("date_naissance")
    private String date_naissance;

    public String getEmail()
    {
        return this.email;
    }

    public String getName()
    {
        return this.name;
    }

    public String getDate()
    {
        return this.date_naissance;
    }
}

