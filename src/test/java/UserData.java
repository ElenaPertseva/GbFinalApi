import java.util.ArrayList;
import java.util.Date;


public class UserData {

    public int id;
        public String title;
        public String description;
        public String content;
        public int authorId;
        public MainImage mainImage;
        public Date updatedAt;
        public Date createdAt;
        public ArrayList<Object> labels;
        public Object delayPublishTo;
        public boolean draft;

    public UserData(int id, String title, String description, String content, int authorId, MainImage mainImage, Date updatedAt, Date createdAt, ArrayList<Object> labels, Object delayPublishTo, boolean draft) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.authorId = authorId;
        this.mainImage = mainImage;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.labels = labels;
        this.delayPublishTo = delayPublishTo;
        this.draft = draft;
    }

        public int getId() {
        return id;
    }

        public void setId(int id) {
        this.id = id;
    }

        public String getTitle() {
        return title;
    }

        public void setTitle(String title) {
        this.title = title;
    }

        public String getDescription() {
        return description;
    }

        public void setDescription(String description) {
        this.description = description;
    }

        public String getContent() {
        return content;
    }

        public void setContent(String content) {
        this.content = content;
    }

        public int getAuthorId() {
        return authorId;
    }

        public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

        public MainImage getMainImage() {
        return mainImage;
    }

        public void setMainImage(MainImage mainImage) {
        this.mainImage = mainImage;
    }

        public Date getUpdatedAt() {
        return updatedAt;
    }

        public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

        public Date getCreatedAt() {
        return createdAt;
    }

        public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

        public ArrayList<Object> getLabels() {
        return labels;
    }

        public void setLabels(ArrayList<Object> labels) {
        this.labels = labels;
    }

        public Object getDelayPublishTo() {
        return delayPublishTo;
    }

        public void setDelayPublishTo(Object delayPublishTo) {
        this.delayPublishTo = delayPublishTo;
    }

        public boolean isDraft() {
        return draft;
    }

        public void setDraft(boolean draft) {
        this.draft = draft;
    }
    }

    class MainImage{
        public int id;
        public String cdnUrl;
    }

    class Meta{
        public int prevPage;
        public int nextPage;
        public int count;
    }

    class Root{
        public ArrayList<UserData> data;
        public Meta meta;
    }
