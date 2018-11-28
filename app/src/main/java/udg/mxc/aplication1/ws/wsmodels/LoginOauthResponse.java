package udg.mxc.aplication1.ws.wsmodels;

import java.util.List;

public class LoginOauthResponse{
	private UserInfo userInfo;
	private int success;
	private String message;
	private List<ZonesItem> zones;

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ZonesItem> getZones() {
		return zones;
	}

	public void setZones(List<ZonesItem> zones) {
		this.zones = zones;
	}
}