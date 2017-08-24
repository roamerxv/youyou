package pers.roamer.youyou.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author roamer - 徐泽宇
 * @create 2017-08-2017/8/24  下午3:06
 */
@Entity
@Table(name = "parking_info", schema = "youyou", catalog = "")
public class ParkingInfoEntity {
    private String id;
    private String buildingNo;
    private String roomNo;
    private String propertyCert;
    private Date propertyCertRegisterAt;
    private String propertyOwner;
    private String propertyOwnerCid;
    private String drivingLicenseNo;
    private Date drivingLicenseRegisterAt;
    private String drivingLicenseOwner;
    private String carNo;
    private String parkingNo;
    private String contactMobile;
    private String comment;
    private Integer lineOrder;
    private Date registerDate;
    private String createdBy;
    private Timestamp createdAt;
    private String updatedBy;
    private Timestamp updatedAt;
    private ParkingTypeEntity parkingTypeByParkingType;
    private LivingTypeEntity livingTypeByLivingType;
    private ApproveTypeEntity approveTypeByApproveType;

    @Id
    @Column(name = "id", nullable = false, length = 36)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "building_no", nullable = false, length = 4)
    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    @Basic
    @Column(name = "room_no", nullable = false, length = 16)
    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    @Basic
    @Column(name = "property_cert", nullable = true, length = 32)
    public String getPropertyCert() {
        return propertyCert;
    }

    public void setPropertyCert(String propertyCert) {
        this.propertyCert = propertyCert;
    }

    @Basic
    @Column(name = "property_cert_register_at", nullable = true)
    public Date getPropertyCertRegisterAt() {
        return propertyCertRegisterAt;
    }

    public void setPropertyCertRegisterAt(Date propertyCertRegisterAt) {
        this.propertyCertRegisterAt = propertyCertRegisterAt;
    }

    @Basic
    @Column(name = "property_owner", nullable = true, length = 16)
    public String getPropertyOwner() {
        return propertyOwner;
    }

    public void setPropertyOwner(String propertyOwner) {
        this.propertyOwner = propertyOwner;
    }

    @Basic
    @Column(name = "property_owner_cid", nullable = true, length = 16)
    public String getPropertyOwnerCid() {
        return propertyOwnerCid;
    }

    public void setPropertyOwnerCid(String propertyOwnerCid) {
        this.propertyOwnerCid = propertyOwnerCid;
    }

    @Basic
    @Column(name = "driving_license_no", nullable = true, length = 16)
    public String getDrivingLicenseNo() {
        return drivingLicenseNo;
    }

    public void setDrivingLicenseNo(String drivingLicenseNo) {
        this.drivingLicenseNo = drivingLicenseNo;
    }

    @Basic
    @Column(name = "driving_license_register_at", nullable = true)
    public Date getDrivingLicenseRegisterAt() {
        return drivingLicenseRegisterAt;
    }

    public void setDrivingLicenseRegisterAt(Date drivingLicenseRegisterAt) {
        this.drivingLicenseRegisterAt = drivingLicenseRegisterAt;
    }

    @Basic
    @Column(name = "driving_license_owner", nullable = true, length = 16)
    public String getDrivingLicenseOwner() {
        return drivingLicenseOwner;
    }

    public void setDrivingLicenseOwner(String drivingLicenseOwner) {
        this.drivingLicenseOwner = drivingLicenseOwner;
    }

    @Basic
    @Column(name = "car_no", nullable = true, length = 16)
    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    @Basic
    @Column(name = "parking_no", nullable = true, length = 8)
    public String getParkingNo() {
        return parkingNo;
    }

    public void setParkingNo(String parkingNo) {
        this.parkingNo = parkingNo;
    }

    @Basic
    @Column(name = "contact_mobile", nullable = true, length = 36)
    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    @Basic
    @Column(name = "comment", nullable = true, length = -1)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "line_order", nullable = true)
    public Integer getLineOrder() {
        return lineOrder;
    }

    public void setLineOrder(Integer lineOrder) {
        this.lineOrder = lineOrder;
    }

    @Basic
    @Column(name = "register_date", nullable = false)
    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Basic
    @Column(name = "created_by", nullable = false, length = 32)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "created_at", nullable = false)
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updated_by", nullable = false, length = 32)
    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Basic
    @Column(name = "updated_at", nullable = false)
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParkingInfoEntity that = (ParkingInfoEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (buildingNo != null ? !buildingNo.equals(that.buildingNo) : that.buildingNo != null) return false;
        if (roomNo != null ? !roomNo.equals(that.roomNo) : that.roomNo != null) return false;
        if (propertyCert != null ? !propertyCert.equals(that.propertyCert) : that.propertyCert != null) return false;
        if (propertyCertRegisterAt != null ? !propertyCertRegisterAt.equals(that.propertyCertRegisterAt) : that.propertyCertRegisterAt != null)
            return false;
        if (propertyOwner != null ? !propertyOwner.equals(that.propertyOwner) : that.propertyOwner != null)
            return false;
        if (propertyOwnerCid != null ? !propertyOwnerCid.equals(that.propertyOwnerCid) : that.propertyOwnerCid != null)
            return false;
        if (drivingLicenseNo != null ? !drivingLicenseNo.equals(that.drivingLicenseNo) : that.drivingLicenseNo != null)
            return false;
        if (drivingLicenseRegisterAt != null ? !drivingLicenseRegisterAt.equals(that.drivingLicenseRegisterAt) : that.drivingLicenseRegisterAt != null)
            return false;
        if (drivingLicenseOwner != null ? !drivingLicenseOwner.equals(that.drivingLicenseOwner) : that.drivingLicenseOwner != null)
            return false;
        if (carNo != null ? !carNo.equals(that.carNo) : that.carNo != null) return false;
        if (parkingNo != null ? !parkingNo.equals(that.parkingNo) : that.parkingNo != null) return false;
        if (contactMobile != null ? !contactMobile.equals(that.contactMobile) : that.contactMobile != null)
            return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (lineOrder != null ? !lineOrder.equals(that.lineOrder) : that.lineOrder != null) return false;
        if (registerDate != null ? !registerDate.equals(that.registerDate) : that.registerDate != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedBy != null ? !updatedBy.equals(that.updatedBy) : that.updatedBy != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (buildingNo != null ? buildingNo.hashCode() : 0);
        result = 31 * result + (roomNo != null ? roomNo.hashCode() : 0);
        result = 31 * result + (propertyCert != null ? propertyCert.hashCode() : 0);
        result = 31 * result + (propertyCertRegisterAt != null ? propertyCertRegisterAt.hashCode() : 0);
        result = 31 * result + (propertyOwner != null ? propertyOwner.hashCode() : 0);
        result = 31 * result + (propertyOwnerCid != null ? propertyOwnerCid.hashCode() : 0);
        result = 31 * result + (drivingLicenseNo != null ? drivingLicenseNo.hashCode() : 0);
        result = 31 * result + (drivingLicenseRegisterAt != null ? drivingLicenseRegisterAt.hashCode() : 0);
        result = 31 * result + (drivingLicenseOwner != null ? drivingLicenseOwner.hashCode() : 0);
        result = 31 * result + (carNo != null ? carNo.hashCode() : 0);
        result = 31 * result + (parkingNo != null ? parkingNo.hashCode() : 0);
        result = 31 * result + (contactMobile != null ? contactMobile.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (lineOrder != null ? lineOrder.hashCode() : 0);
        result = 31 * result + (registerDate != null ? registerDate.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedBy != null ? updatedBy.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "parking_type", referencedColumnName = "id")
    public ParkingTypeEntity getParkingTypeByParkingType() {
        return parkingTypeByParkingType;
    }

    public void setParkingTypeByParkingType(ParkingTypeEntity parkingTypeByParkingType) {
        this.parkingTypeByParkingType = parkingTypeByParkingType;
    }

    @ManyToOne
    @JoinColumn(name = "living_type", referencedColumnName = "id")
    public LivingTypeEntity getLivingTypeByLivingType() {
        return livingTypeByLivingType;
    }

    public void setLivingTypeByLivingType(LivingTypeEntity livingTypeByLivingType) {
        this.livingTypeByLivingType = livingTypeByLivingType;
    }

    @ManyToOne
    @JoinColumn(name = "approve_type", referencedColumnName = "id")
    public ApproveTypeEntity getApproveTypeByApproveType() {
        return approveTypeByApproveType;
    }

    public void setApproveTypeByApproveType(ApproveTypeEntity approveTypeByApproveType) {
        this.approveTypeByApproveType = approveTypeByApproveType;
    }
}
