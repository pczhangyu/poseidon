package com.poseidon.model;

public class LoginRecordEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b2c_login_record.id
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b2c_login_record.account_id
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    private String accountId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b2c_login_record.account_type
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    private Byte accountType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b2c_login_record.username
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b2c_login_record.login_time
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    private Long loginTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b2c_login_record.id
     *
     * @return the value of b2c_login_record.id
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b2c_login_record.id
     *
     * @param id the value for b2c_login_record.id
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b2c_login_record.account_id
     *
     * @return the value of b2c_login_record.account_id
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b2c_login_record.account_id
     *
     * @param accountId the value for b2c_login_record.account_id
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b2c_login_record.account_type
     *
     * @return the value of b2c_login_record.account_type
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    public Byte getAccountType() {
        return accountType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b2c_login_record.account_type
     *
     * @param accountType the value for b2c_login_record.account_type
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    public void setAccountType(Byte accountType) {
        this.accountType = accountType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b2c_login_record.username
     *
     * @return the value of b2c_login_record.username
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b2c_login_record.username
     *
     * @param username the value for b2c_login_record.username
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b2c_login_record.login_time
     *
     * @return the value of b2c_login_record.login_time
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    public Long getLoginTime() {
        return loginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b2c_login_record.login_time
     *
     * @param loginTime the value for b2c_login_record.login_time
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }
}