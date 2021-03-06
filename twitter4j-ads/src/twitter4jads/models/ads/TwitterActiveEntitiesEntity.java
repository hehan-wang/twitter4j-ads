package twitter4jads.models.ads;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

/**
 * david.wang
 */
public class TwitterActiveEntitiesEntity implements Serializable {

    @SerializedName("entity_id")
    private String entityId;
    @SerializedName("activity_start_time")
    private String activityStartTime;
    @SerializedName("activity_end_time")
    private String activityEndTime;
    @SerializedName("placements")
    private List<String> placements;

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(String activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    public String getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(String activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    public List<String> getPlacements() {
        return placements;
    }

    public void setPlacements(List<String> placements) {
        this.placements = placements;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TwitterActiveEntitiesEntity.class.getSimpleName() + "[", "]")
                .add("entityId='" + entityId + "'")
                .add("activityStartTime='" + activityStartTime + "'")
                .add("activityEndTime='" + activityEndTime + "'")
                .add("placements=" + placements)
                .toString();
    }
}
