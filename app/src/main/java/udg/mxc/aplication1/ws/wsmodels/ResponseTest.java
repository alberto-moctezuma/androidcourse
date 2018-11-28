package udg.mxc.aplication1.ws.wsmodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseTest{
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("height")
	@Expose
	private String height;
	@SerializedName("mass")
	@Expose
	private String mass;
	@SerializedName("hair_color")
	@Expose
	private String hairColor;
	@SerializedName("skin_color")
	@Expose
	private String skinColor;
	@SerializedName("eye_color")
	@Expose
	private String eyeColor;
	@SerializedName("birth_year")
	@Expose
	private String birthYear;
	@SerializedName("gender")
	@Expose
	private String gender;
	@SerializedName("homeworld")
	@Expose
	private String homeworld;
	@SerializedName("films")
	@Expose
	private List<String> films = null;
	@SerializedName("species")
	@Expose
	private List<String> species = null;
	@SerializedName("vehicles")
	@Expose
	private List<String> vehicles = null;
	@SerializedName("starships")
	@Expose
	private List<String> starships = null;
	@SerializedName("created")
	@Expose
	private String created;
	@SerializedName("edited")
	@Expose
	private String edited;
	@SerializedName("url")
	@Expose
	private String url;

}