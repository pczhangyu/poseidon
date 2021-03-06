package com.poseidon.web.mapper.model;


import java.io.Serializable;
import java.util.Set;

public class RoleExt implements Serializable{


    public Set<ResourceExt> getResourceExtSet() {
        return resourceExtSet;
    }

    public void setResourceExtSet(Set<ResourceExt> resourceExtSet) {
        this.resourceExtSet = resourceExtSet;
    }

    private Set<ResourceExt> resourceExtSet;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.role_id
     *
     * @mbggenerated Fri Apr 21 14:33:25 CST 2017
     */
    private String roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.role_name
     *
     * @mbggenerated Fri Apr 21 14:33:25 CST 2017
     */
    private String roleName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.seq
     *
     * @mbggenerated Fri Apr 21 14:33:25 CST 2017
     */
    private Byte seq;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.description
     *
     * @mbggenerated Fri Apr 21 14:33:25 CST 2017
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.role_status
     *
     * @mbggenerated Fri Apr 21 14:33:25 CST 2017
     */
    private Byte roleStatus;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.role_id
     *
     * @return the value of role.role_id
     *
     * @mbggenerated Fri Apr 21 14:33:25 CST 2017
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.role_id
     *
     * @param roleId the value for role.role_id
     *
     * @mbggenerated Fri Apr 21 14:33:25 CST 2017
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.role_name
     *
     * @return the value of role.role_name
     *
     * @mbggenerated Fri Apr 21 14:33:25 CST 2017
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.role_name
     *
     * @param roleName the value for role.role_name
     *
     * @mbggenerated Fri Apr 21 14:33:25 CST 2017
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.seq
     *
     * @return the value of role.seq
     *
     * @mbggenerated Fri Apr 21 14:33:25 CST 2017
     */
    public Byte getSeq() {
        return seq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.seq
     *
     * @param seq the value for role.seq
     *
     * @mbggenerated Fri Apr 21 14:33:25 CST 2017
     */
    public void setSeq(Byte seq) {
        this.seq = seq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.description
     *
     * @return the value of role.description
     *
     * @mbggenerated Fri Apr 21 14:33:25 CST 2017
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.description
     *
     * @param description the value for role.description
     *
     * @mbggenerated Fri Apr 21 14:33:25 CST 2017
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.role_status
     *
     * @return the value of role.role_status
     *
     * @mbggenerated Fri Apr 21 14:33:25 CST 2017
     */
    public Byte getRoleStatus() {
        return roleStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.role_status
     *
     * @param roleStatus the value for role.role_status
     *
     * @mbggenerated Fri Apr 21 14:33:25 CST 2017
     */
    public void setRoleStatus(Byte roleStatus) {
        this.roleStatus = roleStatus;
    }

}