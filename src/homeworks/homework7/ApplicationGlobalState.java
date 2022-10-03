package homeworks.homework7;

public final class ApplicationGlobalState {
    private static ApplicationGlobalState INSTANCE;
    private String LATITUDE = null;
    private String LONGITUDE = null;
    public String getLatitude() {
        return LATITUDE;
    }
    public void setLatitude(String LATITUDE) {
        this.LATITUDE = LATITUDE;
    }
    public String getLongitude() {
        return LONGITUDE;
    }
    public void setLongitude(String LONGITUDE) {
        this.LONGITUDE = LONGITUDE;
    }

    private ApplicationGlobalState() {
    }

    public static ApplicationGlobalState getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ApplicationGlobalState();
        }
        return INSTANCE;
    }
}
