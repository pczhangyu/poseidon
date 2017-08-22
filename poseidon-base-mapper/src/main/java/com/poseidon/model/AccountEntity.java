package com.poseidon.model;

public class AccountEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b2c_account.account_id
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    private String accountId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b2c_account.username
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b2c_account.password
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b2c_account.account_level
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    private Byte accountLevel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b2c_account.create_time
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    private Long createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b2c_account.account_type
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    private String accountType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b2c_account.disabled
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    private String disabled;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b2c_account.account_id
     *
     * @return the value of b2c_account.account_id
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b2c_account.account_id
     *
     * @param accountId the value for b2c_account.account_id
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b2c_account.username
     *
     * @return the value of b2c_account.username
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b2c_account.username
     *
     * @param username the value for b2c_account.username
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b2c_account.password
     *
     * @return the value of b2c_account.password
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b2c_account.password
     *
     * @param password the value for b2c_account.password
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b2c_account.account_level
     *
     * @return the value of b2c_account.account_level
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    public Byte getAccountLevel() {
        return accountLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b2c_account.account_level
     *
     * @param accountLevel the value for b2c_account.account_level
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    public void setAccountLevel(Byte accountLevel) {
        this.accountLevel = accountLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b2c_account.create_time
     *
     * @return the value of b2c_account.create_time
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b2c_account.create_time
     *
     * @param createTime the value for b2c_account.create_time
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b2c_account.account_type
     *
     * @return the value of b2c_account.account_type
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b2c_account.account_type
     *
     * @param accountType the value for b2c_account.account_type
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b2c_account.disabled
     *
     * @return the value of b2c_account.disabled
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    public String getDisabled() {
        return disabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b2c_account.disabled
     *
     * @param disabled the value for b2c_account.disabled
     *
     * @mbggenerated Tue Aug 22 14:46:43 CST 2017
     */
    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }
}