package cl.zecovery.android.sidcoalert.main;

/**
 * Created by fran on 10-03-16.
 */
public class Alert {

    public int alertId;
    public String number;
    public String user;
    public String region;
    public String init;
    public String stop;
    public String deltaTime;
    public String deltaQuery;
    public String deltaDownload;
    public String size;
    public String trasnfTime;


    public Alert() {
    }

    public Alert(int alertId, String user, String region) {
        this.alertId = alertId;
        this.user = user;
        this.region = region;
    }

    public int getAlertId() {
        return alertId;
    }

    public void setAlertId(int alertId) {
        this.alertId = alertId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getInit() {
        return init;
    }

    public void setInit(String init) {
        this.init = init;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public String getDeltaTime() {
        return deltaTime;
    }

    public void setDeltaTime(String deltaTime) {
        this.deltaTime = deltaTime;
    }

    public String getDeltaQuery() {
        return deltaQuery;
    }

    public void setDeltaQuery(String deltaQuery) {
        this.deltaQuery = deltaQuery;
    }

    public String getDeltaDownload() {
        return deltaDownload;
    }

    public void setDeltaDownload(String deltaDownload) {
        this.deltaDownload = deltaDownload;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTrasnfTime() {
        return trasnfTime;
    }

    public void setTrasnfTime(String trasnfTime) {
        this.trasnfTime = trasnfTime;
    }
}
