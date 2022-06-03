package Properties;


import java.io.Serializable;

public class Images implements Serializable {

    private String photoPath;
    private String uploaderName;
    private String caption;
    private String privacy;

    public Images(String photoPath, String uploaderName, String caption, String privacy) {
        this.photoPath = photoPath;
        this.uploaderName = uploaderName;
        this.caption = caption;
        this.privacy = privacy;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public String getUploaderName() {
        return uploaderName;
    }

    public String getCaption() {
        return caption;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public void setUploaderName(String uploaderName) {
        this.uploaderName = uploaderName;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public String toString() {
        return this.uploaderName + " : " + this.caption;
    }


}
