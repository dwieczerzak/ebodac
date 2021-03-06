package org.motechproject.ebodac.domain;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.motechproject.ebodac.constants.EbodacConstants;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;
import org.motechproject.mds.annotations.Ignore;
import org.motechproject.mds.annotations.NonEditable;
import org.motechproject.mds.annotations.UIDisplayable;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Unique;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

/**
 * Models data for registration of Subject in EBODAC
 */
@Entity(recordHistory = true)
public class Subject {

    /**
     * Fields captured in ZETES
     */

    private Long id;

    @Unique
    @NonEditable
    @UIDisplayable(position = 0)
    @Field(required = true)
    private String subjectId;

    @UIDisplayable(position = 1)
    @Pattern(regexp = "^\\D*$")
    @Field
    private String name;

    @UIDisplayable(position = 2)
    @Pattern(regexp = "^\\D*$")
    @Field
    private String householdName;

    @UIDisplayable(position = 3)
    @Pattern(regexp = "^\\D*$")
    @Field
    private String headOfHousehold;

    @UIDisplayable(position = 4)
    @Column(length = 20)
    @Pattern(regexp = "^[0-9\\s]*$")
    @Field
    private String phoneNumber;

    @UIDisplayable(position = 5)
    @Field
    private String address;

    @UIDisplayable(position = 7)
    @Column(length = 20)
    @Field
    private Language language;

    @NonEditable
    @UIDisplayable(position = 8)
    @Field(required = true)
    private String siteId;

    @UIDisplayable(position = 9)
    @Field
    private String community;

    /**
     * Fields captured in RAVE
     */

    @NonEditable
    @UIDisplayable(position = 6)
    @Field
    private Gender gender;

    @NonEditable
    @Field
    private Long stageId;

    @NonEditable
    @Field
    private DateTime dateOfBirth;

    @NonEditable
    @Field
    private DateTime primerVaccinationDate;

    @NonEditable
    @Field
    private DateTime boosterVaccinationDate;

    @NonEditable
    @Field(displayName = "Date of Discontinuation Vac.")
    private DateTime dateOfDisconVac;

    @NonEditable
    @Field(displayName = "Withdrawal Date")
    private DateTime dateOfDisconStd;

    /**
     * Motech internal fields
     */
    @NonEditable(display = false)
    @Field(defaultValue = "false")
    private boolean changed;

    @NonEditable(display = false)
    @Field
    private String owner;

    @NonEditable
    @Field
    @Persistent(mappedBy = "subject")
    @Cascade(delete = true)
    private List<Visit> visits = new ArrayList<>();

    public Subject() {
    }

    public Subject(String subjectId, String name, String householdName, String headOfHousehold,
                   String phoneNumber, String address, Language language, String community, String siteId) {
        this.subjectId = subjectId;
        this.name = name;
        this.householdName = householdName;
        this.headOfHousehold = headOfHousehold;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.language = language;
        this.community = community;
        setSiteId(siteId);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHouseholdName() {
        return householdName;
    }

    public void setHouseholdName(String householdName) {
        this.householdName = householdName;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        if (StringUtils.isBlank(siteId)) {
            this.siteId = EbodacConstants.SITE_ID_FOR_STAGE_I;
        } else {
            this.siteId = siteId;
        }
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getHeadOfHousehold() {
        return headOfHousehold;
    }

    public void setHeadOfHousehold(String headOfHousehold) {
        this.headOfHousehold = headOfHousehold;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }

    public DateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public DateTime getPrimerVaccinationDate() {
        return primerVaccinationDate;
    }

    public void setPrimerVaccinationDate(DateTime primerVaccinationDate) {
        this.primerVaccinationDate = primerVaccinationDate;
    }

    public DateTime getBoosterVaccinationDate() {
        return boosterVaccinationDate;
    }

    public void setBoosterVaccinationDate(DateTime boosterVaccinationDate) {
        this.boosterVaccinationDate = boosterVaccinationDate;
    }

    public DateTime getDateOfDisconVac() {
        return dateOfDisconVac;
    }

    public void setDateOfDisconVac(DateTime dateOfDisconVac) {
        this.dateOfDisconVac = dateOfDisconVac;
    }

    public DateTime getDateOfDisconStd() {
        return dateOfDisconStd;
    }

    public void setDateOfDisconStd(DateTime dateOfDisconStd) {
        this.dateOfDisconStd = dateOfDisconStd;
    }

    public Boolean getChanged() {
        return changed;
    }

    public void setChanged(Boolean changed) {
        this.changed = changed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    @Ignore
    public String getLanguageCode() {
        if (language != null) {
            return language.getCode();
        } else {
            return null;
        }

    }

    @Override
    public String toString() {
        return String.format("Subject{id='%s', name='%s', householdName='%s', phoneNumber='%s'}",
                getSubjectId(), getName(), getHouseholdName(), getPhoneNumber());
    }
}